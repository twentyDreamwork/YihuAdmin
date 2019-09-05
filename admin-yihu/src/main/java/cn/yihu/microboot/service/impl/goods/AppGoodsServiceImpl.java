package cn.yihu.microboot.service.impl.goods;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.yihu.microboot.mapper.goods.CarouselMapper;
import cn.yihu.microboot.mapper.goods.ClassifyMapper;
import cn.yihu.microboot.mapper.goods.GoodsMapper;
import cn.yihu.microboot.service.goods.AppGoodsService;
import cn.yihu.microboot.util.Results;
import cn.yihu.microboot.vo.Page;
import cn.yihu.microboot.vo.goods.Carousel;
import cn.yihu.microboot.vo.goods.Classify;
import cn.yihu.microboot.vo.goods.Goods;
import cn.yihu.microboot.vo.goods.res.AppIndex;

/**
 * 商品分类实现
 * @author Administrator
 *
 */
@Service("appGoodsService")
@SuppressWarnings("unchecked")
public class AppGoodsServiceImpl implements AppGoodsService{

	@Autowired
	private ClassifyMapper classifyMapper;
	@Autowired
	private CarouselMapper carouselMapper;
	@Autowired
	private GoodsMapper goodsMapper;
	
	
	@Override
	public Results<List<Classify>> queryAllClassify() {
		return Results.resultSucc(classifyMapper.queryAllClassify());
	}

	@Override
	public Results<List<Classify>> queryMajorClassify() {
		return Results.resultSucc(classifyMapper.queryMajorClassify());
	}

	
	@Override
	public Results<List<Classify>> queryAllClassifyByParentId(String parentId) {
		return Results.resultSucc(classifyMapper.queryAllClassifyByParentId(parentId));
	}


	@Override
	public Results<List<Carousel>> queryAllCarousel() {
		return Results.resultSucc(carouselMapper.queryAllCarousel());
	}


	@Override
	public Results<AppIndex> appIndex() {
		AppIndex appIndex = new AppIndex();
		appIndex.setCarousels(carouselMapper.queryAllCarousel());
		appIndex.setMajorClassifys(classifyMapper.queryMajorClassify());
		return Results.resultSucc(appIndex);
	}

	@Override
	public Results<List<Goods>> queryGoodsByCateId(String cateId) {
		return Results.resultSucc(goodsMapper.queryGoodsByCateId(cateId));
	}

	@Override
	public Results<List<Goods>> queryhotGoods(Page page) {
		// TODO Auto-generated method stub
		int count = goodsMapper.count_hot();
		page.setTotalCount(count);
		return Results.resultSucc(goodsMapper.findHotGoodsPage((page.getPageNo()-1)*page.getPageSize(),page.getPageSize()));
	}

	@Override
	public Results<List<Goods>> queryrecommendGoods(Page page) {
		// TODO Auto-generated method stub
		int count = goodsMapper.count_hot();
		page.setTotalCount(count);
		return Results.resultSucc(goodsMapper.findrecommendGoodsPage((page.getPageNo()-1)*page.getPageSize(),page.getPageSize()));
	}

	@Override
	public Results<Boolean> insertClassify(Classify classify) {
		return classifyMapper.insert(classify) > 0 ? Results.resultSucc() : Results.resultErr();
	}

	@Override
	public Results<Boolean> updateClassify(Classify classify) {
	    return classifyMapper.updateAllColumnById(classify) > 0 ? Results.resultSucc() : Results.resultErr();
	}

	@Override
	public Results<Boolean> insertCarousel(Carousel carousel) {
		return carouselMapper.insert(carousel) > 0 ? Results.resultSucc() : Results.resultErr();
	}

	@Override
	public Results<Boolean> updateCarousel(Carousel carousel) {
		  return carouselMapper.updateAllColumnById(carousel) > 0 ? Results.resultSucc() : Results.resultErr();
	}

	@Override
	public Results<Boolean> delCarousel(Integer id) {
		return carouselMapper.deleteById(id)> 0 ? Results.resultSucc() : Results.resultErr();
	}

	
	
}
