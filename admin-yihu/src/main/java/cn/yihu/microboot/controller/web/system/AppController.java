package cn.yihu.microboot.controller.web.system;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import cn.yihu.microboot.config.JSONInitialize;
import cn.yihu.microboot.service.AppService;
import cn.yihu.microboot.util.UUIDTool;
import cn.yihu.microboot.util.controller.AbstractBaseController;
import cn.yihu.microboot.vo.APP;
import cn.yihu.microboot.vo.Page;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

@Api(value = "Web app管理")
@RestController
@RequestMapping("/operation")
public class AppController extends AbstractBaseController{

	@Resource
	private AppService appSrvice;
	
	@ApiOperation(value="pc端获取app列表")
	@GetMapping("/getapplist")
	public JSONObject appList(String pageno,String size,String sort) {
		JSONObject res_json = new JSONObject();
		int count = appSrvice.count();
		Page page=new Page<>(Integer.parseInt(pageno),Integer.parseInt(size),count);
		List<APP> applist=appSrvice.findAllAppPage(page);
		JSONArray jsonarray=JSONArray.fromObject(applist, new JSONInitialize().JSONDateConfig());
		res_json.put("content", jsonarray);
		res_json.put("totalElements", count);
		return res_json;
	}
	
	@RequestMapping(value = "/insertapp", method = RequestMethod.GET)
	public JSONObject insertapp(String name,String icon,String platform,String appPackage,String link,String type,String integral,String downloadNum,String remark) {
		JSONObject res_json = new JSONObject();
		UUIDTool uuid=new UUIDTool();
		APP app=new APP(uuid.getUUID(), name, icon, Integer.parseInt(platform), appPackage, link, Integer.parseInt(type), integral, Integer.parseInt(downloadNum), remark); 
		int result=appSrvice.insertApp(app);
		if(result==0) {
			res_json.put("result", result);
			res_json.put("code", 200);
			res_json.put("msg", "插入失败");
			return res_json;
		}
		res_json.put("result", result);
		res_json.put("code", 200);
		res_json.put("msg", "插入成功");
		return res_json;
	}
	
	@RequestMapping(value = "/deleteapp", method = RequestMethod.GET)
	public JSONObject deleteapp(String Appid) {
		JSONObject res_json = new JSONObject();
		int result=appSrvice.deleteApp(Appid);
		if(result==0) {
			res_json.put("result", result);
			res_json.put("code", 200);
			res_json.put("msg", "删除失败");
			return res_json;
		}
		res_json.put("result", result);
		res_json.put("code", 200);
		res_json.put("msg", "删除成功");
		return res_json;
	}
	
	@RequestMapping(value = "/updateapp", method = RequestMethod.GET)
	public JSONObject updateapp(String id,String name,String icon,String platform,String appPackage,String link,String type,String integral,String downloadNum,String remark) {
		JSONObject res_json = new JSONObject();
		APP app=new APP(id, name, icon, Integer.parseInt(platform), appPackage, link, Integer.parseInt(type), integral, Integer.parseInt(downloadNum), remark);
		int result = appSrvice.updateApp(app);
		if(result==0) {
			res_json.put("result", result);
			res_json.put("code", 200);
			res_json.put("msg", "更新失败");
			return res_json;
		}
		res_json.put("result", result);
		res_json.put("code", 200);
		res_json.put("msg", "更新成功");
		return res_json;
	}
	
}
