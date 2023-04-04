package kodlama.io.rentacar.businness.dto.requests.create;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class CreateMaintenanceRequest {
    private int carId;
    private Date sendDate;
    private Date returnDate;

    private Boolean isViewable;

}