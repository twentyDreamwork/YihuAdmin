package cn.yihu.microboot.controller.web.service;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import cn.yihu.microboot.service.RewardService;
import cn.yihu.microboot.util.CommonCode;
import cn.yihu.microboot.util.Results;
import cn.yihu.microboot.vo.Page;
import cn.yihu.microboot.vo.Reward;
import io.swagger.annotations.Api;

//奖励
@Api(value = "web奖励管理")
@RestController
@RequestMapping("/service/reward")
public class RewardController {
	
	private RewardService rewardService;

	// 添加
	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public Results add(String rewardname,String value,String day) {
		try {
			int i=rewardService.add(rewardname, Integer.parseInt(value), Integer.parseInt(day));
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
	@PostMapping("/update")
	public Results update(@RequestBody Reward reward) {
		try {
			int i=rewardService.update(reward);
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
	@DeleteMapping("/delete")
	public Results delete(String id) {
		int i=rewardService.delete(id);
		if(i==0) {
			new Results(CommonCode.FAIL);
		}
		return new Results(CommonCode.SUCCESS);
	}

	// 查询
	@GetMapping("/page")
	public Results select_page(String pageno) {
		Page page=new Page<>(Integer.parseInt(pageno));
		page = rewardService.select_page(page);
		return new Results<Page>(CommonCode.SUCCESS,page);
	}
	
	//单一查询
	@RequestMapping(value = "/one", method = RequestMethod.GET)
	public Results select_one(String id) {
		return new Results<Reward>(CommonCode.SUCCESS,rewardService.select_one(id));
	} 
}
