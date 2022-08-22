package bg.softuni.project.linkedout.config;


import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class ApplicationConfigurationBean {


    @Bean
    public ModelMapper modelMapper(){
        return new ModelMapper();
    }

}
