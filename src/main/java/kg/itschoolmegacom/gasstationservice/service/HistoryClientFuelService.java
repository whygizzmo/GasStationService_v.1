package kg.itschoolmegacom.gasstationservice.service;

import kg.itschoolmegacom.gasstationservice.models.dtos.HistoryClientFuelDto;
import kg.itschoolmegacom.gasstationservice.models.dtos.request.FuelCalculatePay;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public interface HistoryClientFuelService {
    public ResponseEntity<?> save(HistoryClientFuelDto historyClientFuelDto);


    public ResponseEntity<?> pay(FuelCalculatePay fuelCalculatePay);
}
