package tech.arrays.clientmanager.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tech.arrays.clientmanager.exception.UserNotFoundException;
import tech.arrays.clientmanager.model.Client;
import tech.arrays.clientmanager.repo.ClientRepo;

import java.util.List;
import java.util.UUID;

@Service
public class ClientService {
    private final ClientRepo clientRepo;


    @Autowired
    public ClientService(ClientRepo clientRepo) {
        this.clientRepo = clientRepo;
    }

    public Client addClient (Client client){
        client.setClientCode(UUID.randomUUID().toString());
        return clientRepo.save(client);
    }

    public List<Client> findAllClient(){
        return clientRepo.findAll();
    }
    public Client updateClient(Client client) {
        return clientRepo.save(client);

    }
    public Client findClientById(Long id){
        return clientRepo.findClientById(id).orElseThrow(() -> new UserNotFoundException("User by Id" + id + "was not found"));
    }


    public void deleteClient(Long id){
        clientRepo.deleteClientById(id);

    }
}

