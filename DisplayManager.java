/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ritika
 */
public class DisplayManager {
    private PaymentUI paymentUI;
    private UserProfileUI userprofileUI;
    
    public void showuserprofileUI(){
        userprofileUI.setVisible(true);
    }
     public void showpaymentUI(){
        userprofileUI.setVisible(false);
        paymentUI.setVisible(true);
    }
     public void exit(){
          paymentUI.setVisible(false);
          System.exit(0);
     }
     
    public static void main(String[] args)
    {
        DisplayManager myMgr=new DisplayManager();
       
        myMgr.userprofileUI= new UserProfileUI(myMgr);
        
        myMgr.paymentUI=new PaymentUI (myMgr);
        myMgr.showuserprofileUI();
    }
    
}
