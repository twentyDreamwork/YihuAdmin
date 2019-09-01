package cn.yihu.microboot.mapper.goods;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.baomidou.mybatisplus.mapper.BaseMapper;

import cn.yihu.microboot.vo.goods.Classify;

@Mapper
public interface ClassifyMapper extends BaseMapper<Classify>{
	
	
	/**
	 * 查询全部分类
	 * @return
	 */
	@Select("select * from xe_classify")
	List<Classify> queryAllClassify();
	
	
	/**
	 * 查询商品一级分类
	 * @return
	 */
	@Select("select * from xe_classify where parent_id='0'")
	List<Classify> queryMajorClassify();
	
	
	/**
	 * 根据parentId查找商品分类
	 * @param parentId
	 * @return
	 */
	@Select("select * from xe_classify where parent_id=#{parentId}")
	List<Classify> queryAllClassifyByParentId(@Param("parentId")String parentId);
	

}
