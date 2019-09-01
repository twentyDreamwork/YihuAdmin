package cn.yihu.microboot.service.store.impl;

import java.sql.Timestamp;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.yihu.microboot.dao.store.XeLocationMapper;
import cn.yihu.microboot.service.store.LocationService;
import cn.yihu.microboot.util.DateTime;
import cn.yihu.microboot.util.UUIDTool;
import cn.yihu.microboot.vo.Page;
import cn.yihu.microboot.vo.store.XeLocation;

@Service
public class LocationServiceimpl implements LocationService{

	@Resource
	private XeLocationMapper locationmapper;
	
	@Override
	public int add(String lname, int pid, int sort) {
		// TODO Auto-generated method stub
		UUIDTool uuidtool=new UUIDTool();
		DateTime datetime=new DateTime();
		Timestamp date=datetime.now().toSqlTimestamp();
		return locationmapper.insertSelective(new XeLocation(uuidtool.getUUID(), lname, pid, sort, 1));
	}

	@Override
	public int update(String id, String lname, int pid, int sort, int display) {
		// TODO Auto-generated method stub
		return locationmapper.updateByPrimaryKeySelective(new XeLocation(id, lname, pid, sort, display));
	}

	@Override
	public int delete(String id) {
		// TODO Auto-generated method stub
		return locationmapper.deleteByPrimaryKey(id);
	}

	@Override
	public Page select_page(Page page) {
		// TODO Auto-generated method stub
		int count=locationmapper.count_all();
		page.setTotalCount(count);
		page.setResultList(locationmapper.findpage((page.getPageNo()-1)*page.getPageSize(),page.getPageSize()));
		return page;
	}

	@Override
	public XeLocation select_one(String id) {
		// TODO Auto-generated method stub
		return locationmapper.selectByPrimaryKey(id);
	}

}
