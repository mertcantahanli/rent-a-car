package kodlama.io.rentacar.repository;

import kodlama.io.rentacar.model.Rental;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RentalRepository extends JpaRepository<Rental, Integer> {
    Rental findRentalByCarId(int carId);
}