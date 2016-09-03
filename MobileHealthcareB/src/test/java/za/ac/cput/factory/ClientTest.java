package za.ac.cput.factory;

import org.testng.Assert;
import org.testng.annotations.Test;
import za.ac.cput.domain.Client;
import za.ac.cput.domain.ClientAddress;

/**
 * Created by Lilo on 8/7/2016.
 */
public class ClientTest {
   private Client passenger;
    private ClientAddress passengerAddress;

    @Test
    public void testCreate() throws Exception {
        passengerAddress = AddressFactory.createClientAddress("streetTest","CityTest","1000");
        passenger = ClientFactory.createClient("admin","testlastname",passengerAddress);

        Assert.assertEquals(passenger.getObjAdress().getStreet(),"streetTest");
        Assert.assertEquals(passenger.getName(),"admin");

    }

    @Test
    public void testUpdate() throws Exception {
        passengerAddress = AddressFactory.createClientAddress("streetTest","CityTest","1000");
        passenger = ClientFactory.createClient("admin","testlastname",passengerAddress);

        Client copyPassenger = new Client.ClientBuilder()
                .copy(passenger)
                .name("testName")
                .build();
        Assert.assertEquals(copyPassenger.getName(),"testName");
        Assert.assertEquals(copyPassenger.getObjAdress().getCode(),"1000");
    }
}
