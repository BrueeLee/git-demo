package cn.learn.service;

import cn.learn.mapper.UserMapper;
import cn.learn.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserMapper userMapper;
    public List<User> getUsers(){
        return userMapper.selectUsers();
    }
}
