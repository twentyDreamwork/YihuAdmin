package dream.work.service;

import java.util.List;

import dream.work.domain.GenConfig;
import dream.work.domain.vo.ColumnInfo;

/**
 * @author jie
 * @date 2019-01-02
 */
public interface GeneratorService {

    /**
     * 查询数据库元数据
     * @param name
     * @param startEnd
     * @return
     */
    Object getTables(String name, int[] startEnd);

    /**
     * 得到数据表的元数据
     * @param name
     * @return
     */
    Object getColumns(String name);

    /**
     * 生成代码
     * @param columnInfos
     * @param genConfig
     * @param tableName
     */
    void generator(List<ColumnInfo> columnInfos, GenConfig genConfig, String tableName);
}
