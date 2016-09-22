package za.ac.cput.healthBackend.domain;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by Ijaaz on 2016-09-22.
 */
@Entity
public class Client implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String lastName;
    @Embedded
    private ClientAddress objAdress;
    private Client(ClientBuilder objBuilder)
    {
        this.id=objBuilder.id;
        this.name=objBuilder.name;
        this.lastName=objBuilder.lastName;
        this.objAdress=objBuilder.objAdress;
    }
    private Client(){}
    public Long getId(){
        return id;
    }
    public String getName() {
        return name;
    }

    public String getLastName() {
        return lastName;
    }

    public ClientAddress getObjAdress() {
        return objAdress;
    }

    public static class ClientBuilder
    {
        private Long id;
        private String name;
        private String lastName;
        private ClientAddress objAdress;

        public ClientBuilder id(Long id)
        {
            this.id=id;
            return this;
        }

        public ClientBuilder name(String name)
        {
            this.name=name;
            return this;
        }
        public ClientBuilder lastName(String lastName)
        {
            this.lastName=lastName;
            return this;
        }
        public ClientBuilder address(ClientAddress objAdress)
        {
            this.objAdress=objAdress;
            return this;
        }
        public ClientBuilder copy(Client objClient)
        {
            this.id= objClient.id;
            this.name= objClient.name;
            this.lastName= objClient.lastName;
            this.objAdress= objClient.objAdress;
            return  this;
        }
        public Client build()
        {
            return new Client(this);
        }


    }

    @Override
    public int hashCode() {
        return (int) (id ^ (id >>> 32));
    }

}
