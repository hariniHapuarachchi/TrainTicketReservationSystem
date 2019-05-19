package rest.repository;

import rest.entity.SuperEntity;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

public interface CrudRepository <T extends SuperEntity, ID extends Serializable> extends SuperRepository{

    void save(T entity);
    Optional<List<T>> findAll();
    Optional<T> find(ID key);
    void update(T entity);

}
