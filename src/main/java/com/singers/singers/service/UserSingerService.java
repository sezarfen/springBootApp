package com.singers.singers.service;

import com.singers.singers.dao.UserSingerRepository;
import com.singers.singers.entity.Singer;
import com.singers.singers.entity.UserSinger;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.apache.catalina.User;
import org.springframework.stereotype.Service;

@Service
public class UserSingerService {

    private final UserSingerRepository userSingerRepository;

    public UserSingerService(UserSingerRepository userSingerRepository)
    {
        this.userSingerRepository = userSingerRepository;
    }

    public UserSinger getByUsername(String username)
    {
        return userSingerRepository.findById(username).orElse(null);
    }

    @Transactional
    public void addNewFollowing(String username, int singerId)
    {
        UserSinger newRecord = new UserSinger(username,singerId);
        userSingerRepository.save(newRecord);
    }

    @Transactional
    public void deleteFollowing(String username, int singerId)
    {
        userSingerRepository.deleteById(username);
    }
}
