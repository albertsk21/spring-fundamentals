package bg.softuni.restservice.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean(name = "modelMapper")
    public ModelMapper modelMapper(){
        return new ModelMapper();
    }
}
