package cn.yihu.microboot.mapper.goods;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.baomidou.mybatisplus.mapper.BaseMapper;

import cn.yihu.microboot.vo.goods.Carousel;

@Mapper
public interface CarouselMapper extends BaseMapper<Carousel>{
	
	
	
	/**
	 * 查询全部轮播
	 * @return
	 */
	@Select("select * from xe_carousel ")
	List<Carousel> queryAllCarousel();
	
	/**
	 * 根据id删除
	 * @param id
	 * @return
	 */
	@Delete("delete from xe_carousel where id=#{id}")
	int deletebyid(@Param("id")int id);
	
	/**
	 * 统计数量
	 * @return
	 */
	@Select("select count(*) from xe_carousel")
	int count();

	/**
	 * 页面查询
	 * @param pageno
	 * @param pagesize
	 * @return
	 */
	@Select("select * from xe_carousel limit #{pageno},#{pagesize}")
	List<Carousel> listpage(@Param("pageno")int pageno,@Param("pagesize")int pagesize);
	

	int insertSelective(Carousel carousel);
}
