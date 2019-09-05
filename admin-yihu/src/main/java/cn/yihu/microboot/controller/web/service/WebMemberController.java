package cn.yihu.microboot.controller.web.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import cn.yihu.microboot.config.JSONInitialize;
import cn.yihu.microboot.service.MemberService;
import cn.yihu.microboot.util.CommonCode;
import cn.yihu.microboot.util.Results;
import cn.yihu.microboot.vo.APP;
import cn.yihu.microboot.vo.Member;
import cn.yihu.microboot.vo.Page;
import io.swagger.annotations.Api;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

//会员
@Api(value = "web会员管理")
@RestController
@RequestMapping("/service")
public class WebMemberController {
	
	@Resource
	private MemberService memberservice;

	//添加
	@PostMapping("/addmember")
	public Results add(@RequestBody Member member) {
		int i=memberservice.add(member);
		if(i==0) {
			return new Results(CommonCode.FAIL);
		}
		return new Results(CommonCode.SUCCESS);
	}
	//修改
	@PostMapping("/updatemember")
	public Results update(@RequestBody Member member) {
		int i=memberservice.update(member);
		if(i==0) {
			return new Results(CommonCode.FAIL);
		}
		return new Results(CommonCode.SUCCESS);
	}
	//删除
	@DeleteMapping("/deletemember/{id}")
	public Results delete(@PathVariable("id") String id) {
		int i=memberservice.delete(id);
		if(i==0) {
			return new Results(CommonCode.FAIL);
		}
		return new Results(CommonCode.SUCCESS);
	}
	//查询
	@GetMapping("/getmemberlist")
	public JSONObject select_page(String pageno,String size,String sort) {
		JSONObject res_json = new JSONObject();
		int count = memberservice.count();
		Page page=new Page<>(Integer.parseInt(pageno),Integer.parseInt(size),count);
		List<Member> applist=memberservice.select_page(page);
		JSONArray jsonarray=JSONArray.fromObject(applist, new JSONInitialize().JSONDateConfig());
		res_json.put("content", jsonarray);
		res_json.put("totalElements", count);
		return res_json;
	}
	
	@RequestMapping(value = "/one", method = RequestMethod.GET)
	public Results select_one(String id) {
		return new Results<Member>(CommonCode.SUCCESS,memberservice.select_one(id));
	}
	
}
