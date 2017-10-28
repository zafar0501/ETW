package in.microlan.www.perfectmatrimony.authenticate.model;

/**
 * Created by Akshaya on 16-05-2017.
 */

public class MemberDetailModel {
    private String dob;
    private String age;
    private String status;
    private String livesIn;
    private String nativePlace;
    private String education;
    private String jobDetail;
    private String title;
    private String description;

    public String getTitle() {
        return title;
    }

    public MemberDetailModel(String title, String description) {
        this.title = title;
        this.description = description;
    }

    public String getDescription() {

        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getLivesIn() {
        return livesIn;
    }

    public void setLivesIn(String livesIn) {
        this.livesIn = livesIn;
    }

    public String getNativePlace() {
        return nativePlace;
    }

    public void setNativePlace(String nativePlace) {
        this.nativePlace = nativePlace;
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    public String getJobDetail() {
        return jobDetail;
    }

    public void setJobDetail(String jobDetail) {
        this.jobDetail = jobDetail;
    }

    public MemberDetailModel(String title, String dob, String age, String status, String livesIn, String nativePlace) {
        this.dob = dob;
        this.age = age;
        this.status = status;
        this.livesIn = livesIn;
        this.nativePlace = nativePlace;
        this.title = title;
    }

    public MemberDetailModel(String title, String education, String jobDetail) {
        this.education = education;
        this.jobDetail = jobDetail;
        this.title = title;
    }
}
