package in.microlan.www.perfectmatrimony.authenticate.model;

/**
 * Created by Akshaya on 12-05-2017.
 */

public class NewsFeedModel {
    private String title, desc;
    private int icon,likeStatus;
    private String likesCount;

    public NewsFeedModel() {
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
