package com.jd.graphql.controller;

import com.jd.graphql.Model.Order;
import com.jd.graphql.Model.User;
import com.jd.graphql.Service.OrderService;
import com.jd.graphql.Service.UserService;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Controller
public class OrderController {
    private OrderService orderService;
    private UserService userService;

    public OrderController(OrderService orderService,UserService userService){
        this.orderService = orderService;
        this.userService = userService;
    }

    @QueryMapping
    public List<Order> getOrders(){
       return  orderService.getAllOrders();
    }

    @MutationMapping
    public Order createOrder(@Argument String orderDetail, @Argument String address, @Argument String price, @Argument int userId ){
        User user = userService.getUser(userId);
        Order order = new Order();
        order.setOrderDetail(orderDetail);
        order.setAddress(address);
        order.setPrice(price);
        order.setUser(user);
        return orderService.createOrder(order);
    }

    @QueryMapping
    public Order getOrder(@Argument int orderId){
        return orderService.getOrder(orderId);
    }

    @MutationMapping
    public boolean deleteOrder(@Argument int orderId){
        return orderService.deleteOrder(orderId);
    }
}
