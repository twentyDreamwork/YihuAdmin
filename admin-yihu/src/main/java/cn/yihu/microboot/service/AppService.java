package cn.yihu.microboot.service;

import cn.yihu.microboot.vo.APP;
import cn.yihu.microboot.vo.Page;

public interface AppService {

	public Page findAllAppPage(Page page);
	
	public int insertApp(APP app);
	
	public int deleteApp(String appid);
	
	public int updateApp(APP app);
}
