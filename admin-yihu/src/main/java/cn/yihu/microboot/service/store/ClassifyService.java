package cn.yihu.microboot.service.store;

import java.util.List;

import cn.yihu.microboot.vo.Page;
import cn.yihu.microboot.vo.goods.Classify;
import cn.yihu.microboot.vo.store.XeClassify;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public interface ClassifyService {

	//web
	//public int add(String classifyname,String parentid,int depth,int priority,String keywords,String title,String description);
	
	//public int update(String id,String classifyname,String parentid,int depth,int status,int priority,String keywords,String title,String description);
	
	public int add(Classify classify);
	
	public int update(Classify classify);
	
	public int delete(String id);
	
	public List<Classify> select_page(Page page);
	
	public Classify select_one(String id);
	
	public int count();
	
	public JSONArray select_all();
	
}
