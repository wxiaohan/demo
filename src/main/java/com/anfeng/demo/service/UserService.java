package com.anfeng.demo.service;

import com.anfeng.demo.mapper.UserMapper;
import com.anfeng.demo.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @author xiaohan
 */
@Service
public class UserService {

    @Autowired
    private UserMapper userMapper;

    @GetMapping("/queryUserList")
    public List<User> queryUserList() {
        return userMapper.queryUserList();
    }

    @PostMapping(value = "/addUser")
    public int addUser(User user) {
        return userMapper.addUser(user);
    }

    @PostMapping(value = "/updateUser")
    public int updateUser(Integer id, User user) {
        return userMapper.updateUser(user);
    }

    @PostMapping(value = "/deleteUser")
    @ResponseBody
    public int deleteUser(Integer id) {
        return userMapper.deleteUser(id);
    }

}
