package cn.yihu.microboot.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.yihu.microboot.dao.Coin_logMapper;
import cn.yihu.microboot.service.CoinlogService;
import cn.yihu.microboot.vo.Coin_log;
import cn.yihu.microboot.vo.Page;

@Service
public class CoinlogServiceimpl implements CoinlogService{

	@Resource
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

}
