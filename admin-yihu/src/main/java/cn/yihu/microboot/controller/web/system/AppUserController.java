package cn.yihu.microboot.controller.web.system;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import cn.yihu.microboot.service.UserService;
import cn.yihu.microboot.util.controller.AbstractBaseController;
import cn.yihu.microboot.vo.APP;
import cn.yihu.microboot.vo.Page;
import io.swagger.annotations.Api;
import net.sf.json.JSONObject;

@Api(value = "web app用户管理")
@RestController
@RequestMapping("/operation")
public class AppUserController extends AbstractBaseController{
	
	@Resource
	private UserService userservice;

	@RequestMapping(value = "/getappuserlist", method = RequestMethod.GET)
	public JSONObject appuserList(String pageno) {
		JSONObject res_json = new JSONObject();
		Page page=new Page<>(Integer.parseInt(pageno));
		page=userservice.findAllAppUserPage(page);
		res_json=JSONObject.fromObject(page);
		res_json.put("code", 200);
		res_json.put("msg", "成功");
		return res_json;
	}
	
	@RequestMapping(value = "/insertappuser", method = RequestMethod.GET)
	public JSONObject insertappuser(String wxid,String username,String password,String phone, String platform, String MachineCode, String IP,String creater) {
		JSONObject res_json=new JSONObject();
		int result=userservice.insertAppUser(wxid, username, password, phone, platform, MachineCode, IP, creater);
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
	
	@RequestMapping(value = "/deleteappuser", method = RequestMethod.GET)
	public JSONObject deleteappuser(String id) {
		JSONObject res_json=new JSONObject();
		int result=userservice.deleteAppUser(id);
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
	
	@RequestMapping(value = "/updateappuser", method = RequestMethod.GET)
	public JSONObject updateappuser(String id,String wxid,String username,String password,String phone, String platform, String MachineCode, String IP,String updater) {
		JSONObject res_json = new JSONObject();
		int result=userservice.updateAppUser(id, wxid, username, password, phone, platform, MachineCode, IP,updater);
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
	
}
