package com.zhang.db.controller;

import com.zhang.db.dto.RoleDto;
import com.zhang.db.entity.Role;
import com.zhang.db.enums.RoleTypeEnum;
import com.zhang.db.enums.StatusEnum;
import com.zhang.db.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author zhangjiwei
 * @Description TODO
 * @Date 2021/7/26 10:02
 */
@RequestMapping("/role")
@RestController
public class RoleController {
    @Autowired
    private RoleService roleService;

    @GetMapping("/all")
    public List<Role> getAll() {

        return roleService.findAllRole();
    }

    @GetMapping("/save")
    public boolean save(String name, Integer type) {
//        RoleDto roleDto = new RoleDto().setName(name)
//                .setType(type);
//        return roleService.saveRole(roleDto);
        return true;
    }

    @PostMapping("/save2")
    public boolean save2(@RequestBody RoleDto roleDto) {

        return roleService.saveRole(roleDto);
    }

    @GetMapping("/save3")
    public boolean save3(String name, RoleTypeEnum type, StatusEnum status) {
        RoleDto roleDto = new RoleDto().setName(name)
                .setType(type).setStatus(status);
        return roleService.saveRole(roleDto);
//        return true;
    }

    @PostMapping("/save4")
    public boolean save4(RoleDto roleDto) {
//        RoleDto roleDto = new RoleDto().setName(name)
//                .setType(type);
        return roleService.saveRole(roleDto);
//        return true;
    }

    @GetMapping("/save5")
    public boolean save5(Integer age) {
//        RoleDto roleDto = new RoleDto().setName(name)
//                .setType(type).setStatus(status);
//        return roleService.saveRole(roleDto);
        return true;
//        return true;
    }
}
