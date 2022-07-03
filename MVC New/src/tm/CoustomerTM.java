package tm;

public class CoustomerTM {
    private String id;
    private String title;
    private String adress;
    private String name;
    private String province;
    private String city;
    private String postalCode;

    public CoustomerTM() {
    }

    public CoustomerTM(String id, String title, String adress, String name, String province, String city, String postalCode) {
        this.id = id;
        this.title = title;
        this.adress = adress;
        this.name = name;
        this.province = province;
        this.city = city;
        this.postalCode = postalCode;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    @Override
    public String toString() {
        return "CoustomerTM{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", adress='" + adress + '\'' +
                ", name='" + name + '\'' +
                ", province='" + province + '\'' +
                ", city='" + city + '\'' +
                ", postalCode='" + postalCode + '\'' +
                '}';
    }
}
