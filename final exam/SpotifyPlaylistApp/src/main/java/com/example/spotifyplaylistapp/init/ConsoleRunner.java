package com.example.spotifyplaylistapp.init;

import com.example.spotifyplaylistapp.model.dtos.StyleDTO;
import com.example.spotifyplaylistapp.model.enums.StyleNameEnum;
import com.example.spotifyplaylistapp.service.StyleService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class ConsoleRunner implements CommandLineRunner {

    private StyleService styleService;

    public ConsoleRunner(StyleService styleService) {
        this.styleService = styleService;
    }


    @Override
    public void run(String... args) throws Exception {


        if(this.styleService.isEmpty()){
            this.addStyles();
        }


    }

    private void addStyles(){

        StyleDTO styleDTO1 = new StyleDTO();
        styleDTO1.setStyleName(StyleNameEnum.JAZZ);
        StyleDTO styleDTO2 = new StyleDTO();
        styleDTO2.setStyleName(StyleNameEnum.POP);
        StyleDTO styleDTO3 = new StyleDTO();
        styleDTO3.setStyleName(StyleNameEnum.ROCK);

        this.styleService.saveStyle(styleDTO1);
        this.styleService.saveStyle(styleDTO2);
        this.styleService.saveStyle(styleDTO3);

    }
}
