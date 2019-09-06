package cn.yihu.microboot.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.yihu.microboot.dao.AppUserMapper;
import cn.yihu.microboot.dao.Coin_logMapper;
import cn.yihu.microboot.service.CoinlogService;
import cn.yihu.microboot.util.Results;
import cn.yihu.microboot.vo.AppUser;
import cn.yihu.microboot.vo.Coin_log;
import cn.yihu.microboot.vo.Page;

@Service("coinlogService")
@SuppressWarnings("unchecked")
public class CoinlogServiceimpl implements CoinlogService{

	@Autowired
	private AppUserMapper appusermapper;
	
	@Autowired
	private Coin_logMapper coinlogmapper;
	
	@Override
	public int delete(String logid) {
		// TODO Auto-generated method stub
		return coinlogmapper.deleteByPrimaryKey(logid);
	}

	@Override
	public List<Coin_log> coinlog_list(Page page) {
		// TODO Auto-generated method stub
		int count = coinlogmapper.count_all();
		page.setTotalCount(count);
		return coinlogmapper.findpage((page.getPageNo()-1)*page.getPageSize(),page.getPageSize());
	}

	

	@Override
	public int count() {
		// TODO Auto-generated method stub
		return coinlogmapper.count_all();
	}

	@Override
	public Results<List<Coin_log>> coinlog_list(String machinecode) {
		// TODO Auto-generated method stub
		AppUser appuser=appusermapper.selectByMachineCode(machinecode);
		return new Results().resultSucc(coinlogmapper.selectByUserid(appuser.getId()));
	}

}
