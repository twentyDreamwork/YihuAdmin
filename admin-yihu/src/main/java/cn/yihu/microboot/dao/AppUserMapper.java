package cn.yihu.microboot.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import cn.yihu.microboot.vo.AppUser;
import net.sf.json.JSONObject;

@Mapper
public interface AppUserMapper {
    int deleteByPrimaryKey(String id);

    int insert(AppUser record);
    
    int insertSelective(AppUser record);

    AppUser selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(AppUser record);

    int updateByPrimaryKey(AppUser record);
    //
    AppUser selectByUser(AppUser record);
    
    AppUser selectByMachineCode(String machinecode);
    
    int  checkMachineCode(String machinecode);
    
    AppUser selectByUserAndPhone(String username,String phone);
    
    int countAllUser();
    
    List<AppUser> findAllUser(int pageno,int pagesize);
    
    int checkwxid(String wxid);
    
    AppUser selectByWxid(String wxid);
    
}