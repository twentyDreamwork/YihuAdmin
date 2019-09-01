package cn.yihu.microboot.service.impl;

import java.sql.Timestamp;
import java.util.Date;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.yihu.microboot.dao.IntegralMapper;
import cn.yihu.microboot.dao.InvitedUserMapper;
import cn.yihu.microboot.dao.UserMapper;
import cn.yihu.microboot.service.UserService;
import cn.yihu.microboot.util.DateTime;
import cn.yihu.microboot.util.ShareCodeUtil;
import cn.yihu.microboot.util.StrUtil;
import cn.yihu.microboot.util.UUIDTool;
import cn.yihu.microboot.vo.Page;
import cn.yihu.microboot.vo.User;
import net.sf.json.JSONObject;

@Service
public class UserServiceImpl implements UserService{

	@Resource
	private UserMapper usermapper;
	
	@Resource
	private IntegralMapper integermapper;
	
	@Resource
	private InvitedUserMapper invitedusermapper;
	
	/**
	 *注册
	 */
	@Override
	public int add_user(JSONObject register_json) {
		// TODO Auto-generated method stub
		UUIDTool uuidtool=new UUIDTool();
		ShareCodeUtil scu=new ShareCodeUtil();
		DateTime datetime=new DateTime();
		Timestamp date=datetime.now().toSqlTimestamp();
		String uuid=uuidtool.getUUID();
		User user=new User();
		user.setId(uuid);
		user.setWxid(register_json.getString("wxid"));
		user.setUsername(register_json.getString("username"));
		user.setPlatform(register_json.getInt("platform"));
		user.setMachinecode(register_json.getString("MachineCode"));
		user.setInvitationcode(register_json.getString("wxid"));
		user.setCreater("System");
		user.setUpdater("System");
		user.setCreatetime(date);
		user.setUpdatetime(date);
		user.setLogintime(date);
		user.setHeadimgurl(register_json.getString("headimgurl"));
		
		int i=usermapper.insertSelective(user);
		
		
		return i;
	}

	
	@Override
	public User find_user(String mc) {
		// TODO Auto-generated method stub
		return usermapper.selectByMachineCode(mc);
	}

	@Override
	public boolean check_machineCode(String machinecode) {
		// TODO Auto-generated method stub
		int result=usermapper.checkMachineCode(machinecode);
		if(result!=0) {
			return true;
		}
		return false;
	}


	@Override
	public User find_user_machineCode(String machinecode) {
		// TODO Auto-generated method stub
		return usermapper.selectByMachineCode(machinecode);
	}

	@Override
	public int del_user(String userid) {
		// TODO Auto-generated method stub
		int result=usermapper.deleteByPrimaryKey(userid);
		if(result==0) {
			return 0;
		}
		result=integermapper.deleteByUserId(userid);
		if(result==0) {
			return 0;
		}
		result=invitedusermapper.deleteByUserid(userid);
		if(result==0) {
			return 0;
		}
		return 1;
	}

	@Override
	public int UpdateUser(JSONObject login_json,User olduser) {
		// TODO Auto-generated method stub
		User user=new User();
		Date date=DateTime.now().toDate();
		
		user.setId(olduser.getId());
		user.setPlatform(login_json.getInt("platform"));
		user.setMachinecode(login_json.getString("MachineCode"));
		user.setUpdater(olduser.getUsername());
		user.setLogintime(date);
		
		int result=usermapper.updateByPrimaryKeySelective(user);
		
		return result;
	}


	@Override
	public Page findAllAppUserPage(Page page) {
		// TODO Auto-generated method stub
		int count=usermapper.countAllUser();
		page.setTotalCount(count);
		page.setResultList(usermapper.findAllUser((page.getPageNo()-1)*page.getPageSize(),page.getPageSize()));
		return page;
	}


	@Override
	public int insertAppUser(String wxid, String username, String password, String phone, String platform,
			String MachineCode, String IP, String creater) {
		// TODO Auto-generated method stub
		Date date=DateTime.now().toDate();
		UUIDTool uuid=new UUIDTool();
		User user=new User();
		user.setId(uuid.getUUID());
		user.setWxid(wxid);
		user.setUsername(username);
		user.setPassword(password);
		user.setPhone(phone);
		user.setPlatform(Integer.parseInt(platform));
		user.setMachinecode(MachineCode);
		user.setIp(IP);
		user.setCreatetime(date);
		user.setUpdatetime(date);
		user.setCreater(creater);
		user.setUpdater(creater);
		int result=usermapper.insertSelective(user);
		return result;
	}


	@Override
	public int deleteAppUser(String id) {
		// TODO Auto-generated method stub
		return usermapper.deleteByPrimaryKey(id);
	}


	@Override
	public int updateAppUser(String id, String wxid, String username, String password, String phone, String platform,
			String MachineCode, String IP, String updater) {
		// TODO Auto-generated method stub
		Date date=DateTime.now().toDate();
		User user=new User();
		user.setId(id);
		user.setWxid(wxid);
		user.setUsername(username);
		user.setPassword(password);
		user.setPhone(phone);
		user.setPlatform(Integer.parseInt(platform));
		user.setMachinecode(MachineCode);
		user.setIp(IP);
		user.setUpdatetime(date);
		user.setUpdater(updater);
		int result=usermapper.updateByPrimaryKeySelective(user);
		return result;
	}


	@Override
	public int check_wxid(String wxid) {
		// TODO Auto-generated method stub
		return usermapper.checkwxid(wxid);
	}

}
