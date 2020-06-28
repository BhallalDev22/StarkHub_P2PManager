package P2PManager;

public class MainExit {

    public static String query(String UserName){
        DatabaseHandler db = DatabaseHandler.getInstance();

        String qu = "LoginCredentials SET Status = 0 WHERE UserName = '" + UserName + "';";
        String qu2 = "UPDATE VideoList SET Status = 0 WHERE UserName = '" + UserName + "';";

        try {
            db.execAction(qu);
            System.out.println("User status in login table set to 0 successfully\n");

            db.execAction(qu2);
            System.out.println("Video status in video list table set to 0 successfully\n");

            return "Successful;";

        }catch (Exception e){
            System.out.println("Logout actions completion failed\n");
            e.printStackTrace();
            return "Unsuccessful";

        }
    }
}
