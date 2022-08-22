package bg.softuni.restservice.service.impl;

import bg.softuni.restservice.repository.AuthorRepository;
import bg.softuni.restservice.service.AuthorService;
import org.springframework.stereotype.Service;

@Service
public class AuthorServiceImpl implements AuthorService {


    private AuthorRepository authorRepository;

    public AuthorServiceImpl(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }
}
