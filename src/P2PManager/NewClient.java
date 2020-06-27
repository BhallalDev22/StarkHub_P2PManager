package P2PManager;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class NewClient extends Thread{
    private Socket socket;
    DatabaseHandler handler = DatabaseHandler.getInstance();
    VaryingData vd = VaryingData.getInstance();
    String CurrentUserName = null;

    public NewClient(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            BufferedReader input = new BufferedReader(
                    new InputStreamReader(socket.getInputStream()));
            PrintWriter output = new PrintWriter(socket.getOutputStream(), true);

            Gson gson = new GsonBuilder().serializeNulls().create();
            String trendingVideos = gson.toJson(vd);

            output.println(trendingVideos);
            System.out.println("Trending videos sent successful\n");

            while(true) {
                String sip = input.readLine();
                if(sip.equals("exit")) {
                    break;
                }

                output.println(sip);
            }

        } catch(IOException e) {
            System.out.println("Socket IO exception!\n");
            e.printStackTrace();
        } finally {
            try {
                socket.close();
            } catch(IOException e) {
                System.out.println("Unable to close client socket!\n");
                e.printStackTrace();
            }
        }

    }
}
