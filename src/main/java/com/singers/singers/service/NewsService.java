package com.singers.singers.service;

import com.singers.singers.dao.NewsRepository;
import com.singers.singers.entity.News;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NewsService implements GeneralService<News> {

    private final NewsRepository newsRepository;

    @Autowired
    public NewsService(NewsRepository newsRepository) {
        this.newsRepository = newsRepository;
    }

    @Override
    public List<News> findAll() {
        return newsRepository.findAll();
    }

    @Override
    public News findById(int id) {
        return newsRepository.findById(id).orElseThrow();
    }

    @Override
    public void deleteById(int id) {
        newsRepository.deleteById(id);
    }

    @Override
    public News update(News news) {
        return newsRepository.save(news);
    }

    @Override
    public void save(News news) {
        newsRepository.save(news);
    }
}
