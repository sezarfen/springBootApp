package com.singers.singers.controllers;

import com.singers.singers.entity.News;
import com.singers.singers.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(path = "/news")
public class NewsController {

    private final NewsService newsService;

    @Autowired
    public NewsController(NewsService newsService)
    {
        this.newsService = newsService;
    }

    @GetMapping(path = "/{newsId}")
    public String getNewsPage(@PathVariable(name = "newsId") int newsId, Model model)
    {
        News news = newsService.findById(newsId);

        model.addAttribute("news", news);

        return "infoPages/newsIndex";
    }


}
