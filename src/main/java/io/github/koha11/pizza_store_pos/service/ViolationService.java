package io.github.koha11.pizza_store_pos.service;

import io.github.koha11.pizza_store_pos.entity.violation.Violation;
import io.github.koha11.pizza_store_pos.repository.ViolationRepository;
import io.github.koha11.pizza_store_pos.util.Helper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ViolationService extends GenericService<Violation>{
    @Autowired
    private ViolationRepository violationRepo;

    public ViolationService(JpaRepository<Violation, String> repo) {
        super(repo);
    }

    @Override
    public void create(Violation t) {
        var listOfT = this.getAll();
        var id = Helper.generateId(Violation.class, listOfT.size());
        t.setViolationId(id);
        repo.save(t);
    }
}
