package cn.yihu.microboot.controller.web.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cn.yihu.microboot.config.JSONInitialize;
import cn.yihu.microboot.service.CarouselService;
import cn.yihu.microboot.vo.Coin_log;
import cn.yihu.microboot.vo.Page;
import cn.yihu.microboot.vo.goods.Carousel;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

@Api(value = "web轮播图管理")
@RestController
@RequestMapping("/service")
public class CarouselController {
	
	
	@Resource
	private CarouselService carouselService;
	
	@ApiOperation(value="pc端获取轮播图界面")
	@GetMapping("/carousepage")
	public JSONObject carousepage(String pageno,String size) {
		JSONObject res_json = new JSONObject();
		int count = carouselService.count();
		Page page=new Page<>(Integer.parseInt(pageno),Integer.parseInt(size),count);
		List<Carousel> loglist = carouselService.list_page(page);
		JSONArray jsonarray=JSONArray.fromObject(loglist, new JSONInitialize().JSONDateConfig());
		res_json.put("content", jsonarray);
		res_json.put("totalElements", count);
		return res_json;
	}

}
