package kg.itschoolmegacom.gasstationservice.repository;

import kg.itschoolmegacom.gasstationservice.models.entity.Fuel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FuelRepo extends JpaRepository<Fuel,Long> {
    /*@Query(value = "select * from fuels where id = ?",
            nativeQuery = true)
    Fuel findByFuelId(Long id);*/

}
