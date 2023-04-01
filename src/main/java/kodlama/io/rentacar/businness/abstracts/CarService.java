package kodlama.io.rentacar.businness.abstracts;

import kodlama.io.rentacar.businness.dto.requests.create.CreateCarRequest;
import kodlama.io.rentacar.businness.dto.requests.update.UpdateCarRequest;
import kodlama.io.rentacar.businness.dto.responses.create.CreateCarResponse;
import kodlama.io.rentacar.businness.dto.responses.get.GetAllCarsResponse;
import kodlama.io.rentacar.businness.dto.responses.get.GetCarResponse;
import kodlama.io.rentacar.businness.dto.responses.update.UpdateCarResponse;

import java.util.List;

public interface CarService {


    List<GetAllCarsResponse> getAll();
    GetCarResponse getById(int id);
    CreateCarResponse add(CreateCarRequest request);
    UpdateCarResponse update(int id, UpdateCarRequest request);
    void delete(int id);

}
