package cn.yihu.microboot.mapper.goods;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.baomidou.mybatisplus.mapper.BaseMapper;

import cn.yihu.microboot.vo.goods.Goods;

@Mapper
public interface GoodsMapper extends BaseMapper<Goods>{
	
	
	/**
	 * 根据商品二级分类 查询商品
	 * @param cateId
	 * @return
	 */
	@Select("select * from xe_goods where cate_id=#{cateId}")
	List<Goods> queryGoodsByCateId(@Param("cateId")String cateId);

}
