package P2PManager;

public class AddToWatchLater {

    public static String query(String UserName, String VideoName, String ChannelName){

        DatabaseHandler db = DatabaseHandler.getInstance();

        String qu = "INSERT INTO WatchLaterList (UserName, VideoName, ChannelName) VALUES ('" + UserName + "', '" + VideoName + "', '" + ChannelName + "');";

        try {
            db.execAction(qu);
            System.out.println("Video added to watch later successfully\n");

            return "Successful";

        }catch (Exception e){
            System.out.println("Adding video to the watch later list failed\n");
            e.printStackTrace();
            return "Unsuccessful";
        }
    }
}
