package io.github.koha11.pizza_store_pos.service;

import io.github.koha11.pizza_store_pos.entity.store_table.TableStatus;
import io.github.koha11.pizza_store_pos.entity.table_reservation.ReservationStatus;
import io.github.koha11.pizza_store_pos.entity.table_reservation.TableReservation;
import io.github.koha11.pizza_store_pos.repository.TableReservationRepository;
import io.github.koha11.pizza_store_pos.util.Helper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class TableReservationService extends GenericService<TableReservation>{
    @Autowired
    private TableReservationRepository tableReservationRepo;

    @Autowired
    @Lazy
    private TableService tableService;

    public TableReservationService(JpaRepository<TableReservation, String> repo) {
        super(repo);
    }

    // GET METHODS
    public List<TableReservation> getTableReservationsByDateAndTable(LocalDateTime bookedTime, String tableId) {
        List<TableReservation> tableReservations = getAll();

        return tableReservations.stream().filter(tableReservation -> {
            if(tableId.isEmpty())
                return tableReservation.getBookedTime().getDayOfMonth() == bookedTime.getDayOfMonth();
            else
                return tableReservation.getBookedTime().getDayOfMonth() == bookedTime.getDayOfMonth() && tableReservation.getTableId().equals(tableId);

        }).toList();
    }

    public TableReservation getTableReservationByOrderId(String orderId) {
        Optional<TableReservation> bsOpt = tableReservationRepo.findByOrderId(orderId);

        if(bsOpt.isPresent()) {
            return bsOpt.get();
        }
        else throw new IllegalStateException("Order Id not found");
    }

    public TableReservation getReservationByTableId(String tableId) {
        Optional<TableReservation> trOpt = tableReservationRepo.findByTableId(tableId);

        if(trOpt.isPresent()) {
            return trOpt.get();
        }
        else throw new IllegalStateException("Table Id not found");
    }

    // POST METHODS
    @Override
    public void create(TableReservation t) {
        var listOfT = this.getAll();
        var id = Helper.generateId(TableReservation.class, listOfT.size());
        t.setTableReservationId(id);
        t.setCreatedAt(Timestamp.valueOf(LocalDateTime.now()));
        repo.save(t);
    }

    // PUT/PATCH METHODS
    @Override
    public TableReservation update(String id, TableReservation t) {
        super.update(id, t);
        if(t.getStatus() == ReservationStatus.CANCELED && !t.getTableId().isEmpty())
        {
            if(tableService.getOne(t.getTableId()).getTableStatus() == TableStatus.RESERVED)
                tableService.changeStatus(t.getTableId(), TableStatus.AVAILABLE);
        }

        return t;
    }

    // HELPER
    public boolean check() {
        return true;
    }
}
