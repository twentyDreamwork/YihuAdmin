package cn.yihu.microboot.dao.store;

import org.apache.ibatis.annotations.Mapper;

import cn.yihu.microboot.vo.store.XeCart;

@Mapper
public interface XeCartMapper {
    int insert(XeCart record);

    int insertSelective(XeCart record);
}