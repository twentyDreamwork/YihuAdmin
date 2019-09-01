package cn.yihu.microboot.controller.api;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import cn.yihu.microboot.util.HttpRequest;
import io.swagger.annotations.Api;
import net.sf.json.JSONObject;

@Api(value = "微信信息")
@RestController
@RequestMapping("/api")
public class WeixinController {

	//获取token
	private final String get_access_token="https://api.weixin.qq.com/sns/oauth2/access_token";
	//获取用户信息
	private final String get_userinfo="https://api.weixin.qq.com/sns/userinfo";
	
	//appid=APPID&secret=SECRET&code=CODE&grant_type=authorization_code
	// access_token=ACCESS_TOKEN&openid=OPENID
	//获取微信用户信息
	@RequestMapping(value = "/getWeixinInfo", method = RequestMethod.GET)
	public JSONObject getWeixinInfo(String appid,String secret,String code) {
		HttpRequest http=new HttpRequest();
		String text="appid="+appid+"&secret="+secret+"&code="+code+"&grant_type=authorization_code";
		JSONObject result=JSONObject.fromObject(http.sendGet(get_access_token, text));
		
		text=null;
		
		text="access_token="+result.getString("access_token")+"&openid="+result.getString("openid");
	
		result=JSONObject.fromObject(http.sendGet(get_userinfo, text));
		
		return result;
	}
	
}
