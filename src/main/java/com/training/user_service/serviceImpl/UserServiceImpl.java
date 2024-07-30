package com.training.user_service.serviceImpl;

import com.training.user_service.entity.User;
import com.training.user_service.repository.UserRepository;
import com.training.user_service.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class UserServiceImpl implements UserService {

  @Autowired
  private UserRepository userRepository;

  @Override
  public List<User> findAllUser() {
    List<User> users = userRepository.findAll();
    return users;
  }

  @Override
  public User saveUser(User user) {
    return userRepository.save(user);
  }

  @Override
  public User findUserById(Long userId) {
    User user = userRepository.findByUserId(userId);
//    if (user == null) {
//      throw new UserNotFoundException("User with id " + departmentId + " does not exist in database");
//    }
    return user;
  }

  @Override
  public void deleteUserById(Long userId) {
    userRepository.deleteById(userId);
  }

  @Override
  public User updateUser(Long userId, User userData) {
    User user = userRepository.findByUserId(userId);
    if (Objects.nonNull(user.getUserName()) && !"".equalsIgnoreCase(user.getUserName())) {
      user.setUserName(userData.getUserName());
    }

    if (Objects.nonNull(user.getUserAddress()) && !"".equalsIgnoreCase(user.getUserAddress())) {
      user.setUserAddress(userData.getUserAddress());
    }

    return userRepository.save(user);
  }
}
