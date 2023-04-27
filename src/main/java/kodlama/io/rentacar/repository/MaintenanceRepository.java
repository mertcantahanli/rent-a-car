package kodlama.io.rentacar.repository;

import kodlama.io.rentacar.model.Maintenance;
import org.springframework.data.jpa.repository.JpaRepository;


public interface MaintenanceRepository extends JpaRepository<Maintenance, Integer> {
    Maintenance findMaintenanceByCarIdAndIsCompletedFalse(int carId);


    boolean existsByCarIdAndIsCompletedIsFalse(int carId);

}