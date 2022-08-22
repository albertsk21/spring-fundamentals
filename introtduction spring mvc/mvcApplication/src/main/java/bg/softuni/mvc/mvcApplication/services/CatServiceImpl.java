package bg.softuni.mvc.mvcApplication.services;

import bg.softuni.mvc.mvcApplication.models.dtos.CatDTO;
import bg.softuni.mvc.mvcApplication.models.entities.CatEntity;
import bg.softuni.mvc.mvcApplication.repositories.CatRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class CatServiceImpl implements CatService {

    private CatRepository catRepository;
    private ModelMapper modelMapper;

    public CatServiceImpl(CatRepository catRepository, ModelMapper modelMapper) {
        this.catRepository = catRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public List<CatDTO> getAllCats() {

        List<CatEntity> cats = this.catRepository.findAll();
        List<CatDTO> catsDTO = new ArrayList<>(Arrays.asList(this.modelMapper.map(cats.toArray(),CatDTO[].class)));
        return catsDTO;
    }

    @Override
    public Optional<CatDTO> getCatById(Long id) {
        CatEntity catEntity = this.catRepository.findCatEntityById(id);
        CatDTO catDTO = this.modelMapper.map(catEntity,CatDTO.class);
        return Optional.ofNullable(catDTO);
    }

    @Override
    public Long createCat(CatDTO catDTO) {
        CatEntity catEntity = this.modelMapper.map(catDTO,CatEntity.class);
        CatEntity saveCatEntity =  this.catRepository.save(catEntity);
        return saveCatEntity.getId();
    }

    @Override
    public void deleteCat(Long id) {
        this.catRepository.deleteById(id);
    }
}
