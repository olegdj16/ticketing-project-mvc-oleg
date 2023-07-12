package net.endeffect.service;
//this is for Generics

import java.util.List;

public interface CrudService<T, ID> {

    T save(T entity);
    T findById(ID id);
    List<T> findAll();
    void delete(T entity);
    void deleteById(ID id);
}
