package com.example.kataapiesther_nm.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public class BaseService<T, Id, R extends JpaRepository<T, Id>> {
    @Autowired
    protected R repositorio;

    public T save(T t) {
        return repositorio.save(t);
    }

    public Optional<T> findById(Id id) {
        return repositorio.findById(id);
    }

    public List<T> findAll() {
        return repositorio.findAll();
    }

    public T edit(T t) {
        return repositorio.save(t);
    }

    public void delete(T t) {
        repositorio.delete(t);
    }

    public void deleteById(Id id) {
        repositorio.deleteById(id);
    }
}
