package com.singers.singers.service;


import com.singers.singers.entity.Singer;

import java.util.List;

public interface GeneralService<T> {
    List<T> findAll();
    T findById(int id);
    void deleteById(int id);
    T update(T t);
    void save(T t);
}
