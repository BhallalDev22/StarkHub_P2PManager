package P2PManager;

public class Subscribe {

    public static String query(String ChannelName, String UserName){

        DatabaseHandler db = DatabaseHandler.getInstance();

        String qu = "INSERT INTO SubscriberList (ChannelName, UserName) VALUES ('" + ChannelName + "', '" + UserName + "');";
        String qu2 = "UPDATE ChannelList SET NumberOfSubscribers = NumberOfSubscribers + 1 WHERE ChannelName = '" + ChannelName + "';";

        try {
            db.execAction(qu);
            System.out.println("User successfully subscribed to the channel\n");

            db.execAction(qu2);
            System.out.println("Number of subscribers incremented of the channel successfully\n");

            return "Successful";

        }catch (Exception e){
            System.out.println("User attempt to subscribe channel failed\n");
            e.printStackTrace();
            return "Unsuccessful";
        }
    }
}
