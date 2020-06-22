package P2PManager;

import java.net.Socket;

public class NewClient extends Thread{
    private Socket socket;

    public NewClient(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        
    }
}
