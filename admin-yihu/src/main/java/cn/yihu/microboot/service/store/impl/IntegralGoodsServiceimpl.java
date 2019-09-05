package cn.yihu.microboot.service.store.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import cn.yihu.microboot.dao.IntegralGoodsMapper;
import cn.yihu.microboot.service.store.IntegralGoodsService;
import cn.yihu.microboot.util.Results;
import cn.yihu.microboot.util.UUIDTool;
import cn.yihu.microboot.vo.Page;
import cn.yihu.microboot.vo.goods.IntegralGoods;

public class IntegralGoodsServiceimpl implements IntegralGoodsService{

	@Autowired
	public IntegralGoodsMapper integralgoodsmapper;
	
	@Override
	public Results<Boolean> add(IntegralGoods ig) {
		// TODO Auto-generated method stub
		UUIDTool uuidtool=new UUIDTool();
		ig.setId(uuidtool.getUUID());
		return integralgoodsmapper.insert(ig)> 0 ? Results.resultSucc() : Results.resultErr();
	}

	@Override
	public Results<Boolean> update(IntegralGoods ig) {
		// TODO Auto-generated method stub
		return integralgoodsmapper.updateById(ig)> 0 ? Results.resultSucc() : Results.resultErr();
	}

	@Override
	public Results<Boolean> delete(String id) {
		// TODO Auto-generated method stub
		return integralgoodsmapper.deleteById(id)> 0 ? Results.resultSucc() : Results.resultErr();
	}

	@Override
	public List<IntegralGoods> listpage(Page page) {
		// TODO Auto-generated method stub
		int count = integralgoodsmapper.count();
		page.setTotalCount(count);
		return integralgoodsmapper.listpage((page.getPageNo()-1)*page.getPageSize(),page.getPageSize());
	}

	@Override
	public int count() {
		// TODO Auto-generated method stub
		return integralgoodsmapper.count();
	}

}
