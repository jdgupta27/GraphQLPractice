package com.jd.graphql.Service;

import com.jd.graphql.Helper.ExceptionHelper;
import com.jd.graphql.Model.Order;
import com.jd.graphql.Repository.OrderRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {
    private OrderRepo orderRepo;

    public OrderService(OrderRepo orderRepo) {
        this.orderRepo = orderRepo;
    }

    public Order createOrder(Order order){
        return orderRepo.save(order);
    }

    public List<Order> getAllOrders(){
        return orderRepo.findAll();
    }

    public Order getOrder(int orderId){
        return orderRepo.findById(orderId).orElseThrow(ExceptionHelper::throwResourceNotFoundException);
    }

    public boolean deleteOrder(int orderId){
        Order order = orderRepo.findById(orderId).orElseThrow(ExceptionHelper::throwResourceNotFoundException);
        orderRepo.delete(order);
        return true;
    }
}
