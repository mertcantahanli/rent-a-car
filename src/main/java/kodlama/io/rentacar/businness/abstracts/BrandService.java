package kodlama.io.rentacar.businness.abstracts;

import kodlama.io.rentacar.businness.dto.requests.create.CreateBrandRequest;
import kodlama.io.rentacar.businness.dto.requests.update.UpdateBrandRequest;
import kodlama.io.rentacar.businness.dto.responses.create.CreateBrandResponse;
import kodlama.io.rentacar.businness.dto.responses.get.GetAllBrandsResponse;
import kodlama.io.rentacar.businness.dto.responses.get.GetBrandResponse;
import kodlama.io.rentacar.businness.dto.responses.update.UpdateBrandResponse;

import java.util.List;

public interface BrandService {
    List<GetAllBrandsResponse> getAll();
    GetBrandResponse getById(int id);
    CreateBrandResponse add(CreateBrandRequest request);
    UpdateBrandResponse update(int id, UpdateBrandRequest request);
    void delete(int id);

}
