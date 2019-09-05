package cn.yihu.microboot.service.store;

import java.math.BigDecimal;

import cn.yihu.microboot.vo.Page;
import cn.yihu.microboot.vo.store.XeClassify;
import cn.yihu.microboot.vo.store.XeOrder;

public interface OrderService {

	//web
	public int add(String userid,String goodsid,BigDecimal totalmoney);
	
	public int update(String id,String userid,String goodsid,BigDecimal totalmoney);
	
	public int delete(String id);
	
	public Page select_page(Page page);
	
	public XeOrder select_one(String id);
	
}
