package kodlama.io.rentacar.repository;

import kodlama.io.rentacar.model.Model;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ModelRepository extends JpaRepository<Model, Integer> {
}
