package cn.yihu.microboot.controller.web.store;

import java.math.BigDecimal;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import cn.yihu.microboot.service.store.CommentService;
import cn.yihu.microboot.service.store.OrderService;
import cn.yihu.microboot.util.CommonCode;
import cn.yihu.microboot.util.Results;
import cn.yihu.microboot.vo.Page;
import cn.yihu.microboot.vo.store.XeClassify;
import cn.yihu.microboot.vo.store.XeOrder;
import io.swagger.annotations.Api;

//订单
@Api(value="web订单管理")
@RestController
@RequestMapping("/store/order")
public class OrderController {

	@Resource
	private OrderService orderService;
	
	// 添加
	public Results add() {
		return new Results(CommonCode.SUCCESS);
	}

	// 修改
	@RequestMapping(value = "/update", method = RequestMethod.GET)
	public Results update(String id,String userid,String goodsid,String totalmoney) {
		try {
			int i=orderService.update(id, userid, goodsid, BigDecimal.valueOf(Long.parseLong(totalmoney)) );
			if(i==0) {
				new Results(CommonCode.FAIL);
			}
		}catch (NumberFormatException e) {
			// TODO: handle exception
			new Results(CommonCode.PARAM_ERROR);
		}catch (Exception e) {
			// TODO: handle exception
			new Results(e.toString());
		}
		return new Results(CommonCode.SUCCESS);
	}

	// 删除
	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	public Results delete(String id) {
		int i=orderService.delete(id);
		if(i==0) {
			new Results(CommonCode.FAIL);
		}
		return new Results(CommonCode.SUCCESS);
	}

	// 查询
	@RequestMapping(value = "/page", method = RequestMethod.GET)
	public Results select_page(String pageno) {
		Page page=new Page<>(Integer.parseInt(pageno));
		page = orderService.select_page(page);
		return new Results<Page>(CommonCode.SUCCESS,page);
	}
	
	//单一查询
	@RequestMapping(value = "/one", method = RequestMethod.GET)
	public Results select_one(String id) {
		return new Results<XeOrder>(CommonCode.SUCCESS,orderService.select_one(id));
	} 
	
}
