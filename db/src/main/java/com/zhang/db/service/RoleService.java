package com.zhang.db.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.zhang.db.dto.RoleDto;
import com.zhang.db.entity.Role;

import java.util.List;

/**
 * @author zhangjiwei
 * @Description TODO
 * @Date 2021/7/26 9:57
 */
public interface RoleService extends IService<Role> {
    List<Role> findAllRole();

    boolean saveRole(RoleDto roleDto);
}
