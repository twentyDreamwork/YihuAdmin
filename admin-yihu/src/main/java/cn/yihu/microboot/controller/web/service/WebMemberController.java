package cn.yihu.microboot.controller.web.service;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import cn.yihu.microboot.service.MemberService;
import cn.yihu.microboot.util.CommonCode;
import cn.yihu.microboot.util.Results;
import cn.yihu.microboot.vo.Member;
import cn.yihu.microboot.vo.Page;
import io.swagger.annotations.Api;

//会员
@Api(value = "web会员管理")
@RestController
@RequestMapping("/service/member")
public class WebMemberController {
	
	@Resource
	private MemberService memberservice;

	//添加
	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public Results add(String member_name,String level,String icon,String addition) {
		int i=memberservice.add(member_name, level, icon, addition);
		if(i==0) {
			return new Results(CommonCode.FAIL);
		}
		return new Results(CommonCode.SUCCESS);
	}
	//修改
	@RequestMapping(value = "/update", method = RequestMethod.GET)
	public Results update(String id,String member_name,String level,String icon,String addition) {
		int i=memberservice.update(id, member_name, level, icon, addition);
		if(i==0) {
			return new Results(CommonCode.FAIL);
		}
		return new Results(CommonCode.SUCCESS);
	}
	//删除
	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	public Results delete(String id) {
		int i=memberservice.delete(id);
		if(i==0) {
			return new Results(CommonCode.FAIL);
		}
		return new Results(CommonCode.SUCCESS);
	}
	//查询
	@RequestMapping(value = "/page", method = RequestMethod.GET)
	public Results select_page(String pageno) {
		Page page=new Page<>(Integer.parseInt(pageno));
		page = memberservice.select_page(page);
		return new Results<Page>(CommonCode.SUCCESS,page);
	}
	@RequestMapping(value = "/one", method = RequestMethod.GET)
	public Results select_one(String id) {
		return new Results<Member>(CommonCode.SUCCESS,memberservice.select_one(id));
	}
	
}
