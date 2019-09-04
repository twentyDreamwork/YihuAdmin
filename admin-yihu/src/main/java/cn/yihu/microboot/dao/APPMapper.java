package cn.yihu.microboot.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;

import cn.yihu.microboot.vo.APP;
import cn.yihu.microboot.vo.AppUser;

@Mapper
public interface APPMapper extends BaseMapper<APP>{
    int deleteByPrimaryKey(String id);

    int insertSelective(APP record);

    APP selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(APP record);

    int updateByPrimaryKey(APP record);
    
    int CountApp(int platform);
    
    List<APP> findbyPlatform(int platform,int pageno,int pagesize);
    
    int addappnum(String appid);
    
    int CountAllApp();
    
    List<APP> findAllApp(int pageno,int pagesize);
    
	
}