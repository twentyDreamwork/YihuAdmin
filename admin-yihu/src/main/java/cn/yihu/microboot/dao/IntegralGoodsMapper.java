package cn.yihu.microboot.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.baomidou.mybatisplus.mapper.BaseMapper;

import cn.yihu.microboot.vo.goods.IntegralGoods;


@Mapper
public interface IntegralGoodsMapper extends BaseMapper<IntegralGoods>{

	@Select("select * form xe_intgralgoods limit #{pageno},#{pagesize}")
	public List<IntegralGoods> listpage(@Param("pageno")int pageno,@Param("pagesize")int pagesize);
	
	@Select("select count(*) from xe_intgralgoods")
	public int count();
	
}
