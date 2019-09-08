package cn.yihu.microboot.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.yihu.microboot.mapper.goods.CarouselMapper;
import cn.yihu.microboot.service.CarouselService;
import cn.yihu.microboot.vo.Page;
import cn.yihu.microboot.vo.goods.Carousel;

@Service("carouselservice")
@SuppressWarnings("unchecked")
public class CarouselServiceimpl implements CarouselService{

	@Autowired
	private CarouselMapper carouselmapper;
	
	@Override
	public int count() {
		// TODO Auto-generated method stub
		return carouselmapper.count();
	}

	@Override
	public List<Carousel> list_page(Page page) {
		// TODO Auto-generated method stub
		return carouselmapper.listpage((page.getPageNo()-1)*page.getPageSize(),page.getPageSize());
	}

	
	
}
