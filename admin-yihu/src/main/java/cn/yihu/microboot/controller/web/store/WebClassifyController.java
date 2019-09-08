package cn.yihu.microboot.controller.web.store;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import cn.yihu.microboot.config.JSONInitialize;
import cn.yihu.microboot.service.store.ClassifyService;
import cn.yihu.microboot.util.CommonCode;
import cn.yihu.microboot.util.Results;
import cn.yihu.microboot.vo.Coin_log;
import cn.yihu.microboot.vo.Page;
import cn.yihu.microboot.vo.goods.Classify;
import cn.yihu.microboot.vo.store.XeClassify;
import io.swagger.annotations.Api;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

//分类
@Api(value="web分类管理")
@RestController
@RequestMapping("/store/classify")
public class WebClassifyController {

	@Resource
	private ClassifyService classifyService;
	
	// 添加
	//@RequestMapping(value = "/add", method = RequestMethod.GET)
	public Results add(String classifyname,String parentid,String depth,String priority,String keywords,String title,String description) {
		try {
			int i=classifyService.add(classifyname, parentid, Integer.parseInt(depth), Integer.parseInt(priority), keywords, title, description);
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
	public Results update(String id,String classifyname,String parentid,String depth,String status,String priority,String keywords,String title,String description) {
		try {
			int i=classifyService.update(id,classifyname, parentid, Integer.parseInt(depth), Integer.parseInt(status), Integer.parseInt(priority), keywords, title, description);
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
		int i=classifyService.delete(id);
		if(i==0) {
			new Results(CommonCode.FAIL);
		}
		return new Results(CommonCode.SUCCESS);
	}

	// 查询
	@RequestMapping(value = "/page", method = RequestMethod.GET)
	public JSONObject select_page(String pageno,String size) {
		JSONObject res_json = new JSONObject();
		int count = classifyService.count();
		Page page=new Page<>(Integer.parseInt(pageno),Integer.parseInt(size),count);
		List<Classify> loglist = classifyService.select_page(page);
		JSONArray jsonarray=JSONArray.fromObject(loglist, new JSONInitialize().JSONDateConfig());
		res_json.put("content", jsonarray);
		res_json.put("totalElements", count);
		return res_json;
	}
	
	//单一查询
	@RequestMapping(value = "/one", method = RequestMethod.GET)
	public Results select_one(String id) {
		return new Results<XeClassify>(CommonCode.SUCCESS,classifyService.select_one(id));
	} 	
}
