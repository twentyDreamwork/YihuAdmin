package cn.yihu.microboot.dao.store;

import org.apache.ibatis.annotations.Mapper;

import cn.yihu.microboot.vo.store.XeGoodsDetail;

@Mapper
public interface XeGoodsDetailMapper {
    int insert(XeGoodsDetail record);

    int insertSelective(XeGoodsDetail record);
}