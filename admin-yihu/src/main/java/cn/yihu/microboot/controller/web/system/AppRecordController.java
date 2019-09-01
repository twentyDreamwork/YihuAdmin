package cn.yihu.microboot.controller.web.system;

import java.sql.Timestamp;
import java.util.Date;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import cn.yihu.microboot.service.AppRecordService;
import cn.yihu.microboot.util.DateTime;
import cn.yihu.microboot.util.UUIDTool;
import cn.yihu.microboot.util.controller.AbstractBaseController;
import cn.yihu.microboot.vo.APP;
import cn.yihu.microboot.vo.DownloadRecord;
import cn.yihu.microboot.vo.Page;
import io.swagger.annotations.Api;
import net.sf.json.JSONObject;

@Api(value = "web app日志")
@RestController
@RequestMapping("/operation")
public class AppRecordController extends AbstractBaseController{
	
	@Resource
	private AppRecordService apprecordService;

	@RequestMapping(value = "/getrecordlist", method = RequestMethod.GET)
	public JSONObject recordList(String pageno) {
		JSONObject res_json = new JSONObject();
		Page page=new Page<>(Integer.parseInt(pageno));
		
		page=apprecordService.findAllAppRecordPage(page);
		res_json=JSONObject.fromObject(page);
		res_json.put("code", 200);
		res_json.put("msg", "成功");
		return res_json;
	}
	
	@RequestMapping(value = "/insertrecord", method = RequestMethod.GET)
	public JSONObject insertrecord(String userid,String appid,String username) {
		JSONObject res_json = new JSONObject();
		UUIDTool uuid=new UUIDTool();
		DownloadRecord dlr=new DownloadRecord();
		DateTime datetime=new DateTime();
		Timestamp date=datetime.now().toSqlTimestamp();
		
		dlr.setId(uuid.getUUID());
		dlr.setUserid(userid);
		dlr.setAppid(appid);
		dlr.setCreatetime(date);
		dlr.setUpdatetime(date);
		dlr.setUpdater(username);
		
		int result=apprecordService.insertAppRecord(dlr);
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
	
	@RequestMapping(value = "/deleterecord", method = RequestMethod.GET)
	public JSONObject deleterecord(String id) {
		JSONObject res_json = new JSONObject();
		int result = apprecordService.deleteAppRecord(id);
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
	
	@RequestMapping(value = "/updaterecord", method = RequestMethod.GET)
	public JSONObject updaterecord(String id,String userid,String appid,String username) {
		JSONObject res_json = new JSONObject();
		DownloadRecord dlr=new DownloadRecord();
		DateTime datetime=new DateTime();
		Timestamp date=datetime.now().toSqlTimestamp();
		
		dlr.setId(id);
		dlr.setUserid(userid);
		dlr.setAppid(appid);
		dlr.setCreatetime(date);
		dlr.setUpdatetime(date);
		dlr.setUpdater(username);
		
		int result = apprecordService.updateAppRecord(dlr);
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
