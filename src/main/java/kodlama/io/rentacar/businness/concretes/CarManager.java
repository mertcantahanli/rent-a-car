package kodlama.io.rentacar.businness.concretes;

import kodlama.io.rentacar.businness.abstracts.CarService;
import kodlama.io.rentacar.businness.dto.requests.create.CreateCarRequest;
import kodlama.io.rentacar.businness.dto.requests.update.UpdateCarRequest;
import kodlama.io.rentacar.businness.dto.responses.create.CreateCarResponse;
import kodlama.io.rentacar.businness.dto.responses.get.GetAllCarsResponse;
import kodlama.io.rentacar.businness.dto.responses.get.GetCarResponse;
import kodlama.io.rentacar.businness.dto.responses.update.UpdateCarResponse;
import kodlama.io.rentacar.entities.Car;
import kodlama.io.rentacar.repository.CarRepository;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CarManager implements CarService {

    private final CarRepository repository;
    private  final ModelMapper mapper;


    @Override
    public List<GetAllCarsResponse> getAll() {
        List<Car> cars = repository.findAll();
        List<GetAllCarsResponse> response = cars
                .stream().map(car -> mapper.map(car,GetAllCarsResponse.class))
                .toList();
        return response;
    }

    @Override
    public GetCarResponse getById(int id) {
        checkIfCarExists(id);
        Car car=repository.findById(id).orElseThrow();
        GetCarResponse response =mapper.map(car, GetCarResponse.class);
        return response;
    }

    @Override
    public CreateCarResponse add(CreateCarRequest request) {
        Car car = mapper.map(request, Car.class);
        car.setId(0);
        repository.save(car);
        CreateCarResponse response = mapper.map(car, CreateCarResponse.class);
        return response;
    }

    @Override
    public UpdateCarResponse update(int id, UpdateCarRequest request) {
        Car car = mapper.map(request, Car.class);
        car.setId(id);
        repository.save(car);
        UpdateCarResponse response = mapper.map(car, UpdateCarResponse.class);
        return response;
    }

    @Override
    public void delete(int id) {
        repository.deleteById(id);
    }
    private void checkIfCarExists(int id){
        // id ye ait data kontrolu yapar
        if (!repository.existsById(id)) throw  new RuntimeException("Araba bulunamadi");
    }
}
