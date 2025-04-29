package io.github.koha11.pizza_store_pos.service;

import io.github.koha11.pizza_store_pos.entity.food.FoodType;
import io.github.koha11.pizza_store_pos.util.Helper;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

@Transactional
public class GenericService<T> {
    protected JpaRepository<T, String> repo;
    protected final String notFoundIdMsg = "Can not found this id";

    public GenericService(JpaRepository<T, String> repo) {
        this.repo = repo;
    }

    public List<T> getAll() {
        return repo.findAll();
    }

    public T getOne(String id) {
        var t = repo.findById(id);

        if(t.isPresent())
        {
            return t.get();
        }
        else
        {
            throw new IllegalStateException(notFoundIdMsg);
        }
    }

    public void create(T t) {
        repo.save(t);
    }

    public void update(String id, T t) {
        Optional<T> tOpt = repo.findById(id);

        tOpt.ifPresentOrElse(t1 ->  repo.save(t),() -> {
            throw new IllegalStateException(notFoundIdMsg);
        });
    }

    public void delete(String id) {
        Optional<T> tOpt = repo.findById(id);

        tOpt.ifPresentOrElse(t -> {
            repo.delete(t);
        }, () -> {
            throw new IllegalStateException(notFoundIdMsg);
        });
    }
}
