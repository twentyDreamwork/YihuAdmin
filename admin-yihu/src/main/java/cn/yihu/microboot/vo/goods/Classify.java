package cn.yihu.microboot.vo.goods;

import java.io.Serializable;
import java.util.Date;

import com.baomidou.mybatisplus.annotations.TableName;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;


/**
 * 商品分类
 * @author Yang
 *
 */
@Data
@TableName("xe_classify")
public class Classify implements Serializable {
	private static final long serialVersionUID = 1L;

	@ApiModelProperty("id")
	private String id;
	
	@ApiModelProperty("名称")
	private String classifyName;
	
	@ApiModelProperty("父id")
	private String parentId;
	
	@ApiModelProperty("图标")
	private String icons;
	
	@ApiModelProperty("父id")
	private Integer depth;
	
	@ApiModelProperty("状态(1:启用;0:关闭")
	private Integer status;
	
	@ApiModelProperty("优先级，越大越靠前")
	private Integer priority;
	
	@ApiModelProperty("关键字")
	private String keywords;
	
	@ApiModelProperty("标题")
	private String title;
	
	@ApiModelProperty("描述")
	private String description;
	
	@ApiModelProperty("创建者")
	private String creater;
	
	@ApiModelProperty("创建时间")
	private Date createTime;
	
	@ApiModelProperty("更新者")
	private String updater;
	
	@ApiModelProperty("更新时间")
	private Date updateTime;
	

}
