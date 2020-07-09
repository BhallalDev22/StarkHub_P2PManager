package P2PManager;

import java.io.IOException;
import java.net.ServerSocket;
import java.sql.ResultSet;

public class MainServer {
    public static void main(String[] args) {

        DatabaseHandler db = DatabaseHandler.getInstance();
        VaryingData vd = VaryingData.getInstance();

        new Thread(() -> {
            String query1 = "UPDATE VideoList SET CurrentViews = 0;";
            String query2 = "SELECT VideoName, UserName, ChannelName, VideoViews, VideoPath FROM VideoList WHERE Status = 1 ORDER BY CurrentViews DESC LIMIT 9;";

            ResultSet rs;

            while(true){
                rs = db.execQuery(query2);
                try {
                    vd.Reset();
                    while (rs.next()) {
                        vd.VideoName.add(rs.getString("VideoName"));
                        vd.UserName.add(rs.getString("UserName"));
                        vd.ChannelName.add(rs.getString("ChannelName"));
                        vd.VideoViews.add(rs.getInt("VideoViews"));
                        vd.VideoPath.add(rs.getString("VideoPath"));
                    }
                    System.out.println("Trending vodeo list updated by thread\n");
                    db.execAction(query1);
                    System.out.println("CurrentViews set to 0\n");
                    Thread.sleep(3600000);
                }catch(Exception e){
                    System.out.println("No trending video found\n");
                    System.exit(0);
                    e.printStackTrace();
                }
            }
        }).start();

        try(ServerSocket serverSocket = new ServerSocket(5000)) {
            while(true) {
                new NewClient(serverSocket.accept()).start();
                System.out.println("New client connection successful\n");
            }
        } catch(IOException e) {
            System.out.println("New client connection unsuccessful\n");
            e.printStackTrace();
        }
    }
}
