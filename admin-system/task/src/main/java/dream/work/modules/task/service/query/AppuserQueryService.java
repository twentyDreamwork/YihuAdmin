package dream.work.modules.task.service.query;

import dream.work.utils.PageUtil;
import dream.work.modules.task.domain.Appuser;
import dream.work.modules.task.service.dto.AppuserDTO;
import dream.work.modules.task.repository.AppuserRepository;
import dream.work.modules.task.service.mapper.AppuserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.ObjectUtils;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

/**
 * @author jie
 * @date 2018-12-03
 */
@Service
@CacheConfig(cacheNames = "appuser")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true, rollbackFor = Exception.class)
public class AppuserQueryService {

    @Autowired
    private AppuserRepository appuserRepository;

    @Autowired
    private AppuserMapper appuserMapper;

    /**
     * 分页
     */
    @Cacheable(keyGenerator = "keyGenerator")
    public Object queryAll(AppuserDTO appuser, Pageable pageable){
        Page<Appuser> page = appuserRepository.findAll(new Spec(appuser),pageable);
        return PageUtil.toPage(page.map(appuserMapper::toDto));
    }

    /**
    * 不分页
    */
    @Cacheable(keyGenerator = "keyGenerator")
    public Object queryAll(AppuserDTO appuser){
        return appuserMapper.toDto(appuserRepository.findAll(new Spec(appuser)));
    }

    class Spec implements Specification<Appuser> {

        private AppuserDTO appuser;

        public Spec(AppuserDTO appuser){
            this.appuser = appuser;
        }

        @Override
        public Predicate toPredicate(Root<Appuser> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder cb) {

            List<Predicate> list = new ArrayList<Predicate>();

            if(!ObjectUtils.isEmpty(appuser.getWxid())){
                /**
                * 模糊
                */
                list.add(cb.like(root.get("wxid").as(String.class),"%"+appuser.getWxid()+"%"));
            }
            if(!ObjectUtils.isEmpty(appuser.getPhone())){
                /**
                * 模糊
                */
                list.add(cb.like(root.get("phone").as(String.class),"%"+appuser.getPhone()+"%"));
            }
            if(!ObjectUtils.isEmpty(appuser.getPlatform())){
                /**
                * 精确
                */
                list.add(cb.equal(root.get("platform").as(Integer.class),appuser.getPlatform()));
            }
            Predicate[] p = new Predicate[list.size()];
            return cb.and(list.toArray(p));
        }
    }
}