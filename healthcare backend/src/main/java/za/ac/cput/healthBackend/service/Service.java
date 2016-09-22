package za.ac.cput.healthBackend.service;

/**
 * Created by Ijaaz on 2016-09-22.
 */
public interface Service<E,ID>
{
    E create(E entity);

    E readById(ID id);

    Iterable<E> readAll();

    E update(E entity);

    void delete(E entity);
}
