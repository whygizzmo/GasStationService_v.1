package kg.itschoolmegacom.gasstationservice.models.dtos;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.Date;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class FuelDto {
    Long id;
    String name;
    double pricePerLiter;




}
