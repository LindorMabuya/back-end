package za.ac.cput.healthBackend.factory;

import za.ac.cput.healthBackend.domain.Client;
import za.ac.cput.healthBackend.domain.ClientAddress;

/**
 * Created by Ijaaz on 2016-09-22.
 */
public class ClientFactory
{
    public static Client createClient(String name, String lastName, ClientAddress address){
        return new Client.ClientBuilder()
                .name(name)
                .lastName(lastName)
                .address(address)
                .build();
    }
}
