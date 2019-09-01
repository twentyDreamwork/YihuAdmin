package cn.yihu.microboot.dao.store;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import cn.yihu.microboot.vo.store.XeClassify;

@Mapper
public interface XeClassifyMapper {
    int deleteByPrimaryKey(String id);

    int insert(XeClassify record);

    int insertSelective(XeClassify record);

    XeClassify selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(XeClassify record);

    int updateByPrimaryKey(XeClassify record);
    
    int count_all();
    
    List<XeClassify> findpage(int pageno,int pagesize);
    
    List<XeClassify> findall();
}