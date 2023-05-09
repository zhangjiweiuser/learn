package com.zhang.db.service;

import com.zhang.db.dto.UserDto;

public interface UserCacheService {
    UserDto getById(int id, int age);
    String getName(int id);

    void deleteById(int id);
}
