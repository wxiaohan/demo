package com.anfeng.demo.controller;

import com.anfeng.demo.pojo.User;
import com.anfeng.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * @author xiaohan
 */
@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/queryUserList")
    public List<User> queryUserList() {
        return userService.queryUserList();
    }

    @PostMapping(value = "/addUser")
    public String addUser(@Valid User user, BindingResult result) {
        if (result.hasErrors()) {
            // 获取异常信息对象
            List<ObjectError> errors = result.getAllErrors();
            // 将异常信息输出
            for (ObjectError error : errors) {
                return error.getDefaultMessage();
            }
        }
        int affectedRows = userService.addUser(user);
        return affectedRows > 0 ? "SUCCESS" : "FAILURE";
    }

    @PostMapping(value = "/updateUser/{id}")
    public String updateUser(@PathVariable Integer id, @Valid User user, BindingResult result) {
        if (result.hasErrors()) {
            // 获取异常信息对象
            List<ObjectError> errors = result.getAllErrors();
            // 将异常信息输出
            for (ObjectError error : errors) {
                return error.getDefaultMessage();
            }
        }

        int affectedRows = userService.updateUser(id, user);
        return affectedRows > 0 ? "SUCCESS" : "FAILURE";
    }

    @PostMapping(value = "/deleteUser/{id}")
    @ResponseBody
    public String deleteUser(@PathVariable Integer id) {
        int affectedRows = userService.deleteUser(id);
        return affectedRows > 0 ? "SUCCESS" : "FAILURE";
    }
}
