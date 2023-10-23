package model.entity;

import java.io.Serializable;
import java.util.List;

public class Order implements Serializable {
    private static final long serialVersionUID = -6747591090240549936L;
    private int id;
    private User user;
    private List<Cart> listCart;
    private String receiveName;
    private String receiveAddress;
    private String telephone;
    private String receiveTime;
    private byte status;

    public Order() {
    }

    public Order(int id, User user, List<Cart> listCart, String receiveName, String receiveAddress, String telephone, String receiveTime) {
        this.id = id;
        this.user = user;
        this.listCart = listCart;
        this.receiveName = receiveName;
        this.receiveAddress = receiveAddress;
        this.telephone = telephone;
        this.receiveTime = receiveTime;
        this.status = 0;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getReceiveName() {
        return receiveName;
    }

    public void setReceiveName(String receiveName) {
        this.receiveName = receiveName;
    }

    public String getReceiveAddress() {
        return receiveAddress;
    }

    public void setReceiveAddress(String receiveAddress) {
        this.receiveAddress = receiveAddress;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getReceiveTime() {
        return receiveTime;
    }

    public void setReceiveTime(String receiveTime) {
        this.receiveTime = receiveTime;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Cart> getListCart() {
        return listCart;
    }

    public void setListCart(List<Cart> listCart) {
        this.listCart = listCart;
    }

    public byte getStatus() {
        return status;
    }

    public void setStatus(byte status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Id : " + id + "\n" +
                "User :" + user.getUserName() + "\n" +
                listCart + "\n" +
                "ReceiveName : " + receiveName + "\n" +
                "ReceiveAddress :m" + receiveAddress + "\n" +
                "Telephone : " + telephone + "\n" +
                "ReceiveTime : " + receiveTime + "\n" +
                "Status : " + status + "\n";
    }
}
