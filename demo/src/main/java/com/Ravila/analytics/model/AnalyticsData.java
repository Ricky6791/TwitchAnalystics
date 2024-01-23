public class AnalyticsData {
	private int streamViews;
	private int chatActivity;
	private int followerGrowth;

	// constructors, getters and setters
    public AnalyticsData() {
        // default constructor
    }

    public AnalyticsData(int streamViews, int chatActivity, int followerGrowth) {
        this.streamViews = streamViews;
        this.chatActivity = chatActivity;
        this.followerGrowth = followerGrowth;
    }

    public int getStreamViews() {
        return streamViews;
    }

    public void setStreamViews(int streamViews) {
        this.streamViews = streamViews;
    }

    public int getChatActivity() {
        return chatActivity;
    }

    public void setChatActivity(int chatActivity) {
        this.chatActivity = chatActivity;
    }

    public int getFollowerGrowth() {
        return followerGrowth;
    }

    public void setFollowerGrowth(int followerGrowth) {
        this.followerGrowth = followerGrowth;
    }
}