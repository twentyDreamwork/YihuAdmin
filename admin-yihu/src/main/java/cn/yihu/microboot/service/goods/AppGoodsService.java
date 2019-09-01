package cn.yihu.microboot.service.goods;

import java.util.List;

import cn.yihu.microboot.util.Results;
import cn.yihu.microboot.vo.goods.Carousel;
import cn.yihu.microboot.vo.goods.Classify;
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
	 * 根据父级ID获取撒谎商品分类
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
}
