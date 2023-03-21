package kodlama.io.rentacar.api.controllers;

import kodlama.io.rentacar.businness.abstracts.BrandService;
import kodlama.io.rentacar.entities.concretes.Brand;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/brands")
public class BrandsController {
        private BrandService service;

    public BrandsController(BrandService service) {
        this.service = service;
    }
    @GetMapping
    public List<Brand> findAll(){
        return service.getAll();
    }

    @GetMapping("/{id}")
    public Brand getById(int id){
        return service.getById(id);
    }
    @PostMapping
    public Brand add(@RequestBody Brand brand ){
        return service.add(brand);
    }
    @PutMapping("/{id}")
    public Brand update(@PathVariable int id ,@RequestBody Brand brand){
        return service.update(id,brand);
    }
    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id){
        service.delete(id);
    }
}
