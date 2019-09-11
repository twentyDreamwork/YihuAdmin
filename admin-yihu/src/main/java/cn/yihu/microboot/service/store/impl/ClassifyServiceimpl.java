package cn.yihu.microboot.service.store.impl;

import java.sql.Timestamp;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.yihu.microboot.dao.store.XeClassifyMapper;
import cn.yihu.microboot.service.store.ClassifyService;
import cn.yihu.microboot.util.DateTime;
import cn.yihu.microboot.util.UUIDTool;
import cn.yihu.microboot.vo.Page;
import cn.yihu.microboot.vo.goods.Classify;
import cn.yihu.microboot.vo.store.XeClassify;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

@Service
public class ClassifyServiceimpl implements ClassifyService {

	@Resource
	private XeClassifyMapper classifymapper;
	
	@Override
	public int add(Classify classify) {
		// TODO Auto-generated method stub
		UUIDTool uuidtool=new UUIDTool();
		DateTime datetime=new DateTime();
		Timestamp date=datetime.now().toSqlTimestamp();
		classify.setId(uuidtool.getUUID());
		classify.setCreateTime(date);
		classify.setUpdateTime(date);
		return classifymapper.insertSelective(classify);
		//return classifymapper.insertSelective(new XeClassify(uuidtool.getUUID(), classifyname, parentid, depth, 1, priority, keywords, title, description, null, date, null, date));
	}

	@Override
	public int update(Classify classify) {
		// TODO Auto-generated method stub
		DateTime datetime=new DateTime();
		Timestamp date=datetime.now().toSqlTimestamp();
		classify.setUpdateTime(date);
		return classifymapper.updateByPrimaryKeySelective(classify);
		//return classifymapper.updateByPrimaryKeySelective(new Classify(id, classifyname, parentid, depth, status, priority, keywords, title, description, null, null, null, date));
	}

	@Override
	public int delete(String id) {
		// TODO Auto-generated method stub
		return classifymapper.deleteByPrimaryKey(id);
	}

	@Override
	public List<Classify> select_page(Page page) {
		// TODO Auto-generated method stub
		return classifymapper.selectpage((page.getPageNo()-1)*page.getPageSize(),page.getPageSize());
	}

	@Override
	public Classify select_one(String id) {
		// TODO Auto-generated method stub
		return classifymapper.selectByPrimaryKey(id);
	}

	@Override
	public int count() {
		// TODO Auto-generated method stub
		return classifymapper.count_all();
	}

	@Override
	public JSONArray select_all() {
		// TODO Auto-generated method stub
		List<Classify> clist1=classifymapper.findfirst();
		List<Classify> clist2=classifymapper.findsecond();
		JSONObject c1=new JSONObject();
		JSONObject c2=new JSONObject();
		JSONArray ca=new JSONArray();
		JSONArray cl=new JSONArray();
		for(Classify classify1:clist1) {
			ca=new JSONArray();
			c2=new JSONObject();
			for(Classify classify2:clist2) {
				if(classify1.getId().equals(classify2.getParentId())) {
					c2.put("id", classify2.getId());
					c2.put("label", classify2.getClassifyName());
					c2.put("children", classify2.getParentId());
				}else {
					continue;
				}
				ca.add(c2);
			}
			c1.put("id", classify1.getId());
			c1.put("label", classify1.getClassifyName());
			c1.put("children", ca);
			cl.add(c1);
		}
		return cl;
	}

}
