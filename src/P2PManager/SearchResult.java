package P2PManager;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.sql.ResultSet;

public class SearchResult {

    public static  String query(){
        DatabaseHandler db = DatabaseHandler.getInstance();
        PojoToClient ptc = new PojoToClient();
        ResultSet rs = null;

        String qu = "SELECT VideoName FROM VideoList WHERE Status = 1";
        try{
            rs = db.execQuery(qu);
            while (rs.next()){
                ptc.VideoName.add(rs.getString("VideoName"));
            }
            System.out.println("Video list for search query updated successfully\n");

            Gson gson = new GsonBuilder().serializeNulls().create();
            String searchList = gson.toJson(ptc);

            System.out.println("Video list for search query ready to be sent\n");

            return  searchList;

        }catch (Exception e){
            System.out.println("Video list for search query updated unsuccessfully\n");
            e.printStackTrace();
            return "Unsuccessful";
        }
    }
}
