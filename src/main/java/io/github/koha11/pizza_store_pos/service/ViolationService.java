package io.github.koha11.pizza_store_pos.service;

import io.github.koha11.pizza_store_pos.entity.violation.Violation;
import io.github.koha11.pizza_store_pos.repository.ViolationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ViolationService {
    @Autowired
    private ViolationRepository violationRepo;

    public List<Violation> getAll() {
        return violationRepo.findAll();
    }
}
