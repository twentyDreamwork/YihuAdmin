package cn.yihu.microboot.service;

import java.util.List;

import cn.yihu.microboot.vo.Coin_log;
import cn.yihu.microboot.vo.Page;

public interface CoinlogService {

	//web
	public int delete(String logid);
	
	public Page coinlog_list(Page page);
	
}
