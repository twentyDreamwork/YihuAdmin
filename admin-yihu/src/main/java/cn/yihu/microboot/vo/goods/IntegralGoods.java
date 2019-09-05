package cn.yihu.microboot.vo.goods;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import com.baomidou.mybatisplus.annotations.TableName;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;


@Data
@TableName("xe_goods")
public class IntegralGoods implements Serializable{
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
	
	@ApiModelProperty("积分")
	private Integer integral;
	
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
	
	@ApiModelProperty("热门")
	private Integer hot;
	
	@ApiModelProperty("限时")
	private Integer time;
	
	@ApiModelProperty("计时器(小时)")
	private Integer timer;
	
	@ApiModelProperty("开始计时")
	private Date timestart;
	
	/*
	 * public Goods(String id, String shopId, String cateId, String locaId, String
	 * mainTitle, String subTitle,Integer integral, BigDecimal price, BigDecimal
	 * oldPrice, Integer buy, String goodsImg,String taobaoUrl,Integer
	 * recommend,Integer hot,Integer time,Integer timer，Date timestart) { this.id =
	 * id; this.shopId = shopId; this.cateId = cateId; this.locaId = locaId;
	 * this.mainTitle = mainTitle; this.subTitle = subTitle; this.integral =
	 * integral; this.price = price; this.oldPrice = oldPrice; this.buy = buy;
	 * this.goodsImg = goodsImg; this.taobaoUrl=taobaoUrl; this.recommend=recommend;
	 * this.hot=hot; this.time=time; this.timer=timer; this.timestart=timestart; }
	 */
	
}