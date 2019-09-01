package cn.yihu.microboot.service.store;

import cn.yihu.microboot.vo.Page;
import cn.yihu.microboot.vo.store.XeClassify;
import cn.yihu.microboot.vo.store.XeUserAddress;

public interface UserAddressService {

	//web
	public int add(String userid,String consiggnee,String consignee,String province,String city,String county,String street,String tel,String postcode);
	
	public int update(String id,String userid,String consiggnee,String consignee,String province,String city,String county,String street,String tel,String postcode);
	
	public int delete(String id);
	
	public Page select_page(Page page);
	
	public XeUserAddress select_one(String id);
	
}
