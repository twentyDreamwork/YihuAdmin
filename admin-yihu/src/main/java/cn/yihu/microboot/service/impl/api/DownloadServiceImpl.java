package cn.yihu.microboot.service.impl.api;

import java.sql.Timestamp;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.yihu.microboot.dao.APPMapper;
import cn.yihu.microboot.dao.AppUserMapper;
import cn.yihu.microboot.dao.DownloadRecordMapper;
import cn.yihu.microboot.dao.IntegralMapper;
import cn.yihu.microboot.service.api.DownloadService;
import cn.yihu.microboot.util.DateTime;
import cn.yihu.microboot.util.UUIDTool;
import cn.yihu.microboot.vo.APP;
import cn.yihu.microboot.vo.AppUser;
import cn.yihu.microboot.vo.DownloadRecord;
import cn.yihu.microboot.vo.Integral;
import cn.yihu.microboot.vo.Page;
import net.sf.json.JSONObject;

@Service
public class DownloadServiceImpl implements DownloadService{

	@Resource
	private IntegralMapper integralmapper;
	
	@Resource
	private APPMapper  appmapper;
	
	@Resource
	private DownloadRecordMapper downloadrecordmapper;
	
	@Resource
	private AppUserMapper usermapper;
	
	@Override
	public Page downloadlist(JSONObject json) {
		// TODO Auto-generated method stub
		
		int platform=Integer.parseInt(json.getString("platform"));
		int count=appmapper.CountApp(platform);
		Page page=new Page<>();
		page.setPageNo(Integer.parseInt(json.getString("pageno")));
		if(count==0) {
			page.setTotalCount(0);
			page.setPageNaviSize(1);
			page.setResultList(null);
			return page;
		}
		page.setTotalCount(count);
		page.setResultList(appmapper.findbyPlatform(platform, (page.getPageNo()-1)*page.getPageSize(),page.getPageSize()));
		
		//integralmapper.updateByUsername(json.getString("username"));
		
		return page;
	}

	@Override
	public int downloadrecord(JSONObject json) {
		// TODO Auto-generated method stub
		UUIDTool uuid=new UUIDTool();
		DateTime datetime=new DateTime();
		Timestamp date=datetime.now().toSqlTimestamp();
		int result = appmapper.addappnum(json.getString("appid"));
		if(result==0) {
			return 0;
		}
		AppUser user=usermapper.selectByWxid(json.getString("wxid"));
		DownloadRecord downloadRecord=new DownloadRecord(uuid.getUUID(),null, user.getId(), json.getString("appid"), date, date, "system");
		result=downloadrecordmapper.insertSelective(downloadRecord);
		//result=integralmapper.updateByUsername(user.getUsername(),json.getString("appid"));
		return 1;
	}

	@Override
	public List<String> downloadrecordlist(JSONObject json) {
		// TODO Auto-generated method stub
		AppUser user=usermapper.selectByWxid(json.getString("wxid"));
		List<String> record_list=downloadrecordmapper.selectByUserid(user.getId());
		return record_list;
	}

	
}
