package model.entity;

import model.role.Role;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class User implements Serializable {
    private static final long serialVersionUID = -1981211154107557123L;
    private int id;
    private String fullName;
    private String userName;
    private String email;
    private String password;
    private boolean status;
    private String telephone;
    private String address;
    private String cardNumber;
    private Set<Role> roles = new HashSet<>();
    private List<Cart> listCart = new ArrayList<>();


    public User() {
    }

    public User(int id, String fullName, String userName, String email, String password, boolean status, Set<Role> roles, List<Cart> listCart) {
        this.id = id;
        this.fullName = fullName;
        this.userName = userName;
        this.email = email;
        this.password = password;
        this.status = status;
        this.roles = roles;
        this.listCart = listCart;

    }

    public User(int id, String userName, String fullName, String email, String password, Set<Role> roleSet, List<Cart> listCartItem) {
        this.id = id;
        this.userName = userName;
        this.email = email;
        this.fullName = fullName;
        this.roles = roleSet;
        this.password = password;
        this.listCart = listCartItem;

    }

    public User(int id, String fullName, String userName, String email, String password, boolean status, String telephone, String address, String cardNumber, Set<Role> roles, List<Cart> listCart) {
        this.id = id;
        this.fullName = fullName;
        this.userName = userName;
        this.email = email;
        this.password = password;
        this.status = status;
        this.telephone = telephone;
        this.address = address;
        this.cardNumber = cardNumber;
        this.roles = roles;
        this.listCart = listCart;

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    public List<Cart> getListCart() {
        return listCart;
    }

    public void setListCart(List<Cart> listCart) {
        this.listCart = listCart;
    }



    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    @Override
    public String toString() {
        return
                "UserId : "+ id +"\n"
                +"UserName : "+ userName+"\n"
                +"Email : "+ email+"\n"
                +"Password : " +password+"\n"
                +"Role : "+roles;

    }
}

