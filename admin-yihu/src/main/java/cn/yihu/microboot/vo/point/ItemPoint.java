package cn.yihu.microboot.vo.point;

import java.io.Serializable;
import java.util.Date;

import com.baomidou.mybatisplus.annotations.TableName;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@TableName("t_item_point")
public class ItemPoint implements Serializable {
	private static final long serialVersionUID = 1L;

	@ApiModelProperty("id")
	private Integer id;

	@ApiModelProperty("物品名称")
	private String itemName;

	@ApiModelProperty("物品展示图")
	private String itemImg;

	@ApiModelProperty("内容")
	private String itemContent;

	@ApiModelProperty("跳转url（不需要跳转可忽略）")
	private String itemUrl;

	@ApiModelProperty("所需积分")
	private String point;

	@ApiModelProperty("库存数")
	private Integer stockNum;
	
	@ApiModelProperty("排序字段")
	private Integer orderNum;
	
	@ApiModelProperty("是否上架 0 否 1 是")
	private Integer isShop;
	
	@ApiModelProperty("是否热门 0 否 1 是")
	private Integer isHot;
	
	@ApiModelProperty("是否推荐 0 否 1是")
	private Integer isRecommend;
	
	@ApiModelProperty("是否轮播 0 否 1是")
	private Integer isCarousel;
	
	@ApiModelProperty("创建人")
	private Date createdAt;
	
	@ApiModelProperty("创建时间")
	private Integer createdBy;
}
