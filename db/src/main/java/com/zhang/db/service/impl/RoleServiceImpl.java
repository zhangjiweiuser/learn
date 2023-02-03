package com.zhang.db.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zhang.db.dao.RoleMapper;
import com.zhang.db.dto.RoleDto;
import com.zhang.db.entity.Role;
import com.zhang.db.service.RoleService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author zhangjiwei
 * @Description TODO
 * @Date 2021/7/26 9:58
 */
@Service
public class RoleServiceImpl extends ServiceImpl<RoleMapper, Role> implements RoleService {

    @Override
    public List<Role> findAllRole() {
        return baseMapper.findAllRole();
    }

    @Override
    public boolean saveRole(RoleDto roleDto) {
        Role role = new Role();
        role.setName(roleDto.getName());
//        role.setType(roleDto.getType() == 1 ? RoleTypeEnum.MANAGER : RoleTypeEnum.GUEST);
        role.setType(roleDto.getType());
        role.setStatus(roleDto.getStatus());
        return baseMapper.insert(role) == 1;
    }

}
