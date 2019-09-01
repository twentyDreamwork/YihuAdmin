package cn.yihu.microboot.dao;

import org.apache.ibatis.annotations.Mapper;

import cn.yihu.microboot.vo.InvitedUser;
@Mapper
public interface InvitedUserMapper {
    int insert(InvitedUser record);

    int insertSelective(InvitedUser record);
    
    int deleteByUserid(String userid);
}