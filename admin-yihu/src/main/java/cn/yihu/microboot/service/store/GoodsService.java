package cn.yihu.microboot.service.store;

import java.util.List;

import cn.yihu.microboot.vo.Page;
import cn.yihu.microboot.vo.goods.Goods;

public interface GoodsService {

	//web
	public int add();
	
	public int update();
	
	public int delete(String id);
	
	public List<Goods> select_page(Page page);
	
	public Goods select_one(String id);
	
	public int count();
	
}
