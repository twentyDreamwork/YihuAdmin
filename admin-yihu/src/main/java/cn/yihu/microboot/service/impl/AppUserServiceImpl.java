package cn.yihu.microboot.service.impl;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.yihu.microboot.dao.AppUserMapper;
import cn.yihu.microboot.dao.IntegralMapper;
import cn.yihu.microboot.dao.InvitedUserMapper;
import cn.yihu.microboot.service.AppUserService;
import cn.yihu.microboot.util.DateTime;
import cn.yihu.microboot.util.ShareCodeUtil;
import cn.yihu.microboot.util.StrUtil;
import cn.yihu.microboot.util.UUIDTool;
import cn.yihu.microboot.vo.AppUser;
import cn.yihu.microboot.vo.Page;
import net.sf.json.JSONObject;

@Service("appUserService")
@SuppressWarnings("unchecked")
public class AppUserServiceImpl implements AppUserService{

	@Autowired
	private AppUserMapper usermapper;
	
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
		AppUser user=new AppUser();
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
	public AppUser find_user(String mc) {
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
	public AppUser find_user_machineCode(String machinecode) {
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
	public int UpdateUser(JSONObject login_json,AppUser olduser) {
		// TODO Auto-generated method stub
		AppUser user=new AppUser();
		Date date=DateTime.now().toDate();
		
		user.setId(olduser.getId());
		user.setPlatform(login_json.getInt("platform"));
		user.setMachinecode(login_json.getString("MachineCode"));
		user.setUpdater(olduser.getUsername());
		user.setLogintime(date);
		
		int result=usermapper.updateById(user);
		
		return result;
	}


	@Override
	public List<AppUser> findAllAppUserPage(Page page,String sort) {
		// TODO Auto-generated method stub
		String[] s=sort.split(",");
		return usermapper.findAllUser((page.getPageNo()-1)*page.getPageSize(),page.getPageSize(),s[0],s[1]);
	}


	@Override
	public int insertAppUser(AppUser user) {
		// TODO Auto-generated method stub
		Date date=DateTime.now().toDate();
		UUIDTool uuid=new UUIDTool();
		//AppUser user=new AppUser();
		user.setId(uuid.getUUID());
		//user.setWxid(wxid);
		//user.setUsername(username);
		//user.setPassword(password);
		//user.setPhone(phone);
		//user.setPlatform(Integer.parseInt(platform));
		//user.setMachinecode(MachineCode);
		//user.setIp(IP);
		user.setCreatetime(date);
		user.setUpdatetime(date);
		//user.setCreater(creater);
		//user.setUpdater(creater);
		int result=usermapper.insertSelective(user);
		return result;
	}


	@Override
	public int deleteAppUser(String id) {
		// TODO Auto-generated method stub
		return usermapper.deleteByPrimaryKey(id);
	}


	@Override
	public int updateAppUser(AppUser user) {
		// TODO Auto-generated method stub
		Date date=DateTime.now().toDate();
		/*
		 * AppUser user=new AppUser(); user.setId(id); user.setWxid(wxid);
		 * user.setUsername(username); user.setPassword(password); user.setPhone(phone);
		 * user.setPlatform(Integer.parseInt(platform));
		 * user.setMachinecode(MachineCode); user.setIp(IP);
		 */
		user.setUpdatetime(date);
		//user.setUpdater(updater);
		int result=usermapper.updateByPrimaryKeySelective(user);
		return result;
	}


	@Override
	public int check_wxid(String wxid) {
		// TODO Auto-generated method stub
		return usermapper.checkwxid(wxid);
	}


	@Override
	public int count() {
		// TODO Auto-generated method stub
		return usermapper.countAllUser();
	}

}
