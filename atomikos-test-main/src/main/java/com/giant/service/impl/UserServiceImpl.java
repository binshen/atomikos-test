package com.giant.service.impl;

import com.giant.mapper.UserMapper;
import com.giant.model.User;
import com.giant.service.UserService;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public int insertUser(String name) {
        User user = new User(name);
        int result = userMapper.insertUser(user);
        if (result == 1) {
            return user.getId();
        }
        return result;
    }

    @Override
    @Transactional
    public int insertUser2(String name) {
        User user = new User(name);
        int result = userMapper.insertUser(user);
        if (result == 1) {
            int a = 100 / 0;
            return user.getId();
        }
        return result;
    }
}
