package cn.yihu.microboot.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import cn.yihu.microboot.vo.Coin_log;
import cn.yihu.microboot.vo.Page;

@Mapper
public interface Coin_logMapper {
    int deleteByPrimaryKey(String id);

    int insert(Coin_log record);

    int insertSelective(Coin_log record);

    Coin_log selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(Coin_log record);

    int updateByPrimaryKey(Coin_log record);
    
    int count_all();
    
    List<Coin_log> findpage(int pageno,int pagesize);
}