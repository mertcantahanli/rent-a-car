package kodlama.io.rentacar.businness.concretes;

import kodlama.io.rentacar.businness.abstracts.ModelService;
import kodlama.io.rentacar.businness.dto.requests.create.CreateModelRequest;
import kodlama.io.rentacar.businness.dto.requests.update.UpdateModelRequest;
import kodlama.io.rentacar.businness.dto.responses.create.CreateModelResponse;
import kodlama.io.rentacar.businness.dto.responses.get.GetAllModelsResponse;
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
    public List<GetAllModelsResponse> getAll() {
        List<Model> models = repository.findAll();
        List<GetAllModelsResponse> response = models
                .stream().map(model -> mapper.map(model, GetAllModelsResponse.class))
                .toList();
        return response;
    }

    @Override
    public GetModelResponse getById(int id) {
        checkIfModelExists(id);
        Model model=repository.findById(id).orElseThrow();
        GetModelResponse response =mapper.map(model, GetModelResponse.class);
        return response;
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
        Model model = mapper.map(request, Model.class);
        model.setId(id);
        repository.save(model);
        UpdateModelResponse response = mapper.map(model, UpdateModelResponse.class);
        return response;
    }



    @Override
    public void delete(int id) {
        repository.deleteById(id);
    }
    private void checkIfModelExists(int id){
        // id ye ait data kontrolu yapar
        if (!repository.existsById(id)) throw  new RuntimeException("Model bulunamadi");
    }
}
