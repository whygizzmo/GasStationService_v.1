package kg.itschoolmegacom.gasstationservice.repository;

import kg.itschoolmegacom.gasstationservice.models.entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepo extends JpaRepository<Client,Long> {
    public Client findByEmail(String email);
}
