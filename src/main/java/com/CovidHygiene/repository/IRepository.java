package com.CovidHygiene.repository;

public interface IRepository<T, ID> {
    T create(T t);
    T read(String id);
    T update(T t);
    boolean delete(ID id);
}
