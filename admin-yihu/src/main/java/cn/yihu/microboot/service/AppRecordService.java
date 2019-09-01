package cn.yihu.microboot.service;

import cn.yihu.microboot.vo.DownloadRecord;
import cn.yihu.microboot.vo.Page;

public interface AppRecordService {

    public Page findAllAppRecordPage(Page page);
	
	public int insertAppRecord(DownloadRecord dlr);
	
	public int deleteAppRecord(String id);
	
	public int updateAppRecord(DownloadRecord dlr);
	
}
