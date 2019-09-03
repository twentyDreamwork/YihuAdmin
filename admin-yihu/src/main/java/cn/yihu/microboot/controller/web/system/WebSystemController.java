package cn.yihu.microboot.controller.web.system;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import cn.yihu.microboot.service.WebSystemService;
import cn.yihu.microboot.service.api.ApiCheckService;
import cn.yihu.microboot.util.controller.AbstractBaseController;
import io.swagger.annotations.Api;
import net.sf.json.JSONObject;

//@Api(value = "web系统链接")
//@RestController
//@RequestMapping("/system")
public class WebSystemController extends AbstractBaseController{

	@Resource
	private ApiCheckService apicheckService;
	
	@Resource
	private WebSystemService websystemService;
	
	//@RequestMapping(value = "/weblogin", method = RequestMethod.POST)
	public JSONObject weblogin(@RequestBody JSONObject now_json) {
		JSONObject res_json = new JSONObject();
		int result = websystemService.CheckByUserNameAndPassword(now_json.getString("username"), now_json.getString("password"));
		
		if(result==0) {
			res_json.put("code", 200);
			res_json.put("login", 0);
			res_json.put("msg", "不存在该用户或密碼錯誤");
			return res_json;
		}
		
		res_json.put("code", 200);
		res_json.put("login", 1);
		res_json.put("msg", "成功");
		return res_json;
	}
	
}
