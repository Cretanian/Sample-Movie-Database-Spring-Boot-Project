package com.gmdb.team5.pf7project.service;

import java.util.List;

public interface BaseService<T> {
    T create(T clazz);

    List<T> createAll(List<T> clazzes);

    List<T> createAll(T... clazzes);

    void update(T clazz);

    void delete(T clazz);

    void deleteById(Long id);

    boolean exists(T clazz);

    T find(Long id);

    List<T> findAll();
}
