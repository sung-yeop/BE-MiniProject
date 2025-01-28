package demo.service.user;

import demo.dto.UserProfileDto;
import demo.mapper.user.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public List<UserProfileDto> getAllUsers() {
        return userMapper.getAllUsers();
    }

    @Override
    public Boolean addUser(UserProfileDto userProfileDto) {
        int result = userMapper.addUser(userProfileDto);
        System.out.println("유저 DB 등록 후, 반환값 : " + result);
        return result == 1;
    }

    @Override
    public Boolean updateUser(UserProfileDto userProfileDto) {
        int result = userMapper.updateUser(userProfileDto);
        return result == 1;
    }

    @Override
    public UserProfileDto selectUserDetail(Integer userId) {
        UserProfileDto userProfileDto = userMapper.getUserDetail(userId);
        System.out.println("Find : " + userProfileDto);
        return userProfileDto;
    }
}
