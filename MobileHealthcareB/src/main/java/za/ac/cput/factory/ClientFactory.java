package za.ac.cput.factory;


import za.ac.cput.domain.Client;
import za.ac.cput.domain.ClientAddress;

/**
 * Created by Lilo on 7/31/2016.
 */
public class ClientFactory {
    public static Client createClient(String name, String lastName, ClientAddress address){
        return new Client.ClientBuilder()
                .name(name)
                .lastName(lastName)
                .address(address)
                .build();
    }
}
