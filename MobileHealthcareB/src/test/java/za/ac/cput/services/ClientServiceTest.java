package za.ac.cput.services;
import za.ac.cput.App;

import za.ac.cput.domain.Client;
import za.ac.cput.domain.ClientAddress;
import za.ac.cput.factory.AddressFactory;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.context.web.WebAppConfiguration;
import org.junit.Assert;
import org.springframework.beans.factory.annotation.Autowired;

import org.testng.annotations.Test;
import za.ac.cput.factory.ClientFactory;
import za.ac.cput.services.impl.ClientServiceImpl;

import static junit.framework.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
/**
 * Created by Lilo on 8/7/2016.
 */
@SpringApplicationConfiguration(classes = App.class)
@WebAppConfiguration
public class ClientServiceTest extends AbstractTestNGSpringContextTests {
   @Autowired
     private ClientServiceImpl service;

    @Test
    public void testCreate() throws Exception {
        //repository.deleteAll();
        ClientAddress employeeAddress = AddressFactory.createClientAddress("admin","test","0000");
        Client passenger = ClientFactory.createClient("admin","test",employeeAddress);
        Client savedPassenger=service.create(passenger);

        assertNotNull("CREATE TEST",savedPassenger);
    }

    @Test(dependsOnMethods = "testCreate")
    public void testReadAll() throws Exception {
        Iterable<Client> passengers =  service.readAll();

        assertNotNull("READ TEST",passengers);
    }

   /* @Test(dependsOnMethods = "testReadAll")
    public void testUpdate() throws Exception {
        Client passengerFound= service.readById(1L);
        Client updatePassenger = new Client.ClientBuilder()
                .copy(passengerFound)
                .name("service testupdate")
                .build();
        Client updatedPassenger=service.update(updatePassenger);
        Assert.assertSame("UPDATE TEST",updatePassenger.getName(),updatedPassenger.getName());
    }

    @Test(dependsOnMethods = "testUpdate")
    public void testDelete() throws Exception {
        Client foundPassemger = service.readById(3L);
        if(foundPassemger !=null) {
            assertNotNull("BEFORE DELETE TEST",foundPassemger);
            service.delete(foundPassemger);
            Client deletedpassenger = service.readById(3L);

            assertNull("DELETE TEST",deletedpassenger);
        }

    }*/
}
