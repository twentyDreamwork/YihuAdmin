package cn.yihu.microboot.service.impl.goods;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.yihu.microboot.mapper.goods.ClassifyMapper;
import cn.yihu.microboot.service.goods.GoodsClassifyService;
import cn.yihu.microboot.util.Results;
import cn.yihu.microboot.vo.goods.Classify;

/**
 * 商品分类实现
 * @author Administrator
 *
 */
@Service("goodsClassifyService")
@SuppressWarnings("unchecked")
public class GoodsClassifyServiceImpl implements GoodsClassifyService{

	@Autowired
	private ClassifyMapper classifyMapper;
	
	
	@Override
	public Results<List<Classify>> queryAllClassify() {
		return Results.resultSucc(classifyMapper.queryAllClassify());
	}


	@Override
	public Results<List<Classify>> queryAllClassifyByParentId(String parentId) {
		return Results.resultSucc(classifyMapper.queryAllClassifyByParentId(parentId));
	}

}
