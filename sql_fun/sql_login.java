package sql_fun;

import Schema.Accout;

public class sql_login {

    static public Accout logIN(String email, String password) {

        if (!sql_main.IsConnected) {
            sql_main.connect();
        }
        String where = "email='" + email + "' and _password='" + password + "'";
        String[] attrs = { "AccoutId", "email", "_password" };
        String[] data = sql_main.getOne("Accouts", attrs, where);
        if (data == null) {
            return null;
        }
        Accout output = new Accout(Integer.parseInt(data[0]), data[1], data[2]);

        return output;
    }

}
