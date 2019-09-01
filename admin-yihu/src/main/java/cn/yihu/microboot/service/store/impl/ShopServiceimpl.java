package cn.yihu.microboot.service.store.impl;

import java.sql.Timestamp;

import org.springframework.stereotype.Service;

import cn.yihu.microboot.dao.store.XeShopMapper;
import cn.yihu.microboot.service.store.ShopService;
import cn.yihu.microboot.util.DateTime;
import cn.yihu.microboot.util.UUIDTool;
import cn.yihu.microboot.vo.Page;
import cn.yihu.microboot.vo.store.XeShop;

@Service
public class ShopServiceimpl implements ShopService{

	private XeShopMapper shopmapper;
	
	@Override
	public int add(String shopname, String shopaddress, String shoptel) {
		// TODO Auto-generated method stub
		UUIDTool uuidtool=new UUIDTool();
		DateTime datetime=new DateTime();
		Timestamp date=datetime.now().toSqlTimestamp();
		return shopmapper.insertSelective(new XeShop(uuidtool.getUUID(), shopname, shopaddress, null, shoptel, null));
	}

	@Override
	public int update(String id, String shopname, String shopaddress, String shoptel) {
		// TODO Auto-generated method stub
		return shopmapper.updateByPrimaryKeySelective(new XeShop(id, shopname, shopaddress, null, shoptel, null));
	}

	@Override
	public int delete(String id) {
		// TODO Auto-generated method stub
		return shopmapper.deleteByPrimaryKey(id);
	}

	@Override
	public Page select_page(Page page) {
		// TODO Auto-generated method stub
		int count=shopmapper.count_all();
		page.setTotalCount(count);
		page.setResultList(shopmapper.findpage((page.getPageNo()-1)*page.getPageSize(),page.getPageSize()));
		return page;
	}

	@Override
	public XeShop select_one(String id) {
		// TODO Auto-generated method stub
		return shopmapper.selectByPrimaryKey(id);
	}

}
