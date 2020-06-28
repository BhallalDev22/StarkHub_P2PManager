package P2PManager;

public class RemoveFromWatchLater {

    public static String query(String UserName, String VideoName){

        DatabaseHandler db = DatabaseHandler.getInstance();

        String qu = "DELETE FROM WatchLaterList WHERE VideoName = '" + VideoName + "' AND UserName = '" + UserName + "';";

        try {
            db.execAction(qu);
            System.out.println("Video removed from watch later list successfully\n");

            return "Successful";

        }catch (Exception e){
            System.out.println("Removing video from watch later list failed\n");
            e.printStackTrace();
            return "Unsuccessful";
        }
    }
}
