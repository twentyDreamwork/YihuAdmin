package cn.yihu.microboot.dao.store;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import cn.yihu.microboot.vo.store.XeGoods;

@Mapper
public interface XeGoodsMapper {
    int deleteByPrimaryKey(String id);

    int insert(XeGoods record);

    int insertSelective(XeGoods record);

    XeGoods selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(XeGoods record);

    int updateByPrimaryKey(XeGoods record);
    
    int count_all();
    
    List<XeGoods> findpage(int pageno,int pagesize);
    
    List<XeGoods> findall();
}