package P2PManager;

import java.io.IOException;
import java.net.ServerSocket;

public class MainServer {
    public static void main(String[] args) {

        new Thread(() -> {
            DatabaseHandler.getInstance();
        }).start();

        try(ServerSocket serverSocket = new ServerSocket(5000)) {
            while(true) {
                new NewClient(serverSocket.accept()).start();
                System.out.println("New client connection successful");
            }
        } catch(IOException e) {
            System.out.println("New client connection unsuccessful");
            e.printStackTrace();
        }
    }
}
