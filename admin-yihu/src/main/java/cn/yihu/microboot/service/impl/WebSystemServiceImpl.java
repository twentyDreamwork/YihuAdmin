package cn.yihu.microboot.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.yihu.microboot.dao.WebUserMapper;
import cn.yihu.microboot.service.WebSystemService;
import cn.yihu.microboot.util.UUIDTool;
import cn.yihu.microboot.vo.Page;
import cn.yihu.microboot.vo.WebUser;
import net.sf.json.JSONObject;

@Service
public class WebSystemServiceImpl implements WebSystemService{

	@Resource
	private WebUserMapper webusermapper;

	@Override
	public JSONObject findByUserNameAndPassword(String Username, String PassWord) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int CheckByUserNameAndPassword(String Username, String PassWord) {
		// TODO Auto-generated method stub
		return webusermapper.checkUser(Username, PassWord);
	}

	@Override
	public Page findAllUser(Page page) {
		// TODO Auto-generated method stub
		int count = webusermapper.CountAllUser();
		if(count==0) {
			page.setTotalCount(0);
			page.setPageNaviSize(1);
			page.setResultList(null);
			return page;
		}
		page.setTotalCount(count);
		page.setResultList(webusermapper.findAllUser((page.getPageNo()-1)*page.getPageSize(),page.getPageSize()));
		
		
		
		return page;
	}

	@Override
	public int deleteUser(String userid) {
		// TODO Auto-generated method stub
		return webusermapper.deleteByPrimaryKey(userid);
	}

	@Override
	public int updateUser(String userid,String username, String name, String password) {
		// TODO Auto-generated method stub
		WebUser webuser=new WebUser(userid, username, name, password);
		return webusermapper.updateByPrimaryKeySelective(webuser);
	}

	@Override
	public int insertUser(String username, String name, String password) {
		// TODO Auto-generated method stub
		UUIDTool uuid=new UUIDTool();
		WebUser webuser=new WebUser(uuid.getUUID(), username, name, password);
		return webusermapper.insertSelective(webuser);
	}

}
