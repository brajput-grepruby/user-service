package com.training.user_service.service;

import com.training.user_service.entity.User;

import java.util.List;

public interface UserService {
  List<User> findAllUser();

  User saveUser(User user);

  User findUserById(Long userId);

  void deleteUserById(Long userId);

  User updateUser(Long userId, User user);
}
