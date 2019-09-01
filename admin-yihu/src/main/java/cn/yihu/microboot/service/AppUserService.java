package cn.yihu.microboot.service;

import cn.yihu.microboot.vo.APP;
import cn.yihu.microboot.vo.AppUser;
import cn.yihu.microboot.vo.Page;
import net.sf.json.JSONObject;

public interface AppUserService {

	public int add_user(JSONObject register_json);
	
	public AppUser find_user(String machinecode);
	
	public boolean check_machineCode(String machinecode);
    
	public AppUser find_user_machineCode(String machinecode) ;
	
	public int del_user(String userid);
	
	public int UpdateUser(JSONObject login_json,AppUser user);
	
	public int check_wxid(String wxid);
	
	
    public Page findAllAppUserPage(Page page);
	
	public int insertAppUser(String wxid,String username,String password,String phone, String platform, String MachineCode, String IP,String creater);
	
	public int deleteAppUser(String id);
	
	public int updateAppUser(String id,String wxid,String username,String password,String phone, String platform, String MachineCode, String IP,String updater);
    
	
}
