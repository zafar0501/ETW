package in.microlan.www.perfectmatrimony.authenticate.model;

/**
 * Created by zafarhussain on 09/11/17.
 */

public class UserProfileInfoModel {

    private String User_Name;
    private String User_icon_url;
    private String User_Qualification;
    private String User_Age;
    private String User_Height;
    private String User_Weight;



    public String getUser_Name() {
        return User_Name;
    }

    public void setUser_Name(String user_Name) {
        User_Name = user_Name;
    }

    public String getUser_Qualification() {
        return User_Qualification;
    }

    public void setUser_Qualification(String user_Qualification) {
        User_Qualification = user_Qualification;
    }

    public String getUser_Age() {
        return User_Age;
    }

    public void setUser_Age(String user_Age) {
        User_Age = user_Age;
    }

    public String getUser_Height() {
        return User_Height;
    }

    public void setUser_Height(String user_Height) {
        User_Height = user_Height;
    }

    public String getUser_Weight() {
        return User_Weight;
    }

    public void setUser_Weight(String user_Weight) {
        User_Weight = user_Weight;
    }


    public String getUser_icon_url() {
        return User_icon_url;
    }

    public void setUser_icon_url(String user_icon_url) {
        User_icon_url = user_icon_url;
    }


    public UserProfileInfoModel(String user_Name, String user_Age, String user_Height, String user_Weight, String user_Qualification,String user_icon_url) {
        User_icon_url=user_icon_url;
        User_Name = user_Name;
        User_Qualification = user_Qualification;
        User_Age = user_Age;
        User_Height = user_Height;
        User_Weight = user_Weight;

    }


}