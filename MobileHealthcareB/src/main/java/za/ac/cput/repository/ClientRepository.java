package za.ac.cput.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.domain.Client;

/**
 * Created by Lilo on 7/31/2016.
 */
@Repository
public interface ClientRepository extends CrudRepository<Client,Long> {
}
