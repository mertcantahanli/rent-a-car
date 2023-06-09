package kodlama.io.rentacar.business.dto.responses.get;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class GetAllRentalsResponse {
    private int id;
    private int carId;
    private double dailyPrice, totalPrice;
    private int rentedForDays;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
}