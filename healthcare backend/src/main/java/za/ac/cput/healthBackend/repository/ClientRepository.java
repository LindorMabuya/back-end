package za.ac.cput.healthBackend.repository;

import org.springframework.data.repository.CrudRepository;
import za.ac.cput.healthBackend.domain.Client;

/**
 * Created by Ijaaz on 2016-09-22.
 */
public interface ClientRepository extends CrudRepository<Client, Long> {
}
