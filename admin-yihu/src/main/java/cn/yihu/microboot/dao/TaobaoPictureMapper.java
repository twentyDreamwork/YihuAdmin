package cn.yihu.microboot.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import cn.yihu.microboot.vo.TaobaoPicture;

@Mapper
public interface TaobaoPictureMapper {
    int deleteByPrimaryKey(String id);

    int insert(TaobaoPicture record);

    int insertSelective(TaobaoPicture record);

    TaobaoPicture selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(TaobaoPicture record);

    int updateByPrimaryKey(TaobaoPicture record);
    
    List<TaobaoPicture> findbylink(String link);
}