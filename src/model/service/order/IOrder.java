package model.service.order;

import model.entity.Cart;
import model.entity.Order;
import model.service.IGenericService;

import java.util.Calendar;
import java.util.List;

public interface IOrder extends IGenericService<Order> {
//    void Confirm();
void minusPro(Order order);
List<Cart> checkNotMatchCart(List<Cart> carts);
    List<Cart> checkMatchCart(List<Cart> carts);

}
