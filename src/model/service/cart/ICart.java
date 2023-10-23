package model.service.cart;

import model.entity.Cart;
import model.service.IGenericService;

public interface ICart extends IGenericService<Cart> {
    boolean editQuantity(int idPro,int quantity);



}
