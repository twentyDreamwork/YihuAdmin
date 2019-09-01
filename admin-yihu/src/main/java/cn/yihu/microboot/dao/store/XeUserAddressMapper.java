package cn.yihu.microboot.dao.store;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import cn.yihu.microboot.vo.store.XeUserAddress;

@Mapper
public interface XeUserAddressMapper {
    int deleteByPrimaryKey(String id);

    int insert(XeUserAddress record);

    int insertSelective(XeUserAddress record);

    XeUserAddress selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(XeUserAddress record);

    int updateByPrimaryKey(XeUserAddress record);
    
    int count_all();
    
    List<XeUserAddress> findpage(int pageno,int pagesize);
    
    List<XeUserAddress> findall();
}