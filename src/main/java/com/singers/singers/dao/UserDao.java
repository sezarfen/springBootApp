package com.singers.singers.dao;


import com.singers.singers.entity.User;

public interface UserDao {

    User findByUserName(String userName);

    void save(User theUser);
}
