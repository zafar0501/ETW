package in.microlan.www.perfectmatrimony.authenticate.model;

/**
 * Created by zafarhussain on 05/11/17.
 */

public class MyMatrimonyModel {

    private String Name, Age;
    private String icon_url;

    public MyMatrimonyModel(String name, String age,String icon_url) {
        Name = name;
        Age = age;
        this.icon_url = icon_url;
    }


    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getAge() {
        return Age;
    }

    public void setAge(String age) {
        Age = age;
    }
    public String getIcon_url() {return icon_url;}

    public void setIcon_url(String icon_url) {this.icon_url = icon_url;}


}
