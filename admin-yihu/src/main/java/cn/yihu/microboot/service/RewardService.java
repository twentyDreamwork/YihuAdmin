package cn.yihu.microboot.service;

import java.util.List;

import cn.yihu.microboot.vo.Page;
import cn.yihu.microboot.vo.Reward;

public interface RewardService {
	
	//web
	public int add(String rewardname,int value,int day);
	
	public int update(String id,String rewardname,int value,int day);
	
	public int delete(String id);
	
	public Page select_page(Page page);
	
	public Reward select_one(String id);

	//api
	public List<Reward> rewardlist();
	
	public int addcoin(String machinecode,String coin,String channel);
	
}
