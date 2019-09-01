package cn.yihu.microboot.controller.web.store;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import cn.yihu.microboot.service.store.CommentService;
import cn.yihu.microboot.util.CommonCode;
import cn.yihu.microboot.util.Results;
import cn.yihu.microboot.vo.Page;
import cn.yihu.microboot.vo.store.XeClassify;
import cn.yihu.microboot.vo.store.XeComment;
import io.swagger.annotations.Api;

//评价
@Api(value = "web评价管理")
@RestController
@RequestMapping("/store/comment")
public class CommentController {

	@Resource
	private CommentService commentService;
	
	// 添加
	public Results add() {
		return new Results(CommonCode.SUCCESS);
	}

	// 修改
	public Results update() {
		return new Results(CommonCode.SUCCESS);
	}

	// 删除
	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	public Results delete(String id) {
		int i=commentService.delete(id);
		if(i==0) {
			new Results(CommonCode.FAIL);
		}
		return new Results(CommonCode.SUCCESS);
	}

	// 查询
	@RequestMapping(value = "/page", method = RequestMethod.GET)
	public Results select_page(String pageno) {
		Page page=new Page<>(Integer.parseInt(pageno));
		page = commentService.select_page(page);
		return new Results<Page>(CommonCode.SUCCESS,page);
	}
	
	//单一查询
	@RequestMapping(value = "/one", method = RequestMethod.GET)
	public Results select_one(String id) {
		return new Results<XeComment>(CommonCode.SUCCESS,commentService.select_one(id));
	} 
	
}
