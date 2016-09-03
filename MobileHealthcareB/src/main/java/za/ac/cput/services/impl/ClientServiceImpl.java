package za.ac.cput.services.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.Client;
import za.ac.cput.repository.ClientRepository;
import za.ac.cput.services.ClientService;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Lilo on 7/31/2016.
 */
@Service
public class ClientServiceImpl implements ClientService {
    @Autowired
    private ClientRepository repository;

    @Override
    public Client create(Client entity) {
        return repository.save(entity);
    }

    @Override
    public Client readById(Long id) {
        return repository.findOne(id);
    }

    @Override
    public Set<Client> readAll() {
        Iterable<Client> clients = repository.findAll();
        Set<Client> clientSet= new HashSet<>();

        for (Client client: clients){
            clientSet.add(client);
        }
        return clientSet;
    }

    @Override
    public Client update(Client entity) {
        return repository.save(entity);
    }

    @Override
    public void delete(Client entity) {
        repository.delete(entity);
    }
}
