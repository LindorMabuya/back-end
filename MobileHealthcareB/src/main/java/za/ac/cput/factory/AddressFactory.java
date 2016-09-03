package za.ac.cput.factory;


import za.ac.cput.domain.ClientAddress;

/**
 * Created by Lilo on 7/31/2016.
 */
public class AddressFactory {
    public static ClientAddress createClientAddress(String street, String city, String code) {
    return new ClientAddress.AddressBuilder()
            .street(street)
            .city(city)
            .code(code)
            .build();
       }
}
