package P2PManager;

import java.sql.ResultSet;

public class AddVideo {

    public static String query(String VideoName, String ChannelName, String VideoPath, String UserName, String VideoTag){
        DatabaseHandler db = DatabaseHandler.getInstance();
        ResultSet rs = null;

        String qu = "INSERT INTO VideoList (VideoName, ChannelName, VideoPath, UserName, VideoTag) VALUES ('" + VideoName + "', '" + ChannelName + "', '" + VideoPath + "', '" + UserName + "', '" + VideoTag + "');";
        String qu2 = "UPDATE ChannelList SET NumberOfVideos = NumberOfVideos + 1 WHERE ChannelName = '" + ChannelName + "';";
        String qu3 = "SELECT UserName FROM SubscriberList WHERE ChannelName = '" + ChannelName + "';";

        try{
            db.execAction(qu);
            System.out.println("New video added to video list\n");
            db.execAction(qu2);
            System.out.println("Number of videos incremented in channel list\n");

            rs = db.execQuery(qu3);
            while (rs.next()){
                String un = rs.getString("UserName");
                String qu4 = "INSERT INTO NotificationsList (ChannelName, UserName, VideoName) VALUES ('" + ChannelName + "', '" + un + "', '" + VideoName + "');";
                db.execAction(qu4);
            }

            System.out.println("Notifications list updated successfully\n");

            return "Successful";
        }catch (Exception e){
            System.out.println("Video add operation unsuccessful\n");
            e.printStackTrace();
            return "Unsuccessful";
        }
    }
}
