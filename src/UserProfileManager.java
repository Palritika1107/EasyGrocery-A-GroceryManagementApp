
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author MOHINI GUPTA
 */
import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.StringTokenizer;
import javax.swing.JFrame;
public class UserProfileManager {

    /**
     * @param args the command line arguments
     */
    private  ArrayList<User> userList;
    EasyGroceryManager mainMgr;
    
     public UserProfileManager(EasyGroceryManager mainMgr){
         this.mainMgr = mainMgr;
        this.userList = new ArrayList<>();
        //this.init("");
    }
    public boolean init(String filename){
        boolean result=false;
        FileReader reader = null;
        BufferedReader bufReader = null;
        
        try {
            // constructor may throw FileNotFoundException
            reader = new FileReader("user.csv");
            bufReader = new BufferedReader(reader);
            
           // bufReader.readLine();
            String oneLine = bufReader.readLine();
            while(oneLine != null){
                //reader.read() may throw IOException
                System.out.println(oneLine);
                StringTokenizer st = new StringTokenizer(oneLine, ",");
                ArrayList<String> arrayl = new ArrayList<>();
                while (st.hasMoreTokens()) {
                    //System.out.println(st.nextToken());
                    arrayl.add(st.nextToken());              
                }
                System.out.println(arrayl);
                this.userList.add(new User(arrayl.get(0),arrayl.get(1),arrayl.get(2),arrayl.get(3),Integer.parseInt(arrayl.get(4))));
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
   
    public boolean addUserDetails(User newUser) throws IOException{
        boolean result= false;
        this.userList.add(newUser);
        System.out.println(userList);
        try (FileWriter writer = new FileWriter("src/user.csv")) {  
            BufferedWriter bw = new BufferedWriter(writer);
            //bw.newLine();
            
            String s2="";
            for (Iterator<User> it = this.userList.iterator(); it.hasNext();) {
                String var = it.next().save();
                s2=s2+var+'\n';
                
            }
            bw.append(s2);
            bw.close();
        }
        System.out.println("added"+ newUser.toString());
        result=true;
        return result;
    }
    public List<User> showUserDetails(){
        List<User> result=null;
        //System.out.println(userList);
        result=Collections.unmodifiableList(this.userList);
        //System.out.println(result);
        return result;       
    }
    
//    public static void main(String args[]) throws IOException {
//
//        UserProfileManager mgr=new UserProfileManager();
//        mgr.init("user.csv");
//
//       // assert(mgr.showUserDetails().size()==10);
//       // assert(mgr.showUserDetails().get(0).getName().equals("Mohini"));
//        
//      //  JFrame userProfileUI=new UserProfileUI(mgr);
//      //  userProfileUI.setVisible(true);
//   
//        
//    }
    
}
