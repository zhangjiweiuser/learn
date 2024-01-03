package com.zhang.service.impl;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zhang.entity.Shop;
import com.zhang.mapper.ShopMapper;
import com.zhang.service.ShopService;
import org.springframework.stereotype.Service;

@DS("qwer")
@Service
public class ShopServiceImpl extends ServiceImpl<ShopMapper, Shop> implements ShopService {
}
