package com.singers.singers.api;

import com.singers.singers.entity.News;
import com.singers.singers.service.NewsService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "/api/news")
public class NewsRestController {

    private final NewsService newsService;

    public NewsRestController (NewsService newsService)
    {
        this.newsService = newsService;
    }

    @GetMapping(path = "")
    public List<News> getNewsList()
    {
        List<News> newsList = newsService.findAll();

        return newsList;
    }

    @GetMapping(path = "/{newsId}")
    public  News getNews(@PathVariable(name = "newsId") int newsId)
    {
        News news = newsService.findById(newsId);

        return news;
    }
}
