package cn.yihu.microboot.service.store;

import cn.yihu.microboot.vo.Page;
import cn.yihu.microboot.vo.store.XeClassify;
import cn.yihu.microboot.vo.store.XeComment;

public interface CommentService {

	//web
	public int add();
	
	public int update();
	
	public int delete(String id);
	
	public Page select_page(Page page);
	
	public XeComment select_one(String id);
	
}
