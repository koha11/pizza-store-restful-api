package io.github.koha11.pizza_store_pos.entity.mapper;

import io.github.koha11.pizza_store_pos.entity.violation.Violation;
import io.github.koha11.pizza_store_pos.entity.violation.ViolationRecord;
import io.github.koha11.pizza_store_pos.entity.violation.ViolationRecordRequest;
import io.github.koha11.pizza_store_pos.service.ViolationService;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.springframework.beans.factory.annotation.Autowired;

@Mapper(componentModel = "spring")
public abstract class ViolationRecordMapper {
    @Autowired
    protected ViolationService violationService;

    @Mapping(source = "violationId", target = "violation", qualifiedByName = "getViolation")
    public abstract ViolationRecord DTOtoViolationRecord(ViolationRecordRequest dto);

    @Named("getViolation")
    protected Violation getViolation(String violationId) {
        return violationService.getOne(violationId);
    }
}
