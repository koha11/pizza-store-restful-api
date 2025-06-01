package io.github.koha11.pizza_store_pos.controller;

import io.github.koha11.pizza_store_pos.service.GenericService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public class GenericController<T> {
    protected final GenericService<T> genericService;

    public GenericController(GenericService<T> genericService) {
        this.genericService = genericService;
    }

    @GetMapping
    public List<T> getAll() {
        return genericService.getAll();
    }

    @GetMapping("/{id}")
    public T getOne(@PathVariable String id) {
        return genericService.getOne(id);
    }

    @PutMapping("/edit/{id}")
    public T update(@PathVariable String id ,@RequestBody T t) {
       return genericService.update(id, t);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable String id) {
        genericService.delete(id);
    }
}
