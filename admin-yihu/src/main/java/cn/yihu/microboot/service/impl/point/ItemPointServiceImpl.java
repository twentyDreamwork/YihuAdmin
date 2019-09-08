package cn.yihu.microboot.service.impl.point;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.yihu.microboot.mapper.point.ItemPointMapper;
import cn.yihu.microboot.service.point.ItemPointService;
import cn.yihu.microboot.util.Results;
import cn.yihu.microboot.vo.point.ItemPoint;

@Service("itemPointService")
@SuppressWarnings("unchecked")
public class ItemPointServiceImpl implements ItemPointService{

	@Autowired
	private ItemPointMapper itemPointMapper;
	
	
	@Override
	public Results<List<ItemPoint>> queryAllItemPoint() {
		return Results.resultSucc(itemPointMapper.queryAllItemPoint());
	}

	@Override
	public Results<List<ItemPoint>> queryHotItemPoint() {
		return Results.resultSucc(itemPointMapper.queryHotItemPoint());
	}

	@Override
	public Results<List<ItemPoint>> queryRecommendItemPoint() {
		return Results.resultSucc(itemPointMapper.queryRecommendItemPoint());
	}

	@Override
	public Results<List<ItemPoint>> queryCarouselItemPoint() {
		return Results.resultSucc(itemPointMapper.queryCarouselItemPoint());
	}

	@Override
	public Results<Boolean> insertItemPoint(ItemPoint itemPoint) {
		return Results.resultSucc(itemPointMapper.insertAllColumn(itemPoint) > 0);
	}

	@Override
	public Results<Boolean> updateItemPoint(ItemPoint itemPoint) {
		return Results.resultSucc(itemPointMapper.updateById(itemPoint) > 0);
	}

}
