package cn.yihu.microboot.controller.web.system;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import cn.yihu.microboot.service.WebSystemService;
import cn.yihu.microboot.service.api.ApiCheckService;
import cn.yihu.microboot.util.controller.AbstractBaseController;
import cn.yihu.microboot.vo.Page;
import cn.yihu.microboot.vo.WebUser;
import io.swagger.annotations.Api;
import net.sf.json.JSONObject;

//@Api(value = "web用户管理")
//@RestController
//@RequestMapping("/system")
public class WebUserController extends AbstractBaseController{

	@Resource
	private ApiCheckService apicheckService;
	
	@Resource
	private WebSystemService websystemService;
	
	//@RequestMapping(value = "/getuser", method = RequestMethod.GET)
	public JSONObject UserList(String pageno) {
		JSONObject res_json = new JSONObject();
		JSONObject now_json = new JSONObject();
		
		Page<WebUser> page=new Page<>(Integer.parseInt(pageno));
		page=websystemService.findAllUser(page);
		res_json=JSONObject.fromObject(page);
		res_json.put("code", 200);
		res_json.put("msg", "成功");
		return res_json;
	}
	
	//@RequestMapping(value = "/deleteuser", method = RequestMethod.GET)
	public JSONObject deleteUser(String userid) {
		JSONObject res_json = new JSONObject();
		int result=websystemService.deleteUser(userid);
		if(result==0) {
			res_json.put("result", result);
			res_json.put("code", 200);
			res_json.put("msg", "删除失败");
			return res_json;
		}
		res_json.put("result", result);
		res_json.put("code", 200);
		res_json.put("msg", "删除成功");
		return res_json;
	}
	
	//@RequestMapping(value = "/updateuser", method = RequestMethod.GET)
	public JSONObject updateUser(String userid,String username,String name,String password) {
		JSONObject res_json = new JSONObject();
		int result=websystemService.updateUser(userid,username, name, password);
		if(result==0) {
			res_json.put("result", result);
			res_json.put("code", 200);
			res_json.put("msg", "更新失败");
			return res_json;
		}
		res_json.put("result", result);
		res_json.put("code", 200);
		res_json.put("msg", "更新成功");
		return res_json;
	}
	
	//@RequestMapping(value = "/insertuser", method = RequestMethod.GET)
	public JSONObject insertUser(String username,String name,String password) {
		JSONObject res_json = new JSONObject();
		int result=websystemService.insertUser(username, name, password);
		if(result==0) {
			res_json.put("result", result);
			res_json.put("code", 200);
			res_json.put("msg", "插入失败");
			return res_json;
		}
		res_json.put("result", result);
		res_json.put("code", 200);
		res_json.put("msg", "插入成功");
		return res_json;
	}
}
