package kg.itschoolmegacom.gasstationservice.controllers;

import kg.itschoolmegacom.gasstationservice.models.dtos.ClientDto;
import kg.itschoolmegacom.gasstationservice.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/user")
public class ClientController {
    @Autowired
    private ClientService clientService;

    @PostMapping("/save")
    public ResponseEntity<?>saveUser(@RequestBody ClientDto clientDto){
        return clientService.save(clientDto);
    }
}
