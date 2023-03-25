package kodlama.io.rentacar.businness.concretes;

import kodlama.io.rentacar.businness.abstracts.BrandService;
import kodlama.io.rentacar.entities.Brand;
import kodlama.io.rentacar.repository.BrandRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class BrandManager implements BrandService {

    private final BrandRepository repository;


    @Override
    public List<Brand> getAll() {
        return repository.findAll();
    }

    @Override
    public Brand getById(int id) {
        checkIfBrandExists(id);
        return repository.findById(id).orElseThrow();
    }

    @Override
    public Brand add(Brand brand) {
        return repository.save(brand);
    }

    @Override
    public Brand update(int id, Brand brand) {
        brand.setId(id);
        return repository.save(brand);
    }

    @Override
    public void delete(int id) {
        repository.deleteById(id);
    }

    private void checkIfBrandExists(int id){
        // id ye ait data kontrolu yapar
        if (!repository.existsById(id)) throw  new RuntimeException("Marka bulunamadi");

    }
}
