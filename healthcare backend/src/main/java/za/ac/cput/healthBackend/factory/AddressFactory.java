package za.ac.cput.healthBackend.factory;

import za.ac.cput.healthBackend.domain.ClientAddress;

/**
 * Created by Ijaaz on 2016-09-22.
 */
public class AddressFactory
{
    public static ClientAddress createClientAddress(String street, String city, String code) {
        return new ClientAddress.AddressBuilder()
                .street(street)
                .city(city)
                .code(code)
                .build();
    }
}
