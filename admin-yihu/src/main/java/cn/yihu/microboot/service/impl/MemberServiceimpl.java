package cn.yihu.microboot.service.impl;

import java.sql.Timestamp;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.yihu.microboot.dao.MemberMapper;
import cn.yihu.microboot.service.MemberService;
import cn.yihu.microboot.util.DateTime;
import cn.yihu.microboot.util.UUIDTool;
import cn.yihu.microboot.vo.Member;
import cn.yihu.microboot.vo.Page;

@Service
public class MemberServiceimpl implements MemberService{

	@Resource
	private MemberMapper membermapper;
	
	@Override
	public int add(String member_name, String level, String icon, String addition) {
		// TODO Auto-generated method stub
		UUIDTool uuidtool=new UUIDTool();
		DateTime datetime=new DateTime();
		Timestamp date=datetime.now().toSqlTimestamp();
		Member member=new Member(uuidtool.getUUID(), member_name, Integer.parseInt(level), Integer.parseInt(icon), Integer.parseInt(addition), "System", date, "System", date);
		return membermapper.insertSelective(member);
	}

	@Override
	public int update(String id, String member_name, String level, String icon, String addition) {
		// TODO Auto-generated method stub
		DateTime datetime=new DateTime();
		Timestamp date=datetime.now().toSqlTimestamp();
		Member member=new Member(id, member_name, Integer.parseInt(level), Integer.parseInt(icon), Integer.parseInt(addition), null, null, "System", date);
		return membermapper.updateByPrimaryKeySelective(member);
	}

	@Override
	public int delete(String id) {
		// TODO Auto-generated method stub
		return membermapper.deleteByPrimaryKey(id);
	}

	@Override
	public Page select_page(Page page) {
		// TODO Auto-generated method stub
		int count=membermapper.count_all();
		page.setTotalCount(count);
		page.setResultList(membermapper.findpage((page.getPageNo()-1)*page.getPageSize(),page.getPageSize()));
		return page;
	}

	@Override
	public Member select_one(String id) {
		// TODO Auto-generated method stub
		return membermapper.selectByPrimaryKey(id);
	}
	
	@Override
	public List<Member> member_list() {
		// TODO Auto-generated method stub
		return membermapper.findall();
	}
	
}
