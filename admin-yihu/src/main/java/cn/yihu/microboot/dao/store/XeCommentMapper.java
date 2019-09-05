package cn.yihu.microboot.dao.store;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import cn.yihu.microboot.vo.store.XeComment;

@Mapper
public interface XeCommentMapper {
    int deleteByPrimaryKey(String id);

    int insert(XeComment record);

    int insertSelective(XeComment record);

    XeComment selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(XeComment record);

    int updateByPrimaryKey(XeComment record);
    
    int count_all();
    
    List<XeComment> findpage(int pageno,int pagesize);
    
    List<XeComment> findall();
}