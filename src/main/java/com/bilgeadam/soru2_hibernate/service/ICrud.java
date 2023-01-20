package com.bilgeadam.soru2_hibernate.service;

public interface ICrud <T> {

    void getAll();
    void save(T t);
    void update(T t);
    void delete(int id);

}
