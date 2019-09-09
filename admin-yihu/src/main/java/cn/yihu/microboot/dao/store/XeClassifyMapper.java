package cn.yihu.microboot.dao.store;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import cn.yihu.microboot.vo.goods.Classify;
import cn.yihu.microboot.vo.store.XeClassify;

@Mapper
public interface XeClassifyMapper {
    int deleteByPrimaryKey(String id);

    int insert(Classify record);

    int insertSelective(Classify record);

    Classify selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(Classify record);

    int updateByPrimaryKey(Classify record);
    
    int count_all();
    
    List<Classify> findpage(int pageno,int pagesize);
    
    List<Classify> findall();
    
    List<Classify> selectpage(int pageno,int pagesie);
    
    List<Classify> findfirst();
    
    List<Classify> findsecond();
}