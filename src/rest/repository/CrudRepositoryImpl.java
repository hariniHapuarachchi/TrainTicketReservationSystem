package rest.repository;

import rest.entity.SuperEntity;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;
import java.util.Optional;

public class CrudRepositoryImpl <T extends SuperEntity, ID extends Serializable> implements CrudRepository<T, ID>{

    @PersistenceContext
    private EntityManager em;
    private Class<T> entity;

    public CrudRepositoryImpl() {
        entity = (Class<T>) (((ParameterizedType) this.getClass().getGenericSuperclass()).getActualTypeArguments()[0]);
    }

    @Override
    public void save(T entity) {
        em.persist(entity);
    }

    @Override
    public Optional<List<T>> findAll() {
        return Optional.ofNullable(em.createQuery("SELECT alias FROM " + entity.getName() + " alias").getResultList());
    }

    @Override
    public Optional<T> find(ID key) {
        return Optional.ofNullable(em.find(entity, key));
    }

    @Override
    public void update(T entity) {
        em.merge(entity);
    }

}
