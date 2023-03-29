package kodlama.io.rentacar.api.controllers;

import kodlama.io.rentacar.businness.abstracts.ModelService;
import kodlama.io.rentacar.businness.dto.requests.create.CreateModelRequest;
import kodlama.io.rentacar.businness.dto.responses.create.CreateModelResponse;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/Models")
@AllArgsConstructor
public class ModelsController {
    private final ModelService modelService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CreateModelResponse add(@RequestBody CreateModelRequest request ){
        return modelService.add(request);
    }
}
