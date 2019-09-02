package cn.yihu.microboot.service.impl.goods;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.yihu.microboot.mapper.goods.CarouselMapper;
import cn.yihu.microboot.mapper.goods.ClassifyMapper;
import cn.yihu.microboot.mapper.goods.GoodsMapper;
import cn.yihu.microboot.service.goods.AppGoodsService;
import cn.yihu.microboot.util.Results;
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


	
}
