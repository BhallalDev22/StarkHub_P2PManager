package P2PManager;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.sql.ResultSet;

public class Notifications {

    public static String query(String UserName){
        DatabaseHandler db = DatabaseHandler.getInstance();
        ResultSet rs = null;
        PojoToClient ptc = new PojoToClient();

        String qu = "SELECT ChannelName, VideoName FROM NotificationsList WHERE UserName = '" + UserName + "';";
        String qu2 = "DELETE FROM NotificationsList WHERE UserName = '" + UserName + "';";
        try{
            rs = db.execQuery(qu);
            while (rs.next()){
                ptc.ChannelName.add(rs.getString("ChannelName"));
                ptc.VideoName.add(rs.getString("VideoName"));
            }

            Gson gson = new GsonBuilder().serializeNulls().create();
            String notificationsList = gson.toJson(ptc);

            System.out.println("Notifications ready to be sent\n");

            db.execAction(qu2);
            System.out.println("Notifications reseted for the user successfully\n");

            return notificationsList;

        }catch (Exception e){
            System.out.println("Notifications update unsuccessful\n");
            e.printStackTrace();
            return "Unsuccessful";
        }
    }
}
