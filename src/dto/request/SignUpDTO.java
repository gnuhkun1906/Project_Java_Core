package dto.request;

import model.entity.Cart;



import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SignUpDTO {
private int id;
private String fullName;
private String userName;
private String email;
private String password;
private String rePassword;
private List<Cart> listCart =new ArrayList<>();
private boolean status;

private Set<String> strRole=new HashSet<>();
    public SignUpDTO() {
    }

    public SignUpDTO(int id, String fullName, String userName, String email, String password,String rePassword,boolean status, Set<String> strRole,List<Cart>listCart
    ) {
        this.id = id;
        this.fullName = fullName;
        this.userName = userName;
        this.email = email;
        this.password = password;
        this.strRole = strRole;
        this.rePassword=rePassword;
        this.status=true;
        this.listCart =listCart;
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

    public Set<String> getStrRole() {
        return strRole;
    }

    public void setStrRole(Set<String> strRole) {
        this.strRole = strRole;
    }

    public boolean isStatus() {
        return status;
    }

    public String getRePassword() {
        return rePassword;
    }
    public void setRePassword(String rePassword) {
        this.rePassword = rePassword;
    }
    public void setStatus(boolean status) {
        this.status = status;
    }

    public List<Cart> getListCart() {
        return listCart;
    }
    public void setListCart(List<Cart> listCart) {
        this.listCart = listCart;
    }
}
