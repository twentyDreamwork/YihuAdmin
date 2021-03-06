package cn.yihu.microboot.controller.web.system;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import cn.yihu.microboot.config.JSONInitialize;
import cn.yihu.microboot.config.JsonDateValueProcessor;
import cn.yihu.microboot.service.AppUserService;
import cn.yihu.microboot.util.CommonCode;
import cn.yihu.microboot.util.Results;
import cn.yihu.microboot.util.controller.AbstractBaseController;
import cn.yihu.microboot.vo.APP;
import cn.yihu.microboot.vo.AppUser;
import cn.yihu.microboot.vo.Page;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;

@Api(value = "web app用户管理")
@RestController
@RequestMapping("/operation")
public class WebAppUserController extends AbstractBaseController{
	
	@Resource
	private AppUserService userservice;

	@ApiOperation(value="pc端获取app用户列表")
	@GetMapping("/getappuserlist")
	public JSONObject appuserList(String pageno,String size,String sort) {
		//System.out.println(pageno+"   "+size+"    "+sort);
		JSONObject res_json = new JSONObject();
		int count = userservice.count();
		Page page=new Page<>(Integer.parseInt(pageno),Integer.parseInt(size),count);
		List<AppUser> applist=userservice.findAllAppUserPage(page,sort);
		JSONArray jsonarray=JSONArray.fromObject(applist, new JSONInitialize().JSONDateConfig());
		res_json.put("content", jsonarray);
		res_json.put("totalElements", count);
		return res_json;
	}
	
	//@RequestMapping(value = "/insertappuser", method = RequestMethod.GET)
	public JSONObject insertappuser(@RequestBody AppUser appuser) {
		JSONObject res_json=new JSONObject();
		int result=userservice.insertAppUser(appuser);
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
	
	@ApiOperation(value="pc端删除app用户")
	@DeleteMapping("/deleteappuser")
	public Results deleteappuser(String id) {
		JSONObject res_json=new JSONObject();
		int result=userservice.deleteAppUser(id);
		if(result==0) {
			return new Results<>(CommonCode.FAIL);
		}
		return new Results<>(CommonCode.SUCCESS);
	}
	
	@ApiOperation(value="pc端更新app用户信息")
	@PostMapping("/updateappuser")
	//public JSONObject updateappuser(String id,String wxid,String username,String password,String phone, String , String MachineCode, String IP,String updater) {
	public JSONObject updateappuser(@RequestBody AppUser appuser) {
	    JSONObject res_json = new JSONObject();
		int result=userservice.updateAppUser(appuser);
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
