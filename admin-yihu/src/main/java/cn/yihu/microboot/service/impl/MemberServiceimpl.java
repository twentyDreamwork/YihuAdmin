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
import cn.yihu.microboot.vo.Reward;

@Service
public class MemberServiceimpl implements MemberService{

	@Resource
	private MemberMapper membermapper;
	
	@Override
	public int add(Member member) {
		// TODO Auto-generated method stub
		UUIDTool uuidtool=new UUIDTool();
		DateTime datetime=new DateTime();
		Timestamp date=datetime.now().toSqlTimestamp();
		member.setId(uuidtool.getUUID());
		member.setCreater("System");
		member.setCreateTime(date);
		member.setUpdater("System");
		member.setUpdateTime(date);
		return membermapper.insertSelective(member);
	}

	@Override
	public int update(Member member) {
		// TODO Auto-generated method stub
		DateTime datetime=new DateTime();
		Timestamp date=datetime.now().toSqlTimestamp();
		member.setUpdateTime(date);
		return membermapper.updateByPrimaryKeySelective(member);
	}

	@Override
	public int delete(String id) {
		// TODO Auto-generated method stub
		return membermapper.deleteByPrimaryKey(id);
	}

	@Override
	public List<Member> select_page(Page page) {
		// TODO Auto-generated method stub
		int count=membermapper.count_all();
		page.setTotalCount(count);
		return membermapper.findpage((page.getPageNo()-1)*page.getPageSize(),page.getPageSize());
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

	@Override
	public int count() {
		// TODO Auto-generated method stub
		return membermapper.count_all();
	}
	
}
