package P2PManager;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class NewClient extends Thread{
    private Socket socket;
    DatabaseHandler handler = DatabaseHandler.getInstance();

    public NewClient(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            BufferedReader input = new BufferedReader(
                    new InputStreamReader(socket.getInputStream()));
            PrintWriter output = new PrintWriter(socket.getOutputStream(), true);

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
