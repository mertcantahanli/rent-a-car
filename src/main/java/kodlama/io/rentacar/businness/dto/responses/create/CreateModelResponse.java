package kodlama.io.rentacar.businness.dto.responses.create;

import kodlama.io.rentacar.entities.Brand;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class CreateModelResponse {
    private  int id;
    private  String name;
    private Brand brand;
}
