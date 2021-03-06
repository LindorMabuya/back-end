package za.ac.cput.services;

import java.util.Set;

/**
 * Created by Lilo on 7/31/2016.
 */
public interface Services<E,ID> {
    E create(E entity);

    E readById(ID id);

    Set<E> readAll();

    E update(E entity);

    void delete(E entity);

}
