package cn.yihu.microboot.service.api;

import net.sf.json.JSONObject;

public interface ApiCheckService {

	public JSONObject validator(int type,String method, String data);
	
}
