package P2PManager;

import java.sql.ResultSet;

public class Login {

    public static String query(String UserName, String Password, String IPAddress){
        DatabaseHandler db = DatabaseHandler.getInstance();
        ResultSet rs = null;
        String pass =  null;

        String qu = "SELECT Password FROM LoginCredentials WHERE UserName = '" + UserName + "';";
        try{
            rs = db.execQuery(qu);
            System.out.println("Login password fetch successfull\n");
            while (rs.next()){
                pass = rs.getString("Password");
            }

            if(pass == Password){
                String qu2 = "UPDATE LoginCredentials SET Status = 1, IPAddress = '" + IPAddress + "' WHERE UserName = '" + UserName + "';";
                String qu3 = "UPDATE VideoList SET Status = 1 WHERE UserName = '" + UserName + "';";
                try{
                    db.execAction(qu2);
                    db.execAction(qu3);
                    System.out.println("Login time updates successfull\n");
                }catch (Exception e){
                    System.out.println("Login time updates unsuccessfull\n");
                    e.printStackTrace();
                }
                String notificatiosList = Notifications.query(UserName);
                System.out.println("Notifications JSON created successfully\n");
                return notificatiosList;
            }
            else {
                return "Login unsuccessful";
            }
        }catch(Exception e){
            System.out.println("Login password fetch unsuccessfull\n");
            e.printStackTrace();
            return "Login unsuccessfull";
        }
    }
}
