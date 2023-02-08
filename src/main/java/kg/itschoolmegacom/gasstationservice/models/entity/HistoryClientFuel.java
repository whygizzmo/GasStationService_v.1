package kg.itschoolmegacom.gasstationservice.models.entity;

import kg.itschoolmegacom.gasstationservice.models.enums.PayStatus;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "client_fuel_history")
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class HistoryClientFuel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    @ManyToOne
    @JoinColumn(name = "fuel_id")
    Fuel fuel;
    @ManyToOne

    @JoinColumn(name = "client_id")
    Client client;
    double volume;
    double amount;
    double deposit;
    double change;
    String PlateNumber;

    @CreationTimestamp
    Date CreatedData;

    @Enumerated(value = EnumType.ORDINAL)
    PayStatus payStatus;




}
