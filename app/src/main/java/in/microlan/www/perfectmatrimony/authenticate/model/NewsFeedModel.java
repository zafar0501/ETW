package in.microlan.www.perfectmatrimony.authenticate.model;

/**
 * Created by Akshaya on 12-05-2017.
 */

public class NewsFeedModel {
    private String title, desc;
    private int icon, likeStatus;
    private String likesCount;

    public NewsFeedModel() {
    }

    public int getLikeStatus() {
        return likeStatus;
    }

    public void setLikeStatus(int likeStatus) {
        this.likeStatus = likeStatus;
    }

    public String getLikesCount() {
        return likesCount;
    }

    public void setLikesCount(String likesCount) {
        this.likesCount = likesCount;
    }

    public NewsFeedModel(String title, String desc, int icon, String likesCount, int likeStatus) {
        this.title = title;
        this.desc = desc;
        this.icon = icon;
        this.likeStatus = likeStatus;
        this.likesCount = likesCount;

    }
    public NewsFeedModel(String title, String desc, int icon) {
        this.title = title;
        this.desc = desc;
        this.icon = icon;


    }


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public int getIcon() {
        return icon;
    }

    public void setIcon(int icon) {
        this.icon = icon;
    }
}
