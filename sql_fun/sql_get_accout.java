package sql_fun;

import Schema.Accout;

public class sql_get_accout {
    static public Accout getData(int AccoutId) {

        if (!sql_main.IsConnected) {
            sql_main.connect();
        }
        String where = "AccoutId='" + AccoutId + "'";
        String[] attrs = { "AccoutId", "email", "_password" };
        String[] data = sql_main.getOne("Accouts", attrs, where);
        if (data == null) {
            return null;
        }

        Accout output = new Accout(Integer.parseInt(data[0]), data[1], data[2]);

        return output;
    }
}
