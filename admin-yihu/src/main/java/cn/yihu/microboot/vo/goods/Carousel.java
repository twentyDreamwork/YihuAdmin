package cn.yihu.microboot.vo.goods;

import java.io.Serializable;
import java.util.Date;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@TableName("xe_carousel")
public class Carousel implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@ApiModelProperty("id")
	@TableId(value = "id",type = IdType.INPUT)//mybatis pulsBaseMapper插入的时候会自动生成UUID，需要加此注解才能数据库自增
	private Integer id;
	
	@ApiModelProperty("商品ID")
	private String goodsId;
	
	@ApiModelProperty("图片")
	private String imgs;
	
	@ApiModelProperty("类型 1 外链 2 内跳转")
	private Integer type;
	
	@ApiModelProperty("内容")
	private String contents;
	
	@ApiModelProperty("备注")
	private String remark;
	
	@ApiModelProperty("创建时间")
	private Date createdTime;
	
	@ApiModelProperty("创建人")
	private String creater;

}
