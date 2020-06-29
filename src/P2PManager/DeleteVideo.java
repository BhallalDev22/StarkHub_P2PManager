package P2PManager;

public class DeleteVideo {

    public static String query(String ChannelName ,String VideoName){

        DatabaseHandler db = DatabaseHandler.getInstance();

        String qu = "DELETE FROM VideoList WHERE VideoName = '" + VideoName + "';";
        String qu2 = "UPDATE ChannelList SET NumberOfVideos = NumberOfVideos - 1 WHERE ChannelName = '" + ChannelName + "';";
        String qu3 = "DELETE FROM CommentList WHERE VideoName = '" + VideoName + "';";
        String qu4 = "DELETE FROM WatchLaterList WHERE VideoName = '" + VideoName + "';";
        String qu5 = "DELETE FROM WatchHistory WHERE VideoName = '" + VideoName + "';";

        try {
            db.execAction(qu);
            System.out.println("Video details removed from video list successfully\n");

            db.execAction(qu2);
            System.out.println("Decremented number of videos in channel list successfully\n");

            db.execAction(qu3);
            System.out.println("Video comments removed from comment list successfully\n");

            db.execAction(qu4);
            System.out.println("Video details removed from watch later list successfully\n");

            db.execAction(qu5);
            System.out.println("Video details removed from watch history list successfully\n");

            return "Successful";

        }catch (Exception e){
            System.out.println("Failed to delete video\n");
            e.printStackTrace();
            return "Unsuccessful";
        }
    }
}
