package cn.yihu.microboot.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import cn.yihu.microboot.vo.Reward;

@Mapper
public interface RewardMapper {
    int deleteByPrimaryKey(String id);

    int insert(Reward record);

    int insertSelective(Reward record);

    Reward selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(Reward record);

    int updateByPrimaryKey(Reward record);
    
    int count_all();
    
    List<Reward> findpage(int pageno,int pagesize);
    
    List<Reward> findall();
}