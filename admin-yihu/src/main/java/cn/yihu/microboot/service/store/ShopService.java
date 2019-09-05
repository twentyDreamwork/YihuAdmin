package cn.yihu.microboot.service.store;

import cn.yihu.microboot.vo.Page;
import cn.yihu.microboot.vo.store.XeClassify;
import cn.yihu.microboot.vo.store.XeShop;

public interface ShopService {

	//web
	public int add(String shopname,String shopaddress,String shoptel);
	
	public int update(String id,String shopname,String shopaddress,String shoptel);
	
	public int delete(String id);
	
	public Page select_page(Page page);
	
	public XeShop select_one(String id);
	
}
