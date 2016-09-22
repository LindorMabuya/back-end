package za.ac.cput.healthBackend.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.healthBackend.domain.Client;
import za.ac.cput.healthBackend.service.ClientService;

/**
 * Created by Ijaaz on 2016-09-22.
 */
@RestController
public class ClientController
{
    @Autowired
    private ClientService service;

    /*
       CREATE
    */
    @RequestMapping(value = "/client/",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            method = RequestMethod.POST)
    public ResponseEntity<Client> createColdDrink(@RequestBody Client client) {
        service.create(client);
        return new ResponseEntity<Client>(client, HttpStatus.CREATED);
    }

    /*
        READ BY ID
    * */
    @RequestMapping(value = "/client/{id}",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<Client> readColdDrinkByID(@PathVariable("id") long id) {
        Client client = service.readById(id);
        if (client == null) {
            return new ResponseEntity<Client>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<Client>(client, HttpStatus.OK);
    }

    /*
        READ ALL
      */
    @RequestMapping(value = "/clients/",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Iterable<Client>> findAllColdDrinks() {
        Iterable<Client> clients = service.readAll();
        if (clients == null) {
            return new ResponseEntity<Iterable<Client>>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<Iterable<Client>>(clients, HttpStatus.OK);
    }

    /*
        UPDATE
    * */
    @RequestMapping(value = "/client/{id}",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            method = RequestMethod.PUT)
    public ResponseEntity<Client> updateColdDrink(@PathVariable("id") long id, @RequestBody Client client)
    {
        Client currentClient = service.readById(id);
        if(currentClient == null)
        {
            return new ResponseEntity<Client>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        Client update = new Client.ClientBuilder()
                .name(currentClient.getName())
                .lastName(currentClient.getLastName())
                .address(client.getObjAdress()).build();
        service.update(update);
        return new ResponseEntity<Client>(update,HttpStatus.OK);
    }

    /*
        DELETE
    * */
    @RequestMapping(value = "/client/{id}",
            method = RequestMethod.DELETE)
    public ResponseEntity<Client> deleteColdDrink(@PathVariable("id") long id)
    {
        Client beverage = service.readById(id);
        if(beverage == null)
        {
            return new ResponseEntity<Client>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        service.delete(beverage);
        return new ResponseEntity<Client>(HttpStatus.NO_CONTENT);
    }

    @RequestMapping(value = "/")
    public String testDeployment()
    {
        return "Hello World";
    }

}
