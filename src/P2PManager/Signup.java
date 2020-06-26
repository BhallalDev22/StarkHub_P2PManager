package P2PManager;

public class Signup {

    public static String query(String UserName, String EmailID, String Password){
        DatabaseHandler db = DatabaseHandler.getInstance();

        String qu = "INSERT INTO LoginCredentials (UserName, EmailID, Password, IPAddress) VALUES ('" + UserName + "', '" + EmailID + "', '" + Password + "');";
        try{
            db.execAction(qu);
            System.out.println("Signup action successful\n");
            return "Signup successful";
        }catch (Exception e){
            System.out.println("Signup action unsuccessful\n");
            e.printStackTrace();
            return "Signup action unsuccessful";
        }
    }
}
