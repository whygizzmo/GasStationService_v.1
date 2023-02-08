package kg.itschoolmegacom.gasstationservice.service.impl;

import kg.itschoolmegacom.gasstationservice.mappers.HistoryClientFuelMapper;
import kg.itschoolmegacom.gasstationservice.models.dtos.HistoryClientFuelDto;
import kg.itschoolmegacom.gasstationservice.models.dtos.request.FuelCalculatePay;
import kg.itschoolmegacom.gasstationservice.models.entity.Client;
import kg.itschoolmegacom.gasstationservice.models.entity.HistoryClientFuel;
import kg.itschoolmegacom.gasstationservice.models.enums.PayStatus;
import kg.itschoolmegacom.gasstationservice.repository.ClientRepo;
import kg.itschoolmegacom.gasstationservice.repository.FuelRepo;
import kg.itschoolmegacom.gasstationservice.repository.HistoryClientFuelRepo;
import kg.itschoolmegacom.gasstationservice.service.HistoryClientFuelService;
import kg.itschoolmegacom.gasstationservice.service.MailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class HistoryClientFuelServiceImpl implements HistoryClientFuelService {
    @Autowired
    MailService mailService;
    @Autowired
    ClientRepo clientRepo;
    @Autowired
    FuelRepo fuelRepo;
    @Autowired
    private HistoryClientFuelRepo historyClientFuelRepo;

    @Autowired
    public HistoryClientFuelServiceImpl(HistoryClientFuelRepo historyClientFuelRepo) {

        this.historyClientFuelRepo = historyClientFuelRepo;
    }

    @Override
    public ResponseEntity<?> save(HistoryClientFuelDto historyClientFuelDto) {

        //  historyClientFuelDto.getFuel().getId();

        HistoryClientFuel historyClientFuel = HistoryClientFuelMapper.INSTANCE.toHistory(historyClientFuelDto);
        historyClientFuel.setFuel(fuelRepo.findById(historyClientFuelDto.getFuel().getId()).get());


        historyClientFuel.setClient(clientRepo.findByEmail(historyClientFuelDto.getClient().getEmail()));
        if (historyClientFuel.getClient() == null) {
            historyClientFuel.setClient(clientRepo.save(new Client(historyClientFuelDto.getClient().getEmail())));
        }
        historyClientFuel.setPayStatus(PayStatus.PENDING);
        // historyClientFuel.setPayStatus(historyClientFuelDto.getPayStatus());
        // historyClientFuelRepo.save(historyClientFuel);


        //  return ResponseEntity.ok(new FuelCalculateAnswer(historyClientFuelRepo.save(historyClientFuel).getId(),historyClientFuelDto.getAmount()));
        return ResponseEntity.ok("Order number : " + historyClientFuelRepo
                .save(historyClientFuel).getId() + " " + " sum :" + historyClientFuelDto.getAmount());
    }

    @Override
    public ResponseEntity<?> pay(FuelCalculatePay fuelCalculatePay) {
        HistoryClientFuel historyClientFuel = historyClientFuelRepo
                .findById(fuelCalculatePay
                .getHistoryId()).get();
         if (historyClientFuel.getAmount()> historyClientFuel.getDeposit() + fuelCalculatePay.getDeposit()){
             historyClientFuel.setDeposit(historyClientFuel.getDeposit()+ fuelCalculatePay.getDeposit());
                    historyClientFuelRepo.update(historyClientFuel.getId(), historyClientFuel.getDeposit());
             return ResponseEntity.ok("Contribute more : "+ (historyClientFuel.getAmount() - historyClientFuel.getDeposit()));
         }else {
             historyClientFuel.setDeposit(historyClientFuel.getDeposit() + fuelCalculatePay.getDeposit());
             historyClientFuel.setChange(historyClientFuel.getDeposit() - historyClientFuel.getAmount());
             historyClientFuel.setPayStatus(PayStatus.PAID);
             historyClientFuelRepo.update(historyClientFuel.getId(), historyClientFuel.getDeposit(),
                     historyClientFuel.getChange());
         }
                mailService.sendEmail(historyClientFuel.getClient().getEmail(),
                        "\t\t\tGazprom gas-station \n\n# " +
                                historyClientFuel.getId()+ " : order ID  \n"+
                                historyClientFuel.getFuel().getName() +" : fuel TYPE\n"+
                                historyClientFuel.getVolume() + " : liters\n"+
                                historyClientFuel.getAmount() +" c : sum\n"+
                                historyClientFuel.getDeposit() +" c : gived\n"+
                                historyClientFuel.getChange() + " : change\n"+
                                historyClientFuel.getPlateNumber() + " : plate number\n"+
                                historyClientFuel.getClient().getEmail() + " : email\n"+
                                historyClientFuel.getCreatedData() + " - date\n\n"+
                                "\t\tBon Voyage! - thanks for buying!"

                        ,"Check 'Gazprom' station.");

        return ResponseEntity.ok("check sended on email !");
    }

}
