package dream.work.modules.system.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import dream.work.aop.log.Log;
import dream.work.exception.BadRequestException;
import dream.work.modules.system.domain.Permission;
import dream.work.modules.system.service.PermissionService;
import dream.work.modules.system.service.dto.PermissionDTO;
import dream.work.modules.system.service.query.PermissionQueryService;

import java.util.List;

/**
 * @author jie
 * @date 2018-12-03
 */
@RestController
@RequestMapping("api")
public class PermissionController {

    @Autowired
    private PermissionService permissionService;

    @Autowired
    private PermissionQueryService permissionQueryService;

    private static final String ENTITY_NAME = "permission";

    /**
     * 返回全部的权限，新增角色时下拉选择
     * @return
     */
    @GetMapping(value = "/permissions/tree")
    @PreAuthorize("hasAnyRole('ADMIN','PERMISSION_ALL','PERMISSION_CREATE','PERMISSION_EDIT','ROLES_SELECT','ROLES_ALL')")
    public ResponseEntity getTree(){
        return new ResponseEntity(permissionService.getPermissionTree(permissionService.findByPid(0L)),HttpStatus.OK);
    }

    @Log("查询权限")
    @GetMapping(value = "/permissions")
    @PreAuthorize("hasAnyRole('ADMIN','PERMISSION_ALL','PERMISSION_SELECT')")
    public ResponseEntity getPermissions(@RequestParam(required = false) String name){
        List<PermissionDTO> permissionDTOS = permissionQueryService.queryAll(name);
        return new ResponseEntity(permissionService.buildTree(permissionDTOS),HttpStatus.OK);
    }

    @Log("新增权限")
    @PostMapping(value = "/permissions")
    @PreAuthorize("hasAnyRole('ADMIN','PERMISSION_ALL','PERMISSION_CREATE')")
    public ResponseEntity create(@Validated @RequestBody Permission resources){
        if (resources.getId() != null) {
            throw new BadRequestException("A new "+ ENTITY_NAME +" cannot already have an ID");
        }
        return new ResponseEntity(permissionService.create(resources),HttpStatus.CREATED);
    }

    @Log("修改权限")
    @PutMapping(value = "/permissions")
    @PreAuthorize("hasAnyRole('ADMIN','PERMISSION_ALL','PERMISSION_EDIT')")
    public ResponseEntity update(@Validated(Permission.Update.class) @RequestBody Permission resources){
        permissionService.update(resources);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    @Log("删除权限")
    @DeleteMapping(value = "/permissions/{id}")
    @PreAuthorize("hasAnyRole('ADMIN','PERMISSION_ALL','PERMISSION_DELETE')")
    public ResponseEntity delete(@PathVariable Long id){
        permissionService.delete(id);
        return new ResponseEntity(HttpStatus.OK);
    }
}
