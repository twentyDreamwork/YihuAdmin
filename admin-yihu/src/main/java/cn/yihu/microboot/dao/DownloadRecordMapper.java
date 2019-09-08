package cn.yihu.microboot.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import cn.yihu.microboot.vo.Custom;
import cn.yihu.microboot.vo.DownloadRecord;
import net.sf.json.JSONArray;

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
    
    List<DownloadRecord> findAllRecord(int pageno,int pagesize);
    
    @Select("SELECT Count(*) FROM download_record AS dr LEFT JOIN app AS a ON dr.`appid`=a.`id` WHERE dr.`userid`=#{userid}")
    int recorduseridcount(@Param("userid")String userid);
    
    @Select("SELECT dr.`id` as id,dr.`createtime` as createtime,a.`Name` as name,a.`Integral` as Integral FROM download_record AS dr LEFT JOIN app AS a ON dr.`appid`=a.`id` WHERE dr.`userid`=#{userid} limit #{pageno},#{pagesize}")
    List<Custom> selectbyuserid(@Param("userid")String userid,@Param("pageno")int pageno,@Param("pagesize")int pagesize);
    
}