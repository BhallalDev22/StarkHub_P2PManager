package P2PManager;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.sql.ResultSet;

public class WatchHistory {

    public static String query(String UserName){

        DatabaseHandler db = DatabaseHandler.getInstance();
        PojoToClient ptc = new PojoToClient();
        ResultSet rs = null;

        String qu = "SELECT VideoName, ChannelName, WatchTime FROM WatchHistory WHERE UserName = '" + UserName + "' ORDER BY WatchTime DESC;";

        try {
            rs = db.execQuery(qu);
            while(rs.next()){
                ptc.VideoName.add(rs.getString("VideoName"));
                ptc.ChannelName.add(rs.getString("ChannelName"));
                ptc.WatchTime.add(rs.getString("WatchTime"));
            }

            System.out.println("Watch history successfully prepared\n");

            Gson gson = new GsonBuilder().serializeNulls().create();
            String userWatchHistory = gson.toJson(ptc);

            System.out.println("Watch history ready to be sent\n");

            return userWatchHistory;
        }catch (Exception e){
            System.out.println("Watch history fetch unsuccessful\n");
            e.printStackTrace();
            return "Unsuccessful";
        }
    }
}
