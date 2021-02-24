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
import javax.swing.JFrame;

public class CartManager {
    ArrayList<Cart>myCart ;
    
    
     CartManager()
    {
        this.myCart = new ArrayList<Cart>();
        //this.init();
    }
     public ArrayList<Cart> getDetails()
    {

        return this.myCart;
    }
    public boolean init()
    {
        //READING FILE
        try{

       FileReader reader = new FileReader("src/CartData.txt");
       
       BufferedReader bufReader = new BufferedReader(reader);
//       tokenizeThings(bufReader);
       bufReader.readLine();
       String oneLine = bufReader.readLine();
//       System.out.println(oneLine);
       while(oneLine != null)
       {
           int count=0;
           tokenizeThings(oneLine);
           oneLine = bufReader.readLine();
       }
       
       
        }
        catch (FileNotFoundException e) {
                //do something clever with the exception
                System.out.println("File Not Found");
                return false;
        }
        catch (IOException e) {
                //do something clever with the exception
                System.out.println("IO Exception");   
                return false;
        } 
    return true;
    }
    public void tokenizeThings(String s)
    {
        StringTokenizer st = new StringTokenizer(s, ",");
        String uId=null,uName="",iId="",iName=null,price=null,qty=null,total=null;
        int count = 0;
        while (st.hasMoreTokens()) {
        switch(count)
                {
                    case 0:
                        uId = st.nextToken();
                        count++;
                        break;
                    case 1:
                        uName = st.nextToken();
                        count++;
                        break;
                    case 2:
                        iId = st.nextToken();
                        count++;
                        break;
                    case 3:
                        iName = st.nextToken();
                        
                        count++;
                        break;
                    case 4:
                        price=st.nextToken();
                        count++;
                        break;
                    case 5:
                        qty=st.nextToken();
                        count++;
                        break;   
                     case 6:
                        st.nextToken();
                        count++;
                        break;
                    default:System.out.println("wrong");
                            break;
                }
              }
        total = calcTotal(uId,price,qty);        
        Cart obj = new Cart(uId,uName,iId,iName,price,qty,total);
        
        addDetails(obj);
    }
    public String calcTotal(String uId,String price,String qty){
        int q=Integer.parseInt(qty);
        double p=Double.parseDouble(price);        
        
        double t=0.0;
        t+=p*q;
        return Double.toString(t);
        
    }
    public boolean addDetails(Cart cartOb)
    {
        boolean result = false;
        //cartOb.setTotal(calcTotal(cartOb.getuId(),cartOb.getPrice(),cartOb.getQty()));
         this.myCart.add(cartOb);
         // this.myCart.add(cartOb.getTotal());
         
        System.out.println("added"+cartOb.toString());
        Collections.sort(myCart,new Comparator<Cart>()
        {
            public int compare(Cart c1,Cart c2){
                return Integer.valueOf(c1.getuId().substring(1)).compareTo(Integer.valueOf(c2.getuId().substring(1)));
            }
        });
        result = true;
        //System.out.println(myCart);
        
        return result;
    }
    public boolean doHouseKeeping(CartManager mgr)
    {
//        GET DETAILS i.e GET ALL THE DATA INSTANCES
         ArrayList<Cart> obj = mgr.getDetails();
         int i=1,id;
         
         double t[]=new double[100];
         
         CartUI ui =new CartUI(mgr);
         
         try{
             String file = "src/ModifiedCart.txt";
            FileWriter writer = new FileWriter(file);  
            BufferedWriter bw = new BufferedWriter(writer);
            bw.write("User Id, User name, Total");
            bw.newLine();
//            bw.close();
            String s2="";
            id=Integer.parseInt(obj.get(0).getuId().substring(1));;
            t[id]=Double.parseDouble(obj.get(0).getTotal());
            while(i!=obj.size()){
                id=Integer.parseInt(obj.get(i).getuId().substring(1));
                if(obj.get(i-1).getuId().equals(obj.get(i).getuId()))
                    t[id]+=Double.parseDouble(obj.get(i).getTotal());
                else
                    t[id]=Double.parseDouble(obj.get(i).getTotal());
                i++;
            }
            
            i=0;
           
            while(i!=obj.size()){
                        id=Integer.parseInt(obj.get(i).getuId().substring(1));
                obj.get(i).setTotal(Double.toString(t[id]));
                //System.out.println(obj.get(i).getTotal());
                if(i==0)
                    s2=s2+obj.get(0).getuId()+","+obj.get(0).getUname()+","+obj.get(i).getTotal()+"\n";
                else if(obj.get(i-1).getuId().equals(obj.get(i).getuId())==false)
                    s2=s2+obj.get(i).getuId()+","+obj.get(i).getUname()+","+obj.get(i).getTotal()+"\n";
                    
                i++;

            }
            bw.write(s2);
            bw.close();
            writer.close();
             //System.out.println(myCart);
         }
         catch(FileNotFoundException e) {
                //do something clever with the exception
                System.out.println("File Not Found");
                
        }
         catch (IOException e) {
                //do something clever with the exception
                System.out.println("IO Exception");   
//                return false;
        } 
        
        
        return true;
    }
     public static void main(String[] args)
    {
        //INSTANTIATE MANAGER
        CartManager mgr = new CartManager();
        //READ FILE AND INITIALIZE 
         mgr.init();
         //WRITE TO FILE
         
         
         JFrame CartUI =new CartUI(mgr);
         CartUI.setVisible(true);
         
         mgr.doHouseKeeping(mgr);
         
         //UNIT TESTING
         /*Cart ob1=new Cart("U2","Arshia Chaudhuri","I10","Chips","50","5","0.0");
         ob1.setTotal(mgr.calcTotal(ob1.getuId(),ob1.getPrice(),ob1.getQty()));
         mgr.addDetails(ob1);
         mgr.doHouseKeeping(mgr);*/
    }
         
   
}
