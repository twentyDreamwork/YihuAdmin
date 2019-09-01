package cn.yihu.microboot.controller.api;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import cn.yihu.microboot.service.UserService;
import cn.yihu.microboot.service.api.TaobaoService;
import cn.yihu.microboot.vo.Page;
import cn.yihu.microboot.vo.TaobaoPicture;
import io.swagger.annotations.Api;
import net.sf.json.JSONObject;

/**
 * 淘宝链接
 * 
 * @author leqi
 *
 */
@Api(value = "淘宝链接")
@RestController
@RequestMapping("/api")
public class TaobaoController {

	@Resource
	private UserService userService;
	
	@Resource
	private TaobaoService taobaoService;

	// 淘宝链接列表
	@RequestMapping(value = "/gettaobaolink", method = RequestMethod.GET)
	public JSONObject taobao_link_list(String unionid, String platform, String pageno) {
		JSONObject res_json = new JSONObject();
		JSONObject now_json = new JSONObject();

		now_json.put("wxid", unionid);
		now_json.put("platform", platform);
		now_json.put("pageno", pageno);

		// 检验用户是否已注册
		if (userService.check_wxid(now_json.getString("wxid")) == 0) {
			res_json.put("code", 102);
			res_json.put("msg", "该用户未注册");
			return res_json;
		}
		
		Page page= taobaoService.linklist(now_json);
		res_json=JSONObject.fromObject(page);
		res_json.put("code", 200);
		res_json.put("msg", "成功");
		return res_json;
	}

	// 淘宝图片链接
	@RequestMapping(value = "/gettaobaoimg", method = RequestMethod.GET)
	public JSONObject taobao_picture_list(String link) {
		JSONObject res_json = new JSONObject();
		List<TaobaoPicture> tbp=taobaoService.link_img(link);
		res_json.put("data", res_json);
		res_json.put("code", 200);
		res_json.put("msg", "成功");
		return res_json;
	}

}
