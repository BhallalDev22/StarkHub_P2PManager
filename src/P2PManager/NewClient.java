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
    String sf = "Successful";
    String usf = "Unsuccessful";

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

                PojoFromClient pfc = gson.fromJson(sip, PojoFromClient.class);

                if(pfc.header == 1)
                {
                    if(Signup.query(pfc.UserName, pfc.EmailID, pfc.Password) == sf)
                    {
                        output.println(sf);
                    }
                    else
                    {
                        output.println(usf);
                    }
                }
                else if(pfc.header == 2)
                {
                    String xyz = Login.query(pfc.UserName, pfc.Password, pfc.IPAddress);
                    if(xyz != usf)
                    {
                        output.println(xyz);
                    }
                    else
                    {
                        output.println(usf);
                    }
                }
                else if(pfc.header == 3)
                {
                    String xyz = SearchResult.query();
                    if(xyz != usf)
                    {
                        output.println(xyz);
                    }
                    else
                    {
                        output.println(usf);
                    }
                }
                else if(pfc.header == 4)
                {
                    String xyz = PlayVideo.query(pfc.VideoName, pfc.UserName);
                    if(xyz != usf)
                    {
                        output.println(xyz);
                    }
                    else
                    {
                        output.println(usf);
                    }
                }
                else if(pfc.header == 5)
                {
                    String xyz = ViewAccount.query(pfc.UserName);
                    if(xyz != usf)
                    {
                        output.println(xyz);
                    }
                    else
                    {
                        output.println(usf);
                    }
                }
                else if(pfc.header == 6)
                {
                    String xyz = ViewAllChannels.query(pfc.UserName);
                    if(xyz != usf)
                    {
                        output.println(xyz);
                    }
                    else
                    {
                        output.println(usf);
                    }
                }
                else if(pfc.header == 7)
                {
                    String xyz = ViewChannel.query(pfc.ChannelName);
                    if(xyz != usf)
                    {
                        output.println(xyz);
                    }
                    else
                    {
                        output.println(usf);
                    }
                }
                else if(pfc.header == 8)
                {
                    String xyz = ViewChannelVideos.query(pfc.ChannelName);
                    if(xyz != usf)
                    {
                        output.println(xyz);
                    }
                    else
                    {
                        output.println(usf);
                    }
                }
                else if(pfc.header == 9)
                {
                    String xyz = CreateChannel.query(pfc.UserName, pfc.ChannelName);
                    if(xyz != usf)
                    {
                        output.println(xyz);
                    }
                    else
                    {
                        output.println(usf);
                    }
                }
                else if(pfc.header == 10)
                {
                    String xyz = AddVideo.query(pfc.VideoName, pfc.ChannelName, pfc.VideoPath, pfc.UserName, pfc.VideoTag);
                    if(xyz != usf)
                    {
                        output.println(xyz);
                    }
                    else
                    {
                        output.println(usf);
                    }
                }
                else if(pfc.header == 11)
                {
                    String xyz = WatchHistory.query(pfc.UserName);
                    if(xyz != usf)
                    {
                        output.println(xyz);
                    }
                    else
                    {
                        output.println(usf);
                    }
                }
                else if(pfc.header == 12)
                {
                    String xyz = CommentHistory.query(pfc.UserName);
                    if(xyz != usf)
                    {
                        output.println(xyz);
                    }
                    else
                    {
                        output.println(usf);
                    }
                }
                else if(pfc.header == 13)
                {
                    String xyz = ViewSubscribedChannels.query(pfc.UserName);
                    if(xyz != usf)
                    {
                        output.println(xyz);
                    }
                    else
                    {
                        output.println(usf);
                    }
                }
                else if(pfc.header == 14)
                {
                    String xyz = LikeVideo.query(pfc.VideoName);
                    if(xyz != usf)
                    {
                        output.println(xyz);
                    }
                    else
                    {
                        output.println(usf);
                    }
                }
                else if(pfc.header == 15)
                {
                    String xyz = DislikeVideo.query(pfc.VideoName);
                    if(xyz != usf)
                    {
                        output.println(xyz);
                    }
                    else
                    {
                        output.println(usf);
                    }
                }
                else if(pfc.header == 16)
                {
                    String xyz = WriteComment.query(pfc.VideoName, pfc.UserName, pfc.Comment);
                    if(xyz != usf)
                    {
                        output.println(xyz);
                    }
                    else
                    {
                        output.println(usf);
                    }
                }
                else if(pfc.header == 17)
                {
                    String xyz = Subscribe.query(pfc.ChannelName, pfc.UserName);
                    if(xyz != usf)
                    {
                        output.println(xyz);
                    }
                    else
                    {
                        output.println(usf);
                    }
                }
                else if(pfc.header == 18)
                {
                    String xyz = Unsubscribe.query(pfc.ChannelName, pfc.UserName);
                    if(xyz != usf)
                    {
                        output.println(xyz);
                    }
                    else
                    {
                        output.println(usf);
                    }
                }
                else if(pfc.header == 19)
                {
                    String xyz = AddToWatchLater.query(pfc.UserName, pfc.VideoName, pfc.ChannelName);
                    if(xyz != usf)
                    {
                        output.println(xyz);
                    }
                    else
                    {
                        output.println(usf);
                    }
                }
                else if(pfc.header == 20)
                {
                    String xyz = RemoveFromWatchLater.query(pfc.UserName, pfc.VideoName);
                    if(xyz != usf)
                    {
                        output.println(xyz);
                    }
                    else
                    {
                        output.println(usf);
                    }
                }
                else if(pfc.header == 21)
                {
                    String xyz = MainExit.query(pfc.UserName);
                    if(xyz != usf)
                    {
                        output.println(xyz);
                    }
                    else
                    {
                        output.println(usf);
                    }
                }
                else if(pfc.header == 22)
                {
                    String xyz = ViewWatchLater.query(pfc.UserName);
                    if(xyz != usf)
                    {
                        output.println(xyz);
                    }
                    else
                    {
                        output.println(usf);
                    }
                }
                else if(pfc.header == 23)
                {
                    String xyz = DeleteVideo.query(pfc.ChannelName, pfc.VideoName);
                    if(xyz != usf)
                    {
                        output.println(xyz);
                    }
                    else
                    {
                        output.println(usf);
                    }
                }

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
