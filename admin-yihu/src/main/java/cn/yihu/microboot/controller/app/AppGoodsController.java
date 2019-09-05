package cn.yihu.microboot.controller.app;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cn.yihu.microboot.service.goods.AppGoodsService;
import cn.yihu.microboot.util.Results;
import cn.yihu.microboot.vo.Page;
import cn.yihu.microboot.vo.goods.Carousel;
import cn.yihu.microboot.vo.goods.Classify;
import cn.yihu.microboot.vo.goods.Goods;
import cn.yihu.microboot.vo.goods.res.AppIndex;
import cn.yihu.microboot.vo.store.XeGoods;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import net.sf.json.JSONObject;

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
	@PostMapping("/queryAllClassifyByParentId")
	public Results<List<Classify>> queryAllClassifyByParentId(@RequestBody JSONObject json) {
		return appGoodsService.queryAllClassifyByParentId(json.getString("parentId"));
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
	@PostMapping("/queryGoodsByCateId")
	public Results<List<Goods>> queryGoodsByCateId(@RequestBody JSONObject json) {
		return appGoodsService.queryGoodsByCateId(json.getString("cateId"));
	}
	
	@ApiOperation(value="获取热门商品")
	@PostMapping("/queryhotGoods")
	public Results<List<XeGoods>> queryhotGoods(@RequestBody JSONObject json){
		int no=Integer.parseInt(json.getString("pageno"));
		Page page=new Page<>(no);
		return appGoodsService.queryhotGoods(page);
	}

	@ApiOperation(value="获取推荐商品")
	@GetMapping("/queryrecommendGoods")
	public Results<List<XeGoods>> queryrecommendGoods(){
		Page page=new Page<>(1);
		return appGoodsService.queryrecommendGoods(page);
	}
	
	@ApiOperation(value="添加商品分类")
	@PostMapping("/insertClassify")
	public Results<Boolean> insertClassify(@RequestBody Classify classify) {
		return appGoodsService.insertClassify(classify);
	}
	
	@ApiOperation(value="更新商品分类")
	@PostMapping("/updateClassify")
	public Results<Boolean> updateClassify(@RequestBody Classify classify) {
		return appGoodsService.updateClassify(classify);
	}
	
	@ApiOperation(value="添加轮播")
	@PostMapping("/insertCarousel")
	public Results<Boolean> insertCarousel(@RequestBody Carousel carousel) {
		return appGoodsService.insertCarousel(carousel);
	}
	
	@ApiOperation(value="更新轮播")
	@PostMapping("/updateCarousel")
	public Results<Boolean> updateCarousel(@RequestBody Carousel carousel) {
		return appGoodsService.updateCarousel(carousel);
	}
	
	
	@ApiOperation(value="删除轮播")
	@DeleteMapping("/delCarousel/{id}")
	public Results<Boolean> delCarousel(@PathVariable("id")Integer id) {
		return appGoodsService.delCarousel(id);
	}
	
	
	
}
