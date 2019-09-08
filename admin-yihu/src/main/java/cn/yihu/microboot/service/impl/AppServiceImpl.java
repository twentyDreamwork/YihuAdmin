package cn.yihu.microboot.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.yihu.microboot.dao.APPMapper;
import cn.yihu.microboot.service.AppService;
import cn.yihu.microboot.vo.APP;
import cn.yihu.microboot.vo.Page;

@Service("appService")
@SuppressWarnings("unchecked")
public class AppServiceImpl implements AppService{

	@Resource
	private APPMapper appmapper;
	


	@Override
	public List<APP> findAllAppPage(Page page) {
		// TODO Auto-generated method stub
		return appmapper.findAllApp((page.getPageNo()-1)*page.getPageSize(),page.getPageSize());
	}

	@Override
	public int insertApp(APP app) {
		// TODO Auto-generated method stub
		
		return appmapper.insert(app);
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

	@Override
	public int count() {
		// TODO Auto-generated method stub
		return appmapper.CountAllApp();
	}
	
}
