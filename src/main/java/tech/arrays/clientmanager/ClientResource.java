package tech.arrays.clientmanager;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tech.arrays.clientmanager.model.Client;
import tech.arrays.clientmanager.service.ClientService;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping ("/Client")
public class ClientResource {
    private final ClientService clientService;

    public ClientResource(ClientService clientService) {
        this.clientService = clientService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Client>> getAllClient (){
        List<Client> clients = clientService.findAllClient();
        return new ResponseEntity<>(clients , HttpStatus.OK);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<Client> getClientById (@PathVariable("id") Long id){
        Client client = clientService.findClientById(id);
        return new ResponseEntity<>(client , HttpStatus.OK);
}
           @PostMapping("/add")
    public ResponseEntity<Client> addClient(@RequestBody Client client){
                  Client client1 = clientService.addClient(client);
                  return new ResponseEntity<>(client1, HttpStatus.CREATED);

           }

           @PutMapping("/update")
    public ResponseEntity<Client> updateClient(@RequestBody Client client){
        Client updateClient = clientService.updateClient(client);
        return new ResponseEntity<>( updateClient, HttpStatus.OK);
           }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteClient(@PathVariable("id") Long id){
        clientService.deleteClient(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}

