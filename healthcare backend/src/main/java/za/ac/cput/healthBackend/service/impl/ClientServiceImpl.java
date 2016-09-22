package za.ac.cput.healthBackend.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.healthBackend.domain.Client;
import za.ac.cput.healthBackend.repository.ClientRepository;
import za.ac.cput.healthBackend.service.ClientService;

/**
 * Created by Ijaaz on 2016-09-22.
 */
@Service
public class ClientServiceImpl implements ClientService {

    @Autowired
    ClientRepository repository;

    @Override
    public Client create(Client entity) {
        return repository.save(entity);
    }

    @Override
    public Client readById(Long aLong) {
        return repository.findOne(aLong);
    }

    @Override
    public Iterable<Client> readAll() {
        Iterable<Client> clients = repository.findAll();
        return clients;
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
