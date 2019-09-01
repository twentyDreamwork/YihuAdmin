package cn.yihu.microboot.service.goods;

import java.util.List;

import cn.yihu.microboot.util.Results;
import cn.yihu.microboot.vo.goods.Classify;

/**
 * 商品分类
 * @author Yang
 *
 */
public interface GoodsClassifyService {
	
	
	/**
	 * 获取全部分类
	 * @return
	 */
	Results<List<Classify>> queryAllClassify();
	
	
	/**
	 * 根据父级ID获取撒谎商品分类
	 * @param parentId
	 * @return
	 */
	Results<List<Classify>> queryAllClassifyByParentId(String parentId);

}
