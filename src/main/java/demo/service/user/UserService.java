package demo.service.user;

import demo.dto.UserProfileDto;

import java.util.List;

public interface UserService {
    List<UserProfileDto> getAllUsers();
    Boolean addUser(UserProfileDto userProfileDto);

    Boolean updateUser(UserProfileDto userProfileDto);

    UserProfileDto selectUserDetail(Integer userId);

    Boolean deleteUser(Integer userId);
}
