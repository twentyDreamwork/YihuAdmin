package cn.yihu.microboot.service;

import cn.yihu.microboot.vo.Page;
import net.sf.json.JSONObject;

public interface WebSystemService {

	public JSONObject findByUserNameAndPassword(String Username,String PassWord);
	
	public int CheckByUserNameAndPassword(String Username,String PassWord);
	
	public Page findAllUser(Page page);
	
	public int deleteUser(String userid);
	
	public int updateUser(String userid,String username,String name,String password);
	
	public int insertUser(String username,String name,String password);
	
}
