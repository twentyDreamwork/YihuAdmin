package cn.yihu.microboot.service;

import java.util.List;

import cn.yihu.microboot.vo.Page;
import cn.yihu.microboot.vo.goods.Carousel;

public interface CarouselService {

	public int count();
	
	public List<Carousel> list_page(Page page);
	
}
