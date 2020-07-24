package P2PManager;

public class WriteComment {

    public static String query(String VideoName, String UserName, String Comment, String ChannelName){

        DatabaseHandler db = DatabaseHandler.getInstance();

        String qu = "INSERT INTO CommentList (VideoName, UserName, Comment , ChannelName) VALUES ('" + VideoName + "', '" + UserName + "', '" + Comment + "', '" + ChannelName + "');";

        try{
            db.execAction(qu);

            System.out.println("Comment inserted successfully\n");

            return "Successful";
        }catch (Exception e){
            System.out.println("Comment insertion unsuccessful\n");
            e.printStackTrace();
            return "Unsuccessful";
        }
    }
}
