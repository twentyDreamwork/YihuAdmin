package cn.yihu.microboot.service.store.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.yihu.microboot.dao.store.XeGoodsMapper;
import cn.yihu.microboot.service.store.GoodsService;
import cn.yihu.microboot.vo.Page;
import cn.yihu.microboot.vo.goods.Goods;
import cn.yihu.microboot.vo.store.XeGoods;

/**
 * 商品管理实现
 * @author leqi
 *
 */
@Service("GoodsService")
@SuppressWarnings("unchecked")
public class GoodsServiceimpl implements GoodsService {

	@Autowired
	public XeGoodsMapper goodsmapper;
	
	@Override
	public int add() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int update() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(String id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<Goods> select_page(Page page) {
		// TODO Auto-generated method stub
		return goodsmapper.findpage((page.getPageNo()-1)*page.getPageSize(),page.getPageSize());
	}

	@Override
	public Goods select_one(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int count() {
		// TODO Auto-generated method stub
		return goodsmapper.count_all();
	}

}
