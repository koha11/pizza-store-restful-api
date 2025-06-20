package io.github.koha11.pizza_store_pos.service;

import io.github.koha11.pizza_store_pos.entity.employee.EmpType;
import io.github.koha11.pizza_store_pos.entity.food.FoodType;
import io.github.koha11.pizza_store_pos.repository.EmpTypeRepository;
import io.github.koha11.pizza_store_pos.repository.FoodTypeRepository;
import io.github.koha11.pizza_store_pos.util.Helper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class EmpTypeService extends GenericService<EmpType>{
    @Autowired
    private EmpTypeRepository empTypeRepo;

    public EmpTypeService(JpaRepository<EmpType, String> repo) {
        super(repo);
    }

    @Override
    public void create(EmpType t) {
        t.setEmpTypeId(t.getEmpTypeId());
        t.setCreatedAt(Timestamp.valueOf(LocalDateTime.now()));
        repo.save(t);
    }

    @Override
    public EmpType update(String id, EmpType t) {
        t.setCreatedAt(Timestamp.valueOf(LocalDateTime.now()));
        return super.update(id, t);
    }

}
