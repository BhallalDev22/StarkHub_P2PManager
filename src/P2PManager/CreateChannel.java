package P2PManager;

public class CreateChannel {

    public static String query(String UserName, String ChannelName){
        DatabaseHandler db = DatabaseHandler.getInstance();

        String qu = "INSERT INTO ChannelList (ChannelName, UserName) VALUES ('" + ChannelName + "', '" + UserName + "');";

        try{
            db.execAction(qu);
            System.out.println("Channel created successfully\n");
            return "Successful";
        }catch (Exception e){
            System.out.println("Channel creation unsuccessful\n");
            e.printStackTrace();
            return "Unsuccessful";
        }
    }
}
