/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author 206_Arshia Chaudhuri
 */
import java.io.*;
import java.util.StringTokenizer; 
import java.util.*;
import java.util.regex.*;

public class Cart {
    private String uId;
    private String uName;
       private String iId;
       private String iName;
       private String price;
       private String qty;
       private String total;

    public Cart(String uId, String uname, String iId, String iName, String price, String qty,String total) {
        this.uId = uId;
        this.uName = uname;
        this.iId = iId;
        this.iName = iName;
        this.price = price;
        this.qty = qty;
        this.total=total;
    }

    public void setuId(String uId) {
        this.uId = uId;
    }

    public void setUname(String uname) {
        this.uName = uname;
    }

    public void setiId(String iId) {
        this.iId = iId;
    }

    public void setiName(String iName) {
        this.iName = iName;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public void setQty(String qty) {
        this.qty = qty;
    }

    public void setTotal(String total) {
        this.total = total;
    }

    public String getuId() {
        return uId;
    }

    public String getUname() {
        return uName;
    }

    public String getiId() {
        return iId;
    }

    public String getiName() {
        return iName;
    }

    public String getPrice() {
        return price;
    }

    public String getQty() {
        return qty;
    }

    public String getTotal() {
        return total;
    }
       
       public String toString(){
        return(uId+","+uName+","+iId+", "+iName+","+price+","+qty+","+total);
       }
       
}
