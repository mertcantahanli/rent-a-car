package kodlama.io.rentacar.business.dto.requests.create;

import jakarta.validation.constraints.Pattern;
import kodlama.io.rentacar.common.constants.Regex;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class CreateCarRequest {
    private int modelId;
    private double dailyPrice;
    private int modelYear;
    @Pattern(regexp = Regex.plate, message = "plate pattern is not correct")
    private String plate;
}
