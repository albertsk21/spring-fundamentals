package bg.softuni.mvc.mvcApplication.services;


import bg.softuni.mvc.mvcApplication.models.dtos.CatDTO;

import java.util.List;
import java.util.Optional;

public interface CatService {

    List<CatDTO> getAllCats();

    Optional<CatDTO> getCatById(Long id);

    Long createCat(CatDTO catDTO);

    void deleteCat(Long id);


}
