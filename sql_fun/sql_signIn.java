package sql_fun;

import Schema.Accout;

public class sql_signIn {

    static public Accout signIN(String email, String password) {

        if (!sql_main.IsConnected) {
            sql_main.connect();
        }

        String[] attrs = { email, password };
        boolean ok = sql_main.putOne("Accouts", attrs);
        if (ok) {
            Accout accout = sql_login.logIN(email, password);
            if (accout != null) {
                return accout;
            } else {
                return null;
            }
        } else {
            return null;
        }

    }
}
