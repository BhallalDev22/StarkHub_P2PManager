package P2PManager;

import java.sql.ResultSet;

public class CreateChannel {

    public static String query(String UserName, String Password, String ChannelName){
        DatabaseHandler db = DatabaseHandler.getInstance();
        ResultSet rs = null;
        String pass =  null;

        String qu = "SELECT Password FROM LoginCredentials WHERE UserName = '" + UserName + "';";
        try{
            rs = db.execQuery(qu);
            System.out.println("Login password fetch successfull\n");
            while (rs.next()){
                pass = rs.getString("Password");
//                System.out.println(pass);
            }

            if(pass.equals(Password)) {

                String qu1 = "INSERT INTO ChannelList (ChannelName, UserName) VALUES ('" + ChannelName + "', '" + UserName + "');";


                db.execAction(qu1);
                System.out.println("Channel created successfully\n");
                return "Successful";
            }
            else{
                return "Unsuccessful";
            }
        }catch (Exception e){
            System.out.println("Channel creation unsuccessful\n");
            e.printStackTrace();
            return "Unsuccessful";
        }
    }
}
