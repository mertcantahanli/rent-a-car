package kodlama.io.rentacar.api.controllers;

import kodlama.io.rentacar.businness.abstracts.MaintenanceService;
import kodlama.io.rentacar.businness.dto.requests.create.CreateMaintenanceRequest;
import kodlama.io.rentacar.businness.dto.responses.create.CreateMaintenanceResponse;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("/api/maintenance")
public class MaintenanceController {
    private final MaintenanceService maintenanceService;
//    @GetMapping
//    public List<GetAllMaintenancesResponse> getAllMaintenancesResponses(){
//        return maintenanceService.getAll();
//    }
//    @GetMapping("/{}")
//    public GetMaintenanceResponse getById(@PathVariable int id){
//        return maintenanceService.getById(id);
//    }
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CreateMaintenanceResponse add(@RequestBody CreateMaintenanceRequest request){
        return maintenanceService.add(request);
    }
//    @PutMapping("/{id}")
//    public UpdateMaintenanceResponse update(@PathVariable int id, @RequestBody UpdateMaintenanceRequest request){
//        return maintenanceService.update(id,request);
//    }
//    @PutMapping("/status/{id}")
//    public UpdateMaintenanceStatusForCarResponse updateStatus(@PathVariable int id, @RequestBody UpdateMaintenanceStatusForCarRequest request){
//        return maintenanceService.returnFromMaintenance(id,request);
//
//    }
//    @DeleteMapping
//    public void delete(@PathVariable int id){
//        maintenanceService.delete(id);
//    }
}