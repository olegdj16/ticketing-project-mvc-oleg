package net.endeffect.service;

import java.util.List;

public interface CrudService<T, ID> {

    T save(T roleDto);
    List<T> findAll();
    T findById(ID id);
    void delete(T role);
    void deleteById (ID id);

}
