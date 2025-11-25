package com.user.dao;

import com.user.dto.User;

public interface userinterface {
 public boolean insert(User u);
 public User get(String email,long phone);
 public boolean delete(User u);
 public User get(String email,String password);
 public boolean updatePassword(User u);
}
