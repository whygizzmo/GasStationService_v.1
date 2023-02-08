package kg.itschoolmegacom.gasstationservice.mappers;

import kg.itschoolmegacom.gasstationservice.models.dtos.ClientDto;
import kg.itschoolmegacom.gasstationservice.models.entity.Client;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
@Mapper
public interface ClientMapper {
    ClientMapper INSTANCE = Mappers.getMapper(ClientMapper.class);
    Client toClient(ClientDto clientDto);
    ClientDto toClientDto (Client client);
}
