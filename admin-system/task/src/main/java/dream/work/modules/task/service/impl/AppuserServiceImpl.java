package dream.work.modules.task.service.impl;

import dream.work.modules.task.domain.Appuser;
import dream.work.utils.ValidationUtil;
import dream.work.modules.task.repository.AppuserRepository;
import dream.work.modules.task.service.AppuserService;
import dream.work.modules.task.service.dto.AppuserDTO;
import dream.work.modules.task.service.mapper.AppuserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import java.util.Optional;

/**
* @author Yang
* @date 2019-09-01
*/
@Service
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true, rollbackFor = Exception.class)
public class AppuserServiceImpl implements AppuserService {

    @Autowired
    private AppuserRepository appuserRepository;

    @Autowired
    private AppuserMapper appuserMapper;

    @Override
    public AppuserDTO findById(String id) {
        Optional<Appuser> appuser = appuserRepository.findById(id);
        ValidationUtil.isNull(appuser,"Appuser","id",id);
        return appuserMapper.toDto(appuser.get());
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public AppuserDTO create(Appuser resources) {
        return appuserMapper.toDto(appuserRepository.save(resources));
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void update(Appuser resources) {
        Optional<Appuser> optionalAppuser = appuserRepository.findById(resources.getId());
        ValidationUtil.isNull( optionalAppuser,"Appuser","id",resources.getId());

        Appuser appuser = optionalAppuser.get();
        // 此处需自己修改
        resources.setId(appuser.getId());
        appuserRepository.save(resources);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void delete(String id) {
        appuserRepository.deleteById(id);
    }
}