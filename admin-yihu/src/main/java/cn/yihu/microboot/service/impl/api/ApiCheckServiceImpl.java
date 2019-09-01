package cn.yihu.microboot.service.impl.api;

import org.springframework.stereotype.Service;

import cn.yihu.microboot.service.api.ApiCheckService;
import cn.yihu.microboot.util.ApiUtil;
import cn.yihu.microboot.util.ApiConst;
import cn.yihu.microboot.util.JsonValidator;
import net.sf.json.JSONObject;

@Service
public class ApiCheckServiceImpl implements ApiCheckService{

	@Override
	public JSONObject validator(int type,String method, String data) {
		JSONObject res_json = new JSONObject();
        JsonValidator jv = new JsonValidator();
        if (!jv.validate(data)) {
            res_json.put("code", 100);
            res_json.put("msg", "非法格式报文");
            return res_json;
        }
        // 检验Signature 合法性
        JSONObject req_json = JSONObject.fromObject(data);

        // JSON字段检验
        if (!ApiUtil.checkParam(type,method, req_json)) {
            res_json.put("code", 101);
            res_json.put("msg", "缺少参数");
            return res_json;
        }
        //检查签名
		/*
		 * if (!Tools.checkSignature(req_json.getString("signature"), Const.KEY,
		 * req_json.getString("timestamp"),req_json.getString("nonce"))) {
		 * res_json.put("code", 100); res_json.put("msg", "signature错误"); return
		 * res_json; }
		 */
        
        // 如果以上检测通过则返回 0并且返回转换后的JSON对象
        req_json.put("code", 0);
		return req_json;
	}
	
}
