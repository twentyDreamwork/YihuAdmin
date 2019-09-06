package cn.yihu.microboot.controller.api;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import cn.yihu.microboot.service.CoinlogService;
import cn.yihu.microboot.service.RewardService;
import cn.yihu.microboot.util.CommonCode;
import cn.yihu.microboot.util.Results;
import cn.yihu.microboot.vo.Coin_log;
import cn.yihu.microboot.vo.Reward;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import net.sf.json.JSONObject;

//获取金币渠道
@Api(value = "积分控制")
@RestController
@RequestMapping("/api/integral")
public class CoinController {

	@Resource
	private RewardService rewardservice;
	
	@Resource
	private CoinlogService coinlogservice;
	
	//奖励列表
	@ApiOperation(value="奖励列表")
	@RequestMapping(value = "/rewardlist", method = RequestMethod.GET)
	public Results rewardlist() {
		List<Reward> rewardlist=rewardservice.rewardlist();
	    Results result=new Results(CommonCode.SUCCESS, rewardlist);
		return result;
	}
	
	//在线奖励
	@ApiOperation(value="在线奖励")
	@ApiImplicitParams({
        @ApiImplicitParam(paramType="query", name = "machinecode", value = "机器码", required = true, dataType = "String"),
        @ApiImplicitParam(paramType="query", name = "coin", value = "金币", required = true, dataType = "String"),
    })
	@PostMapping("/online_rewards")
	public Results online_rewards(@RequestBody JSONObject json) {
		return rewardservice.addcoin(json.getString("machinecode"), json.getString("coin"), "在线奖励");
	}
	
	//签到
	@ApiOperation(value="签到奖励")
	@ApiImplicitParams({
        @ApiImplicitParam(paramType="query", name = "machinecode", value = "机器码", required = true, dataType = "String"),
        @ApiImplicitParam(paramType="query", name = "coin", value = "金币", required = true, dataType = "String"),
    })
	@PostMapping("/signin_rewards")
	public Results sign_in(@RequestBody JSONObject json) {
		return rewardservice.addcoin(json.getString("machinecode"), json.getString("coin"), "每日签到");
	}
	
	//下载奖励
	@ApiOperation(value="下载奖励")
	@ApiImplicitParams({
        @ApiImplicitParam(paramType="query", name = "machinecode", value = "机器码", required = true, dataType = "String"),
        @ApiImplicitParam(paramType="query", name = "coin", value = "金币", required = true, dataType = "String"),
    })
	@PostMapping("/download_rewards")
	public Results download_rewards(@RequestBody JSONObject json) {
		return rewardservice.addcoin(json.getString("machinecode"), json.getString("coin"), "每日签到");
	}
	
	//购物赠送
	@ApiOperation(value="购物奖励")
	@ApiImplicitParams({
        @ApiImplicitParam(paramType="query", name = "machinecode", value = "机器码", required = true, dataType = "String"),
        @ApiImplicitParam(paramType="query", name = "coin", value = "金币", required = true, dataType = "String"),
    })
	//@RequestMapping(value = "/shopping", method = RequestMethod.GET)
	public Results<Boolean> shopping(@RequestBody JSONObject json) {
		return rewardservice.addcoin(json.getString("machinecode"), json.getString("coin"), "每日签到");
	}
	
	//下载奖励
	@ApiOperation(value="减积分")
	@ApiImplicitParams({
	    @ApiImplicitParam(paramType="query", name = "machinecode", value = "机器码", required = true, dataType = "String"),
	    @ApiImplicitParam(paramType="query", name = "coin", value = "金币", required = true, dataType = "String"),
	})
	@PostMapping("/minuscoin")
	public Results<Boolean> minus(@RequestBody JSONObject json){
		return rewardservice.minuscoin(json.getString("machinecode"), json.getString("coin"), json.getString("channel"));
	}
	
	@ApiOperation(value="积分日志")
	@PostMapping("/getintegrallog")
	public Results<List<Coin_log>> coin_log(@RequestBody JSONObject json){
		return coinlogservice.coinlog_list(json.getString("machinecode"));
	}
}