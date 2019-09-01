package cn.yihu.microboot.service.impl.api;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.yihu.microboot.dao.TaobaoLinkMapper;
import cn.yihu.microboot.dao.TaobaoPictureMapper;
import cn.yihu.microboot.service.api.TaobaoService;
import cn.yihu.microboot.vo.Page;
import cn.yihu.microboot.vo.TaobaoPicture;
import net.sf.json.JSONObject;

@Service
public class TaobaoServiceImpl implements TaobaoService{

	@Resource
	private TaobaoLinkMapper taobaolinkmapper;
	
	@Resource
	private TaobaoPictureMapper taobaopicturemapper;
	
	@Override
	public Page linklist(JSONObject json) {
		// TODO Auto-generated method stub
		int platform=Integer.parseInt(json.getString("platform"));
		int count=taobaolinkmapper.countLink(platform);
		Page page=new Page<>();
		page.setPageNo(Integer.parseInt(json.getString("pageno")));
		if(count==0) {
			page.setTotalCount(0);
			page.setPageNaviSize(1);
			page.setResultList(null);
			return page;
		}
		page.setTotalCount(count);
		page.setResultList(taobaolinkmapper.findbyPlatform(platform, (page.getPageNo()-1)*page.getPageSize(),page.getPageSize()));

		return page;
	}

	@Override
	public List<TaobaoPicture> link_img(String link) {
		// TODO Auto-generated method stub
		return taobaopicturemapper.findbylink(link);
	}

}
