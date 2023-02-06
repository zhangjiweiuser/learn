package learn.chapter2023.chapter02.mapstruct;

import org.mapstruct.Mapper;

import java.util.List;

@Mapper
public interface UserMapper {
    UserDto userToUserDto(User user);

    List<UserDto> userToUserDto(List<User> users);
}
