package cn.yihu.microboot.service.api;

import java.util.List;

import cn.yihu.microboot.vo.DownloadRecord;
import cn.yihu.microboot.vo.Page;
import net.sf.json.JSONObject;

public interface DownloadService {

	public Page downloadlist(JSONObject json);
	
	public List<String> downloadrecordlist(JSONObject json);
	
	public int downloadrecord(JSONObject json);
}
