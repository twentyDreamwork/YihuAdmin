package cn.yihu.microboot.controller.web.store;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import cn.yihu.microboot.service.store.CommentService;
import cn.yihu.microboot.service.store.LocationService;
import cn.yihu.microboot.util.CommonCode;
import cn.yihu.microboot.util.Results;
import cn.yihu.microboot.vo.Page;
import cn.yihu.microboot.vo.store.XeClassify;
import cn.yihu.microboot.vo.store.XeLocation;
import io.swagger.annotations.Api;

//地址
//@Api(value = "web地址管理")
//@RestController
//@RequestMapping("/store/location")
public class LocationController {

	@Resource
	private LocationService locationService;
	
	// 添加
	//@RequestMapping(value = "/add", method = RequestMethod.GET)
	public Results add(String lname,String pid,String sort) {
		try {
			int i=locationService.add(lname, Integer.parseInt(pid), Integer.parseInt(sort));
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
	public Results update(String id,String lname,String pid,String sort,String display) {
		try {
			int i=locationService.update(id, lname, Integer.parseInt(pid), Integer.parseInt(sort), Integer.parseInt(display));
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
		int i=locationService.delete(id);
		if(i==0) {
			new Results(CommonCode.FAIL);
		}
		return new Results(CommonCode.SUCCESS);
	}

	// 查询
	//@RequestMapping(value = "/page", method = RequestMethod.GET)
	public Results select_page(String pageno) {
		Page page=new Page<>(Integer.parseInt(pageno));
		page = locationService.select_page(page);
		return new Results<Page>(CommonCode.SUCCESS,page);
	}
	
	//单一查询
	//@RequestMapping(value = "/one", method = RequestMethod.GET)
	public Results select_one(String id) {
		return new Results<XeLocation>(CommonCode.SUCCESS,locationService.select_one(id));
	} 
	
}
