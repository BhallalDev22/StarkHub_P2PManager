package P2PManager;

public class LikeVideo {

    public static String query(String VideoName){

        DatabaseHandler db = DatabaseHandler.getInstance();

        String qu = "UPDATE VideoList SET VideoLikes = VideoLikes + 1 WHERE VideoName = '" + VideoName + "';";

        try{
            db.execAction(qu);

            System.out.println("Video like incremented successfully\n");

            return "Successful";

        }catch(Exception e){
            System.out.println("Video like incrementation failed\n");
            e.printStackTrace();
            return "Unsuccessful";
        }
    }
}
