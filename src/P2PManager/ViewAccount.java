package P2PManager;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.sql.ResultSet;

public class ViewAccount {

    public static String query(String UserName){

        DatabaseHandler db = DatabaseHandler.getInstance();
        PojoToClient ptc = new PojoToClient();
        ResultSet rs = null;

        String qu = "SELECT UserName, EmailID, AccountCreationDate FROM LoginCredentials WHERE UserName = '" + UserName + "';";


        try {
            rs = db.execQuery(qu);
            while (rs.next()){
                ptc.UserName = rs.getString("UserName");
                ptc.EmailID = rs.getString("EmailID");
                ptc.AccountCreationTime = rs.getString("AccountCreationDate");
            }

            System.out.println("Account details fetch successful\n");

            Gson gson = new GsonBuilder().serializeNulls().create();
            String userAccountDetails = gson.toJson(ptc);

            System.out.println("Account details ready to be sent\n");

            return userAccountDetails;

        }catch (Exception e){
            System.out.println("Account details fetch unsuccessful\n");
            e.printStackTrace();
            return "Unsuccessful";
        }
    }
}
