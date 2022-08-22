package bg.softuni.userproject.core;


import bg.softuni.userproject.model.dtos.UserDTO;
import bg.softuni.userproject.model.enums.UserTypeEnum;
import bg.softuni.userproject.service.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class ConsoleRunner implements CommandLineRunner {

    private UserService userService;

    public ConsoleRunner(UserService userService) {
        this.userService = userService;
    }
    @Override
    public void run(String... args) {

    }

    private void addUsers(){
        UserDTO userDTO1 = new UserDTO();
        userDTO1.setFirstName("John");
        userDTO1.setLastName("William");
        userDTO1.setUserType(UserTypeEnum.MODERATOR);
        userDTO1.setUsername("john1234");
        userDTO1.setPassword("12345");

        UserDTO userDTO2 = new UserDTO();
        userDTO2.setFirstName("Beatrice");
        userDTO2.setLastName("Andreea");
        userDTO2.setUserType(UserTypeEnum.MODERATOR);
        userDTO2.setUsername("beea1234");
        userDTO2.setPassword("12345");

        UserDTO userDTO3 = new UserDTO();
        userDTO3.setFirstName("Alexander");
        userDTO3.setLastName("Thomas");
        userDTO3.setUserType(UserTypeEnum.MODERATOR);
        userDTO3.setUsername("alexander1234");
        userDTO3.setPassword("12345");

        UserDTO userDTO4 = new UserDTO();
        userDTO4.setFirstName("Jeff");
        userDTO4.setLastName("Chan");
        userDTO4.setUserType(UserTypeEnum.MODERATOR);
        userDTO4.setUsername("jeff1234");
        userDTO4.setPassword("12345");

        this.userService.save(userDTO1);
        this.userService.save(userDTO2);
        this.userService.save(userDTO3);
        this.userService.save(userDTO4);
    }
}
