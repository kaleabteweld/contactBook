package Schema;

public class User extends Address {
    private String First_name;
    private String last_name;
    private String telephone_number;
    private String email;

    static String[] attr = { "First_name", "last_name", "telephone_number", "email" };

    public User(String First_name, String last_name, String telephone_number, String email, Address address) {

        super(address);
        this.First_name = First_name;
        this.last_name = last_name;
        this.telephone_number = telephone_number;
        this.email = email;

    }

    public User(User user, Address address) {

        super(address);

        this.First_name = user.getFirst_name();
        this.last_name = user.getlast_name();
        this.telephone_number = user.getTelephone_number();
        this.email = user.getEmail();

    }

    // sette's
    public void setFirst_name(String First_name) {
        this.First_name = First_name;
    }

    public void setlast_name(String last_name) {
        this.last_name = last_name;
    }

    public void setTelephone_number(String telephone_number) {
        this.telephone_number = telephone_number;
    }

    public void setemail(String email) {
        this.email = email;
    }

    public void setAddress(Address address) {
        setRegion(address.getRegion());
        setCity(address.getCity());
        setSub_city(address.getSub_city());
        setWerda(address.getWerda());
        setHouseNo(address.getHouseNo());
    }

    // getter's
    public String getFirst_name() {
        return this.First_name;
    }

    public String getlast_name() {
        return this.last_name;
    }

    public String getTelephone_number() {
        return this.telephone_number;
    }

    public String getEmail() {
        return this.email;
    }
}
