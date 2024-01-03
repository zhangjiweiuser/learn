package com.zhang.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zhang.entity.Customer;
import com.zhang.mapper.CustomerMapper;
import com.zhang.service.CustomerService;
import org.springframework.stereotype.Service;


@Service
public class CustomerServiceImpl extends ServiceImpl<CustomerMapper, Customer> implements CustomerService {
}
