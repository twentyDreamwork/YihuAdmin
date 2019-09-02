package dream.work.modules.task.service.mapper;

import dream.work.mapper.EntityMapper;
import dream.work.modules.task.domain.Appuser;
import dream.work.modules.task.service.dto.AppuserDTO;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

/**
* @author Yang
* @date 2019-09-01
*/
@Mapper(componentModel = "spring",uses = {},unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface AppuserMapper extends EntityMapper<AppuserDTO, Appuser> {

}