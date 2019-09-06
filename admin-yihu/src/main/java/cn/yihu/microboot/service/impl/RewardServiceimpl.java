package cn.yihu.microboot.service.impl;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.yihu.microboot.dao.AppUserMapper;
import cn.yihu.microboot.dao.Coin_logMapper;
import cn.yihu.microboot.dao.IntegralMapper;
import cn.yihu.microboot.dao.RewardMapper;
import cn.yihu.microboot.service.RewardService;
import cn.yihu.microboot.util.CommonCode;
import cn.yihu.microboot.util.Results;
import cn.yihu.microboot.util.UUIDTool;
import cn.yihu.microboot.vo.AppUser;
import cn.yihu.microboot.vo.Coin_log;
import cn.yihu.microboot.vo.Integral;
import cn.yihu.microboot.vo.Page;
import cn.yihu.microboot.vo.Reward;

@Service("rewardService")
@SuppressWarnings("unchecked")
public class RewardServiceimpl implements RewardService {

	@Autowired
	private RewardMapper rewardmapper;
	
	@Autowired
	private AppUserMapper appusermapper;
	
	@Autowired
	private IntegralMapper integralmapper;
	
	@Autowired
	private Coin_logMapper coin_logmapper;
	
	@Override
	public int add(String rewardname, int value, int day) {
		// TODO Auto-generated method stub
		UUIDTool uuidtool=new UUIDTool();
		return rewardmapper.insert(new Reward(uuidtool.getUUID(), rewardname, value, day));
	}

	@Override
	public int update(Reward reward) {
		// TODO Auto-generated method stub
		return rewardmapper.updateByPrimaryKeySelective(reward);
	}

	@Override
	public int delete(String id) {
		// TODO Auto-generated method stub
		return rewardmapper.deleteByPrimaryKey(id);
	}

	@Override
	public Page select_page(Page page) {
		// TODO Auto-generated method stub
		int count = rewardmapper.count_all();
		page.setTotalCount(count);
		page.setResultList(rewardmapper.findpage((page.getPageNo()-1)*page.getPageSize(),page.getPageSize()));
		return page;
	}

	@Override
	public Reward select_one(String id) {
		// TODO Auto-generated method stub
		return rewardmapper.selectByPrimaryKey(id);
	}

	@Override
	public List<Reward> rewardlist() {
		// TODO Auto-generated method stub
		return rewardmapper.findall();
	}

	@Override
	public Results<Boolean> addcoin(String machinecode, String coin, String channel) {
		// TODO Auto-generated method stub
		UUIDTool uuidtool=new UUIDTool();
		//查询用户
		AppUser appuser=appusermapper.selectByMachineCode(machinecode);
		//添加加分记录
		int result=coin_logmapper.insertAllColumn(new Coin_log(uuidtool.getUUID(), appuser.getId(), coin, new Date(), channel));
		if(result==0) {
			return new Results<>(CommonCode.FAIL);
		}
		//添加积分
		Integral integral=integralmapper.selectByUserid(appuser.getId());
		result=integralmapper.updateByUseridSelective(new Integral(null, appuser.getId(), integral.getTotal()+Integer.parseInt(coin), integral.getNowintegral()+Integer.parseInt(coin), null, null, null, new Date(), null));
		if(result==0) {
			return new Results<>(CommonCode.FAIL);
		}
		return new Results<>(CommonCode.SUCCESS);
	}

	@Override
	public Results<Boolean> minuscoin(String machinecode, String coin, String channel) {
		// TODO Auto-generated method stub
		UUIDTool uuidtool=new UUIDTool();
		//查询用户
		AppUser appuser=appusermapper.selectByMachineCode(machinecode);
		//添加加分记录
		int result=coin_logmapper.insertAllColumn(new Coin_log(uuidtool.getUUID(), appuser.getId(), coin, new Date(), channel));
		if(result==0) {
			return new Results<>(CommonCode.FAIL);
		}
		//添加积分
		Integral integral=integralmapper.selectByUserid(appuser.getId());
		result=integralmapper.updateByUseridSelective(new Integral(null, appuser.getId(), integral.getTotal()-Integer.parseInt(coin), integral.getNowintegral()-Integer.parseInt(coin), null, null, null, new Date(), null));
		if(result==0) {
			return new Results<>(CommonCode.FAIL);
		}
		return new Results<>(CommonCode.SUCCESS);
	}

}
