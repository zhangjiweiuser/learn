package com.zhang.service.impl;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zhang.entity.AutoRoleMod;
import com.zhang.mapper.AutoRoleModMapper;
import com.zhang.service.AutoRoleService;
import org.springframework.stereotype.Service;
@DS("qwer")
@Service
public class AutoRoleServiceImpl extends ServiceImpl<AutoRoleModMapper, AutoRoleMod> implements AutoRoleService {
}
