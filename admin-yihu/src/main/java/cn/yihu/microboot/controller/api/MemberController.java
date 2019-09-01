package cn.yihu.microboot.controller.api;

import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import cn.yihu.microboot.service.MemberService;
import cn.yihu.microboot.vo.Member;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import net.sf.json.JSONObject;

@Api(value = "会员管理")
@RestController
@RequestMapping("/api")
public class MemberController {
	
	private MemberService memberservice;

	//会员信息列表
	@ApiOperation(value="会员信息列表")
	@RequestMapping(value = "/memberlist", method = RequestMethod.GET)
	public JSONObject member_list() {
		JSONObject res_json=new JSONObject();
		List<Member> memberlist=memberservice.member_list();
		
		res_json.put("code", 200);
		res_json.put("data", memberlist);
		res_json.put("msg", "成功");
		return res_json;
	}
	
	//用户会员信息
	public JSONObject user_member() {
		return null;
	}
	
}
