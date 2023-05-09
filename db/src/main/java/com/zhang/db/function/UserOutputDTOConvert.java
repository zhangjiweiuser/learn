package com.zhang.db.function;

import com.zhang.db.dto.UserOutputDTO;
import com.zhang.db.entity.User;
import org.springframework.beans.BeanUtils;

/**
 * @author zhangjiwei1
 * @description
 * @create 2023-05-09 9:18
 */
public class UserOutputDTOConvert implements DTOConvert<User, UserOutputDTO> {
    @Override
    public UserOutputDTO convert(User user) {
        UserOutputDTO outputDTO = new UserOutputDTO();
        BeanUtils.copyProperties(user, outputDTO);
        return outputDTO;
    }
}
