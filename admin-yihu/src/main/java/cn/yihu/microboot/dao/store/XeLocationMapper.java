package cn.yihu.microboot.dao.store;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import cn.yihu.microboot.vo.store.XeLocation;

@Mapper
public interface XeLocationMapper {
    int deleteByPrimaryKey(String id);

    int insert(XeLocation record);

    int insertSelective(XeLocation record);

    XeLocation selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(XeLocation record);

    int updateByPrimaryKey(XeLocation record);
    
    int count_all();
    
    List<XeLocation> findpage(int pageno,int pagesize);
    
    List<XeLocation> findall();
}