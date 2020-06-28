package P2PManager;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.sql.ResultSet;

public class ViewWatchLater {

    public static String query(String UserName){

        DatabaseHandler db = DatabaseHandler.getInstance();
        PojoToClient ptc = new PojoToClient();
        ResultSet rs = null;

        String qu = "SELECT VideoName, ChannelName, WatchLaterTime FROM WatchLaterList WHERE UserName = '" + UserName + "';";

        try {
            rs = db.execQuery(qu);
            while (rs.next()){
                ptc.VideoName.add(rs.getString("VideoName"));
                ptc.ChannelName.add(rs.getString("ChannelName"));
                ptc.WatchLaterTime.add(rs.getString("WatchLaterTime"));
            }
            System.out.println("Watch later list fetch successful\n");

            Gson gson = new GsonBuilder().serializeNulls().create();
            String watchLaterList = gson.toJson(ptc);

            System.out.println("Watch later list ready to be sent\n");

            return watchLaterList;

        }catch (Exception e){
            System.out.println("Unable to fetch watch later list\n");
            e.printStackTrace();
            return "Unsuccessful";
        }
    }
}
