package dream.work.modules.task.service;

import dream.work.modules.task.domain.Appuser;
import dream.work.modules.task.service.dto.AppuserDTO;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;

/**
* @author Yang
* @date 2019-09-01
*/
@CacheConfig(cacheNames = "appuser")
public interface AppuserService {

    /**
     * findById
     * @param id
     * @return
     */
    @Cacheable(key = "#p0")
    AppuserDTO findById(String id);

    /**
     * create
     * @param resources
     * @return
     */
    @CacheEvict(allEntries = true)
    AppuserDTO create(Appuser resources);

    /**
     * update
     * @param resources
     */
    @CacheEvict(allEntries = true)
    void update(Appuser resources);

    /**
     * delete
     * @param id
     */
    @CacheEvict(allEntries = true)
    void delete(String id);
}