package kg.itschoolmegacom.gasstationservice.controllers;

import kg.itschoolmegacom.gasstationservice.models.dtos.FuelDto;
import kg.itschoolmegacom.gasstationservice.models.dtos.request.FuelCalculateRequest;
import kg.itschoolmegacom.gasstationservice.models.entity.Fuel;
import kg.itschoolmegacom.gasstationservice.service.FuelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/fuel")
public class FuelController {

    @Autowired
    private FuelService fuelService;

     @GetMapping("/calculate")
    public ResponseEntity<?> calculateFuel(@RequestBody FuelCalculateRequest fuelCalculateRequest){
     return ResponseEntity.ok(fuelService.calculate(fuelCalculateRequest));
     }

     @PostMapping("/save")
    public ResponseEntity<?> saveFuel(@RequestBody FuelDto fuelDto){
         return fuelService.save(fuelDto);
     }

     @GetMapping("/list")
    public ResponseEntity<?> listFuel(){
         return ResponseEntity.ok(fuelService.getFuel());
     }
     @GetMapping("/getOne")
     public Fuel getOne(Long id){
         return fuelService.getOne(id);
     }
}
