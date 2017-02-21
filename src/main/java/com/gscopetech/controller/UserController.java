package com.gscopetech.controller;

import com.gscopetech.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.gscopetech.service.UserService;

import java.util.List;

/**
 * Created with adbus-Y.
 * Author  秋杰
 * Email   yaoqiujie@gscopetech.com
 * Date    2017/2/15
 */
@RestController
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping(value="update",method=RequestMethod.POST)
    public String update(String username,String password){
        userService.update(password, username);
        return "index.jsp";
    }

    @RequestMapping(value="get", method=RequestMethod.GET)
    @ResponseBody
    public List<User> getUser() {
        List<User> userList = userService.getAllUsers();
        return userList;
    }
}
