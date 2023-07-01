package com.singers.singers.dao;

import com.singers.singers.entity.UserSinger;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserSingerRepository extends JpaRepository<UserSinger, String> {
}
