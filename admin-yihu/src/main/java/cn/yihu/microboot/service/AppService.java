package cn.yihu.microboot.service;

import java.util.List;

import cn.yihu.microboot.vo.APP;
import cn.yihu.microboot.vo.Page;

public interface AppService {

	public List<APP> findAllAppPage(Page page);
	
	public int insertApp(APP app);
	
	public int deleteApp(String appid);
	
	public int updateApp(APP app);
	
	public int count();
}
