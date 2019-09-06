package cn.yihu.microboot.service.goods;

import java.util.List;

import cn.yihu.microboot.util.Results;
import cn.yihu.microboot.vo.Page;
import cn.yihu.microboot.vo.goods.Carousel;
import cn.yihu.microboot.vo.goods.Classify;
import cn.yihu.microboot.vo.goods.Goods;
import cn.yihu.microboot.vo.goods.res.AppIndex;

/**
 * 商品分类
 * @author Yang
 *
 */
public interface AppGoodsService {
	
	
	/**
	 * 获取全部分类
	 * @return
	 */
	Results<List<Classify>> queryAllClassify();
	
	

	/**
	 * 获取商品一级分类
	 * @return
	 */
	Results<List<Classify>> queryMajorClassify();
	
	
	
	/**
	 * 根据父级ID获取商品分类
	 * @param parentId
	 * @return
	 */
	Results<List<Classify>> queryAllClassifyByParentId(String parentId);
	
	
	/**
	 * 获取轮播
	 * @return
	 */
	Results<List<Carousel>> queryAllCarousel();
	
	
	/**
	 * app首页
	 * @return
	 */
	Results<AppIndex> appIndex();
	
	
	/**
	 * 根据商品二级分类 查询商品
	 * @param cateId
	 * @return
	 */
	Results<List<Goods>> queryGoodsByCateId(String cateId);
	
	/**
	 * 获取热门商品
	 * @return
	 */
	Results<List<Goods>> queryhotGoods(Page page);
	
	/**
	 * 获取推荐商品
	 * @return
	 */
	Results<List<Goods>> queryrecommendGoods(Page page);
	
	
	/**
	 * 添加商品分类
	 * @param classify
	 * @return
	 */
	Results<Boolean> insertClassify(Classify classify);
	
	
	/**
	 * 更新商品分类
	 * @param classify
	 * @return
	 */
	Results<Boolean> updateClassify(Classify classify);
	
	
	
	/**
	 * 添加轮播
	 * @param classify
	 * @return
	 */
	Results<Boolean> insertCarousel(Carousel carousel);
	
	
	/**
	 * 更新轮播
	 * @param classify
	 * @return
	 */
	Results<Boolean> updateCarousel(Carousel carousel);
	
	
	/**
	 * 删除轮播
	 * @param classify
	 * @return
	 */
	Results<Boolean> delCarousel(Integer id);
	
	/**
	 * 获取限时商品
	 * @param page
	 * @return
	 */
	Results<List<Goods>> querytimeGoods(Page page);
	
	/**
	 * 根据分类获取商品
	 * @param page
	 * @return
	 */
	Results<List<Goods>> queryClassifyGoods(Page page,String classifyid);
}
