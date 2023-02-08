package kg.itschoolmegacom.gasstationservice.models.dtos.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class FuelCalculatePay {
    long historyId;
    double deposit;
}
