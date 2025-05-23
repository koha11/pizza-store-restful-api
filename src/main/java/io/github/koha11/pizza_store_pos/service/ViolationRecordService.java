package io.github.koha11.pizza_store_pos.service;

import io.github.koha11.pizza_store_pos.entity.employee.Employee;
import io.github.koha11.pizza_store_pos.entity.mapper.ViolationRecordMapper;
import io.github.koha11.pizza_store_pos.entity.variant.Variant;
import io.github.koha11.pizza_store_pos.entity.violation.Violation;
import io.github.koha11.pizza_store_pos.entity.violation.ViolationRecord;
import io.github.koha11.pizza_store_pos.entity.violation.ViolationRecordDTO;
import io.github.koha11.pizza_store_pos.entity.violation.ViolationRecordRequest;
import io.github.koha11.pizza_store_pos.repository.ViolationRecordRepository;
import io.github.koha11.pizza_store_pos.repository.ViolationRepository;
import io.github.koha11.pizza_store_pos.util.Helper;
import org.mapstruct.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cglib.core.Local;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.*;
import java.util.ArrayList;
import java.util.List;

@Service
public class ViolationRecordService extends GenericService<ViolationRecord>{
    @Autowired
    private ViolationRecordRepository violationRecordRepo;


    @Qualifier("violationRecordMapperImpl")
    @Autowired
    public ViolationRecordMapper mapper;

    @Autowired
    private ViolationRepository violationRepository;

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

    public List<ViolationRecord> getVRByEmpIdAndWorkingDate(String empId, LocalDate workingDate) {
        return violationRecordRepo.findAllByEmpIdAndWorkingDate(empId, workingDate);
    }




    public List<ViolationRecordDTO> getAllVRByMonthYear(Month month, int year){
        LocalDate startDate = LocalDate.of(year,month, 1);
        LocalDate endDate = LocalDate.of(year,month, YearMonth.of(year, month).lengthOfMonth());
        List<ViolationRecordDTO> listVRDTO = violationRecordRepo.findAllByMonthAndYear(startDate, endDate)
                .stream().map(violationRecord -> mapper.violationRecordToDTO(violationRecord)).toList();
        return listVRDTO;

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

    public void create(List<ViolationRecordRequest> violationRecordRequest) {
        var listOfT = this.getAll();
        int count = listOfT.size();
        List<ViolationRecord> records = new ArrayList<ViolationRecord>();
        for (int i = 0; i < violationRecordRequest.size(); i++) {
            ViolationRecordRequest request  = violationRecordRequest.get(i);
            Violation violation = violationRepository.findById(request.getViolationId()).orElse(null);
            if(violation == null) {
                return;
            }
            var id = Helper.generateId(ViolationRecord.class, count + i);
            ViolationRecord violationRecord = new ViolationRecord();
            violationRecord.setViolationRecordId(id);
            violationRecord.setViolation(violation);
            violationRecord.setCreatedAt(Timestamp.valueOf(LocalDateTime.now()));
            violationRecord.setEmpId(request.getEmpId());
            violationRecord.setWorkingDate(request.getWorkingDate());
            violationRecord.setViolationTime(request.getViolationTime());
            records.add(violationRecord);
        }
        repo.saveAll(records);


    }



    public void delete(String violationRecordId) {
        violationRecordRepo.deleteById(violationRecordId);
    }

    // HELPER METHODS
    public int calcFine(String empId, LocalDate startDate, LocalDate endDate) {
        return 0;
    }

}
