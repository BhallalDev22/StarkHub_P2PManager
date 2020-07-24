package P2PManager;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.sql.ResultSet;

public class ViewChannel {

    public static String query(String ChannelName){

        DatabaseHandler db = DatabaseHandler.getInstance();
        PojoToClient ptc = new PojoToClient();
        ResultSet rs = null;

        String qu = "SELECT ChannelName, ChannelCreationTime, NumberOfVideos, NumberOfSubscribers FROM ChannelList WHERE ChannelName = '" + ChannelName + "';";

        try{
            rs = db.execQuery(qu);
            while (rs.next()){
                ptc.ChannelName.add(rs.getString("ChannelName"));
                ptc.ChannelCreationTime.add(rs.getString("ChannelCreationTime"));
                ptc.NumberOfVideos.add(rs.getInt("NumberOfVideos"));
                ptc.NumberOfSubscribers.add(rs.getInt("NumberOfSubscribers"));
            }

            System.out.println("User Channel data prepared successfully\n");

            Gson gson = new GsonBuilder().serializeNulls().create();
            String userchanneldata = gson.toJson(ptc);

            System.out.println("User Channel data ready to be sent\n");

            return userchanneldata;
        }catch (Exception e){
            System.out.println("User Channel data fetch unsuccessful\n");
            e.printStackTrace();
            return "Unsuccessful";
        }
    }


}
