package kodlama.io.rentacar.businness.dto.responses.get;

import kodlama.io.rentacar.entities.Model;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class GetAllModelResponse {
    private  int id;
    private  String name;
    private Model model;
}
