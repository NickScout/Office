package com.office.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.CrudRepository;
import org.springframework.web.bind.annotation.*;
import com.office.controller.httpexception.*;

import java.util.ArrayList;

@EnableJpaRepositories(basePackages = "com.office")
@RestController
public abstract class AController <T>{

    @SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
    @Autowired
    protected CrudRepository<T, Long> dao;

    @PostMapping
    public void save(@RequestBody T obj) {
        dao.save(obj);
    }
    @GetMapping(value = "/{id}")
    public T find(@PathVariable("id") long id) throws NotFoundException {

        return (T) dao.findById(id).orElseThrow(() -> new NotFoundException());
    }
    @RequestMapping(value = "/multiple/{ids}")
    public Iterable<T> findAllByIds(@PathVariable("ids") ArrayList<Long> ids) {
        return dao.findAllById(ids);
    }
    @GetMapping()
    public Iterable<T> findAll() {
        return dao.findAll();
    }
    @DeleteMapping(value = "/{id}")
    public void delete(@PathVariable long id) { dao.deleteById(id); }
}

