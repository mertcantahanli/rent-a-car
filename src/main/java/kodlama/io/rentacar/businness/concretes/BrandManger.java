package kodlama.io.rentacar.businness.concretes;

import kodlama.io.rentacar.businness.abstracts.BrandService;
import kodlama.io.rentacar.entities.concretes.Brand;
import kodlama.io.rentacar.repository.abstracts.BrandRepository;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class BrandManger  implements BrandService {

    BrandRepository repository;

    public BrandManger(BrandRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Brand> getAll() {
        //is kurallari
        if (repository.getAll().size()==0) throw new RuntimeException("Marka bulunamadi");
        return repository.getAll();
    }

    @Override
    public Brand getById(int id) {
        return null;
    }

    @Override
    public Brand add(Brand product) {
        return null;
    }

    @Override
    public Brand update(int id, Brand product) {
        return null;
    }

    @Override
    public void delete(int id) {

    }
}
