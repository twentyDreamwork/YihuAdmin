package cn.yihu.microboot.dao.store;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import cn.yihu.microboot.vo.store.XeLocation;
import cn.yihu.microboot.vo.store.XeOrder;

@Mapper
public interface XeOrderMapper {
    int deleteByPrimaryKey(String id);

    int insert(XeOrder record);

    int insertSelective(XeOrder record);

    XeOrder selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(XeOrder record);

    int updateByPrimaryKey(XeOrder record);
    
    int count_all();
    
    List<XeLocation> findpage(int pageno,int pagesize);
    
    List<XeLocation> findall();
}