package io.github.koha11.pizza_store_pos.controller;

import io.github.koha11.pizza_store_pos.entity.store_table.StoreTable;
import io.github.koha11.pizza_store_pos.entity.store_table.TableStatus;
import io.github.koha11.pizza_store_pos.service.GenericService;
import io.github.koha11.pizza_store_pos.service.TableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/tables")
public class TableController extends GenericController<StoreTable>{
    @Autowired
    private TableService tableService;

    public TableController(GenericService<StoreTable> genericService) {
        super(genericService);
    }

    @GetMapping("/filter")
    public List<StoreTable> getAll(@RequestParam(name = "stt", required = false
    ) List<TableStatus> statusList) {
        return tableService.getAll(statusList);
    }

    @GetMapping("/reservable-tables")
    public List<StoreTable> getReservableTable(@RequestParam(name = "rd"
    ) LocalDateTime reservedDate, @RequestParam(name="dc") int dinerCount) {
        return tableService.getReservableTable(reservedDate, dinerCount);
    }
}
