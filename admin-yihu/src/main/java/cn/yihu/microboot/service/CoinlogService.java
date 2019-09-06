package cn.yihu.microboot.service;

import java.util.List;

import cn.yihu.microboot.util.Results;
import cn.yihu.microboot.vo.Coin_log;
import cn.yihu.microboot.vo.Page;

public interface CoinlogService {

	//web
	public int delete(String logid);
	
	public List<Coin_log> coinlog_list(Page page);
	
	public int count();
	
	public Results<List<Coin_log>> coinlog_list(String machinecode);
	
}
