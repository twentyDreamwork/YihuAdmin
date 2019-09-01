package cn.yihu.microboot.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import cn.yihu.microboot.vo.TaobaoLink;

@Mapper
public interface TaobaoLinkMapper {
    int deleteByPrimaryKey(String id);

    int insert(TaobaoLink record);

    int insertSelective(TaobaoLink record);

    TaobaoLink selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(TaobaoLink record);

    int updateByPrimaryKey(TaobaoLink record);
    
    int countLink(int platform);
    
    List<TaobaoLink> findbyPlatform(int platform,int pageno,int pagesize);
    
    int CountAllLink();
    
    List<TaobaoLink> findAllLink(int pageno,int pagesize);
}