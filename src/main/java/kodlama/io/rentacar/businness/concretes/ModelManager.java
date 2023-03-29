package kodlama.io.rentacar.businness.concretes;

import kodlama.io.rentacar.businness.abstracts.ModelService;
import kodlama.io.rentacar.businness.dto.requests.create.CreateModelRequest;
import kodlama.io.rentacar.businness.dto.requests.update.UpdateModelRequest;
import kodlama.io.rentacar.businness.dto.responses.create.CreateModelResponse;
import kodlama.io.rentacar.businness.dto.responses.get.GetAllModelResponse;
import kodlama.io.rentacar.businness.dto.responses.get.GetModelResponse;
import kodlama.io.rentacar.businness.dto.responses.update.UpdateModelResponse;
import kodlama.io.rentacar.entities.Model;
import kodlama.io.rentacar.repository.ModelRepository;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@AllArgsConstructor
public class ModelManager implements ModelService {
    private final ModelRepository repository;
    private  final ModelMapper mapper;
    @Override
    public List<GetAllModelResponse> getAll() {
        List<Model> models = repository.findAll();
        List<GetAllModelResponse> response = models
                .stream().map(model -> mapper.map(model,GetAllModelResponse.class))
                .toList();
        return response;
    }

    @Override
    public GetModelResponse getById(int id) {
        return null;
    }


    @Override
    public CreateModelResponse add(CreateModelRequest request) {
        Model model = mapper.map(request, Model.class);
        model.setId(0);
        request.getBrand_id();

        repository.save(model);
        CreateModelResponse response = mapper.map(model, CreateModelResponse.class);

        return response;
    }

    @Override
    public UpdateModelResponse update(int id, UpdateModelRequest request) {
        return null;
    }



    @Override
    public void delete(int id) {

    }
}
