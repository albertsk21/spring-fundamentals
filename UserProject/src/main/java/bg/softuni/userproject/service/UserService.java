package bg.softuni.userproject.service;

import bg.softuni.userproject.model.dtos.UserDTO;

import java.util.List;

public interface UserService {

    UserDTO findById(Long id);
    List<UserDTO> getAll();
    void save(UserDTO userDTO);
    void delete(Long id);

}
