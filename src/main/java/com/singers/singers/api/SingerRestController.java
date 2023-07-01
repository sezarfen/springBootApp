package com.singers.singers.api;

import com.singers.singers.entity.Singer;
import com.singers.singers.service.SingerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/singers")
public class SingerRestController {

    private final SingerService singerService;

    @Autowired
    public SingerRestController(SingerService singerService)
    {
        this.singerService = singerService;
    }

    @GetMapping(path = "")
    public List<Singer> getSingers()
    {
        List<Singer> singerList= singerService.findAll();

        return singerList;
    }

    @GetMapping("/{singerId}")
    public Singer getSinger(@PathVariable int singerId)
    {
        Singer singer = singerService.findById(singerId);

        return singer;
    }

}