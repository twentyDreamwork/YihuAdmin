package cn.yihu.microboot.service;

import java.util.List;

import cn.yihu.microboot.vo.DownloadRecord;
import cn.yihu.microboot.vo.Page;

public interface AppRecordService {

    public List<DownloadRecord> findAllAppRecordPage(Page page);
	
	public int insertAppRecord(DownloadRecord dlr);
	
	public int deleteAppRecord(String id);
	
	public int updateAppRecord(DownloadRecord dlr);
	
	public int count();
	
	
}
