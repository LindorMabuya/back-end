package za.ac.cput.repository;

import org.junit.Assert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.context.web.WebAppConfiguration;

import org.testng.annotations.Test;


import static junit.framework.Assert.assertNotNull;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNull;
import za.ac.cput.App;
import za.ac.cput.domain.Client;
import za.ac.cput.domain.ClientAddress;
import za.ac.cput.factory.AddressFactory;
import za.ac.cput.factory.ClientFactory;

/**
 * Created by Cornelious on 8/7/2016.
 */
@SpringApplicationConfiguration(classes = App.class)
@WebAppConfiguration
public class ClientCrudTest extends AbstractTestNGSpringContextTests {
    @Autowired
    private  ClientRepository repository;

    @Test
    public void testCreate() throws Exception {
        //repository.deleteAll();
        ClientAddress clientAddress = AddressFactory.createClientAddress("Maitland","Durban","8800");
        Client client = ClientFactory.createClient("Sipho","Mazibuko",clientAddress);
        Client savedClient=repository.save(client);

        assertNotNull("CREATE TEST",savedClient);
    }

    @Test(dependsOnMethods = "testCreate")
    public void testReadAll() throws Exception {
        Iterable<Client> passengers =  repository.findAll();

        assertNotNull("READ TEST",passengers);
    }

    /*@Test(dependsOnMethods = "testReadAll")
    public void testUpdate() throws Exception {
        Client passengerFound= repository.findOne(1L);
        Client updateClient = new Client.ClientBuilder()
                .copy(passengerFound)
                .name("testupdate")
                .build();
        Client updatedClient=repository.save(updateClient);
        Assert.assertSame("UPDATE TEST",updateClient.getName(),updatedClient.getName());
    }

    @Test(dependsOnMethods = "testUpdate")
    public void testDelete() throws Exception {
        Client foundClient = repository.findOne(2L);
        if(foundClient !=null) {
            assertNotNull("BEFORE DELETE TEST",foundClient);
            repository.delete(2L);
            Client deletedClient = repository.findOne(2L);

            assertNull("DELETE TEST",deletedClient);
        }

    }*/
}
