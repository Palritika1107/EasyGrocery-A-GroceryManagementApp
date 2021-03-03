/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Muskan
 */
public class Product {
    private int ID;
    private String Name;
    private String Group;
    private int Price;
    private String UnitOfMeasurement;
    private String Company;
    
    public Product(int ID,String Name,String Group,int Price,String UnitOfMeasurement,String Company)
    {
        this.ID = ID;
        this.Name = Name;
        this.Group = Group;
        this.Price = Price;
        this.UnitOfMeasurement = UnitOfMeasurement;
        this.Company = Company;
    }
    public int getID()
    {
        return ID;
    }
    public void setID(int ID)
    {
        this.ID=ID;
    }
    public String getName()
    {
        return Name;
    }
    public void setName(String Name)
    {
        this.Name=Name;
    }
    public String getGroup()
    {
        return Group;
    }
    public void setGroup(String Group)
    {
        this.Group=Group;
    }
    public int getPrice()
    {
        return Price;
    }
    public void setPrice(int Price)
    {
        this.Price=Price;
    }
    public String getUnitOfMeasurement()
    {
        return UnitOfMeasurement;
    }
    public void setUnitOfMeasurement(String UnitOfMeasurement)
    {
        this.UnitOfMeasurement=UnitOfMeasurement;
    }
     public String getCompany()
    {
        return Company;
    }
    public void setCompany(String Company)
    {
        this.Company=Company;
    }
    public String toString()
    {
        return ("ID "+this.getID()+" - "
                +this.getName()+"("+
                this.getGroup()+") : Rs "+
                this.getPrice()+" Company: "+this.getCompany());
    }
    public String save(){
        String s=ID+","+Name+","+Group+","+Price+","+UnitOfMeasurement;
        return s;
    }
    }

