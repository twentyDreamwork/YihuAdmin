package cn.yihu.microboot.dao.store;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.baomidou.mybatisplus.mapper.BaseMapper;

import cn.yihu.microboot.vo.APP;
import cn.yihu.microboot.vo.goods.Goods;

@Mapper
public interface XeGoodsMapper extends BaseMapper<Goods>{
    int deleteByPrimaryKey(String id);

    int insertSelective(Goods record);

    Goods selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(Goods record);

    int updateByPrimaryKey(Goods record);
    
    int count_all();
    
    @Select("select * from xe_goods limit #{pageno},#{pagesize}")
    List<Goods> findpage(@Param("pageno")int pageno,@Param("pagesize")int pagesize);
    
    List<Goods> findall();
}