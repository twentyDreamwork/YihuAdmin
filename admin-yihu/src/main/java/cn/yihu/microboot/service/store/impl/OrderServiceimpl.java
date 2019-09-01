package cn.yihu.microboot.service.store.impl;

import java.math.BigDecimal;
import java.sql.Timestamp;

import org.springframework.stereotype.Service;

import cn.yihu.microboot.dao.store.XeOrderMapper;
import cn.yihu.microboot.service.store.OrderService;
import cn.yihu.microboot.util.DateTime;
import cn.yihu.microboot.util.UUIDTool;
import cn.yihu.microboot.vo.Page;
import cn.yihu.microboot.vo.store.XeOrder;

@Service
public class OrderServiceimpl implements OrderService {

	private XeOrderMapper ordermapper;
	
	@Override
	public int add(String userid, String goodsid, BigDecimal totalmoney) {
		// TODO Auto-generated method stub
		UUIDTool uuidtool=new UUIDTool();
		DateTime datetime=new DateTime();
		Timestamp date=datetime.now().toSqlTimestamp();
		return ordermapper.insertSelective(new XeOrder(uuidtool.getUUID(), userid, goodsid, 0, totalmoney));
	}

	@Override
	public int update(String id, String userid, String goodsid, BigDecimal totalmoney) {
		// TODO Auto-generated method stub
		return ordermapper.updateByPrimaryKeySelective(new XeOrder(id, userid, goodsid, null, totalmoney));
	}

	@Override
	public int delete(String id) {
		// TODO Auto-generated method stub
		return ordermapper.deleteByPrimaryKey(id);
	}

	@Override
	public Page select_page(Page page) {
		// TODO Auto-generated method stub
		int count=ordermapper.count_all();
		page.setTotalCount(count);
		page.setResultList(ordermapper.findpage((page.getPageNo()-1)*page.getPageSize(),page.getPageSize()));
		return page;
	}

	@Override
	public XeOrder select_one(String id) {
		// TODO Auto-generated method stub
		return ordermapper.selectByPrimaryKey(id);
	}

}
