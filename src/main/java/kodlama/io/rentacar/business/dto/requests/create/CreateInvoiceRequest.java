package kodlama.io.rentacar.business.dto.requests.create;

import lombok.*;

import java.time.LocalDateTime;

@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CreateInvoiceRequest {
    private String cardHolder;
    private String modelName;
    private String brandName;
    private String plate;
    private int modelYear;
    private double dailyPrice;
    private int rentedForDays;
    private LocalDateTime rentedAt;
}