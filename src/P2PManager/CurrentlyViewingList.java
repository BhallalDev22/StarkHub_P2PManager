package P2PManager;

import java.net.Socket;
import java.util.ArrayList;
import java.util.HashSet;

public class CurrentlyViewingList {

    public static HashSet<Socket> entry = new HashSet<Socket>();
    public static ArrayList<HashSet<Socket>> currentlyViewing = new ArrayList<HashSet<Socket>>();

    public static void newEntry(){
        entry.clear();
        currentlyViewing.add(entry);
    }
}
