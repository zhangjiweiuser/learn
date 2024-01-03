package com.zhang;

import com.zhang.entity.AutoRoleMod;
import com.zhang.service.AutoRoleService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@SpringBootTest
@Slf4j
public class RoleTest {
    @Resource
    AutoRoleService autoRoleService;

    @Test
    public void testInsertAutoRoleMod() {
        for (int i = 1; i < 10; i++) {
            AutoRoleMod roleMod = new AutoRoleMod();
            roleMod.setName(String.valueOf(i));
            autoRoleService.save(roleMod);
        }
    }

}
