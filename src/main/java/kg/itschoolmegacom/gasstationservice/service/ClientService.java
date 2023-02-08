package kg.itschoolmegacom.gasstationservice.service;

import kg.itschoolmegacom.gasstationservice.models.dtos.ClientDto;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public interface ClientService {
    ResponseEntity<?>save(ClientDto clientDto);
}
