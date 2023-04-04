package kodlama.io.rentacar.api.controllers;

import kodlama.io.rentacar.businness.abstracts.ModelService;
import kodlama.io.rentacar.businness.dto.requests.create.CreateModelRequest;
import kodlama.io.rentacar.businness.dto.requests.update.UpdateModelRequest;
import kodlama.io.rentacar.businness.dto.responses.create.CreateModelResponse;
import kodlama.io.rentacar.businness.dto.responses.get.GetAllModelsResponse;
import kodlama.io.rentacar.businness.dto.responses.get.GetModelResponse;
import kodlama.io.rentacar.businness.dto.responses.update.UpdateModelResponse;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/Models")
@AllArgsConstructor
public class ModelsController {
    private final ModelService modelService;


    @GetMapping
    public List<GetAllModelsResponse> findAll(){
        return modelService.getAll();
    }
    @GetMapping("/{id}")
    public GetModelResponse getById(@PathVariable int id){
        return modelService.getById(id);
    }


    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CreateModelResponse add(@RequestBody CreateModelRequest request ){
        return modelService.add(request);
    }

    @PutMapping("/{id}")
    public UpdateModelResponse update(@PathVariable int id, @RequestBody UpdateModelRequest modelRequest){
        return modelService.update(id, modelRequest);
    }

    @DeleteMapping("/{id}")
    public void delete( @PathVariable int id)
    {
        modelService.delete(id);
    }
}
