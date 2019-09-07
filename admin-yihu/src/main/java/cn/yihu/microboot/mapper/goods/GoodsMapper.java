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

	@Select("select count(*) from xe_goods where hot=1")
	int count_hot();
	
	@Select("select * from xe_goods where hot=1 limit #{pageno},#{pagesize}")
    List<Goods> findHotGoodsPage(@Param("pageno")int pageno,@Param("pagesize")int pagesize);
	
	@Select("select count(*) from xe_goods where recommend=1")
    int count_recommend();
	
	@Select("select * from xe_goods where recommend=1 limit #{pageno},#{pagesize}")
    List<Goods> findrecommendGoodsPage(@Param("pageno")int pageno,@Param("pagesize")int pagesize);
	
	@Select("select count(*) from xe_goods where time=1")
    int count_time();
	
	@Select("select * from xe_goods where time=1 limit #{pageno},#{pagesize}")
    List<Goods> findtimeGoodsPage(@Param("pageno")int pageno,@Param("pagesize")int pagesize);
	
	@Select("select * from xe_goods where time=0 and recommend=0 and hot=0 and cate_id=#{classify} limit #{pageno},#{pagesize}")
    List<Goods> findClassifyGoodsPage(@Param("pageno")int pageno,@Param("pagesize")int pagesize,@Param("classify")String classifyid);
}
