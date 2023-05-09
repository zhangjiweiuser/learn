package com.zhang.db.controller;

import com.zhang.db.dto.UserDto;
import com.zhang.db.dto.UserInputDTO;
import com.zhang.db.dto.UserOutputDTO;
import com.zhang.db.entity.User;
import com.zhang.db.function.UserOutputDTOConvert;
import com.zhang.db.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author zhangjiwei
 * @Description TODO
 * @Date 2021/7/26 10:02
 */
@RestController
public class UserController extends BaseController {
    @Autowired
    private UserService userService;

    @GetMapping("/all")
    public List<User> getAll() {

        log.info("继承的");

        return userService.findAllUser();
    }

    @GetMapping("/save")
    public boolean save(String name, String pwd, Integer age) {
        UserDto userDto = new UserDto().setUserName(name)
                .setPwd(pwd).setAge(age).setUserId(105);
        return userService.saveUser(userDto);
    }

    @PostMapping("/addUser")
    public UserOutputDTO addUser(UserInputDTO userInputDTO) {
        User user = userInputDTO.convertToUser();
        User saveUserResult = userService.addUser(user);
        UserOutputDTO result = new UserOutputDTOConvert().convert(saveUserResult);
        return result;
    }
}
