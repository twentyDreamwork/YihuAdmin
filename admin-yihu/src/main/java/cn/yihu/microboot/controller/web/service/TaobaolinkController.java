package cn.yihu.microboot.controller.web.service;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import cn.yihu.microboot.service.TaobaowebService;
import cn.yihu.microboot.util.Constant;
import cn.yihu.microboot.util.ImgUpload;
import cn.yihu.microboot.util.Results;
import cn.yihu.microboot.vo.Page;
import io.swagger.annotations.Api;
import net.sf.json.JSONObject;

/**
 * 淘宝链接
 * @author leqi
 *
 */
@Api(value = "web淘宝链接管理")
@RestController
@RequestMapping("/service")
public class TaobaolinkController {

	@Resource
	private TaobaowebService taobaoservice;
	
	public Constant conn=new Constant();
	
	//链接列表
	@RequestMapping(value = "/gettaobaolink", method = RequestMethod.GET)
	public JSONObject taobao_link_list(String pageno) {
		JSONObject res_json = new JSONObject();
		Page page=new Page<>(Integer.parseInt(pageno));
		System.out.println("------");
		page=taobaoservice.findAllLinkPage(page);
		System.out.println("------");
		res_json=JSONObject.fromObject(page);
		res_json.put("code", 200);
		res_json.put("msg", "成功");
		return res_json;
	}
	
	//链接添加
	@RequestMapping(value = "/addtaobaolink", method = RequestMethod.GET)
	public void taobao_link_add(String linkname,String link,String remark,List<String> base64DataList) {
		JSONObject res_json = new JSONObject();
		ImgUpload imgupload=new ImgUpload();
		int num=0;
		if(base64DataList.size()>1) {
			num=1;
		}
		Results rs=imgupload.saveImg(base64DataList);
		
		
	}
	
	//链接修改
	@RequestMapping(value = "/updatetaobaolink", method = RequestMethod.GET)
	public void taobao_link_update(String linkid,String linkname,String link,String remark,List<String> base64DataList) {
		
	}
	
	//链接删除
	@RequestMapping(value = "/deltaobaolink", method = RequestMethod.GET)
	public void taobao_link_delete() {
		
	}
	
}
