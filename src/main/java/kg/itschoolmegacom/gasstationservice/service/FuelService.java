package kg.itschoolmegacom.gasstationservice.service;

import kg.itschoolmegacom.gasstationservice.models.dtos.FuelDto;
import kg.itschoolmegacom.gasstationservice.models.dtos.request.FuelCalculateRequest;
import kg.itschoolmegacom.gasstationservice.models.entity.Fuel;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface FuelService {
    ResponseEntity<?> save(FuelDto fuelDto);

    ResponseEntity<?> calculate(FuelCalculateRequest fuelCalculateRequest);

    List<Fuel> getFuel();

    Fuel getOne(Long id);
}
