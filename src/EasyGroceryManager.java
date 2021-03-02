/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author MOHINI GUPTA
 */
public class EasyGroceryManager {
     private DisplayManager displayOb;
     private payMgr payOb;
     private UserProfileManager profileOb;
     private CartManager cartOb;
     private ProductManager productOb;
     
    /**
     * @param args the command line arguments
     */
     public payMgr getPayOb()
     {
         return payOb;
     }
     public UserProfileManager getProfileOb()
     {
         return profileOb;
     }
     public CartManager getCartOb()
     {
         return cartOb;
     }
     public ProductManager getProductOb()
     {
//         this.productOb=ProductManager.getInstanceOfProductManager();
         return productOb;
     }
     public boolean init()
     {
         profileOb.init("user.csv");
         cartOb.init();
         payOb.init();
         productOb.init();
         
         return true;
     }
     public boolean showMainScreen()
     {
         displayOb.showSearch();
         
         
         return true;
     }
     public boolean instantiateUIMain()
     {
         displayOb.instantiateUI(displayOb);
         
         return true; 
         
     }
     public boolean houseKeep()
     {
         payOb.doHouseKeeping(payOb);
         cartOb.doHouseKeeping(cartOb);
//         profileOb.
        return true;
     }
//     public boolean populate()
//     {
//         PaymentUI payUI = displayOb.getPayui();
//         payUI.populateData(payOb.getDetails());
//         
//         return true;
//     }
    public static void main(String[] args) {
        // TODO code application logic here
        
        EasyGroceryManager mainMgr = new EasyGroceryManager();
        mainMgr.payOb = new payMgr(mainMgr);
        mainMgr.profileOb = new UserProfileManager(mainMgr);
        mainMgr.displayOb =  new DisplayManager(mainMgr);
        mainMgr.cartOb= new CartManager(mainMgr);
        mainMgr.productOb= new ProductManager(mainMgr);
        
        
        mainMgr.init();
        mainMgr.instantiateUIMain();
        mainMgr.showMainScreen();
        mainMgr.houseKeep();
        
    }

    
}
