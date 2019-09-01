package cn.yihu.microboot.controller.app;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cn.yihu.microboot.service.goods.GoodsClassifyService;
import cn.yihu.microboot.util.Results;
import cn.yihu.microboot.vo.goods.Classify;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(value = "客户端商品相关接口")
@RestController
@RequestMapping("/goods")
public class AppGoodsController {
	
	@Autowired
	private GoodsClassifyService goodsClassifyService;
	
	
	@ApiOperation(value="获取全部商品分类")
	@GetMapping("/queryAllClassify")
	public Results<List<Classify>> queryAllClassify() {
		return goodsClassifyService.queryAllClassify();
	}
	
	
	@ApiOperation(value="根据父级ID获取商品分类")
	@GetMapping("/queryAllClassifyByParentId/{parentId}")
	public Results<List<Classify>> queryAllClassifyByParentId(@PathVariable("parentId")String parentId) {
		return goodsClassifyService.queryAllClassifyByParentId(parentId);
	}
	
	
	

}
