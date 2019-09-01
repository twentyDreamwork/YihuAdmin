package cn.yihu.microboot.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import cn.yihu.microboot.vo.User;
import net.sf.json.JSONObject;

@Mapper
public interface UserMapper {
    int deleteByPrimaryKey(String id);

    int insert(User record);
    
    int insertSelective(User record);

    User selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);
    //
    User selectByUser(User record);
    
    User selectByMachineCode(String machinecode);
    
    int  checkMachineCode(String machinecode);
    
    User selectByUserAndPhone(String username,String phone);
    
    int countAllUser();
    
    List<User> findAllUser(int pageno,int pagesize);
    
    int checkwxid(String wxid);
    
    User selectByWxid(String wxid);
    
}