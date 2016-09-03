package za.ac.cput.api;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.web.client.RestTemplate;
import za.ac.cput.domain.Client;
import za.ac.cput.domain.ClientAddress;
import za.ac.cput.factory.AddressFactory;
import za.ac.cput.factory.ClientFactory;

import java.util.Set;

/**
 * Created by Lilo on 8/11/2016.
 */
public class ClientControllerTest {
    @Test
    public void testCreate(){
        String URI =  "http://localhost:8080/pass";
        RestTemplate restTemplate = new RestTemplate();
        ClientAddress clientAddress = AddressFactory.createClientAddress("testApi","admin","1000");
        Client passenger = ClientFactory.createClient("testApi","test",clientAddress);
        restTemplate.postForObject(URI,passenger, Client.class );
    }
    @Test
    public void testFindById() {
        String URI =  "http://localhost:8080/pass/{id}";
        RestTemplate restTemplate = new RestTemplate();
        Client passenger= restTemplate.getForObject(URI, Client.class, "6");
        Assert.assertNotNull(passenger);
        Assert.assertEquals("testApi", passenger.getName());

        Assert.assertEquals("test", passenger.getLastName());
    }
    @Test
    public void testUpdate(){
        String URI =  "http://localhost:8080/pass/{id}";
        RestTemplate restTemplate = new RestTemplate();
        Client passenger= restTemplate.getForObject(URI, Client.class, "4");
        if(passenger!=null) {
            String UPDATE_URI = "http://localhost:8080/pass";
            Client updatePassenger = new Client.ClientBuilder()
                    .copy(passenger)
                    .name("successApi")
                    .build();
            restTemplate.put(UPDATE_URI,updatePassenger);
            Client updatedPassenger= restTemplate.getForObject(URI, Client.class, "4");

            Assert.assertEquals(updatePassenger.getName(), updatedPassenger.getName());
        }
    }
    @Test
    public void testFindAll(){
        String URI =  "http://localhost:8080/pass";
        RestTemplate restTemplate = new RestTemplate();
        Set employeeSet = restTemplate.getForObject(URI,Set.class);
        Assert.assertTrue(employeeSet.size()>0);
    }
    @Test
    public void testDelete(){
        String URI =  "http://localhost:8080/pass/{id}";
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.delete(URI,"1");
        Client passenger= restTemplate.getForObject(URI, Client.class, "1");

        Assert.assertNull(passenger);


    }
}
