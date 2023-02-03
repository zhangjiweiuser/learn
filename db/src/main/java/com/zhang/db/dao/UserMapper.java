package com.zhang.db.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zhang.db.entity.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author zhangjiwei
 * @Description TODO
 * @Date 2021/7/26 9:57
 */
@Mapper
public interface UserMapper extends BaseMapper<User> {
    List<User> findAllUser();
}
