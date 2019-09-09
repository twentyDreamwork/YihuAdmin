package cn.yihu.microboot.vo.goods;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import com.baomidou.mybatisplus.annotations.TableName;

import cn.yihu.microboot.vo.goods.res.ClassifyChild;
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
	
	@ApiModelProperty("下一级")
	private List<ClassifyChild> classifyChilds;
	
	public Classify() {
		super();
	}
	
	public Classify(String id,String classifyName,String parentId,String icons,Integer depth,Integer status,
	Integer priority,String keywords,String title,String description,String creater,Date createTime,String updater,
	Date updateTime) {
		this.id=id;
		this.classifyName=classifyName;
		this.parentId=parentId;
		this.icons=icons;
		this.depth=depth;
		this.status=status;
		this.priority=priority;
		this.keywords=keywords;
		this.title=title;
		this.description=description;
		this.creater=creater;
		this.createTime=createTime;
		this.updater=updater;
		this.updateTime=updateTime;
	}
	
}
