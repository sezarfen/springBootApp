package com.singers.singers.service;

import com.singers.singers.dao.SingerRepository;
import com.singers.singers.entity.Singer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SingerService implements GeneralService<Singer> {

    private final SingerRepository singerRepository;

    @Autowired
    public SingerService(SingerRepository singerRepository) {
        this.singerRepository = singerRepository;

    }

    @Override
    public List<Singer> findAll() {
        return singerRepository.findAll();
    }

    @Override
    public Singer findById(int id) {
        Optional<Singer> optionalSinger = singerRepository.findById(id);

        return optionalSinger.orElseThrow();
    }

    @Override
    public void deleteById(int id) {
            singerRepository.deleteById(id);
    }

    @Override
    public Singer update(Singer singer) {
        return singerRepository.save(singer);
    }

    @Override
    public void save(Singer singer) {
        singerRepository.save(singer);
    }
}
