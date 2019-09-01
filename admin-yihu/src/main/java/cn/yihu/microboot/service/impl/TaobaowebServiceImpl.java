package cn.yihu.microboot.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.yihu.microboot.dao.TaobaoLinkMapper;
import cn.yihu.microboot.dao.TaobaoPictureMapper;
import cn.yihu.microboot.service.TaobaowebService;
import cn.yihu.microboot.vo.Page;

@Service
public class TaobaowebServiceImpl implements TaobaowebService {

	@Resource
	private TaobaoLinkMapper taobaolinkmapper;
	
	@Resource
	private TaobaoPictureMapper taobaopicmapper;
	
	@Override
	public Page findAllLinkPage(Page page) {
		// TODO Auto-generated method stub
		int count=taobaolinkmapper.CountAllLink();
		page.setTotalCount(count);
		page.setResultList(taobaolinkmapper.findAllLink((page.getPageNo()-1)*page.getPageSize(),page.getPageSize()));
		
		return page;
	}

}
