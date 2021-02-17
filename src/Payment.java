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
public class Payment {

       private String Date;
       private String Mode;
       private String cardNos;
       private String cardHolderName;
       private String cvv;
       private String payacc;
       
       
       
       public Payment(String Date,String Mode,String cardNos,String cvv,String cardHolderName,String payacc)
       {
           this.Date = Date;
           this.Mode = Mode;
           this.cardNos = cardNos;
           this.cardHolderName = cardHolderName;
           this.cvv = cvv;
           this.payacc = payacc;
       }
       public void setcardNos(String cardNos)
       {
           this.cardNos = cardNos;
       }
       public void setcvv(String cvv)
       {
           this.cvv = cvv;
       }
       public void setMode(String Mode)
       {
           this.Mode = Mode;
       }
       public void setPayAcc(String payacc)
       {
           this.payacc = payacc;
       }
       public String getcardHolderName()
       {
           return this.cardHolderName;
       }
       public String getMode()
       {
           return this.Mode;
       }
       public String getDate()
       {
           return this.Date;
       }
       public String getcardNos()
       {
           return this.cardNos;
       }
       public String getcvv()
       {
           return this.cvv;
       }
       public String getPayAcc()
       {
           return this.payacc;
       }
//      public
//      public String toString() {
//       return "[Date =" + Date + ", Mode=" + Mode + ", cardNos=" + cardNos +",cvv="+cvv+",cardHolderName"+cardHolderName+",PaymentAccess="+payacc+ "]";
//   }
       @Override
       public String toString(){
        return(Date+"|"+Mode+"|"+cardNos+"|"+cvv+"|"+cardHolderName+"|"+payacc);
    }

}

