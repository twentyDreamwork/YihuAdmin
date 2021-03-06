package dream.work.modules.task.repository;

import dream.work.modules.task.domain.Appuser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
* @author Yang
* @date 2019-09-01
*/
public interface AppuserRepository extends JpaRepository<Appuser, String>, JpaSpecificationExecutor {
}