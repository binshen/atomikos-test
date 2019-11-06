package com.giant.api;

import com.giant.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserApi {

    @Autowired
    private UserService userService;

    @RequestMapping("test")
    @Transactional
    public int insertUser() {
        int result = userService.insertUser("123123");
        int a = 200/0;
        return result;
    }

    @RequestMapping("test2")
    public int insertUser2() {
        return userService.insertUser2("456456");
    }

    @RequestMapping("test3")
    public int insertUser3() {
        return userService.insertUser("789789");
    }
}
