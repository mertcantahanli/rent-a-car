package kodlama.io.rentacar.businness.abstracts;

import kodlama.io.rentacar.entities.concretes.Brand;

import java.util.List;

public interface BrandService {
    List<Brand> getAll();
    Brand getById(int id);
    Brand add(Brand product);
    Brand update(int id,Brand product);
    void delete(int id);

}
