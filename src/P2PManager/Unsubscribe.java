package P2PManager;

public class Unsubscribe {

    public static String query(String ChannelName, String UserName){

        DatabaseHandler db = DatabaseHandler.getInstance();

        String qu = "DELETE FROM SubscriberList WHERE ChannelName = '" + ChannelName + "' AND UserName = '" + UserName + "';";
        String qu2 = "UPDATE ChannelList SET NumberOfSubscribers = NumberOfSubscribers - 1 WHERE ChannelName = '" + ChannelName + "';";

        try {
            db.execAction(qu);
            System.out.println("User successfully unsubscribed to the channel\n");

            db.execAction(qu2);
            System.out.println("Number of subscribers decremented of the channel successfully\n");

            return "Successful";

        }catch (Exception e){
            System.out.println("User attempt to unsubscribe channel failed\n");
            e.printStackTrace();
            return "Unsuccessful";
        }
    }
}
