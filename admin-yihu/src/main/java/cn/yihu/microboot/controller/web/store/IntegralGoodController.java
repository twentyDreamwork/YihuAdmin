package cn.yihu.microboot.controller.web.store;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cn.yihu.microboot.config.JSONInitialize;
import cn.yihu.microboot.service.store.IntegralGoodsService;
import cn.yihu.microboot.util.Results;
import cn.yihu.microboot.vo.Page;
import cn.yihu.microboot.vo.goods.Goods;
import cn.yihu.microboot.vo.goods.IntegralGoods;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

//商品
@Api(value = "web商品管理")
@RestController
@RequestMapping("/store")
public class IntegralGoodController {

	@Autowired
	private IntegralGoodsService integralGoodsService;
	
	@ApiOperation(value="pc端添加积分商品")
	@PostMapping("/addintegralgoods")
	public Results<Boolean> add(IntegralGoods ig){
		return integralGoodsService.add(ig);
	}
	
	@ApiOperation(value="pc端修改积分商品")
	@PostMapping("/updateintegralgoods")
	public Results<Boolean> update(IntegralGoods ig){
		return integralGoodsService.update(ig);
	}
	
	@ApiOperation(value="pc端删除积分商品")
	@DeleteMapping("/deleteintegralgoods")
	public Results<Boolean> delete(String id){
		return integralGoodsService.delete(id);
	}
	
	// 查询
	@ApiOperation(value="pc端获取积分商品列表")
	@GetMapping("/getgoodslist")
	public JSONObject select_page(String pageno,String size,String sort) {
		JSONObject res_json = new JSONObject();
		int count = integralGoodsService.count();
		Page page=new Page<>(Integer.parseInt(pageno),Integer.parseInt(size),count);
		List<IntegralGoods> goodslist=integralGoodsService.listpage(page);
		JSONArray jsonarray=JSONArray.fromObject(goodslist, new JSONInitialize().JSONDateConfig());
		res_json.put("content", jsonarray);
		res_json.put("totalElements", count);
		return res_json;
	}
}
