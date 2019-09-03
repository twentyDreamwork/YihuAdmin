package cn.yihu.microboot.config;

import java.util.Date;

import net.sf.json.JsonConfig;

public class JSONInitialize {

	public JsonConfig JSONDateConfig(){
		JsonConfig jsonconfig=new JsonConfig();
		jsonconfig.registerJsonValueProcessor(Date.class, new JsonDateValueProcessor());
		return jsonconfig;
	}
	
}
