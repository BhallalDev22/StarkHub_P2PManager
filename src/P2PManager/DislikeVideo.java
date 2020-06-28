package P2PManager;

public class DislikeVideo {

    public static String query(String VideoName){

        DatabaseHandler db = DatabaseHandler.getInstance();

        String qu = "UPDATE VideoList SET VideoDislikes = VideoDislikes + 1 WHERE VideoName = '" + VideoName + "';";

        try{
            db.execAction(qu);

            System.out.println("Video dislike incremented successfully\n");

            return "Successful";

        }catch(Exception e){
            System.out.println("Video dislike incrementation failed\n");
            e.printStackTrace();
            return "Unsuccessful";
        }
    }
}
