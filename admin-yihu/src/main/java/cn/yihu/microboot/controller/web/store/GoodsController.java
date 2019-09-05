package cn.yihu.microboot.controller.web.store;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import cn.yihu.microboot.config.JSONInitialize;
import cn.yihu.microboot.service.store.CommentService;
import cn.yihu.microboot.service.store.GoodsService;
import cn.yihu.microboot.util.CommonCode;
import cn.yihu.microboot.util.Results;
import cn.yihu.microboot.vo.APP;
import cn.yihu.microboot.vo.Page;
import cn.yihu.microboot.vo.goods.Goods;
import cn.yihu.microboot.vo.store.XeClassify;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

//商品
@Api(value = "web商品管理")
@RestController
@RequestMapping("/store")
public class GoodsController {

	@Resource
	private GoodsService goodsService;
	
	// 添加
	@ApiOperation(value="pc端添加商品")
	@PostMapping("/addgoods")
	public Results<Boolean> add(@RequestBody Goods goods) {
		return goodsService.add(goods);
	}

	// 修改
	@ApiOperation(value="pc端修改商品")
	@PostMapping("/updategoods")
	public Results<Boolean> update(@RequestBody Goods goods) {
		return goodsService.update(goods);
	}

	// 删除
	@ApiOperation(value="pc端删除商品")
	@DeleteMapping("/deletegoods/{id}")
	public Results<Boolean> delete(@PathVariable("id")String id) {
		return goodsService.delete(id);
	}

	// 查询
	@ApiOperation(value="pc端获取商品列表")
	@GetMapping("/getgoodslist")
	public JSONObject select_page(String pageno,String size,String sort) {
		JSONObject res_json = new JSONObject();
		int count = goodsService.count();
		Page page=new Page<>(Integer.parseInt(pageno),Integer.parseInt(size),count);
		List<Goods> goodslist=goodsService.select_page(page);
		JSONArray jsonarray=JSONArray.fromObject(goodslist, new JSONInitialize().JSONDateConfig());
		res_json.put("content", jsonarray);
		res_json.put("totalElements", count);
		return res_json;
	}
	
	//单一查询
	public Results select_one(String id) {
		return new Results<Goods>(CommonCode.SUCCESS,goodsService.select_one(id));
	} 	
	
}
