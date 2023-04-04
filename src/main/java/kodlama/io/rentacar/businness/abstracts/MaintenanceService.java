package kodlama.io.rentacar.businness.abstracts;


import kodlama.io.rentacar.businness.dto.requests.create.CreateMaintenanceRequest;
import kodlama.io.rentacar.businness.dto.requests.update.UpdateMaintenanceRequest;
import kodlama.io.rentacar.businness.dto.responses.create.CreateMaintenanceResponse;
import kodlama.io.rentacar.businness.dto.responses.update.UpdateMaintenanceResponse;

public interface MaintenanceService {
    CreateMaintenanceResponse add(CreateMaintenanceRequest request);
    UpdateMaintenanceResponse update(int id, UpdateMaintenanceRequest request);
//    GetMaintenanceResponse getById(int id);
//    List<GetAllMaintenancesResponse> getAll();
//    UpdateMaintenanceStatusForCarResponse returnFromMaintenance(int id, UpdateMaintenanceStatusForCarRequest request);
//    void delete(int id);
}