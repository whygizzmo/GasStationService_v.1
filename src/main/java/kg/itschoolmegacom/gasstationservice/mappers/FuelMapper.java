package kg.itschoolmegacom.gasstationservice.mappers;

import kg.itschoolmegacom.gasstationservice.models.dtos.FuelDto;
import kg.itschoolmegacom.gasstationservice.models.entity.Fuel;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface FuelMapper {
    FuelMapper INSTANCE = Mappers.getMapper(FuelMapper.class);
    Fuel toFuel(FuelDto fuelDto);
    FuelDto toFuelDto(Fuel fuel);
}
