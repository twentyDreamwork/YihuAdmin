package cn.yihu.microboot.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import cn.yihu.microboot.vo.Page;
import cn.yihu.microboot.vo.WebUser;

@Mapper
public interface WebUserMapper {
    int deleteByPrimaryKey(String id);

    int insert(WebUser record);

    int insertSelective(WebUser record);

    WebUser selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(WebUser record);

    int updateByPrimaryKey(WebUser record);
    
    List<WebUser> findAllUser(int pagenum,int pagesize);
    
    int checkUser(String username,String password);
    
    int CountAllUser();
}