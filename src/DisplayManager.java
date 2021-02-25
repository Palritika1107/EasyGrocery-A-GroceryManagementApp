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
     private CartUI cartUI;
     private Search SearchUI;
     private EasyGroceryManager mainMgr;
    
    public  payMgr getPayMgr()
    {
        return mainMgr.getPayOb();
    }
    public UserProfileManager getProfileMgr()
    {
        return mainMgr.getProfileOb();
    }
    public CartManager getCartMgr()
    {
        return mainMgr.getCartOb();
    }
    public ProductManager getProductMgr()
    {
        return mainMgr.getProductOb();
    }
    public void showSearch(){
        userprofileUI.setVisible(false);
        SearchUI.setVisible(true);
    }
    public void showuserprofileUI(){
        SearchUI.setVisible(false);
        userprofileUI.setVisible(true);
    }
     public void showCartUI(){  
         SearchUI.setVisible(false);
        cartUI.setVisible(true);
    }
     public void showpaymentUI(){
        cartUI.setVisible(false);
        paymentUI.setVisible(true);
    }
    
     
//     public void exit(){
//          paymentUI.setVisible(false);
//          System.exit(0);
//     }
     DisplayManager(EasyGroceryManager mainMgr)
     {
         this.mainMgr = mainMgr;
     }
     public void instantiateUI(DisplayManager ob)
     {
         paymentUI = new PaymentUI(ob);
         userprofileUI = new UserProfileUI(ob);
         cartUI = new CartUI(ob);
         SearchUI=new Search(ob);
     }
//     public boolean forPopulate()
//     {
//          paymentUI.populateData();
//         return true;
//     }
    public static void main(String[] args)
    {
//        DisplayManager myMgr=new DisplayManager();
//       
//        myMgr.userprofileUI= new UserProfileUI(myMgr);
//        
//        myMgr.paymentUI=new PaymentUI (myMgr);
//        myMgr.showuserprofileUI();
        
    }
    
}
