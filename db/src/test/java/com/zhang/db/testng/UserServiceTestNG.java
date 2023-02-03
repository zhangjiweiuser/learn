package com.zhang.db.testng;

import com.zhang.db.DbApplication;
import com.zhang.db.dao.UserMapper;
import com.zhang.db.entity.User;
import com.zhang.db.service.UserService;
import com.zhang.db.service.impl.UserServiceImpl;
import org.assertj.core.util.Lists;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.List;

/**
 * @author zhangjiwei
 * @Description TODO
 * @Date 2021/8/16 17:44
 */
@SpringBootTest(classes = DbApplication.class)
public class UserServiceTestNG extends AbstractTestNGSpringContextTests {
    @Mock
    private UserMapper baseMapper;
    @InjectMocks
    private UserService userService = new UserServiceImpl();

    @BeforeClass
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }



    @DataProvider(name = "cities")
    public Object[][] cities() {
        return new Object[][]{
                {"China", "ShangHai"},
                {"China", "BeiJing"}
        };
    }

    @Test(dataProvider = "cities")
    public void printCities(String country, String city) {
        System.out.println(String.format("%s,城市:%s", country, city));
    }

    @Test
    public void getAll() {
        List<User> userList = userService.findAllUser();
        System.out.println(userList.size());
    }

    @Test
    public void getAllMockTest() {
        List<User> userList = Lists.newArrayList();
        User user = new User();
        user.setId(12);
        user.setUserName("zhao");
        user.setAge(15);
        user.setPwd("Z3");
        userList.add(user);
        Mockito.when(baseMapper.findAllUser()).thenReturn(userList);
        List<User> result = userService.findAllUser();
        System.out.println(result.size());
    }
}
