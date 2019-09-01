package cn.yihu.microboot.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.yihu.microboot.dao.RewardMapper;
import cn.yihu.microboot.service.RewardService;
import cn.yihu.microboot.util.UUIDTool;
import cn.yihu.microboot.vo.Page;
import cn.yihu.microboot.vo.Reward;

@Service
public class RewardServiceimpl implements RewardService {

	@Resource
	private RewardMapper rewardmapper;
	
	@Override
	public int add(String rewardname, int value, int day) {
		// TODO Auto-generated method stub
		UUIDTool uuidtool=new UUIDTool();
		return rewardmapper.insert(new Reward(uuidtool.getUUID(), rewardname, value, day));
	}

	@Override
	public int update(String id, String rewardname, int value, int day) {
		// TODO Auto-generated method stub
		return rewardmapper.updateByPrimaryKeySelective(new Reward(id, rewardname, value, day));
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
	public int addcoin(String machinecode, String coin, String channel) {
		// TODO Auto-generated method stub
		return 0;
	}

}
