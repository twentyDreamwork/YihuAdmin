package cn.yihu.microboot.controller.api;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import cn.yihu.microboot.service.RewardService;
import cn.yihu.microboot.util.CommonCode;
import cn.yihu.microboot.util.Results;
import cn.yihu.microboot.vo.Reward;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import net.sf.json.JSONObject;

//获取金币渠道
@Api(value = "获取金币渠道")
@RestController
@RequestMapping("/api/coin")
public class CoinController {

	@Resource
	private RewardService rewardservice;
	
	//奖励列表
	@ApiOperation(value="奖励列表")
	@RequestMapping(value = "/rewardlist", method = RequestMethod.GET)
	public JSONObject rewardlist() {
		List<Reward> rewardlist=rewardservice.rewardlist();
	    Results result=new Results(CommonCode.SUCCESS, rewardlist);
	    JSONObject res_json =JSONObject.fromObject(result);
		return res_json;
	}
	
	//在线奖励
	@ApiOperation(value="在线奖励")
	@ApiImplicitParams({
        @ApiImplicitParam(paramType="query", name = "machinecode", value = "机器码", required = true, dataType = "String"),
        @ApiImplicitParam(paramType="query", name = "coin", value = "金币", required = true, dataType = "String"),
    })
	@RequestMapping(value = "/online_rewards", method = RequestMethod.GET)
	public JSONObject online_rewards(String machinecode,String coin) {
		Results result;
		if(rewardservice.addcoin(machinecode, coin, "在线奖励")==1) {
			result=new Results(CommonCode.SUCCESS);
		}else {
			result=new Results(CommonCode.FAIL);
		}
		JSONObject res_json =JSONObject.fromObject(result);
		return res_json;
	}
	
	//签到
	@ApiOperation(value="签到奖励")
	@ApiImplicitParams({
        @ApiImplicitParam(paramType="query", name = "machinecode", value = "机器码", required = true, dataType = "String"),
        @ApiImplicitParam(paramType="query", name = "coin", value = "金币", required = true, dataType = "String"),
    })
	@RequestMapping(value = "/sign_in", method = RequestMethod.GET)
	public JSONObject sign_in(String machinecode,String coin) {
		Results result;
		if(rewardservice.addcoin(machinecode, coin, "每日签到")==1) {
			result=new Results(CommonCode.SUCCESS);
		}else {
			result=new Results(CommonCode.FAIL);
		}
		JSONObject res_json =JSONObject.fromObject(result);
		return res_json;
	}
	
	//下载奖励
	@ApiOperation(value="下载奖励")
	@ApiImplicitParams({
        @ApiImplicitParam(paramType="query", name = "machinecode", value = "机器码", required = true, dataType = "String"),
        @ApiImplicitParam(paramType="query", name = "coin", value = "金币", required = true, dataType = "String"),
    })
	public JSONObject download_rewards(String machinecode,String coin) {
		Results result;
		if(rewardservice.addcoin(machinecode, coin, "每日签到")==1) {
			result=new Results(CommonCode.SUCCESS);
		}else {
			result=new Results(CommonCode.FAIL);
		}
		JSONObject res_json =JSONObject.fromObject(result);
		return res_json;
	}
	
	//购物赠送
	@ApiOperation(value="下载奖励")
	@ApiImplicitParams({
        @ApiImplicitParam(paramType="query", name = "machinecode", value = "机器码", required = true, dataType = "String"),
        @ApiImplicitParam(paramType="query", name = "coin", value = "金币", required = true, dataType = "String"),
    })
	@RequestMapping(value = "/shopping", method = RequestMethod.GET)
	public JSONObject shopping(String machinecode,String coin) {
		Results result;
		if(rewardservice.addcoin(machinecode, coin, "每日签到")==1) {
			result=new Results(CommonCode.SUCCESS);
		}else {
			result=new Results(CommonCode.FAIL);
		}
		JSONObject res_json =JSONObject.fromObject(result);
		return res_json;
	}
	
}
