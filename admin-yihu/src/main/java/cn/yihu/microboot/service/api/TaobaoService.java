package cn.yihu.microboot.service.api;

import java.util.List;

import cn.yihu.microboot.vo.Page;
import cn.yihu.microboot.vo.TaobaoPicture;
import net.sf.json.JSONObject;

public interface TaobaoService {

	public Page linklist(JSONObject json);
	
	public List<TaobaoPicture> link_img(String link);
	
}
