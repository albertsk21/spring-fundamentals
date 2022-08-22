package bg.softuni.userproject.service;

import bg.softuni.userproject.model.dtos.UserDTO;
import bg.softuni.userproject.model.entities.UserEntity;
import bg.softuni.userproject.repository.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;
    private ModelMapper modelMapper;

    public UserServiceImpl(UserRepository userRepository, ModelMapper modelMapper) {
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public UserDTO findById(Long id) {
        UserEntity user = this.userRepository.findUserById(id);
        return this.modelMapper.map(user,UserDTO.class);
    }

    @Override
    public List<UserDTO> getAll() {
        return this.userRepository
                .findAll()
                .stream()
                .map(c -> this.modelMapper.map(c,UserDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public void save(UserDTO userDTO) {
        UserEntity user = this.modelMapper.map(userDTO,UserEntity.class);
        this.userRepository.save(user);
    }

    @Override
    public void delete(Long id) {
        this.userRepository.deleteById(id);
    }
}
