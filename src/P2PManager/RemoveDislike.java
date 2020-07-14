package P2PManager;

public class RemoveDislike {

    public static String query(String UserName, String VideoName){

        DatabaseHandler db = DatabaseHandler.getInstance();

        String qu = "UPDATE VideoList SET VideoDislikes = VideoDislikes - 1 WHERE VideoName = '" + VideoName + "';";
        String qu1 = "DELETE FROM LikesDislikesList WHERE UserName = '" + UserName + "' AND VideoName = '" + VideoName + "';";

        try{

            db.execAction(qu);
            System.out.println("Video dislike decremented successfully\n");

            db.execAction(qu1);
            System.out.println("User dislike removed from LikesDislikesList\n");

            return "Successful";

        }catch(Exception e){
            System.out.println("Video dislike remove failed\n");
            e.printStackTrace();
            return "Unsuccessful";
        }
    }
}
