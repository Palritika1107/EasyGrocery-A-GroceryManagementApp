/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ritika
 */
import java.io.*;
import java.util.StringTokenizer; 
import java.util.*;
import java.util.regex.*; 
import javax.swing.*;
//import java.nio.file.Paths;
//import java.lang.Object;
//import java.nio.file.Files;
//import java.nio.file.Path;
public class payMgr {
    
    ArrayList<Payment>myPay ;
    EasyGroceryManager mainMgr;
    public boolean init()
    {
        //READING FILE
        try{

       FileReader reader = new FileReader("paynew.txt");
       
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
//    public boolean writeToFile(payMgr mgr)
    public boolean doHouseKeeping(payMgr mgr)
    {
//         payMgr mgr1 = new payMgr();
//        GET DETAILS i.e GET ALL THE DATA INSTANCES
         ArrayList<Payment> ob = mgr.getDetails();
         
         try{
             String file = "payaccept.txt";
            FileWriter writer = new FileWriter(file);  
            BufferedWriter bw = new BufferedWriter(writer);
            bw.write("Date|ModeOfPayment|cardNos|cvv|CardHolder'sName|PaymentStatus");
            bw.newLine();
//            bw.close();
            String s2="";
            for(Payment str: ob){
                        
                    s2=s2+str.toString()+"\n";

            }
            bw.write(s2);
            bw.close();
            writer.close();
            
            
            
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
    public void tokenizeThings(String s)
    {
        StringTokenizer st = new StringTokenizer(s, "|");
        String Date=null,Mode="",cardNos="",cardHolder=null,cvv=null,payacc=null;
        int count = 0;
        while (st.hasMoreTokens()) {
//        System.out.println(st.nextToken());
        switch(count)
                {
                    case 0:
                        Date = st.nextToken();
                        count++;
                        break;
                    case 1:
                        Mode = st.nextToken();
                        count++;
                        break;
                    case 2:
                        cardNos = st.nextToken();
                        count++;
                        break;
                    case 3:
                        cvv = st.nextToken();
                        
                        count++;
                        break;
                    case 4:
                        cardHolder=st.nextToken();
                        count++;
                        break;
                    default:System.out.println("wrong");
                            break;
                }
              }
        payacc = checkPayMode(Mode,payacc,cardNos);
//        System.out.println(payacc);
//        addDetails(Date,Mode,cardNos,cvv,cardHolder,payacc);
        Payment ob = new Payment(Date,Mode,cardNos,cvv,cardHolder,payacc);
        addDetails(ob);
        
    }
    public String checkPayMode(String Mode,String payacc,String cardNos)
    {
        if(Mode.equals("CashOnDelivery"))
                  {
                      payacc = "Order Accepted";
                  }
                  else
                  {    
                      boolean matchCheck = true;
             
                      StringTokenizer st2 = new StringTokenizer(cardNos, "-");
                      while(st2.hasMoreTokens())
                      {
                        String s = st2.nextToken();
                        Pattern p = Pattern.compile("[0-9]{3}"); 
                        Matcher m = p.matcher(s);  
                        matchCheck = m.matches(); 
                       
//                          matchCheck = Pattern.matches("[0-9]{3}",st2.nextToken());
                          if(!matchCheck){
                              
                              payacc = "Enter correct Debit/Credit Card";
                              break;}
                              
                      }
                      if(matchCheck){
                          payacc = "Order Accepted";}
                  }
        return payacc;
    
    }
    payMgr(EasyGroceryManager mainMgr)
    {
        this.mainMgr=mainMgr;
        this.myPay = new ArrayList<Payment>();
//        this.init();
    }
    public ArrayList<Payment> getDetails()
    {
//        ArrayList<Payment>result = null;
//        
//        result = Collections.unmodifiableList<Payment>(this.myPay);
        
        return this.myPay;
    }

    public boolean addDetails(Payment payOb)
    {
        boolean result = false;

          this.myPay.add(payOb);
        System.out.println("added"+payOb.toString());
//        for(int i=0;i<myPay.size();i++)
//            {
//                System.out.println(myPay.get(i));
//            }
        result = true;
       
        return result;
    }
//    public static void main(String[] args)
//    {
//        //INSTANTIATE MANAGER
//        payMgr mgr = new payMgr();
//        
//          
//        // System.out.println( mgr.init());
//        
//        
//        //READ FILE AND INITIALIZE 
//         mgr.init();
//     
////         System.out.println("reached main");
//         
////         ArrayList<Payment> ob = mgr.getDetails();
////         for(int i=0;i<ob.size();i++)
////            {
////                System.out.println(ob.get(i));
////            }
//
//
//         //WRITE TO FILE
//         mgr.doHouseKeeping(mgr);
//         
//         //CREATE SCREENS
//        // JFrame PaymentUI = new PaymentUI(mgr);
//        // PaymentUI.setVisible(true);
//       
//           //UNIT TESTING
//          assert(mgr.getDetails().size() == 5);
//          assert(mgr.getDetails().get(0).getcardHolderName().equals("Anjali Singh"));
//          assert(mgr.checkPayMode("CashOnDelivery","", "0").equals("Order Accepted"));
//          assert(mgr.addDetails(new Payment("21-3-2021","CashOnDelivery","0","0","Ritika","")));
////         System.out.println(mgr.getDetails().size());
//         
//    }
    
}
