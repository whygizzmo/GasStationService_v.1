package kg.itschoolmegacom.gasstationservice.service.impl;

import kg.itschoolmegacom.gasstationservice.mappers.ClientMapper;
import kg.itschoolmegacom.gasstationservice.models.dtos.ClientDto;
import kg.itschoolmegacom.gasstationservice.models.entity.Client;
import kg.itschoolmegacom.gasstationservice.repository.ClientRepo;
import kg.itschoolmegacom.gasstationservice.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class ClientServiceImpl implements ClientService {

    private ClientRepo clientRepo;


    @Autowired
    public ClientServiceImpl(ClientRepo clientRepo) {
        this.clientRepo = clientRepo;
    }

    @Override
    public ResponseEntity<?> save(ClientDto clientDto) {
        Client client = ClientMapper.INSTANCE.toClient(clientDto);
        client = clientRepo.save(client);

        clientDto =ClientMapper.INSTANCE.toClientDto(client);
        return ResponseEntity.ok(client);

//
    }
}
