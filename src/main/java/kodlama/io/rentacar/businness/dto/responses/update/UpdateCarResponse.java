package kodlama.io.rentacar.businness.dto.responses.update;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class UpdateCarResponse {
    private  int id;

    private int modelYear;
    private String plate;
    private double dailyPrice;
}
