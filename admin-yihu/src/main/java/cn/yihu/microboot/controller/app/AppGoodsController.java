package cn.yihu.microboot.controller.app;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cn.yihu.microboot.service.goods.AppGoodsService;
import cn.yihu.microboot.util.Results;
import cn.yihu.microboot.vo.goods.Carousel;
import cn.yihu.microboot.vo.goods.Classify;
import cn.yihu.microboot.vo.goods.Goods;
import cn.yihu.microboot.vo.goods.res.AppIndex;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(value = "客户端商品相关接口")
@RestController
@RequestMapping("/goods")
public class AppGoodsController {
	
	@Autowired
	private AppGoodsService appGoodsService;
	
	
	@ApiOperation(value="获取全部商品分类")
	@GetMapping("/queryAllClassify")
	public Results<List<Classify>> queryAllClassify() {
		return appGoodsService.queryAllClassify();
	}
	
	
	@ApiOperation(value="获取商品一级分类")
	@GetMapping("/queryMajorClassify")
	public Results<List<Classify>> queryMajorClassify() {
		return appGoodsService.queryMajorClassify();
	}
	
	@ApiOperation(value="根据父级ID获取商品分类")
	@GetMapping("/queryAllClassifyByParentId/{parentId}")
	public Results<List<Classify>> queryAllClassifyByParentId(@PathVariable("parentId")String parentId) {
		return appGoodsService.queryAllClassifyByParentId(parentId);
	}
	
	@ApiOperation(value="获取轮播图")
	@GetMapping("/queryAllCarousel")
	public Results<List<Carousel>> queryAllCarousel() {
		return appGoodsService.queryAllCarousel();
	}
	
	@ApiOperation(value="获取app首页信息")
	@GetMapping("/appIndex")
	public Results<AppIndex> appIndex(){
		return appGoodsService.appIndex();
	}
	

	@ApiOperation(value="根据商品二级分类ID获取商品列表")
	@GetMapping("/queryGoodsByCateId/{cateId}")
	public Results<List<Goods>> queryGoodsByCateId(@PathVariable("cateId")String cateId) {
		return appGoodsService.queryGoodsByCateId(cateId);
	}
}
