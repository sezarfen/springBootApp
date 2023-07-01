package com.singers.singers.controllers;

import com.singers.singers.entity.Dhikr;
import com.singers.singers.entity.Hadith;
import com.singers.singers.entity.News;
import com.singers.singers.service.DhikrService;
import com.singers.singers.service.HadithService;
import com.singers.singers.service.NewsService;
import com.singers.singers.service.SingerService;
import com.singers.singers.utilities.StringManipulator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("")
public class MainController {

    private static int userCounter = 0;
    private final HadithService hadithService;
    private final SingerService singerService;
    private final NewsService newsService;
    private final StringManipulator stringManipulator;
    private final DhikrService dhikrService;

    @Autowired
    public MainController(HadithService hadithService, SingerService singerService,NewsService newsService, StringManipulator stringManipulator, DhikrService dhikrService)
    {
        this.hadithService = hadithService;
        this.singerService = singerService;
        this.newsService = newsService;
        this.stringManipulator = stringManipulator;
        this.dhikrService = dhikrService;
    }

    @GetMapping("")
    public String getIndex(Model model){
        this.userCounter++;
        System.out.println(userCounter);  // bir sayfaya kaç kullanıcı girdiğini hesaplamak için kullanıyoruz

        // Hadith
        List<Hadith> hadithList = hadithService.findAll();
        hadithList.forEach(hadith -> hadith.setEnglishText(stringManipulator.hadithForMainPage(hadith.getEnglishText())));

        // News
        List<News> newsList = newsService.findAll();

        // Dhikr
        List<Dhikr> dhikrList = dhikrService.findAll();


        model.addAttribute("hadithList", hadithList);
        model.addAttribute("newsList", newsList);
        model.addAttribute("dhikrList", dhikrList);

        return "index";
    }

    @GetMapping("/access-denied")
    public String showAccessDenied()
    {
        return "access-denied";
    }

    @GetMapping("/loginPage")
    public String showLoginPage()
    {
        return "loginPage";
    }

}
