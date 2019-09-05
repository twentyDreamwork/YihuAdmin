package cn.yihu.microboot.service.store;

import java.util.List;

import cn.yihu.microboot.util.Results;
import cn.yihu.microboot.vo.Integral;
import cn.yihu.microboot.vo.Page;
import cn.yihu.microboot.vo.goods.IntegralGoods;

public interface IntegralGoodsService {

	//添加
	public Results<Boolean> add(IntegralGoods ig);
	
	//修改
	public Results<Boolean> update(IntegralGoods ig);
	
	//删除
	public Results<Boolean> delete(String id);
	
	//列表
	public List<IntegralGoods> listpage(Page page);
	
	//总数
	public int count();
}
