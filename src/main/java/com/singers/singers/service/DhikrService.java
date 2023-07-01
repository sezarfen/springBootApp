package com.singers.singers.service;

import com.singers.singers.dao.DhikrRepository;
import com.singers.singers.entity.Dhikr;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DhikrService implements GeneralService<Dhikr> {

    private final DhikrRepository dhikrRepository;


    public DhikrService(DhikrRepository dhikrRepository)
    {
        this.dhikrRepository = dhikrRepository;
    }

    @Override
    public List<Dhikr> findAll() {
        return dhikrRepository.findAll();
    }

    @Override
    public Dhikr findById(int id) {
        return dhikrRepository.findById(id).orElseThrow();
    }

    @Override
    public void deleteById(int id) {
        dhikrRepository.deleteById(id);
    }

    @Override
    public Dhikr update(Dhikr dhikr) {
        return dhikrRepository.save(dhikr);
    }

    @Override
    public void save(Dhikr dhikr) {
        dhikrRepository.save(dhikr);
    }
}
