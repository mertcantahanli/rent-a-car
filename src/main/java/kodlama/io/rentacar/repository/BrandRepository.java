package kodlama.io.rentacar.repository;

import kodlama.io.rentacar.model.Brand;
import org.springframework.data.jpa.repository.JpaRepository;

//CRUD operations
public interface BrandRepository extends JpaRepository<Brand, Integer> {

    boolean existsByNameIgnoreCase(String name);

}
