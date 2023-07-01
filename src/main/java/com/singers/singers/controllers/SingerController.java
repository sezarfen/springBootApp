package com.singers.singers.controllers;

import com.singers.singers.entity.Singer;
import com.singers.singers.entity.UserSinger;
import com.singers.singers.service.GeneralService;
import com.singers.singers.service.UserSingerService;
import com.singers.singers.utilities.StringManipulator;
import jakarta.websocket.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@Controller
@RequestMapping("/singers")
public class SingerController {

    private final GeneralService<Singer> singerService;
    private final StringManipulator stringManipulator;

    private final UserSingerService userSingerService;

    @Autowired
    public SingerController(@Qualifier("singerService") GeneralService<Singer> singerService, StringManipulator stringManipulator,UserSingerService userSingerService) {
        this.singerService = singerService;
        this.stringManipulator = stringManipulator;
        this.userSingerService = userSingerService;
    }

    @GetMapping("")
    public String getIndex(Model theModel)
    {
        List<Singer> singerList = singerService.findAll();
        theModel.addAttribute("singers", singerList);
        return "singers/singers";
    }

    @GetMapping("/{singerId}")
    public String getIndex(Model theModel, @PathVariable(name = "singerId") int singerId)
    {
        Singer singer = singerService.findById(singerId);
        singer.setDescription(stringManipulator.singerDescriptionSetter(singer.getDescription(), "en.wikipedia.org/wiki/"+singer.getFirstName()+"-"+singer.getLastName()));
        theModel.addAttribute("singer",singer);

        return "infoPages/singerPage";
    }

    @GetMapping("/addSingerForm")
    public String addSingerForm(Model model)
    {
        Singer singer = new Singer();

        model.addAttribute("singer", singer);

        return "singers/addSingerForm";
    }

    @PostMapping("/save")
    public String saveSinger(@ModelAttribute("singer") Singer singer)
    {
        singerService.save(singer);
        return "redirect:/singers";
    }

    @PostMapping("/follow/{singerId}")
    public String followSinger(@PathVariable(name = "singerId") int singerId, Principal principal) // Principal sayesinde currentUser ' a eriştik
    {
        Singer singer = singerService.findById(singerId);

        userSingerService.addNewFollowing(principal.getName(), singerId);
        singer.setFollowerNumber(singer.getFollowerNumber() + 1);
        singerService.save(singer);

        return "redirect:/singers/"+ singerId;
    }

    @PostMapping("/unfollow/{singerId}")
    public String unfollowSinger(@PathVariable(name = "singerId") int singerId, Principal principal) // Principal sayesinde currentUser ' a eriştik
    {
        userSingerService.deleteFollowing(principal.getName(),singerId);
        Singer singer = singerService.findById(singerId);
        singer.setFollowerNumber(singer.getFollowerNumber() - 1);

        singerService.save(singer);

        return "redirect:/singers/"+ singerId;
    }
}
