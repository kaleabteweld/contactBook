package Schema;

public class Accout {

    private int AccoutId;
    private String email;
    private String _password;

    public Accout(int AccoutId, String email, String _password) {

        this.AccoutId = AccoutId;
        this.email = email;
        this._password = _password;
    }

    public Accout(Accout accout) {

        this.AccoutId = accout.getAccoutId();
        this.email = accout.getemail();
        this._password = accout.get_password();
    }

    // sette's
    public void setAccoutId(int AccoutId) {
        this.AccoutId = AccoutId;
    }

    public void setemail(String email) {
        this.email = email;
    }

    public void set_password(String _password) {
        this._password = _password;
    }

    // getter's
    public int getAccoutId() {
        return this.AccoutId;
    }

    public String getemail() {
        return this.email;
    }

    public String get_password() {
        return this._password;
    }

    public void a() {

        if (getemail() == null) {
            System.out.println("not Set");
        } else {
            System.out.println("\nAccout:{");
            System.out.println("\tAccoutId: " + getAccoutId() + ",");
            System.out.println("\temail: " + getemail() + ",");
            System.out.println("\t_password: " + get_password() + ",");
            System.out.println("}");
        }

    }
}
