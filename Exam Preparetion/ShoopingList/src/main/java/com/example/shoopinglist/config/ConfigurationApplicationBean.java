package com.example.shoopinglist.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class ConfigurationApplicationBean {


    @Bean(name = "modelMapper")
    public ModelMapper modelMapper(){
        return new ModelMapper();
    }

}
