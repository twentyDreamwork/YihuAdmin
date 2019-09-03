package cn.yihu.microboot.controller.web.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import cn.yihu.microboot.config.JSONInitialize;
import cn.yihu.microboot.service.CoinlogService;
import cn.yihu.microboot.util.CommonCode;
import cn.yihu.microboot.util.Results;
import cn.yihu.microboot.vo.Coin_log;
import cn.yihu.microboot.vo.Page;
import io.swagger.annotations.Api;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

//金币记录
@Api(value = "web金币日志")
@RestController
@RequestMapping("/service")
public class CoinlogController {
	
	@Resource
	private CoinlogService coinlogservice;

	//删除
	@RequestMapping(value = "/coinlogdelete", method = RequestMethod.GET)
	public Results delete(String logid) {
		int i=coinlogservice.delete(logid);
		if(i==0) {
			return new Results(CommonCode.FAIL);
		}
		return new Results(CommonCode.SUCCESS);
	}
	
	//全部查询
	@GetMapping("/getcoinloglist")
	public JSONObject findall(String pageno,String size,String sort) {
		JSONObject res_json = new JSONObject();
		int count = coinlogservice.count();
		Page page=new Page<>(Integer.parseInt(pageno),Integer.parseInt(size),count);
		List<Coin_log> loglist = coinlogservice.coinlog_list(page);
		JSONArray jsonarray=JSONArray.fromObject(loglist, new JSONInitialize().JSONDateConfig());
		res_json.put("content", jsonarray);
		res_json.put("totalElements", count);
		return res_json;
	}
	
}
