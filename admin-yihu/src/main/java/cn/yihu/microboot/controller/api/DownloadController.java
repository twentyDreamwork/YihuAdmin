package cn.yihu.microboot.controller.api;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import cn.yihu.microboot.service.AppUserService;
import cn.yihu.microboot.service.IntegralService;
import cn.yihu.microboot.service.InvitedUserService;
import cn.yihu.microboot.service.api.ApiCheckService;
import cn.yihu.microboot.service.api.DownloadService;
import cn.yihu.microboot.vo.Page;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import net.sf.json.JSONObject;

@Api(value = "下载管理")
@RestController
@RequestMapping("/api")
public class DownloadController {

	@Resource
	private AppUserService userService;
	
	@Resource
	private ApiCheckService apicheckService;
	
	@Resource
	private IntegralService integralService;
	
	@Resource
	private InvitedUserService inviteduserService;
	
	@Resource
	private DownloadService downloadService;
	
	//应用下载列表
	@ApiOperation(value="应用下载列表")
	@RequestMapping(value = "/downloadlist", method = RequestMethod.GET)
	@ApiImplicitParams({
        @ApiImplicitParam(paramType="query", name = "unionid", value = "微信id", required = true, dataType = "String"),
        @ApiImplicitParam(paramType="query", name = "platform", value = "平台", required = true, dataType = "String"),
        @ApiImplicitParam(paramType="query", name = "pageno", value = "页码", required = true, dataType = "String")
    })
	public JSONObject Downloadlist(@RequestParam(value="unionid") String unionid,@RequestParam(value="platform")String platform,@RequestParam(value="pageno")String pageno) {
		JSONObject res_json = new JSONObject();
		JSONObject now_json = new JSONObject();
		
		now_json.put("wxid", unionid);
		now_json.put("platform", platform);
		now_json.put("pageno", pageno);
		
		//检验用户是否已注册
		if(userService.check_wxid(now_json.getString("wxid"))==0) {
			res_json.put("code", 102);
			res_json.put("msg", "该用户未注册");
			return res_json;
		}
		
		Page page=downloadService.downloadlist(now_json);
		List<String> recordlist=downloadService.downloadrecordlist(now_json);
		res_json=JSONObject.fromObject(page);
		res_json.put("code", 200);
		res_json.put("msg", "成功");
		res_json.put("record", recordlist);
		return res_json;
	}
	
	//应用下载记录
	@ApiOperation("应用下载记录")
	@RequestMapping(value = "/downloadrecord", method = RequestMethod.GET)
	@ApiImplicitParams({
        @ApiImplicitParam(paramType="query", name = "unionid", value = "微信id", required = true, dataType = "String"),
        @ApiImplicitParam(paramType="query", name = "appid", value = "应用id", required = true, dataType = "String"),
    })
	public JSONObject DownloaRecord(String unionid,String appid) {
		JSONObject res_json = new JSONObject();
		JSONObject now_json = new JSONObject();
		
		now_json.put("wxid", unionid);
		now_json.put("appid", appid);
		
		//检验用户是否已注册
		if(userService.check_wxid(now_json.getString("wxid"))==0) {
			res_json.put("code", 102);
			res_json.put("msg", "该用户未注册");
			return res_json;
		}
		
		int result=downloadService.downloadrecord(now_json);
		if(result==0) {
			res_json.put("result", result);
			res_json.put("code", 200);
			res_json.put("msg", "没找到该app");
		}else if(result==1){
			res_json.put("result", result);
			res_json.put("code", 200);
			res_json.put("msg", "成功");
		}
		
		return res_json;
	}
	
}
