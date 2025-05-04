package io.github.koha11.pizza_store_pos.service;

import io.github.koha11.pizza_store_pos.entity.mapper.ViolationRecordMapper;
import io.github.koha11.pizza_store_pos.entity.variant.Variant;
import io.github.koha11.pizza_store_pos.entity.violation.ViolationRecord;
import io.github.koha11.pizza_store_pos.entity.violation.ViolationRecordRequest;
import io.github.koha11.pizza_store_pos.repository.ViolationRecordRepository;
import io.github.koha11.pizza_store_pos.util.Helper;
import org.mapstruct.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cglib.core.Local;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class ViolationRecordService extends GenericService<ViolationRecord>{
    @Autowired
    private ViolationRecordRepository violationRecordRepo;

    @Qualifier("violationRecordMapperImpl")
    @Autowired
    public ViolationRecordMapper mapper;

    public ViolationRecordService(JpaRepository<ViolationRecord, String> repo) {
        super(repo);
    }

    // GET METHODS
    public List<ViolationRecord> getVRByDate(LocalDate date) {
        return violationRecordRepo.findAllByDate(date);
    }

    public List<ViolationRecord> getEmpVR(String empId, LocalDate startDate, LocalDate endDate) {
        return violationRecordRepo.findAllByEmpId(empId, startDate, endDate);
    }

    // POST METHODS

    @Override
    public void create(ViolationRecord t) {
        var listOfT = this.getAll();
        var id = Helper.generateId(ViolationRecord.class, listOfT.size());
        t.setViolationRecordId(id);
        t.setCreatedAt(Timestamp.valueOf(LocalDateTime.now()));
        repo.save(t);
    }

    public void create(ViolationRecordRequest violationRecordRequest) {
        var listOfT = this.getAll();
        var t = mapper.DTOtoViolationRecord(violationRecordRequest);

        var id = Helper.generateId(ViolationRecord.class, listOfT.size());

        t.setViolationRecordId(id);
        t.setCreatedAt(Timestamp.valueOf(LocalDateTime.now()));

        repo.save(t);
    }

    // HELPER METHODS
    public int calcFine(String empId, LocalDate startDate, LocalDate endDate) {
        return 0;
    }


}
