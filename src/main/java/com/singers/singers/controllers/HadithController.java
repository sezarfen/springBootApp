package com.singers.singers.controllers;

import com.singers.singers.entity.Hadith;
import com.singers.singers.service.GeneralService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/hadith")
public class HadithController {

    private GeneralService<Hadith> hadithService;

    @Autowired
    public HadithController(@Qualifier("hadithService") GeneralService<Hadith> hadithService)
    {
        this.hadithService = hadithService;
    }

    @GetMapping("")
    public String getHadithPage(Model model)
    {
        List<Hadith> hadithList = hadithService.findAll();

        model.addAttribute("hadithList",hadithList);

        return "hadith/hadiths";
    }
}
