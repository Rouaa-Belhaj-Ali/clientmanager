package tech.arrays.clientmanager.repo;


import org.springframework.data.jpa.repository.JpaRepository;
import tech.arrays.clientmanager.model.Client;

import java.util.Optional;

public interface ClientRepo extends JpaRepository<Client, Long> {
    void deleteClientById(Long id);

   Optional<Client> findClientById(Long id);
}
