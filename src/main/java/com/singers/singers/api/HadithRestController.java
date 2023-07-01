package com.singers.singers.api;

import com.singers.singers.entity.Hadith;
import com.singers.singers.service.HadithService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "/api/hadith")
public class HadithRestController {

    private final HadithService hadithService;

    public HadithRestController (HadithService hadithService)
    {
        this.hadithService = hadithService;
    }

    @GetMapping(path = "")
    public List<Hadith> getHadiths()
    {
        List<Hadith> hadithList = hadithService.findAll();

        return hadithList;
    }

    @GetMapping(path = "/{hadithId}")
    public Hadith getHadith(@PathVariable(name = "hadithId") int hadithId)
    {
        Hadith hadith = hadithService.findById(hadithId);

        return hadith;
    }
}
