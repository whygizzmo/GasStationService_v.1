package kg.itschoolmegacom.gasstationservice.repository;

import kg.itschoolmegacom.gasstationservice.models.entity.HistoryClientFuel;
import kg.itschoolmegacom.gasstationservice.models.enums.PayStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
public interface HistoryClientFuelRepo extends JpaRepository<HistoryClientFuel, Long> {
    @Transactional
    @Modifying
    @Query(value = "update client_fuel_history  set deposit = +:deposit where id = :id", nativeQuery = true)
    void update(@Param("id") long id,
                @Param("deposit") double deposit);

    @Transactional
    @Modifying
    @Query(value = "UPDATE client_fuel_history  set deposit= +:deposit," +
            "change=:change WHERE id = :id ", nativeQuery = true)
    void update(@Param("id") long id,
                @Param("deposit") double deposit,
                @Param("change") double change);


}
