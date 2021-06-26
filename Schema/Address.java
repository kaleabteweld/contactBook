package Schema;

public class Address {
    private String region;
    private String city;
    private String sub_city;
    private String werda;
    private String houseNo;

    static String[] attr = { "region", "city", "sub_city", "werda", "houseNo" };

    public Address(String region, String city, String sub_city, String werda, String houseNo) {

        this.region = region;
        this.city = city;
        this.sub_city = sub_city;
        this.werda = werda;
        this.houseNo = houseNo;
    }

    public Address(Address address) {

        this.region = address.region;
        this.city = address.city;
        this.sub_city = address.sub_city;
        this.werda = address.werda;
        this.houseNo = address.houseNo;
    }

    // sette's
    public void setRegion(String region) {
        this.region = region;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setSub_city(String sub_city) {
        this.sub_city = sub_city;
    }

    public void setWerda(String werda) {
        this.werda = werda;
    }

    public void setHouseNo(String houseNo) {
        this.houseNo = houseNo;
    }

    // getter's
    public String getRegion() {
        return this.region;
    }

    public String getCity() {
        return this.city;
    }

    public String getSub_city() {
        return this.sub_city;
    }

    public String getWerda() {
        return this.werda;
    }

    public String getHouseNo() {
        return this.houseNo;
    }
}
