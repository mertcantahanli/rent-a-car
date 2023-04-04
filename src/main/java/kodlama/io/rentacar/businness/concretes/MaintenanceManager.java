package kodlama.io.rentacar.businness.concretes;

import kodlama.io.rentacar.businness.abstracts.CarService;
import kodlama.io.rentacar.businness.abstracts.MaintenanceService;
import kodlama.io.rentacar.businness.dto.requests.create.CreateMaintenanceRequest;
import kodlama.io.rentacar.businness.dto.requests.update.UpdateMaintenanceRequest;
import kodlama.io.rentacar.businness.dto.responses.create.CreateMaintenanceResponse;
import kodlama.io.rentacar.businness.dto.responses.get.GetCarResponse;
import kodlama.io.rentacar.businness.dto.responses.update.UpdateMaintenanceResponse;
import kodlama.io.rentacar.entities.Maintenance;
import kodlama.io.rentacar.enums.State;
import kodlama.io.rentacar.repository.MaintenanceRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Date;


@Service
@RequiredArgsConstructor
public class MaintenanceManager implements MaintenanceService {

    private final MaintenanceRepository repository;
    private final ModelMapper mapper;
    private final CarService carService;

    @Override
    public CreateMaintenanceResponse add(CreateMaintenanceRequest createMaintenanceRequest) {

        GetCarResponse response = checkIfCarExists(createMaintenanceRequest);
        checkIfCarAvaliable(response);
        Maintenance maintenance = mapper.map(createMaintenanceRequest, Maintenance.class);

        response.setState(State.MAINTANCE);

        Date date = new Date();
        maintenance.setId(0);
        maintenance.setSendDate(date);
        repository.save(maintenance);

        CreateMaintenanceResponse createMaintenanceResponse = mapper.map(maintenance, CreateMaintenanceResponse.class);

        return createMaintenanceResponse;
    }


    //
    @Override
    public UpdateMaintenanceResponse update(int id, UpdateMaintenanceRequest request) {
        checkIfMaintenanceExists(id);
        Maintenance maintenance = mapper.map(request, Maintenance.class);
        repository.save(maintenance);
        UpdateMaintenanceResponse respond = mapper.map(maintenance, UpdateMaintenanceResponse.class);
        return respond;
    }


    private void checkIfMaintenanceExists(int id) {
        Maintenance maintenance = repository.getById(id);

    }

    private void checkIfCarAvaliable(GetCarResponse response) {
        if (!State.AVALIABLE.equals(response.getState())) {
            throw new RuntimeException("car not avaliable");
        }

    }

    private GetCarResponse checkIfCarExists(CreateMaintenanceRequest createMaintenanceRequest) {
        GetCarResponse response = carService.getById(createMaintenanceRequest.getCarId());
        return response;
    }

    //
//    @Override
//    public GetMaintenanceResponse getById(int id) {
//        Maintenance maintenance =repository.findById(id).orElseThrow();
//        GetMaintenanceResponse response = mapper.map(maintenance, GetMaintenanceResponse.class);
//        return response;
//    }
//      getMaintenanceByCarId ac araba id sine gore bakimini getirecek
//    @Override
//    public List<GetAllMaintenancesResponse> getAll() {
////        List<Maintenance> maintenances = repository.findAll();
////        List<GetAllMaintenancesResponse> responses = maintenances.stream()
////                .map(maintenance -> mapper.map(maintenance, GetAllMaintenancesResponse.class)).toList();
//        return null;
//    }
//
//    @Override
//    public UpdateMaintenanceStatusForCarResponse returnFromMaintenance(int id, UpdateMaintenanceStatusForCarRequest request) {
//        Car car = mapper.map(carService.getById(request.getCarId()),Car.class);
//        checkIfAvailableForReturningFromMaintenance(car);
//        Maintenance maintenance = mapper.map(getById(id),Maintenance.class);
//        maintenance.setId(id);
//        Date date = new Date();
//        maintenance.setReturnDate(date);
//        repository.save(maintenance);
//        returnFromMaintenance(car);
//        UpdateMaintenanceStatusForCarResponse response = mapper.map(maintenance,UpdateMaintenanceStatusForCarResponse.class);
//        return response;
//    }
//
//    @Override
//    public void delete(int id) {
//        repository.deleteById(id);
//    }

}