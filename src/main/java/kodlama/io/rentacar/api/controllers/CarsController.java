package kodlama.io.rentacar.api.controllers;

import kodlama.io.rentacar.businness.abstracts.CarService;
import kodlama.io.rentacar.businness.dto.requests.create.CreateCarRequest;
import kodlama.io.rentacar.businness.dto.requests.update.UpdateCarRequest;
import kodlama.io.rentacar.businness.dto.responses.create.CreateCarResponse;
import kodlama.io.rentacar.businness.dto.responses.get.GetAllCarsResponse;
import kodlama.io.rentacar.businness.dto.responses.get.GetCarResponse;
import kodlama.io.rentacar.businness.dto.responses.update.UpdateCarResponse;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cars")
@AllArgsConstructor
public class CarsController {
    private final CarService carService;

    @GetMapping
    public List<GetAllCarsResponse> findAll(){
        return carService.getAll();
    }

    @GetMapping("/{id}")
    public GetCarResponse getById(@PathVariable int id){
        return carService.getById(id);
    }
    @PostMapping
    public CreateCarResponse add(@RequestBody  CreateCarRequest request){
        return carService.add(request);
    }

    @PutMapping("/{id}")
    public UpdateCarResponse update(@PathVariable int id, @RequestBody  UpdateCarRequest request){
        return carService.update(id,request);
    }
    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id){
        carService.delete(id);
    }
}