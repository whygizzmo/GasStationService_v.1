package kg.itschoolmegacom.gasstationservice.service.impl;

import kg.itschoolmegacom.gasstationservice.mappers.FuelMapper;
import kg.itschoolmegacom.gasstationservice.models.dtos.ClientDto;
import kg.itschoolmegacom.gasstationservice.models.dtos.FuelDto;
import kg.itschoolmegacom.gasstationservice.models.dtos.HistoryClientFuelDto;
import kg.itschoolmegacom.gasstationservice.models.dtos.request.FuelCalculateRequest;
import kg.itschoolmegacom.gasstationservice.models.entity.Client;
import kg.itschoolmegacom.gasstationservice.models.entity.Fuel;
import kg.itschoolmegacom.gasstationservice.models.enums.PayStatus;
import kg.itschoolmegacom.gasstationservice.repository.ClientRepo;
import kg.itschoolmegacom.gasstationservice.repository.FuelRepo;
import kg.itschoolmegacom.gasstationservice.service.ClientService;
import kg.itschoolmegacom.gasstationservice.service.FuelService;
import kg.itschoolmegacom.gasstationservice.service.HistoryClientFuelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class FuelServiceImpl implements FuelService {

    @Autowired
    private ClientService clientService;
    @Autowired
    private HistoryClientFuelService historyClientFuelService;
    @Autowired
    private FuelRepo fuelRepo;
    private final ClientRepo clientRepo;

    @Autowired
    public FuelServiceImpl(FuelRepo fuelRepo,
                           ClientRepo clientRepo) {

        this.fuelRepo = fuelRepo;
        this.clientRepo = clientRepo;
    }

    @Override
    public ResponseEntity<?> save(FuelDto fuelDto) {
        Fuel fuel = FuelMapper.INSTANCE.toFuel(fuelDto);
        fuel = fuelRepo.save(fuel);

        fuelDto = FuelMapper.INSTANCE.toFuelDto(fuel);

        return ResponseEntity.ok(fuelDto);
    }

    @Override
    public ResponseEntity<?> calculate(FuelCalculateRequest fuelCalculateRequest) {
        Fuel fuel;
        HistoryClientFuelDto historyClientFuelDto = new HistoryClientFuelDto();

        fuel = fuelRepo.findById(fuelCalculateRequest.getFuelId()).get();
        FuelDto fuelDto = FuelMapper.INSTANCE.toFuelDto(fuel);

        double resultPrice = fuelDto.getPricePerLiter() * fuelCalculateRequest.getVolume();

        historyClientFuelDto.setFuel(fuel);
        if ((clientRepo.findByEmail(fuelCalculateRequest.getEmail())) == null) {
            clientService.save(new ClientDto(fuelCalculateRequest.getEmail()));

        }
        historyClientFuelDto.setClient(clientRepo.findByEmail(fuelCalculateRequest.getEmail()));

        historyClientFuelDto.setVolume(fuelCalculateRequest.getVolume());
        historyClientFuelDto.setAmount(resultPrice);
        historyClientFuelDto.setPlateNumber(fuelCalculateRequest.getPlateNumber());
        historyClientFuelDto.setPayStatus(PayStatus.PAID);


        return ResponseEntity.ok(historyClientFuelService.save(historyClientFuelDto));//HistoryClientFuelDto
    }

    @Override
    public List<Fuel> getFuel() {

        return fuelRepo.findAll();

    }

    @Override
    public Fuel getOne(Long id) {
        Fuel fuel = fuelRepo.findById(id).get();
        return fuel;
    }
}
