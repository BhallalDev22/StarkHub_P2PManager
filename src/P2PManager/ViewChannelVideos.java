package P2PManager;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.sql.ResultSet;

public class ViewChannelVideos {

    public static String query(String ChannelName){

        DatabaseHandler db = DatabaseHandler.getInstance();
        PojoToClient ptc = new PojoToClient();
        ResultSet rs = null;

        String qu = "SELECT VideoName, VideoLikes, VideoDislikes, VideoViews, VideoCreationTime, NumberOfComments, VideoTag FROM VideoList WHERE ChannelName = '" + ChannelName + "';";

        try{
            rs = db.execQuery(qu);
            while (rs.next()){
                ptc.VideoName.add(rs.getString("VideoName"));
                ptc.VideoLikes.add(rs.getInt("VideoLikes"));
                ptc.VideoDislikes.add(rs.getInt("VideoDislikes"));
                ptc.VideoViews.add(rs.getInt("VideoViews"));
                ptc.VideoCreationTime.add(rs.getString("VideoCreationTime"));
                ptc.NumberOfComments.add(rs.getInt("NumberOfComments"));
                ptc.VideoTag.add(rs.getString("VideoTag"));
            }
            System.out.println("Video list of user channel prepared successfully\n");

            Gson gson = new GsonBuilder().serializeNulls().create();
            String channelVideoList = gson.toJson(ptc);

            System.out.println("Video list of user channel ready to be sent\n");

            return channelVideoList;

        }catch (Exception e){
            System.out.println("Video list of user channel preparation unsuccessful\n");
            e.printStackTrace();
            return "Unsuccessful";
        }
    }

}
