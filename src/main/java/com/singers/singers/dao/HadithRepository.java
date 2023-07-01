package com.singers.singers.dao;

import com.singers.singers.entity.Hadith;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HadithRepository extends JpaRepository<Hadith, Integer> {
}
