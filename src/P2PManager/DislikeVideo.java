package P2PManager;

import java.sql.ResultSet;

public class DislikeVideo {

    public static String query(String UserName, String VideoName){

        DatabaseHandler db = DatabaseHandler.getInstance();
        ResultSet rs = null;
        int flag = 0;

        String qu = "UPDATE VideoList SET VideoDislikes = VideoDislikes + 1 WHERE VideoName = '" + VideoName + "';";
        String qu1 = "SELECT Status FROM LikesDislikesList WHERE UserName = '" + UserName + "' AND VideoName = '" + VideoName + "';";
        String qu2 = "INSERT INTO LikesDislikesList (UserName, VideoName, Status) VALUES ('" + UserName + "', '" + VideoName + "', " + "-1" + ");";
        String qu3 = "UPDATE VideoList SET VideoLikes = VideoLikes - 1 WHERE VideoName = '" + VideoName + "';";
        String qu4 = "UPDATE LikesDislikesList SET Status = -1 WHERE UserName = '" + UserName + "' AND VideoName = '" + VideoName + "';";

        try{
            rs = db.execQuery(qu1);
            while(rs.next()) {
                flag = rs.getInt("Status");
            }
            if(flag == 0){
                db.execAction(qu2);
                System.out.println("User dislike added to LikesDislikesList successfully\n");

                db.execAction(qu);
                System.out.println("Video dislike incremented successfully\n");
            }
            else if(flag == 1){
                db.execAction(qu);
                System.out.println("Video dislike incremented successfully\n");

                db.execAction(qu3);
                System.out.println("Video like decremented successfully\n");

                db.execAction(qu4);
                System.out.println("User dislike added to LikesDislikesList successfully\n");
            }

            return "Successful";

        }catch(Exception e){
            System.out.println("Video dislike incrementation failed\n");
            e.printStackTrace();
            return "Unsuccessful";
        }
    }
}
