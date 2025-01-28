package demo.mapper.user;

import demo.dto.UserProfileDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserMapper {
    List<UserProfileDto> getAllUsers();

    Integer addUser(UserProfileDto userProfileDto);
    Integer updateUser(UserProfileDto userProfileDto);
    UserProfileDto getUserDetail(Integer id);
    Integer deleteUser(UserProfileDto userProfileDto);
}

