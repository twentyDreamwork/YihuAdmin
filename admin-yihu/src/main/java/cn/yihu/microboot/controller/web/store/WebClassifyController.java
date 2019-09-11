package cn.yihu.microboot.controller.web.store;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
import io.swagger.annotations.ApiOperation;
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
	@ApiOperation(value="pc端添加分类")
	@PostMapping("/add")
	public Results add(@RequestBody Classify classify) {
		try {
			int i=classifyService.add(classify);
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
	@ApiOperation(value="pc端更新分类")
	@PostMapping("/update")
	public Results update(@RequestBody Classify classify) {
		try {
			int i=classifyService.update(classify);
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
	@ApiOperation(value="pc端删除分类")
	@DeleteMapping("/delete/{id}")
	public Results delete(@PathVariable("id")String id) {
		int i=classifyService.delete(id);
		if(i==0) {
			new Results(CommonCode.FAIL);
		}
		return new Results(CommonCode.SUCCESS);
	}

	// 查询
	@ApiOperation(value="pc端分类页面")
	@RequestMapping(value = "/page", method = RequestMethod.GET)
	public JSONObject select_page(int pageno,int size) {
		JSONObject res_json = new JSONObject();
		int count = classifyService.count();
		Page page=new Page<>(pageno,size,count);
		List<Classify> loglist = classifyService.select_page(page);
		JSONArray jsonarray=JSONArray.fromObject(loglist, new JSONInitialize().JSONDateConfig());
		res_json.put("content", jsonarray);
		res_json.put("totalElements", count);
		return res_json;
	}
	
	//查询全部分类
	@ApiOperation(value="pc端查询所有分类")
	@RequestMapping(value = "/allclassify", method = RequestMethod.GET)
	public JSONArray selectall() {
		return classifyService.select_all();
	}
	
	//单一查询
	@RequestMapping(value = "/one", method = RequestMethod.GET)
	public Results select_one(String id) {
		return new Results<Classify>(CommonCode.SUCCESS,classifyService.select_one(id));
	} 	
}
