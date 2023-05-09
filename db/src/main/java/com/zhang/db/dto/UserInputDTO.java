package com.zhang.db.dto;

import com.google.common.base.Converter;
import com.zhang.db.entity.User;
import lombok.Data;
import org.springframework.beans.BeanUtils;

/**
 * @author zhangjiwei1
 * @description
 * @create 2023-05-09 9:12
 */
@Data
public class UserInputDTO {
    private String userName;
    private String pwd;


    public User convertToUser() {
        UserInputDTOConvert userInputDTOConvert = new UserInputDTOConvert();
        User user = userInputDTOConvert.convert(this);
        return user;
    }


    private static class UserInputDTOConvert extends Converter<UserInputDTO, User> {
        @Override
        protected User doForward(UserInputDTO userInputDTO) {
            User user = new User();
            BeanUtils.copyProperties(userInputDTO, user);
            return user;
        }

        @Override
        protected UserInputDTO doBackward(User user) {

            UserInputDTO userInputDTO = new UserInputDTO();
            BeanUtils.copyProperties(user, userInputDTO);
            return userInputDTO;
        }

//        @Override
//        public User convert(UserInputDTO userInputDTO) {
//            User user = new User();
//            BeanUtils.copyProperties(userInputDTO, user);
//            return user;
//        }
    }
}
