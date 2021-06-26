package Schema;

public class Contact extends User {

    User user;
    public int ContactId;
    public static String[] attr = new String[(Address.attr.length + User.attr.length)];
    static {
        System.arraycopy(User.attr, 0, attr, 0, User.attr.length);
        System.arraycopy(Address.attr, 0, attr, User.attr.length, Address.attr.length);
    }

    public Contact(User user, Address address, int ContactId) {
        super(user, address);
        this.ContactId = ContactId;
    }

    public void a() {

        System.out.println("\tuser:{\n");
        System.out.println("\t\tFirst_name: " + getFirst_name() + ",");
        System.out.println("\t\tlast_name: " + getlast_name() + ",");
        System.out.println("\t\ttelephone_number: " + getTelephone_number() + ",");
        System.out.println("\t\temail: " + getEmail() + ",");
        // System.out.println("\t}\n");
        // System.out.println("},\n");

        // System.out.println("{\n");
        System.out.println("\t\tAddress:{\n");
        System.out.println("\t\t\tregion: " + getRegion() + ",");
        System.out.println("\t\t\tcity: " + getCity() + ",");
        System.out.println("\t\t\tsub_city: " + getSub_city() + ",");
        System.out.println("\t\t\twerda: " + getWerda() + ",");
        System.out.println("\t\t\thouseNo: " + getHouseNo() + ",");
        System.out.println("\t\t}\n");
        System.out.println("\t}\n");

    }

    public void set(String attr, String value, String type) {

        if (type == "Address") {
            switch (attr) {
                case "region":
                    setRegion(value);
                    break;
                case "city":
                    setCity(value);
                    break;
                case "sub_city":
                    setSub_city(value);
                    break;
                case "werda":
                    setWerda(value);
                    break;
                case "houseNo":
                    setHouseNo(value);
                    break;
                default:
                    break;
            }
        } else if (type == "User") {
            switch (attr) {
                case "First_name":
                    setFirst_name(value);
                    break;
                case "last_name":
                    setlast_name(value);
                    ;
                    break;
                case "telephone_number":
                    setTelephone_number(value);
                    break;
                case "email":
                    setemail(value);
                    ;
                    break;
                default:
                    break;
            }
        }

    }

    public int getContactId() {
        return this.ContactId;
    }

    public void setContactId(int ContactId) {
        this.ContactId = ContactId;
    }

    public String[] getAll(int i) {

        if (i == 0) {
            String[] dat = { getFirst_name(), getlast_name(), getTelephone_number(), getEmail(), getRegion(), getCity(),
                    getSub_city(), getWerda(), getHouseNo() };
            return dat;
        } else {
            String[] data = { String.valueOf(getContactId()), getFirst_name(), getlast_name(), getTelephone_number(),
                    getEmail(), getRegion(), getCity(), getSub_city(), getWerda(), getHouseNo() };
            return data;
        }

    }
}
