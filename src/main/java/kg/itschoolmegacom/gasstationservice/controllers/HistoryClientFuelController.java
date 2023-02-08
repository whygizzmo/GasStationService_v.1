package kg.itschoolmegacom.gasstationservice.controllers;

import kg.itschoolmegacom.gasstationservice.models.dtos.HistoryClientFuelDto;
import kg.itschoolmegacom.gasstationservice.models.dtos.request.FuelCalculatePay;
import kg.itschoolmegacom.gasstationservice.service.HistoryClientFuelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.PostUpdate;

@RestController
@RequestMapping("api/v1/history")
public class HistoryClientFuelController {
    @Autowired
    private HistoryClientFuelService historyClientFuelService;

    @PostMapping("/save")
    public ResponseEntity<?> saveHistory(@RequestBody
                                         HistoryClientFuelDto historyClientFuelDto) {
        return historyClientFuelService.save(historyClientFuelDto);
    }

    @PutMapping("/pay")
    public ResponseEntity<?> payHistory(@RequestBody FuelCalculatePay fuelCalculatePay) {
        return historyClientFuelService.pay(fuelCalculatePay);
    }
}
