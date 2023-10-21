package com.pxp.UserDatabase.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.pxp.UserDatabase.entity.UserEntity;
import com.pxp.UserDatabase.model.User;
import com.pxp.UserDatabase.service.UserService;

@RestController
@CrossOrigin(origins = "*")
public class UserController {

    @Autowired
    UserService userService;

    @RequestMapping(value = "getAllusers", method = RequestMethod.GET)
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @RequestMapping(value = "adduser", method = RequestMethod.POST)
    public String addUser(@RequestBody UserEntity user) {
        return userService.addUser(user);
    }

    @RequestMapping(value = "updateuser", method = RequestMethod.PUT)
    public String updateUser(@RequestBody UserEntity user) {
        return userService.updateUser(user);
    }

    @RequestMapping(value = "removeuser", method = RequestMethod.DELETE)
    public String removeUser(@RequestBody UserEntity user) {
        return userService.removeUser(user);
    }
}
