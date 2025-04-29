package io.github.koha11.pizza_store_pos.service;

import io.github.koha11.pizza_store_pos.entity.variant.Variant;
import io.github.koha11.pizza_store_pos.entity.violation.ViolationRecord;
import io.github.koha11.pizza_store_pos.repository.ViolationRecordRepository;
import io.github.koha11.pizza_store_pos.util.Helper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ViolationRecordService extends GenericService<ViolationRecord>{
    @Autowired
    private ViolationRecordRepository violationRecordRepo;

    public ViolationRecordService(JpaRepository<ViolationRecord, String> repo) {
        super(repo);
    }

    @Override
    public void create(ViolationRecord t) {
        var listOfT = this.getAll();
        var id = Helper.generateId(ViolationRecord.class, listOfT.size());
        t.setViolationId(id);
        repo.save(t);
    }
}
