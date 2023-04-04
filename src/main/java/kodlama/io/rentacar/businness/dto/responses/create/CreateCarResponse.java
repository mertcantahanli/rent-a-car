package kodlama.io.rentacar.businness.dto.responses.create;

import kodlama.io.rentacar.enums.State;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class CreateCarResponse {
    private  int id;

    private int modelYear;
    private String plate;
    private double dailyPrice;

    private State state;
}
