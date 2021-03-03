import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.swing.JFrame;
import java.util.Iterator;
import java.util.StringTokenizer;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Muskan
 */
public class ProductManager {
    private ArrayList<Product> ProductList;
    //public static ProductManager instance;
    EasyGroceryManager mainMgr;
    
    
     public ProductManager(EasyGroceryManager mainMgr){
        this.mainMgr=mainMgr;
        this.ProductList=new ArrayList<Product>();
        //this.init();
    }
    public ArrayList<Product> Search1(String x)
    {
        ArrayList<Product> result=new ArrayList<Product>();
        if(x.equals(""))
        {
            for(int i=0;i<ProductList.size();i++)
            {
                Product p=ProductList.get(i);
                result.add(p);
                
                
                
            }
        }
        else{
        for(int i=0;i<ProductList.size();i++)
        {
            
            if(x.equals(ProductList.get(i).getName()))
            {
                Product p=ProductList.get(i);
                result.add(p);
                
                
            }
        }}
        
        return result;
        
    }
     public ArrayList<Product> Search2(String x)
    {
        ArrayList<Product> result=new ArrayList<Product>();
         for(int i=0;i<ProductList.size();i++)
         {
             if(x.equals(ProductList.get(i).getGroup()))
                    {
                        Product p=ProductList.get(i);
                        result.add(p);
                        
                    }
         }
         return result;
    }
    
    public boolean init()
    {
        boolean result=false;
        FileReader reader = null;
        BufferedReader bufReader = null;
        try{
             reader = new FileReader("Product.csv");
            bufReader = new BufferedReader(reader);

            bufReader.readLine();
            String oneLine = bufReader.readLine();
                        while(oneLine != null){
                //reader.read() may throw IOException
                //System.out.println(oneLine);
                StringTokenizer st = new StringTokenizer(oneLine, ",");
                ArrayList<String> arrayl = new ArrayList<>();
                while (st.hasMoreTokens()) {
                    //System.out.println(st.nextToken());
                    arrayl.add(st.nextToken());              
                }
                System.out.println(arrayl);
                this.ProductList.add(new Product(Integer.parseInt(arrayl.get(0)),arrayl.get(1),arrayl.get(2),Integer.parseInt(arrayl.get(3)),arrayl.get(4),arrayl.get(5)));
                // System.out.println(this.userList);
                oneLine = bufReader.readLine();
                
            }
            
          //System.out.println(userList);
            bufReader.close();
            reader.close();
           

        } catch (FileNotFoundException e) {
                //do something clever with the exception
                System.out.println("File Not Found");
        } catch (IOException e) {
                //do something clever with the exception
                System.out.println("IO Exception");              
        } 
            
        result=true;
        return result;
    }
    
    public List<Product> getProductDetails()
    {
        //List<Product> result=null;
        //result=Collections.unmodifiableList(this.ProductList);
        return this.ProductList;
    }
    public boolean addProductDetails(Product newProduct)
    {
        boolean result=false;
        this.ProductList.add(newProduct);
        try (FileWriter writer = new FileWriter("Product.csv")) {  
            BufferedWriter bw = new BufferedWriter(writer);
            //bw.newLine();
            
            String p="";
            for (Iterator<Product> it = this.ProductList.iterator(); it.hasNext();) {
                String var = it.next().save();
                p=p+var+'\n';
                
            }
            bw.append(p);
            bw.close();
        }
        catch (FileNotFoundException e) {
                //do something clever with the exception
                System.out.println("File Not Found");
        } catch (IOException e) {
                //do something clever with the exception
                System.out.println("IO Exception");              
        } 
        System.out.println("added"+newProduct.toString());
        result=true;
        return result;
    }
    public boolean doHousekeeping(){
        return true;
    }
     public String SearchPrice(int ID)
     {
         int Price;
                 String s="0";
         for(int i=0;i<ProductList.size();i++)
        {
            
            if(ID==ProductList.get(i).getID())
            {
                Product p=ProductList.get(i);
                //s[j]=p.getID()+","+p.getName()+","+p.getGroup()+","+p.getPrice()+","+p.getUnitOfMeasurement();
                
                Price= p.getPrice();
                 s=Integer.toString(Price);
                break;
            }
         
        }
         return s;
     }   
    //public static void main(String args[]) {
     //  ProductManager mgr=new ProductManager();
     //   mgr.init();
        
        //assert(mgr.getProductDetails().size()==69);
       //assert(mgr.getProductDetails().get(0).getName().equals("Onion"));
     //   JFrame Search = new Search(mgr);
      //   Search.setVisible(true);
//}
}


