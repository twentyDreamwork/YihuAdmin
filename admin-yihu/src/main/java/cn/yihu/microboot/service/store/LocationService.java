package cn.yihu.microboot.service.store;

import cn.yihu.microboot.vo.Page;
import cn.yihu.microboot.vo.store.XeClassify;
import cn.yihu.microboot.vo.store.XeLocation;

public interface LocationService {

	//web
	public int add(String lname,int pid,int sort);
	
	public int update(String id,String lname,int pid,int sort,int display);
	
	public int delete(String id);
	
	public Page select_page(Page page);
	
	public XeLocation select_one(String id);
	
}
