package P2PManager;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.sql.ResultSet;

public class PlayVideo {

    public static String query(String VideoName, String UserName, Socket socket){
        DatabaseHandler db = DatabaseHandler.getInstance();
        PojoToClient ptc = new PojoToClient();
        ResultSet rs = null;
        String cn = null;
        String un = null;
        int isSubscriber = 0;
        int isWatchLater = 0;
        int userID = 0;

        String qu = "SELECT VideoName, ChannelName, VideoLikes, VideoDislikes, VideoViews, VideoCreationTime, NumberOfComments, VideoPath, UserName, VideoTag FROM VideoList WHERE VideoName = '" + VideoName + "';";
        String qu2 = "UPDATE VideoList SET VideoViews = VideoViews + 1, CurrentViews = CurrentViews + 1 WHERE VideoName = '" + VideoName + "';";
        String qu4 = "SELECT UserName, Comment, CommentCreationTime FROM CommentList WHERE VideoName = '" + VideoName + "';";

        try {

            BufferedReader input = new BufferedReader(
                    new InputStreamReader(socket.getInputStream()));
            PrintWriter output = new PrintWriter(socket.getOutputStream(), true);

            db.execAction(qu2);

            System.out.println("Views updated successfully\n");

            rs = db.execQuery(qu);
            while (rs.next()){
                ptc.VideoName.add(rs.getString("VideoName"));
                cn = rs.getString("ChannelName");
                ptc.ChannelName.add(cn);
                ptc.VideoLikes.add(rs.getInt("VideoLikes"));
                ptc.VideoDislikes.add(rs.getInt("VideoDislikes"));
                ptc.VideoViews.add(rs.getInt("VideoViews"));
                ptc.VideoCreationTime.add(rs.getString("VideoCreationTime"));
                ptc.NumberOfComments.add(rs.getInt("NumberOfComments"));
                ptc.VideoPath.add(rs.getString("VideoPath"));
                un = rs.getString("UserName");
                ptc.UserName = un;
            }

            System.out.println("Video details fetched successfully\n");

            String qu5 = "SELECT IPAddress, UserID FROM LoginCredentials WHERE UserName = '" + un + "';";
            rs = db.execQuery(qu5);
            while (rs.next()){
                ptc.IPAddress = rs.getString("IPAddress");
                userID = rs.getInt("UserID");
                ptc.UserID = userID;
            }

            System.out.println("Ipaddress fetch successful\n");

            String qu3 = "INSERT INTO WatchHistory (UserName, VideoName, ChannelName) VALUES ('" + UserName + "', '" + VideoName + "', '" + cn + "');";
            db.execAction(qu3);

            System.out.println("WatchHistory updated successfully\n");

            String qu6 = "SELECT SubscriberID FROM SubscriberList WHERE ChannelName = '" + cn + "' AND UserName = '" + UserName + "';";
            rs = db.execQuery(qu6);
            while (rs.next()){
                isSubscriber = 1;
            }

            System.out.println("Is subscriber checked successfully\n");

            String qu7 = "SELECT WatchLaterID FROM WatchLaterList WHERE VideoName = '" + VideoName + "';";
            rs = db.execQuery(qu7);
            while (rs.next()){
                isWatchLater = 1;
            }

            System.out.println("Is watch later checked successfully\n");

            rs = db.execQuery(qu4);
            while (rs.next()){
                ptc.CommentUserName.add(rs.getString("UserName"));
                ptc.Comment.add(rs.getString("Comment"));
                ptc.ChannelCreationTime.add(rs.getString("CommentCreationTime"));
            }

            System.out.println("Video comments fetched successfully\n");

            Gson gson = new GsonBuilder().serializeNulls().create();
            String videoDetails = gson.toJson(ptc);

            System.out.println("Complete video detail package ready to be sent\n");

            userID-=1;

            CurrentlyViewingList.currentlyViewing.get(userID).add(socket);

            System.out.println("Video added to currently viewing list\n");

            output.println(videoDetails);

            while(true) {
                String sip = input.readLine();
                if(sip.equals("exit")) {
                    CurrentlyViewingList.currentlyViewing.get(userID-1).remove(socket);
                    System.out.println("User successfully removed from currently viewing list\n");
                    return "Successful";
                }

                output.println(sip);
            }

        }catch (Exception e){
            System.out.println("Details to play video fetch and update failed\n");
            e.printStackTrace();
            return "Unsuccessful";
        }

    }

}
