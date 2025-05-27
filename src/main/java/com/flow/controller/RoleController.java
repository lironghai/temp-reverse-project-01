package com.flow.controller;

import com.flow.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.Map;
import java.util.List;

/**
 * 角色控制器，提供角色相关的REST接口。
 */
@RestController
@RequestMapping("/role")
public class RoleController {
    @Autowired
    private RoleService roleService;

    /**
     * 根据角色ID获取角色信息
     */
    @GetMapping("/{id}")
    public Map<String, Object> getRole(@PathVariable("id") String id) {
        return roleService.getRoleById(id);
    }

    /**
     * 创建新角色
     */
    @PostMapping("")
    public void createRole(@RequestBody Map<String, Object> roleInfo) {
        roleService.createRole(roleInfo);
    }

    /**
     * 更新角色信息
     */
    @PutMapping("/{id}")
    public void updateRole(@PathVariable("id") String id, @RequestBody Map<String, Object> roleInfo) {
        roleService.updateRole(id, roleInfo);
    }

    /**
     * 删除角色
     */
    @DeleteMapping("/{id}")
    public void deleteRole(@PathVariable("id") String id) {
        roleService.deleteRole(id);
    }

    /**
     * 查询所有角色
     */
    @GetMapping("")
    public List<Map<String, Object>> listAllRoles() {
        return roleService.listAllRoles();
    }
} 
