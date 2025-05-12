package io.github.koha11.pizza_store_pos.service;

import io.github.koha11.pizza_store_pos.entity.mapper.OrderDetailMapper;
import io.github.koha11.pizza_store_pos.entity.order.OnTableOrderDetail;
import io.github.koha11.pizza_store_pos.entity.order.OrderDetail;
import io.github.koha11.pizza_store_pos.repository.OrderDetailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class OrderDetailService extends GenericService<OrderDetail> {

    @Autowired
    private OrderDetailRepository orderDetailRepo;

    @Autowired
    public OrderDetailMapper orderDetailMapper;

    @Autowired
    private FoodService foodService;

    @Autowired
    private VariantService variantService;

    public OrderDetailService(JpaRepository<OrderDetail, String> repo) {
        super(repo);
    }


    // GET METHODS

    public List<OnTableOrderDetail> getAllByOrderId(String orderId) {
        var ods = orderDetailRepo.findByOrderId(orderId);
        List<OnTableOrderDetail> odsDTO = new ArrayList<>();

        ods.forEach(od -> {
            odsDTO.add(orderDetailMapper.orderDetailToDTO(od));
        });

        return odsDTO;
    }

    // POST METHODS
    @Override
    public void create(OrderDetail od) {
        int actualPrice = calcActualPrice(od.getFoodId(), od.getAmount(), od.getVariantId());

        od.setActualPrice(actualPrice);
        od.setCreatedAt(Timestamp.valueOf(LocalDateTime.now()));

        orderDetailRepo.save(od);
    }

    public void create(String orderId, OnTableOrderDetail odDTO) {
        int actualPrice = calcActualPrice(odDTO.getFoodId(), odDTO.getAmount(), odDTO.getVariantId());

        OrderDetail od = orderDetailMapper.DTOToOrderDetail(odDTO);

        od.setActualPrice(actualPrice);
        od.setOrderId(orderId);
        od.setCreatedAt(Timestamp.valueOf(LocalDateTime.now()));

        orderDetailRepo.save(od);
    }


    // PUT/PATCH METHODS

    public void increaseAmount(String orderId, String foodId) {
        var odOpt = orderDetailRepo.findByIds(orderId, foodId);

        odOpt.ifPresentOrElse(od -> {
            od.setAmount(od.getAmount()+1);
            }, () -> {
            throw new IllegalStateException(notFoundIdMsg);
            }
        );
    }

    public void decreaseAmount(String orderId, String foodId) {
        var odOpt = orderDetailRepo.findByIds(orderId, foodId);

        odOpt.ifPresentOrElse(od -> {
            if(od.getAmount() > 1)
                od.setAmount(od.getAmount()-1);
            }, () -> {
                throw new IllegalStateException(notFoundIdMsg);
            }
        );
    }

    public void editOrderDetail(String orderId, OnTableOrderDetail odDTO) {
        var odOpt = orderDetailRepo.findByIds(orderId, odDTO.getFoodId());

        odOpt.ifPresentOrElse(od -> {
                    od.setNote(odDTO.getNote());
                    od.setVariantId(odDTO.getVariantId());
                    orderDetailRepo.save(od);
                }, () -> {
                    throw new IllegalStateException(notFoundIdMsg);
                }
        );
    }

    // DELETE METHODS
    public void delete(String orderId, String foodId) {
        var odOpt = orderDetailRepo.findByIds(orderId, foodId);

        odOpt.ifPresentOrElse(od -> {
                   orderDetailRepo.delete(od);
                }, () -> {
                    throw new IllegalStateException(notFoundIdMsg);
                }
        );
    }

    // HELPER METHODS
    public int calcActualPrice(String foodId, int amount, String variantId) {
        int foodPrice = foodService.getOne(foodId).getPrice();

        if(variantId == null || variantId.isEmpty())
            return foodPrice * amount;
        else
            return foodPrice * amount + variantService.getOne(variantId).getExtraPrice();
    }
}
