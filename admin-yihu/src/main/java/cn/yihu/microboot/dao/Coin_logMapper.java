package cn.yihu.microboot.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.baomidou.mybatisplus.mapper.BaseMapper;

import cn.yihu.microboot.vo.Coin_log;
import cn.yihu.microboot.vo.Page;

@Mapper
public interface Coin_logMapper extends BaseMapper<Coin_log>{
    int deleteByPrimaryKey(String id);

    int insertSelective(Coin_log record);

    Coin_log selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(Coin_log record);

    int updateByPrimaryKey(Coin_log record);
    
    int count_all();
    
    List<Coin_log> findpage(int pageno,int pagesize);
    
    @Select("select * from coin_log where userid=#{userid} order by time desc")
    List<Coin_log> selectByUserid(@Param("userid")String userid);
}