package P2PManager;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.sql.ResultSet;

public class CommentHistory {

    public static String query(String UserName){

        DatabaseHandler db = DatabaseHandler.getInstance();
        PojoToClient ptc = new PojoToClient();
        ResultSet rs = null;

        String qu = "SELECT VideoName, ChannelName, Comment, CommentCreationTime FROM CommentList WHERE UserName = '" + UserName + "';";

        try {
            rs = db.execQuery(qu);
            while(rs.next()){
                ptc.VideoName.add(rs.getString("VideoName"));
                ptc.ChannelName.add(rs.getString("ChannelName"));
                ptc.Comment.add(rs.getString("Comment"));
                ptc.ChannelCreationTime.add(rs.getString("CommentCreationTime"));
            }

            System.out.println("Comment history successfully prepared\n");

            Gson gson = new GsonBuilder().serializeNulls().create();
            String userCommentHistory = gson.toJson(ptc);

            System.out.println("Comment history ready to be sent\n");

            return userCommentHistory;
        }catch (Exception e){
            System.out.println("Comment history fetch unsuccessful\n");
            e.printStackTrace();
            return "Unsuccessful";
        }
    }
}
