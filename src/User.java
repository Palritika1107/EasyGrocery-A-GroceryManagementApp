/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author MOHINI GUPTA
 */

public class User{
       private String name;
       private String email;
       private String password;
       private String address;
       private int mobile_no;
        
    public User(String n,String e,String p,String a,int m) {
        this.name = n;
        this.email = e;
        this.password= p;
        this.address=a;
        this.mobile_no=m;
    }

    public String getName() {
        return name;
    }
 
    public void setName(String n) {
        this.name = n;
    }
    public String getEmail() {
        return email;
    }
 
    public void setEmail(String e) {
        this.email = e;
    }
    public String getPassword() {
        return password;
    }
 
    public void setPassword(String p) {
        this.password = p;
    }
    public String getAddress() {
        return address;
    }
 
    public void setAddress(String a) {
        this.address = a;
    }
    public int getNumber() {
        return mobile_no;
    }
 
    public void setNumber(int no) {
        this.mobile_no = no;
    }

    /**
     *
     * @return
     */
    @Override
    public String toString(){
        return("[name="+name+" email="+email+" password="+password+" address="+address+" contact no="+mobile_no+"]");
    }
    public String save(){
        String x=name+","+email+","+password+","+address+","+mobile_no;
        return x;
    }
    }
    
 
