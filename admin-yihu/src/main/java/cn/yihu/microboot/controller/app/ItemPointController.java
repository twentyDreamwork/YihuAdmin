package cn.yihu.microboot.controller.app;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cn.yihu.microboot.service.point.ItemPointService;
import cn.yihu.microboot.util.Results;
import cn.yihu.microboot.vo.point.ItemPoint;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(value = "兑换商城相关接口")
@RestController
@RequestMapping("/itemPoint")
public class ItemPointController {
	
	
	@Autowired
	private ItemPointService itemPointService;
	

	@ApiOperation(value="获取全部兑换物品")
	@GetMapping("/queryAllItemPoint")
	public Results<List<ItemPoint>> queryAllItemPoint() {
		return itemPointService.queryAllItemPoint();
	}
	
	
	@ApiOperation(value="获取火热兑换物品")
	@GetMapping("/queryHotItemPoint")
	public Results<List<ItemPoint>> queryHotItemPoint() {
		return itemPointService.queryHotItemPoint();
	}
	
	@ApiOperation(value="获取推荐兑换物品")
	@GetMapping("/queryRecommendItemPoint")
	public Results<List<ItemPoint>> queryRecommendItemPoint() {
		return itemPointService.queryRecommendItemPoint();
	}
	
	@ApiOperation(value="获取轮播兑换物品")
	@GetMapping("/queryCarouselItemPoint")
	public Results<List<ItemPoint>> queryCarouselItemPoint() {
		return itemPointService.queryCarouselItemPoint();
	}
	
	@ApiOperation(value="添加兑换物品")
	@PostMapping("/insertItemPoint")
	public Results<Boolean> insertItemPoint(@RequestBody ItemPoint itemPoint) {
		return itemPointService.insertItemPoint(itemPoint);
	}
	
	@ApiOperation(value="更新兑换物品")
	@PostMapping("/updateItemPoint")
	public Results<Boolean> updateItemPoint(@RequestBody ItemPoint itemPoint) {
		return itemPointService.updateItemPoint(itemPoint);
	}
	
}
