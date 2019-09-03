package cn.yihu.microboot.dao.store;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import cn.yihu.microboot.vo.goods.Goods;
import cn.yihu.microboot.vo.store.XeGoods;

@Mapper
public interface XeGoodsMapper {
    int deleteByPrimaryKey(String id);

    int insert(Goods record);

    int insertSelective(Goods record);

    Goods selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(Goods record);

    int updateByPrimaryKey(Goods record);
    
    int count_all();
    
    List<Goods> findpage(int pageno,int pagesize);
    
    List<Goods> findall();
}