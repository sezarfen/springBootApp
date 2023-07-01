package com.singers.singers.service;

import com.singers.singers.dao.HadithRepository;
import com.singers.singers.entity.Hadith;
import com.singers.singers.entity.Singer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HadithService implements GeneralService<Hadith> {

    private final HadithRepository hadithRepository;

    @Autowired
    public HadithService(HadithRepository hadithRepository)
    {
        this.hadithRepository = hadithRepository;
    }

    @Override
    public List<Hadith> findAll() {
        return hadithRepository.findAll();
    }

    @Override
    public Hadith findById(int id) {
        return hadithRepository.findById(id).orElseThrow();
    }

    @Override
    public void deleteById(int id) {
        hadithRepository.deleteById(id);
    }

    @Override
    public Hadith update(Hadith hadith) {
        return hadithRepository.save(hadith);
    }

    @Override
    public void save(Hadith hadith) {
        hadithRepository.save(hadith);
    }
}