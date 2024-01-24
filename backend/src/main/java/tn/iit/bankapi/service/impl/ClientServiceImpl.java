package tn.iit.bankapi.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import tn.iit.bankapi.dao.ClientDao;
import tn.iit.bankapi.entity.Client;
import tn.iit.bankapi.exceptions.ClientNotFoundException;
import tn.iit.bankapi.service.ClientService;

import java.util.List;
import java.util.Optional;

@Service
public class ClientServiceImpl implements ClientService {

    private ClientDao clientDao;

    public ClientServiceImpl(ClientDao clientDao)
    {
        this.clientDao=clientDao;
    }

    @Override
    public Client addClient(Client client) {
        return clientDao.save(client);
    }

    @Override
    public Client updateClient(@PathVariable int client_id, @RequestBody Client client) {
        Optional<Client> emp = clientDao.findById(client_id);

            Client existEmp = emp.get();
            existEmp.setNom(client.getNom());
            existEmp.setPrenom(client.getPrenom());
            existEmp.setAdresse(client.getAdresse());
            clientDao.save(existEmp);
            return existEmp;

    }

    @Override
    public String deleteClient(int clientId) {
        // More Business Logic
        clientDao.deleteById(clientId);
        return "Success";
    }

    @Override
    public Client getClientById(int clientId) {
        if(clientDao.findById(clientId).isEmpty())
        {
            throw new ClientNotFoundException("id does not exist");
        }
        return clientDao.findById(clientId).get();
    }

    @Override
    public List<Client> getClients() {
        if(clientDao.findAll().isEmpty())
        {
            throw new ClientNotFoundException("no product exist");
        }
        return clientDao.findAll();
    }

    @Override
    public List<Client> getAllClientByName(String name) {
        return clientDao.findAllClientbyName(name);
    }


}
