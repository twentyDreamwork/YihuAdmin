package dream.work.modules.task.rest;

import dream.work.aop.log.Log;
import dream.work.modules.task.domain.Appuser;
import dream.work.modules.task.service.AppuserService;
import dream.work.modules.task.service.dto.AppuserDTO;
import dream.work.modules.task.service.query.AppuserQueryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
* @author Yang
* @date 2019-09-01
*/
@RestController
@RequestMapping("api")
public class AppuserController {

    @Autowired
    private AppuserService appuserService;

    @Autowired
    private AppuserQueryService appuserQueryService;

    @Log("查询Appuser")
    @GetMapping(value = "/appuser")
    @PreAuthorize("hasAnyRole('ADMIN','APPUSER_ALL','APPUSER_SELECT')")
    public ResponseEntity getAppusers(AppuserDTO resources, Pageable pageable){
        return new ResponseEntity(appuserQueryService.queryAll(resources,pageable),HttpStatus.OK);
    }

    @Log("新增Appuser")
    @PostMapping(value = "/appuser")
    @PreAuthorize("hasAnyRole('ADMIN','APPUSER_ALL','APPUSER_CREATE')")
    public ResponseEntity create(@Validated @RequestBody Appuser resources){
        return new ResponseEntity(appuserService.create(resources),HttpStatus.CREATED);
    }

    @Log("修改Appuser")
    @PutMapping(value = "/appuser")
    @PreAuthorize("hasAnyRole('ADMIN','APPUSER_ALL','APPUSER_EDIT')")
    public ResponseEntity update(@Validated @RequestBody Appuser resources){
        appuserService.update(resources);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    @Log("删除Appuser")
    @DeleteMapping(value = "/appuser/{id}")
    @PreAuthorize("hasAnyRole('ADMIN','APPUSER_ALL','APPUSER_DELETE')")
    public ResponseEntity delete(@PathVariable String id){
        appuserService.delete(id);
        return new ResponseEntity(HttpStatus.OK);
    }
}