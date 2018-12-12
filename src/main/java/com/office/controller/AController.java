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

    @PostMapping(value = "/save")
    public void save(@RequestBody T obj){
            dao.save(obj);
    }
    @RequestMapping(value = "/find")
    public T find(@RequestParam("id") long id) throws Exception {
        return (T) dao.findById(id).orElseThrow(() ->new Exception("Entity not found!"));
    }
//    @RequestMapping(value = "/findAllByIds")
//    public Iterable<T> findAllByIds(@("ids")ArrayList<Long> ids) throws Exception {
//        return dao.findAllById(ids);
//    }
    @DeleteMapping(value = "/delete")
    public void delete(@RequestBody T obj) { dao.delete(obj); }
    @DeleteMapping(value = "/deleteById")
    public void deleteById(@RequestParam("id") long id) { dao.deleteById(id); }
}
