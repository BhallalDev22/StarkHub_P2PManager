package P2PManager;

import java.util.ArrayList;

public class PojoToClient {
    private String UserName;
    private String EmailID;
    private String Password;
    private String IPAddress;
    private int status;
    private String AccountCreationTime;
    ArrayList<String> ChannelName = new ArrayList<String>();
    ArrayList<String> ChannelCreationTime = new ArrayList<String>();
    ArrayList<String> ChannelActiveTime = new ArrayList<String>();
    ArrayList<String> VideoName = new ArrayList<String>();
    ArrayList<String> VideoTag = new ArrayList<String>();
    ArrayList<String> VideoViews = new ArrayList<String>();
    private int VideoLikes;
    private int VideoDislikes;
    ArrayList<String> VideoCreationTime = new ArrayList<String>();
    ArrayList<String> Comment = new ArrayList<String>();
    ArrayList<String> CommentTime = new ArrayList<String>();
    ArrayList<String> CommentLikes = new ArrayList<String>();
    ArrayList<String> CommentDislikes = new ArrayList<String>();
    ArrayList<String> SubscribeTime = new ArrayList<String>();
    ArrayList<String> WatchLaterTime = new ArrayList<String>();
    ArrayList<String> WatchTime = new ArrayList<String>();
    ArrayList<String> ChannelRating = new ArrayList<String>();
    ArrayList<String> NumberOfSubscribers = new ArrayList<String>();
    ArrayList<String> NumberOfVideos = new ArrayList<String>();
    private int NumberOfComments;

    public String getUserName() {
        return UserName;
    }

    public void setUserName(String userName) {
        UserName = userName;
    }

    public String getEmailID() {
        return EmailID;
    }

    public void setEmailID(String emailID) {
        EmailID = emailID;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public String getIPAddress() {
        return IPAddress;
    }

    public void setIPAddress(String IPAddress) {
        this.IPAddress = IPAddress;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getAccountCreationTime() {
        return AccountCreationTime;
    }

    public void setAccountCreationTime(String accountCreationTime) {
        AccountCreationTime = accountCreationTime;
    }

    public ArrayList<String> getChannelName() {
        return ChannelName;
    }

    public void setChannelName(ArrayList<String> channelName) {
        ChannelName = channelName;
    }

    public ArrayList<String> getChannelCreationTime() {
        return ChannelCreationTime;
    }

    public void setChannelCreationTime(ArrayList<String> channelCreationTime) {
        ChannelCreationTime = channelCreationTime;
    }

    public ArrayList<String> getChannelActiveTime() {
        return ChannelActiveTime;
    }

    public void setChannelActiveTime(ArrayList<String> channelActiveTime) {
        ChannelActiveTime = channelActiveTime;
    }

    public ArrayList<String> getVideoName() {
        return VideoName;
    }

    public void setVideoName(ArrayList<String> videoName) {
        VideoName = videoName;
    }

    public ArrayList<String> getVideoTag() {
        return VideoTag;
    }

    public void setVideoTag(ArrayList<String> videoTag) {
        VideoTag = videoTag;
    }

    public ArrayList<String> getVideoViews() {
        return VideoViews;
    }

    public void setVideoViews(ArrayList<String> videoViews) {
        VideoViews = videoViews;
    }

    public int getVideoLikes() {
        return VideoLikes;
    }

    public void setVideoLikes(int videoLikes) {
        VideoLikes = videoLikes;
    }

    public int getVideoDislikes() {
        return VideoDislikes;
    }

    public void setVideoDislikes(int videoDislikes) {
        VideoDislikes = videoDislikes;
    }

    public ArrayList<String> getVideoCreationTime() {
        return VideoCreationTime;
    }

    public void setVideoCreationTime(ArrayList<String> videoCreationTime) {
        VideoCreationTime = videoCreationTime;
    }

    public ArrayList<String> getComment() {
        return Comment;
    }

    public void setComment(ArrayList<String> comment) {
        Comment = comment;
    }

    public ArrayList<String> getCommentTime() {
        return CommentTime;
    }

    public void setCommentTime(ArrayList<String> commentTime) {
        CommentTime = commentTime;
    }

    public ArrayList<String> getCommentLikes() {
        return CommentLikes;
    }

    public void setCommentLikes(ArrayList<String> commentLikes) {
        CommentLikes = commentLikes;
    }

    public ArrayList<String> getCommentDislikes() {
        return CommentDislikes;
    }

    public void setCommentDislikes(ArrayList<String> commentDislikes) {
        CommentDislikes = commentDislikes;
    }

    public ArrayList<String> getSubscribeTime() {
        return SubscribeTime;
    }

    public void setSubscribeTime(ArrayList<String> subscribeTime) {
        SubscribeTime = subscribeTime;
    }

    public ArrayList<String> getWatchLaterTime() {
        return WatchLaterTime;
    }

    public void setWatchLaterTime(ArrayList<String> watchLaterTime) {
        WatchLaterTime = watchLaterTime;
    }

    public ArrayList<String> getWatchTime() {
        return WatchTime;
    }

    public void setWatchTime(ArrayList<String> watchTime) {
        WatchTime = watchTime;
    }

    public ArrayList<String> getChannelRating() {
        return ChannelRating;
    }

    public void setChannelRating(ArrayList<String> channelRating) {
        ChannelRating = channelRating;
    }

    public ArrayList<String> getNumberOfSubscribers() {
        return NumberOfSubscribers;
    }

    public void setNumberOfSubscribers(ArrayList<String> numberOfSubscribers) {
        NumberOfSubscribers = numberOfSubscribers;
    }

    public ArrayList<String> getNumberOfVideos() {
        return NumberOfVideos;
    }

    public void setNumberOfVideos(ArrayList<String> numberOfVideos) {
        NumberOfVideos = numberOfVideos;
    }

    public int getNumberOfComments() {
        return NumberOfComments;
    }

    public void setNumberOfComments(int numberOfComments) {
        NumberOfComments = numberOfComments;
    }
}
