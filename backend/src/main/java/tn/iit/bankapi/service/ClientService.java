package tn.iit.bankapi.service;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import tn.iit.bankapi.dto.ClientRequest;
import tn.iit.bankapi.entity.Client;

import java.util.List;

public interface ClientService {
    public Client addClient(Client client);

    Client updateClient(@PathVariable int client_id, @RequestBody Client client);

    public String deleteClient(int clientId);
    public Client getClientById(int clientId);
    public List<Client> getClients();

    public List<Client> getAllClientByName(String name);

    //public List<Client> getByClientName(String clientName);
}
