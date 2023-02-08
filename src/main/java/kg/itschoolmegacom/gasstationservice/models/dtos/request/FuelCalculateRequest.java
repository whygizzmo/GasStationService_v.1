package kg.itschoolmegacom.gasstationservice.models.dtos.request;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class FuelCalculateRequest {
    String email;
    long fuelId;
    double volume;
    String plateNumber;

}
