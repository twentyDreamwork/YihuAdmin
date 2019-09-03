package cn.yihu.microboot.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.baomidou.mybatisplus.mapper.BaseMapper;

import cn.yihu.microboot.vo.AppUser;
import net.sf.json.JSONObject;

@Mapper
public interface AppUserMapper extends BaseMapper<AppUser>{
    int deleteByPrimaryKey(String id);

    
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
    
    @Select("select * from appuser limit #{pageno},#{pagesize}")
    List<AppUser> findAllUser(int pageno,int pagesize,String in,String order);
    
    int checkwxid(String wxid);
    
    AppUser selectByWxid(String wxid);
    
}