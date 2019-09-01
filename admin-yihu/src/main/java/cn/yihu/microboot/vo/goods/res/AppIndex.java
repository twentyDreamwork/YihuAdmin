package cn.yihu.microboot.vo.goods.res;

import java.io.Serializable;
import java.util.List;

import cn.yihu.microboot.vo.goods.Carousel;
import cn.yihu.microboot.vo.goods.Classify;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class AppIndex implements Serializable{

	private static final long serialVersionUID = 1L;

	@ApiModelProperty("轮播信息")
	private List<Carousel> carousels;
	
	
	@ApiModelProperty("商品一级信息")
	private List<Classify> majorClassifys;
	
	
}
