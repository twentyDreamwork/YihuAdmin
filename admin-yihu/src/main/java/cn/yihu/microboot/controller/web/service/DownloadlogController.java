package cn.yihu.microboot.controller.web.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cn.yihu.microboot.config.JSONInitialize;
import cn.yihu.microboot.service.AppRecordService;
import cn.yihu.microboot.service.CoinlogService;
import cn.yihu.microboot.util.CommonCode;
import cn.yihu.microboot.util.Results;
import cn.yihu.microboot.vo.Coin_log;
import cn.yihu.microboot.vo.DownloadRecord;
import cn.yihu.microboot.vo.Page;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

@Api(value = "web下载日志")
@RestController
@RequestMapping("/service")
public class DownloadlogController {

	@Resource
	private AppRecordService recordService;
	
	//全部查询
	@ApiOperation(value="pc端更新下载记录")
	@PutMapping("/downlogupdate")
	public Results update(@RequestBody JSONObject json) {
		DownloadRecord log=(DownloadRecord)JSONObject.toBean(json, DownloadRecord.class);
		int result=recordService.updateAppRecord(log);
		if(result==0) {
			return new Results(CommonCode.FAIL);
		}
		return new Results(CommonCode.SUCCESS);
	}
	
	//删除
	@ApiOperation(value="pc端删除下载记录")
	@DeleteMapping("/downlogdelete/{logid}")
	public Results delete(@PathVariable("logid") String logid) {
		int i=recordService.deleteAppRecord(logid);
		if(i==0) {
			return new Results(CommonCode.FAIL);
		}
		return new Results(CommonCode.SUCCESS);
	}
	
	//全部查询
	@ApiOperation(value="pc端查询下载记录")
	@GetMapping("/getdownloadloglist")
	public JSONObject page(String pageno,String size,String sort) {
		JSONObject res_json = new JSONObject();
		int count = recordService.count();
		Page page=new Page<>(Integer.parseInt(pageno),Integer.parseInt(size),count);
		List<DownloadRecord> loglist = recordService.findAllAppRecordPage(page);
		JSONArray jsonarray=JSONArray.fromObject(loglist, new JSONInitialize().JSONDateConfig());
		res_json.put("content", jsonarray);
		res_json.put("totalElements", count);
		return res_json;
	}
}
