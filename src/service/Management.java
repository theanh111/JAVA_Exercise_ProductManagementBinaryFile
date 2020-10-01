package service;

import java.util.List;

public interface Management<T> {
    void add(T object);

    void update(Long id, T newObject);

    void delete(Long id);

    T findByID(Long id);

    List<T> findByCompanyName(String companyName);

    List<T> findAll();
}