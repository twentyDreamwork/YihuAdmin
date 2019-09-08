package cn.yihu.microboot.mapper.point;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.baomidou.mybatisplus.mapper.BaseMapper;

import cn.yihu.microboot.vo.point.ItemPoint;

@Mapper
public interface ItemPointMapper extends BaseMapper<ItemPoint>{
	
	
	/**
	 * 获取所有上架兑换物品
	 * @return
	 */
	@Select("select * from t_item_point where isShop = 1")
	List<ItemPoint> queryAllItemPoint();
	
	
	/**
	 * 获取上架火热物品列表
	 * @return
	 */
	@Select("select * from t_item_point where isShop = 1 and isHot = 1")
	List<ItemPoint> queryHotItemPoint();
	
	
	/**
	 * 获取上架推荐的物品兑换列表
	 * @return
	 */
	@Select("select * from t_item_point where isShop = 1 and isRecommend = 1")
	List<ItemPoint> queryRecommendItemPoint();
	
	
	/**
	 * 获取加入轮播的上架物品兑换列表
	 * @return
	 */
	@Select("select * from t_item_point where isShop = 1 and isCarousel = 1")
	List<ItemPoint> queryCarouselItemPoint();
	
	
	

}
