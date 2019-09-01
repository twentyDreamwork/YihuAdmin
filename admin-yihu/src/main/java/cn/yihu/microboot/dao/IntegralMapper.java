package cn.yihu.microboot.dao;

import org.apache.ibatis.annotations.Mapper;

import cn.yihu.microboot.vo.Integral;
@Mapper
public interface IntegralMapper {
    int deleteByPrimaryKey(String id);

    int insert(Integral record);

    int insertSelective(Integral record);

    Integral selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(Integral record);

    int updateByPrimaryKey(Integral record);
    
    int updateByUsername(String username,String appid);
    
    int deleteByUserId(String userid);
}