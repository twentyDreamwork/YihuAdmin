package cn.yihu.microboot.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import cn.yihu.microboot.vo.DownloadRecord;

@Mapper
public interface DownloadRecordMapper {
    int deleteByPrimaryKey(String id);

    int insert(DownloadRecord record);

    int insertSelective(DownloadRecord record);

    DownloadRecord selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(DownloadRecord record);

    int updateByPrimaryKey(DownloadRecord record);
    
    List<String> selectByUserid(String userid);
    
    int countAllRecord();
    
    List<DownloadRecord> findAllRecord(int pageno,int pageszie);
    
}