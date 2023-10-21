package com.pxp.UserDatabase.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pxp.UserDatabase.entity.UserEntity;
import com.pxp.UserDatabase.model.User;
import com.pxp.UserDatabase.repository.UserRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public List<User> getAllUsers() {
        try {
            List<UserEntity> users = userRepository.findAll();
            List<User> customUsers = new ArrayList<>();
            users.stream().forEach(e -> {
                User user = new User();
                BeanUtils.copyProperties(e, user);
                customUsers.add(user);
            });
            return customUsers;
        } catch (Exception e) {
            throw e;
        }
    }

    public String addUser(UserEntity user) {
        try {
            if (!userRepository.existsByCompanyNameAndPrice(user.getCompanyName(), user.getPrice())) {
                userRepository.save(user);
                return "User added successfully";
            } else {
                return "This user already exists in the database.";
            }
        } catch (Exception e) {
            throw e;
        }
    }

    public String removeUser(UserEntity user) {
        try {
            if (userRepository.existsByCompanyNameAndPrice(user.getCompanyName(), user.getPrice())) {
                userRepository.delete(user);
                return "User deleted successfully.";
            } else {
                return "User does not exist.";
            }
        } catch (Exception e) {
            throw e;
        }
    }

    public String updateUser(UserEntity user) {
        try {
            if (userRepository.existsById(user.getId())) {
                userRepository.save(user);
                return "User updated successfully.";
            } else {
                return "User does not exist.";
            }
        } catch (Exception e) {
            throw e;
        }
    }
}
