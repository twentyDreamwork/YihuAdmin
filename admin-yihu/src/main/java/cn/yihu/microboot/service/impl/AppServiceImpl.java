package cn.yihu.microboot.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.yihu.microboot.dao.APPMapper;
import cn.yihu.microboot.dao.IntegralMapper;
import cn.yihu.microboot.dao.InvitedUserMapper;
import cn.yihu.microboot.service.AppService;
import cn.yihu.microboot.vo.APP;
import cn.yihu.microboot.vo.Page;

@Service
public class AppServiceImpl implements AppService{

	@Resource
	private APPMapper appmapper;
	


	@Override
	public Page findAllAppPage(Page page) {
		// TODO Auto-generated method stub
		int count=appmapper.CountAllApp();
		page.setTotalCount(count);
		page.setResultList(appmapper.findAllApp((page.getPageNo()-1)*page.getPageSize(),page.getPageSize()));
		
		return page;
	}

	@Override
	public int insertApp(APP app) {
		// TODO Auto-generated method stub
		return appmapper.insertSelective(app);
	}

	@Override
	public int deleteApp(String appid) {
		// TODO Auto-generated method stub
		return appmapper.deleteByPrimaryKey(appid);
	}

	@Override
	public int updateApp(APP app) {
		// TODO Auto-generated method stub
		return appmapper.updateByPrimaryKeySelective(app);
	}
	
}
