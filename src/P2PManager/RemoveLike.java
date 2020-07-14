package P2PManager;

public class RemoveLike {

    public static String query(String UserName, String VideoName){

        DatabaseHandler db = DatabaseHandler.getInstance();

        String qu = "UPDATE VideoList SET VideoLikes = VideoLikes - 1 WHERE VideoName = '" + VideoName + "';";
        String qu1 = "DELETE FROM LikesDislikesList WHERE UserName = '" + UserName + "' AND VideoName = '" + VideoName + "';";

        try{

            db.execAction(qu);
            System.out.println("Video like decremented successfully\n");

            db.execAction(qu1);
            System.out.println("Use like removed from LikesDislikesList\n");

            return "Successful";

        }catch(Exception e){
            System.out.println("Video like remove failed\n");
            e.printStackTrace();
            return "Unsuccessful";
        }
    }
}
