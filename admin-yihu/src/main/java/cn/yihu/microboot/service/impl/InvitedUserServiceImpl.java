package cn.yihu.microboot.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.yihu.microboot.dao.InvitedUserMapper;
import cn.yihu.microboot.service.InvitedUserService;
import cn.yihu.microboot.vo.InvitedUser;

@Service
public class InvitedUserServiceImpl implements InvitedUserService{

	@Resource
	private InvitedUserMapper invitedusermapper;
	
	@Override
	public int add_invited(String invitationCode, String userid) {
		// TODO Auto-generated method stub
		InvitedUser inviteduser=new InvitedUser(invitationCode, userid);
		int result=invitedusermapper.insertSelective(inviteduser);
		return result;
	}

}
