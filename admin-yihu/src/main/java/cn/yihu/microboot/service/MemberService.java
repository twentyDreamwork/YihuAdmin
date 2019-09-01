package cn.yihu.microboot.service;

import java.util.List;

import cn.yihu.microboot.vo.Member;
import cn.yihu.microboot.vo.Page;

public interface MemberService {

	//web
	public int add(String member_name,String level,String icon,String addition);
	
	public int update(String id,String member_name,String level,String icon,String addition);
	
	public int delete(String id);
	
	public Page select_page(Page page);
	
	public Member select_one(String id);

	
	//api
	public List<Member> member_list();
	
	
	
}
