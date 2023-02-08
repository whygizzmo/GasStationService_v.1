package kg.itschoolmegacom.gasstationservice.mappers;

import kg.itschoolmegacom.gasstationservice.models.dtos.HistoryClientFuelDto;
import kg.itschoolmegacom.gasstationservice.models.entity.HistoryClientFuel;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface HistoryClientFuelMapper {
    HistoryClientFuelMapper INSTANCE = Mappers.getMapper(HistoryClientFuelMapper.class);
    HistoryClientFuel toHistory(HistoryClientFuelDto historyClientFuelDto);
    HistoryClientFuelDto toHistoryDto(HistoryClientFuel historyClientFuel);
}
