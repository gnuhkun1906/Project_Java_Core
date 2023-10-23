package controller.order;

import model.entity.Cart;
import model.entity.Order;
import model.service.order.OrderService;
import model.service.order.IOrder;

import java.util.List;

public class OrderController {
    IOrder orderService = new OrderService();

    public List<Order> getListOrder() {
        return orderService.findAll();
    }
    public void addToOrder(Order order){
        orderService.save(order);
    }
    public Order findById(int id){
     return  orderService.findById(id);
    }

    public void delete(int id){
        orderService.deleteById(id);
    }
    public void minusPro(Order order){
        orderService.minusPro(order);
    }
    public List<Cart> checkNotMatchCart(List<Cart> carts){
        return orderService.checkNotMatchCart(carts);
    }
    public List<Cart> checkMatchCart(List<Cart> carts){
        return orderService.checkMatchCart(carts);
    }

}
