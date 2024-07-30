package com.training.user_service.controller;

import com.training.user_service.entity.User;
import com.training.user_service.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
@Slf4j
public class UserController {

  @Autowired
  private UserService userService;

  @GetMapping("/")
  public List<User> findAllUser() {
    return userService.findAllUser();
  }

  @PostMapping("/")
  public User saveUser(@RequestBody User user) {
//    log.info
    return userService.saveUser(user);
  }

  @GetMapping("/{id}")
  public User findUserById(@PathVariable("id") Long userId) {
    return userService.findUserById(userId);
  }

  @DeleteMapping("/{id}")
  public String deleteUserById(@PathVariable("id") Long userId) {
    userService.deleteUserById(userId);
    return "Department deleted";
  }

  @PutMapping("/{id}")
  public User updateUserById(@PathVariable("id") Long userId, @RequestBody User user) {

    return userService.updateUser(userId, user);
  }
}
