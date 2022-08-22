package bg.softuni.essentials.service;

import bg.softuni.essentials.model.CarDTO;
import bg.softuni.essentials.model.EngineEnum;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

@Service
public class CarServiceImpl implements CarService{

    private List<CarDTO> allCars = List.of(
            new CarDTO(1, "Ford","Fiesta", EngineEnum.PETROL,true),
            new CarDTO( 2, "Toyota","Yaris", EngineEnum.DIESEL,false)
    );
    @Override
    public List<CarDTO> getAllCars() {
        return this.allCars;
    }

    @Override
    public Optional<CarDTO> findById(long id){
        Predicate<CarDTO> findByIdPredicate = (car) -> car.getId() == id;
        return this.allCars.stream().filter(findByIdPredicate).findFirst();
    }
}