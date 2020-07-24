package P2PManager;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.sql.ResultSet;

public class ViewAllChannels {

    public static String query(String UserName){
        DatabaseHandler db = DatabaseHandler.getInstance();
        PojoToClient ptc = new PojoToClient();
        ResultSet rs = null;

        String qu = "SELECT ChannelName, NumberOfSubscribers FROM ChannelList WHERE UserName = '" + UserName + "' ORDER BY NumberOfSubscribers DESC;";

        try{
            rs = db.execQuery(qu);
            while (rs.next()){
                ptc.ChannelName.add(rs.getString("ChannelName"));
                ptc.NumberOfSubscribers.add(rs.getInt("NumberOfSubscribers"));
            }
            System.out.println("User channel list prepared\n");

            Gson gson = new GsonBuilder().serializeNulls().create();
            String userChannelList = gson.toJson(ptc);

            System.out.println("User channel list ready to be sent\n");

            return userChannelList;

        }catch (Exception e){
            System.out.println("User channel list fetch unsuccessful\n");
            e.printStackTrace();
            return "Unsuccessful";
        }
    }
}
