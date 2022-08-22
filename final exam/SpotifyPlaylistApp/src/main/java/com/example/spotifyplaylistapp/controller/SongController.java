package com.example.spotifyplaylistapp.controller;

import com.example.spotifyplaylistapp.model.bm.SongBM;
import com.example.spotifyplaylistapp.model.dtos.SongDTO;
import com.example.spotifyplaylistapp.model.enums.StyleNameEnum;
import com.example.spotifyplaylistapp.service.SongService;
import com.example.spotifyplaylistapp.service.StyleService;
import com.example.spotifyplaylistapp.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping("/songs")
public class SongController {


    private SongService songService;
    private ModelMapper modelMapper;
    private StyleService styleService;
    private UserService userService;

    public SongController(SongService songService, ModelMapper modelMapper, StyleService styleService, UserService userService) {
        this.songService = songService;
        this.modelMapper = modelMapper;
        this.styleService = styleService;
        this.userService = userService;
    }

    @GetMapping("")
    public String home(HttpSession httpSession, Model model){


        UUID id = (UUID) httpSession.getAttribute("userId");
        List<SongDTO> pop = this.songService.findSongsByStyleName(StyleNameEnum.POP);
        List<SongDTO> jazz = this.songService.findSongsByStyleName(StyleNameEnum.JAZZ);
        List<SongDTO> rock = this.songService.findSongsByStyleName(StyleNameEnum.ROCK);

        List<SongDTO> playlist = this.userService.gePlayListByUserId(id);

        int totalSeconds = 0;


        for (SongDTO songDTO : playlist ) {

            totalSeconds += songDTO.getDuration();
        }
        model.addAttribute("totalSeconds",totalSeconds);
        model.addAttribute("playlist",playlist);
        model.addAttribute("pop", pop);
        model.addAttribute("jazz", jazz);
        model.addAttribute("rock", rock);
        return httpSession.getAttribute("userId") == null ? "redirect:/" : "home";
    }



    @ModelAttribute("songModel")
    public SongBM songModel(){
        return new SongBM();
    }


    @GetMapping("/add")
    public String addSongGET(HttpSession httpSession){

        return httpSession.getAttribute("userId") != null ? "song-add" : "redirect:/";
    }

    @PostMapping("/add")
    public String addSongPOST(@Valid @ModelAttribute(name = "songModel") SongBM songModel,
                             BindingResult bindingResult,
                             RedirectAttributes redirectAttributes,
                             HttpSession httpSession){

        if (bindingResult.hasErrors()){
            redirectAttributes.addFlashAttribute("songModel",songModel);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.songModel",bindingResult);

            return "redirect:/songs/add";
        }


        UUID userId  = (UUID) httpSession.getAttribute("userId");
        this.songService.saveSong(this.modelMapper.map(songModel, SongDTO.class), userId);

        return "redirect:/songs";
    }


    @GetMapping("/playlist/add/{id}")
    public String addInPlayList(@PathVariable(name = "id") String id,
                                HttpSession httpSession){

        UUID songId = UUID.fromString(id);
        UUID userId = (UUID) httpSession.getAttribute("userId");


        this.userService.addSongInPlaylist(songId,userId);
        return "redirect:/songs";

    }


    @GetMapping("/playlist/remove")
    public String removeAll(HttpSession httpSession){

        UUID id = (UUID) httpSession.getAttribute("userId");
        this.userService.clearPlaylistByUserId(id);
        return "redirect:/songs";
    }
}
