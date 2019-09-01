package cn.yihu.microboot.controller.web.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import cn.yihu.microboot.service.CoinlogService;
import cn.yihu.microboot.util.CommonCode;
import cn.yihu.microboot.util.Results;
import cn.yihu.microboot.vo.Coin_log;
import cn.yihu.microboot.vo.Page;
import io.swagger.annotations.Api;

//金币记录
@Api(value = "web金币日志")
@RestController
@RequestMapping("/service/coinlog")
public class CoinlogController {
	
	@Resource
	private CoinlogService coinlogservice;

	//删除
	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	public Results delete(String logid) {
		int i=coinlogservice.delete(logid);
		if(i==0) {
			return new Results(CommonCode.FAIL);
		}
		return new Results(CommonCode.SUCCESS);
	}
	
	//全部查询
	@RequestMapping(value = "/page", method = RequestMethod.GET)
	public Results findall(String pageno) {
		Page<Coin_log> page =new Page<>(Integer.parseInt(pageno));
		Page logpage = coinlogservice.coinlog_list(page);
		return new Results<Page>(CommonCode.SUCCESS,logpage);
	}
	
}
