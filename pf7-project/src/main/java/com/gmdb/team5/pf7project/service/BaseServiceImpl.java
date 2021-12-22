package com.gmdb.team5.pf7project.service;

import com.gmdb.team5.pf7project.domain.BaseModel;

import java.util.List;

public abstract class BaseServiceImpl<T extends BaseModel> implements BaseService<T , Long> {

    @Override
    public T create(T clazz) {
        return null;
    }

    @Override
    public List<T> createAll(T... clazzes) {
        return null;
    }

    @Override
    public List<T> createAll( List <T> clazzes) {
        return null;
    }

    @Override
    public void update(T clazz) {

    }

    @Override
    public void delete(T clazz) {

    }

    @Override
    public void deleteById(Long aLong) {

    }

    @Override
    public boolean exists(T clazz) {
        return false;
    }

    @Override
    public T find(Long aLong) {
        return null;
    }

    @Override
    public List<T> findAll() {
        return null;
    }
}
