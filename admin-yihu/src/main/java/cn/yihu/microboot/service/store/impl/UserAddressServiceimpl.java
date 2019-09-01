package cn.yihu.microboot.service.store.impl;

import java.sql.Timestamp;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.yihu.microboot.dao.store.XeUserAddressMapper;
import cn.yihu.microboot.service.store.UserAddressService;
import cn.yihu.microboot.util.DateTime;
import cn.yihu.microboot.util.UUIDTool;
import cn.yihu.microboot.vo.Page;
import cn.yihu.microboot.vo.store.XeUserAddress;

@Service
public class UserAddressServiceimpl implements UserAddressService {

	@Resource
	private XeUserAddressMapper useraddressmapper;
	
	@Override
	public int add(String userid, String consiggnee, String consignee, String province, String city, String county,
			String street, String tel, String postcode) {
		// TODO Auto-generated method stub
		UUIDTool uuidtool=new UUIDTool();
		DateTime datetime=new DateTime();
		Timestamp date=datetime.now().toSqlTimestamp();
		return useraddressmapper.insertSelective(new XeUserAddress(uuidtool.getUUID(), userid, consignee, province, city, county, street, tel, postcode));
	}

	@Override
	public int update(String id, String userid, String consiggnee, String consignee, String province, String city,
			String county, String street, String tel, String postcode) {
		// TODO Auto-generated method stub
		return useraddressmapper.updateByPrimaryKeySelective(new XeUserAddress(id, userid, consignee, province, city, county, street, tel, postcode));
	}

	@Override
	public int delete(String id) {
		// TODO Auto-generated method stub
		return useraddressmapper.deleteByPrimaryKey(id);
	}

	@Override
	public Page select_page(Page page) {
		// TODO Auto-generated method stub
		int count=useraddressmapper.count_all();
		page.setTotalCount(count);
		page.setResultList(useraddressmapper.findpage((page.getPageNo()-1)*page.getPageSize(),page.getPageSize()));
		return page;
	}

	@Override
	public XeUserAddress select_one(String id) {
		// TODO Auto-generated method stub
		return useraddressmapper.selectByPrimaryKey(id);
	}

}
