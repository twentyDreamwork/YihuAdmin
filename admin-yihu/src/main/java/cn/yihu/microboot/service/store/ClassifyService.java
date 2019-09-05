package cn.yihu.microboot.service.store;

import cn.yihu.microboot.vo.Page;
import cn.yihu.microboot.vo.store.XeClassify;

public interface ClassifyService {

	//web
	public int add(String classifyname,String parentid,int depth,int priority,String keywords,String title,String description);
	
	public int update(String id,String classifyname,String parentid,int depth,int status,int priority,String keywords,String title,String description);
	
	public int delete(String id);
	
	public Page select_page(Page page);
	
	public XeClassify select_one(String id);
	
}
