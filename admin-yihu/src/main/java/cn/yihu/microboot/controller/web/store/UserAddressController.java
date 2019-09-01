package cn.yihu.microboot.controller.web.store;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import cn.yihu.microboot.service.store.UserAddressService;
import cn.yihu.microboot.util.CommonCode;
import cn.yihu.microboot.util.Results;
import cn.yihu.microboot.vo.Page;
import cn.yihu.microboot.vo.store.XeUserAddress;
import io.swagger.annotations.Api;

//用户地址
@Api(value="web用户地址")
@RestController
@RequestMapping("/store")
public class UserAddressController {

	@Resource
	private UserAddressService addressService;
	
	// 添加
	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public Results add(String userid,String consiggnee,String consignee,String province,String city,String county,String street,String tel,String postcode) {
		try {
			int i=addressService.add(userid, consiggnee, consignee, province, city, county, street, tel, postcode);
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
	@RequestMapping(value = "/update", method = RequestMethod.GET)
	public Results update(String id,String userid,String consiggnee,String consignee,String province,String city,String county,String street,String tel,String postcode) {
		try {
			int i=addressService.update(id, userid, consiggnee, consignee, province, city, county, street, tel, postcode);
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
		int i=addressService.delete(id);
		if(i==0) {
			new Results(CommonCode.FAIL);
		}
		return new Results(CommonCode.SUCCESS);
	}

	// 查询
	@RequestMapping(value = "/page", method = RequestMethod.GET)
	public Results select_page(String pageno) {
		Page page=new Page<>(Integer.parseInt(pageno));
		page = addressService.select_page(page);
		return new Results<Page>(CommonCode.SUCCESS,page);
	}
	
	//单一查询
	@RequestMapping(value = "/one", method = RequestMethod.GET)
	public Results select_one(String id) {
		return new Results<XeUserAddress>(CommonCode.SUCCESS,addressService.select_one(id));
	} 
	
}
