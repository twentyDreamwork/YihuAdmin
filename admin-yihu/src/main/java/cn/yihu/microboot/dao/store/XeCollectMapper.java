package cn.yihu.microboot.dao.store;

import org.apache.ibatis.annotations.Mapper;

import cn.yihu.microboot.vo.store.XeCollect;

@Mapper
public interface XeCollectMapper {
    int insert(XeCollect record);

    int insertSelective(XeCollect record);
}