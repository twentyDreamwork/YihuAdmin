package cn.yihu.microboot.service.store.impl;

import java.sql.Timestamp;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.yihu.microboot.dao.store.XeClassifyMapper;
import cn.yihu.microboot.service.store.ClassifyService;
import cn.yihu.microboot.util.DateTime;
import cn.yihu.microboot.util.UUIDTool;
import cn.yihu.microboot.vo.Page;
import cn.yihu.microboot.vo.store.XeClassify;

@Service
public class ClassifyServiceimpl implements ClassifyService {

	@Resource
	private XeClassifyMapper classifymapper;
	
	@Override
	public int add(String classifyname, String parentid, int depth, int priority, String keywords, String title,
			String description) {
		// TODO Auto-generated method stub
		UUIDTool uuidtool=new UUIDTool();
		DateTime datetime=new DateTime();
		Timestamp date=datetime.now().toSqlTimestamp();
		return classifymapper.insertSelective(new XeClassify(uuidtool.getUUID(), classifyname, parentid, depth, 1, priority, keywords, title, description, null, date, null, date));
	}

	@Override
	public int update(String id, String classifyname, String parentid, int depth, int status, int priority,
			String keywords, String title, String description) {
		// TODO Auto-generated method stub
		DateTime datetime=new DateTime();
		Timestamp date=datetime.now().toSqlTimestamp();
		return classifymapper.updateByPrimaryKeySelective(new XeClassify(id, classifyname, parentid, depth, status, priority, keywords, title, description, null, null, null, date));
	}

	@Override
	public int delete(String id) {
		// TODO Auto-generated method stub
		return classifymapper.deleteByPrimaryKey(id);
	}

	@Override
	public Page select_page(Page page) {
		// TODO Auto-generated method stub
		int count=classifymapper.count_all();
		page.setTotalCount(count);
		page.setResultList(classifymapper.findpage((page.getPageNo()-1)*page.getPageSize(),page.getPageSize()));
		return page;
	}

	@Override
	public XeClassify select_one(String id) {
		// TODO Auto-generated method stub
		return classifymapper.selectByPrimaryKey(id);
	}

}
