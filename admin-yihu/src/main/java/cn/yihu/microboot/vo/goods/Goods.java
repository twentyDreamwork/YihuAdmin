package cn.yihu.microboot.vo.goods;

import java.io.Serializable;
import java.math.BigDecimal;

import com.baomidou.mybatisplus.annotations.TableName;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@TableName("xe_goods")
public class Goods implements Serializable{
	private static final long serialVersionUID = 1L;

	@ApiModelProperty("商品主键")
	private String id;
	
	@ApiModelProperty("外键-商铺id")
	private String shopId;
	
	@ApiModelProperty("外键-分类id',")
	private String cateId;
	
	@ApiModelProperty("外键-分类id',")
	private String locaId;
	
	@ApiModelProperty("商品主标题")
	private String mainTitle;
	
	@ApiModelProperty("商品副标题")
	private String subTitle;
	
	@ApiModelProperty("商品价格")
	private BigDecimal price;
	
	@ApiModelProperty("原价")
	private BigDecimal oldPrice;
	
	@ApiModelProperty("购买人数")
	private Integer buy;
	
	@ApiModelProperty("商品图")
	private String goodsImg;
	
	@ApiModelProperty("淘宝url")
	private String taobaoUrl;
	
	@ApiModelProperty("推荐")
	private Integer recommend;
	
	
	
}
