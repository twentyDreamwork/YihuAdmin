package cn.yihu.microboot.controller.api;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import cn.yihu.microboot.service.AppUserService;
import cn.yihu.microboot.service.IntegralService;
import cn.yihu.microboot.service.InvitedUserService;
import cn.yihu.microboot.service.api.ApiCheckService;
import cn.yihu.microboot.util.controller.AbstractBaseController;
import cn.yihu.microboot.vo.AppUser;
import io.swagger.annotations.Api;
import net.sf.json.JSONObject;

@Api(value = "用户管理")
@RestController
@RequestMapping("/api")
public class AppUserController extends AbstractBaseController{

	@Resource
	private AppUserService userService;
	
	@Resource
	private ApiCheckService apicheckService;
	
	@Resource
	private IntegralService integralService;
	
	@Resource
	private InvitedUserService inviteduserService;
	
//    注册
	//{ "username", "password", "phone", "platform","MachineCode", "ip","InvitationCode"};
	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public JSONObject register(String nickname,String unionid,String platform,String MachineCode,String InvitationCode,String headimgurl) { // 通过model可以实现内容的传递
		JSONObject res_json = new JSONObject();
		JSONObject now_json = new JSONObject();
		now_json.put("username", nickname);
		now_json.put("wxid", unionid);
		now_json.put("headimgurl", headimgurl);
		now_json.put("platform", platform);
		now_json.put("MachineCode", MachineCode);
		now_json.put("InvitationCode", InvitationCode);
		
		//检验设备是否已注册
		if(userService.check_machineCode(now_json.getString("MachineCode"))) {
			res_json.put("code", 102);
			res_json.put("msg", "该机器已注册");
			return res_json;
		}
		//检验用户是否已注册
		if(userService.check_wxid(now_json.getString("wxid"))==1) {
			res_json.put("code", 102);
			res_json.put("msg", "该用户已注册");
			return res_json;
		}
		//用户表添加信息
		int result=userService.add_user(now_json);
		if(result==0) {
			res_json.put("code", 103);
			res_json.put("msg", "用户表插入失败,注册失败");
			return res_json;
		}
		//根据机器码进行查询
		AppUser user=userService.find_user_machineCode(now_json.getString("MachineCode"));
		String invitationCode=now_json.getString("InvitationCode");
		String userid=user.getId();
		//添加到邀请信息表
		if(!now_json.getString("InvitationCode").equals("0")) {
			result=inviteduserService.add_invited(invitationCode,userid);
			if(result==0) {
				res_json.put("code", 103);
				res_json.put("msg", "数据异常,注册失败");
				return res_json;
			}
		}
		//积分表添加信息
		result=integralService.add_integral(user.getId());
		if(result==0) {
			res_json.put("code", 103);
			res_json.put("msg", "积分表插入失败,注册失败");
			return res_json;
		}
		//邀请提成
		
		
		res_json.put("code", 200);
		res_json.put("msg", "注册成功");
		return res_json ; 
	}
	
//  登录
	//{ "username", "password", "phone","platform","MachineCode","ip"}; 
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public JSONObject login(String platform,String MachineCode) { // 通过model可以实现内容的传递
		JSONObject res_json = new JSONObject();
		JSONObject now_json = new JSONObject();
		JSONObject data_json = new JSONObject();
		
		now_json.put("platform", platform);
		now_json.put("MachineCode", MachineCode);
		now_json.put("ip", "0");
		
		
		/*
		 * if(now_json.getString("wxid").length()==0) { res_json.put("code", 200);
		 * res_json.put("login", 0); res_json.put("msg", "不存在该用户或密碼錯誤"); return
		 * res_json; }
		 */
		
		//查询登录信息
		AppUser user=userService.find_user(now_json.getString("MachineCode").isEmpty()?null:now_json.getString("MachineCode"));
		if(user==null) {
			res_json.put("code", 200);
			res_json.put("login", 0);
			res_json.put("msg", "不存在该用户或密碼錯誤");
			return res_json;
		}
		
		int result=userService.UpdateUser(now_json,user);
		
		data_json=JSONObject.fromObject(user);
		
		res_json.put("code", 200);
		res_json.put("login", 1);
		res_json.put("usr", data_json);
		res_json.put("msg", "成功");
		return res_json ; 
	}
	
}
