package com.example.pathfinderproject.service.impl;

import com.example.pathfinderproject.repository.PictureRepository;
import com.example.pathfinderproject.service.PictureService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PictureServiceImpl implements PictureService {

    private PictureRepository pictureRepository;

    public PictureServiceImpl(PictureRepository pictureRepository) {
        this.pictureRepository = pictureRepository;
    }

    @Override
    public List<String> findAllUrls() {
        return this.pictureRepository.findAllUrls();
    }
}
