package com.zhang.service.impl;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zhang.entity.AutoOrderMod;
import com.zhang.mapper.AutoOrderModMapper;
import com.zhang.service.AutoOrderService;
import org.springframework.stereotype.Service;

@DS("qwer")
@Service
public class AutoOrderServiceImpl extends ServiceImpl<AutoOrderModMapper, AutoOrderMod> implements AutoOrderService {
}
