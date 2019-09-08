package cn.yihu.microboot.service.point;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import cn.yihu.microboot.util.Results;
import cn.yihu.microboot.vo.point.ItemPoint;

/**
 * 
 * @author Yang
 *
 */
public interface ItemPointService {
	
	/**
	 * 获取所有上架兑换物品
	 * @return
	 */
	Results<List<ItemPoint>> queryAllItemPoint();
	
	
	/**
	 * 获取上架火热物品列表
	 * @return
	 */
	Results<List<ItemPoint>> queryHotItemPoint();
	
	
	/**
	 * 获取上架推荐的物品兑换列表
	 * @return
	 */
	Results<List<ItemPoint>> queryRecommendItemPoint();
	
	
	/**
	 * 获取加入轮播的上架物品兑换列表
	 * @return
	 */
	Results<List<ItemPoint>> queryCarouselItemPoint();
	
	
	/**
	 * 添加
	 * @param itemPoint
	 * @return
	 */
	Results<Boolean> insertItemPoint(ItemPoint itemPoint);
	
	
	/**
	 * 删除
	 * @param itemPoint
	 * @return
	 */
	Results<Boolean> updateItemPoint(ItemPoint itemPoint);
	

}
