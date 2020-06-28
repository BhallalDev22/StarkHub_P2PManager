package P2PManager;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.sql.ResultSet;

public class ViewSubscribedChannels {

    public static String query(String UserName){
        DatabaseHandler db = DatabaseHandler.getInstance();
        PojoToClient ptc = new PojoToClient();
        ResultSet rs = null;

        String qu = "SELECT ChannelName, SubscribeTime FROM SubscriberList WHERE UserName = '" + UserName + "';";

        try {
            rs = db.execQuery(qu);
            while (rs.next()){
                ptc.ChannelName.add(rs.getString("ChannelName"));
                ptc.SubscribeTime.add(rs.getString("SubscribeTime"));
            }

            System.out.println("Subscribed channels fetched successfully\n");

            Gson gson = new GsonBuilder().serializeNulls().create();
            String subscribedChannelList = gson.toJson(ptc);

            System.out.println("Subscribed channel list ready to be sent\n");

            return subscribedChannelList;
        }catch (Exception e){
            System.out.println("Subscribed channel list fetch unsuccessful");
            e.printStackTrace();
            return "Unsuccessful";
        }
    }
}
