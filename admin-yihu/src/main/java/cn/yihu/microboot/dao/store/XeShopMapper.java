package cn.yihu.microboot.dao.store;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import cn.yihu.microboot.vo.store.XeShop;

@Mapper
public interface XeShopMapper {
    int deleteByPrimaryKey(String id);

    int insert(XeShop record);

    int insertSelective(XeShop record);

    XeShop selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(XeShop record);

    int updateByPrimaryKey(XeShop record);
    
    int count_all();
    
    List<XeShop> findpage(int pageno,int pagesize);
    
    List<XeShop> findall();
}