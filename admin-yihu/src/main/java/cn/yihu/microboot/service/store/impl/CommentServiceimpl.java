package cn.yihu.microboot.service.store.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.yihu.microboot.dao.store.XeCommentMapper;
import cn.yihu.microboot.service.store.CommentService;
import cn.yihu.microboot.vo.Page;
import cn.yihu.microboot.vo.store.XeComment;

@Service
public class CommentServiceimpl implements CommentService {

	@Resource
	private XeCommentMapper commentmapper;
	
	@Override
	public int add() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int update() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(String id) {
		// TODO Auto-generated method stub
		return commentmapper.deleteByPrimaryKey(id);
	}

	@Override
	public Page select_page(Page page) {
		// TODO Auto-generated method stub
		int count=commentmapper.count_all();
		page.setTotalCount(count);
		page.setResultList(commentmapper.findpage((page.getPageNo()-1)*page.getPageSize(),page.getPageSize()));
		return page;
	}

	@Override
	public XeComment select_one(String id) {
		// TODO Auto-generated method stub
		return commentmapper.selectByPrimaryKey(id);
	}

}
