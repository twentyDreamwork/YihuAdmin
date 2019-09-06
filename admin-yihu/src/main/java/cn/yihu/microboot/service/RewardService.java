package cn.yihu.microboot.service;

import java.util.List;

import com.mysql.cj.xdevapi.Result;

import cn.yihu.microboot.util.Results;
import cn.yihu.microboot.vo.Page;
import cn.yihu.microboot.vo.Reward;

public interface RewardService {
	
	//web
	public int add(String rewardname,int value,int day);
	
	public int update(Reward reward);
	
	public int delete(String id);
	
	public Page select_page(Page page);
	
	public Reward select_one(String id);

	//api
	public List<Reward> rewardlist();
	
	public Results<Boolean> addcoin(String machinecode,String coin,String channel);
	
	public Results<Boolean> minuscoin(String machinecode,String coin,String channel);
	
}
