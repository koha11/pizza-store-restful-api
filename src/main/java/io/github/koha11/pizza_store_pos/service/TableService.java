package io.github.koha11.pizza_store_pos.service;

import io.github.koha11.pizza_store_pos.entity.table_reservation.TableReservation;
import io.github.koha11.pizza_store_pos.entity.store_table.StoreTable;
import io.github.koha11.pizza_store_pos.entity.store_table.TableStatus;
import io.github.koha11.pizza_store_pos.repository.TableRepository;
import io.github.koha11.pizza_store_pos.util.Helper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class TableService extends GenericService<StoreTable>{
    @Autowired
    private TableRepository tableRepo;

    @Autowired
    private TableReservationService tableReservationService;

    public TableService(JpaRepository<StoreTable, String> repo) {
        super(repo);
    }

    // GET METHODS

    public List<String> getCurrentTableIds() {
        List<StoreTable> storeTables = getAll();

        List<String> seatIds = new ArrayList<>();

        storeTables.forEach(storeTable -> {
            if (storeTable.getTableStatus() == TableStatus.UNAVAILABLE)
                 seatIds.add(storeTable.getTableId());
        });

        return seatIds;
    }

    public List<StoreTable> getAll(List<TableStatus> statusList) {
        List<StoreTable> storeTables = getAll();

        // Kiem tra cac ban duoc dat va doi trang thai cho no
        ChangeTableStatusForReservation();

        return storeTables.stream().filter(storeTable -> statusList.contains(storeTable.getTableStatus())).toList();
    }

    public List<StoreTable> getReservableTable(LocalDateTime reservedDate, int dinerCount) {
        // Lay tat ca ban nhung loai bo di nhung ban` dang bao tri
        List<StoreTable> storeTables = getAll(List.of(TableStatus.AVAILABLE, TableStatus.RESERVED, TableStatus.OCCUPIED));

        List<TableReservation> tableReservations = tableReservationService.getTableReservationsByDateAndTable(reservedDate, "");

        // Lay ra nhung phieu dat ban co thoi gian chenh lech it hon 3 tieng so voi thoi gian dinh tao phieu va co seatId khac ""
        List<String> sameSeatList = tableReservations.stream().filter(tableReservation -> Duration.between(tableReservation.getBookedTime(), reservedDate).getSeconds() <= 3600*3 && !tableReservation.getTableId().isEmpty()).map(TableReservation::getTableId).toList();

        // Loc de lay ra so ban khong bi trung lich dat, co so luong cho ngoi thoa man voi so luong khach du kien
        return storeTables.stream().filter(storeTable -> !sameSeatList.contains(storeTable.getTableId()) && storeTable.getSeats() >= dinerCount).toList();
    }

    // POST METHODS

    @Override
    public void create(StoreTable storeTable) {
        var list = getAll();
        var id = Helper.generateId(StoreTable.class, list.size());
        storeTable.setTableId(id);
        storeTable.setCreatedAt(Timestamp.valueOf(LocalDateTime.now()));
        repo.save(storeTable);
    }

    // PUT/PATCH METHODS

    @Override
    public StoreTable update(String id,StoreTable storeTable) {
        if(id == null) return null;
        storeTable.setCreatedAt(Timestamp.valueOf(LocalDateTime.now()));
        return repo.save(storeTable);
    }


    public void toggleStatus(String tableId) {
        StoreTable storeTable = getOne(tableId);

        if(storeTable.getTableStatus() == TableStatus.AVAILABLE)
            storeTable.setTableStatus(TableStatus.OCCUPIED);
        else if(storeTable.getTableStatus() == TableStatus.OCCUPIED)
            storeTable.setTableStatus(TableStatus.AVAILABLE);

        repo.save(storeTable);
    }

    public void toggleUnavailable(String tableId) {
        StoreTable storeTable = getOne(tableId);

        if(storeTable.getTableStatus() == TableStatus.UNAVAILABLE)
            storeTable.setTableStatus(TableStatus.AVAILABLE);
        else
            storeTable.setTableStatus(TableStatus.UNAVAILABLE);

        repo.save(storeTable);
    }

    public void changeStatus(String tableId, TableStatus status) {
        StoreTable storeTable = getOne(tableId);

        storeTable.setTableStatus(status);

        repo.save(storeTable);
    }

    // HELPER METHODS

    public boolean isAvailable(String seatId) {
        var seat = getOne(seatId);

        return seat.getTableStatus() == TableStatus.AVAILABLE;
    }

    public void ChangeTableStatusForReservation() {
        var reservations = tableReservationService.getAll();

        List<String> tableIds = reservations.stream().filter(tableReservation -> Duration.between(tableReservation.getBookedTime(), LocalDateTime.now()).getSeconds() <= 3600*3 && !tableReservation.getTableId().isEmpty()).map(TableReservation::getTableId).toList();

        tableIds.forEach(id -> changeStatus(id, TableStatus.RESERVED));
    }
}


