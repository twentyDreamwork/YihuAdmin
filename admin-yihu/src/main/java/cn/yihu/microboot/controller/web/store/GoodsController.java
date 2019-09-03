package cn.yihu.microboot.controller.web.store;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
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
import cn.yihu.microboot.vo.store.XeGoods;
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
	public Results add(String shopid,String cateid,String loca_id,String maintitle,String subtitle,String price,String old_price,String goods_img) {
		return new Results(CommonCode.SUCCESS);
	}

	// 修改
	public Results update() {
		return new Results(CommonCode.SUCCESS);
	}

	// 删除
	public Results delete(String id) {
		int i=goodsService.delete(id);
		if(i==0) {
			new Results(CommonCode.FAIL);
		}
		return new Results(CommonCode.SUCCESS);
	}

	// 查询
	@ApiOperation(value="pc端获取商品列表")
	@GetMapping("/getgoodslist")
	public JSONObject select_page(String pageno,String size,String sort) {
		JSONObject res_json = new JSONObject();
		int count = goodsService.count();
		Page page=new Page<>(Integer.parseInt(pageno),Integer.parseInt(size),count);
		List<Goods> applist=goodsService.select_page(page);
		JSONArray jsonarray=JSONArray.fromObject(applist, new JSONInitialize().JSONDateConfig());
		res_json.put("content", jsonarray);
		res_json.put("totalElements", count);
		return res_json;
	}
	
	//单一查询
	public Results select_one(String id) {
		return new Results<Goods>(CommonCode.SUCCESS,goodsService.select_one(id));
	} 	
	
}
