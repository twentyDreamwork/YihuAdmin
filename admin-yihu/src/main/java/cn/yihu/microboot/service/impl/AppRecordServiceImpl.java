package cn.yihu.microboot.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.yihu.microboot.dao.DownloadRecordMapper;
import cn.yihu.microboot.service.AppRecordService;
import cn.yihu.microboot.vo.DownloadRecord;
import cn.yihu.microboot.vo.Page;

@Service
public class AppRecordServiceImpl implements AppRecordService{

	@Resource
	private DownloadRecordMapper downloadmapper;
	
	@Override
	public Page findAllAppRecordPage(Page page) {
		// TODO Auto-generated method stub
		int count=downloadmapper.countAllRecord();
		page.setTotalCount(count);
		page.setResultList(downloadmapper.findAllRecord((page.getPageNo()-1)*page.getPageSize(),page.getPageSize()));
		
		return page;
	}

	@Override
	public int insertAppRecord(DownloadRecord dlr) {
		// TODO Auto-generated method stub
		return downloadmapper.insertSelective(dlr);
	}

	@Override
	public int deleteAppRecord(String id) {
		// TODO Auto-generated method stub
		return downloadmapper.deleteByPrimaryKey(id);
	}

	@Override
	public int updateAppRecord(DownloadRecord dlr) {
		// TODO Auto-generated method stub
		return downloadmapper.updateByPrimaryKeySelective(dlr);
	}

}
