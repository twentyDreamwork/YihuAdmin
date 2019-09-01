package cn.yihu.microboot.service.impl;

import java.util.Date;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.yihu.microboot.dao.IntegralMapper;
import cn.yihu.microboot.service.IntegralService;
import cn.yihu.microboot.util.DateTime;
import cn.yihu.microboot.util.UUIDTool;
import cn.yihu.microboot.vo.Integral;

@Service
public class IntegralServiceImpl implements IntegralService{

	@Resource
	private IntegralMapper intefralmapper;
	
	@Override
	public int add_integral(String userId) {
		// TODO Auto-generated method stub
		UUIDTool uuidtool=new UUIDTool();
		String uuid=uuidtool.getUUID();
		Date date=DateTime.now().toDate();
		Integral integral=new Integral(uuid, userId, 0, 0, 0, date, "System", date, "System");
		int result=intefralmapper.insertSelective(integral);
		return result;
	}

}
