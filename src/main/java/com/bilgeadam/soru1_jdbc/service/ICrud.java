package com.bilgeadam.soru1_jdbc.service;

public interface ICrud <T> {

        void getAll();
        void save(T t);
        void update(T t);
        void delete(int id);

}
