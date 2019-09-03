package cn.yihu.microboot.controller.web.store;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import cn.yihu.microboot.service.store.ShopService;
import cn.yihu.microboot.util.CommonCode;
import cn.yihu.microboot.util.Results;
import cn.yihu.microboot.vo.Page;
import cn.yihu.microboot.vo.store.XeShop;
import io.swagger.annotations.Api;

//商铺
//@Api(value="web商铺管理")
//@RestController
//@RequestMapping("/store/shop")
public class ShopController {

	@Resource
	private ShopService shopService;
	
	// 添加
	//@RequestMapping(value = "/add", method = RequestMethod.GET)
	public Results add(String shopname,String shopaddress,String shoptel) {
		try {
			int i=shopService.add(shopname, shopaddress, shoptel);
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

	// 修改
	//@RequestMapping(value = "/update", method = RequestMethod.GET)
	public Results update(String id,String shopname,String shopaddress,String shoptel) {
		try {
			int i=shopService.update(id, shopname, shopaddress, shoptel);
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
	//@RequestMapping(value = "/delete", method = RequestMethod.GET)
	public Results delete(String id) {
		int i=shopService.delete(id);
		if(i==0) {
			new Results(CommonCode.FAIL);
		}
		return new Results(CommonCode.SUCCESS);
	}

	// 查询
	//@RequestMapping(value = "/page", method = RequestMethod.GET)
	public Results select_page(String pageno) {
		Page page=new Page<>(Integer.parseInt(pageno));
		page = shopService.select_page(page);
		return new Results<Page>(CommonCode.SUCCESS,page);
	}
	
	//单一查询
	//@RequestMapping(value = "/one", method = RequestMethod.GET)
	public Results select_one(String id) {
		return new Results<XeShop>(CommonCode.SUCCESS,shopService.select_one(id));
	} 
	
}
