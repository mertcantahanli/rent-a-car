package kodlama.io.rentacar.repository;

import kodlama.io.rentacar.model.Car;
import kodlama.io.rentacar.model.enums.State;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CarRepository extends JpaRepository<Car, Integer> {
    List<Car> findAllByStateIsNot(State state);


}
