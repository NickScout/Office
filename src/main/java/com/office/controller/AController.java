package com.office.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.CrudRepository;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@EnableJpaRepositories(basePackages = "com.office")
@RestController
public abstract class AController <T>{

    @SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
    @Autowired
    private CrudRepository<T, Long> dao;

    @PostMapping(value = "/")
    public void save(@RequestBody T obj){
            dao.save(obj);
    }
    @RequestMapping(value = "/")
    public T find(@RequestParam ("id") long id) throws Exception {
        return (T) dao.findById(id).orElseThrow(() ->new Exception("Entity not found!"));
    }
    @RequestMapping(value = "/")
    public Iterable<T> findAllByIds(@RequestParam("ids")ArrayList<Long> ids) {
        return dao.findAllById(ids);
    }
    @RequestMapping(value = "/")
    public Iterable<T> findAll() {
        return dao.findAll();
    }
    @DeleteMapping(value = "/")
    public void delete(@RequestBody T obj) { dao.delete(obj); }
    @DeleteMapping(value = "/")
    public void deleteById(@RequestParam("id") long id) { dao.deleteById(id); }
}
