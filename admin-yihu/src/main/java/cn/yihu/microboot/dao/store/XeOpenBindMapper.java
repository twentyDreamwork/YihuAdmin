package cn.yihu.microboot.dao.store;

import org.apache.ibatis.annotations.Mapper;

import cn.yihu.microboot.vo.store.XeOpenBind;

@Mapper
public interface XeOpenBindMapper {
    int insert(XeOpenBind record);

    int insertSelective(XeOpenBind record);
}