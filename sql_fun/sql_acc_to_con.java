package sql_fun;

import Schema.Contact;
import Schema.Contact_book_array;

public class sql_acc_to_con {
    static public Contact_book_array getData(int AccoutId) {

        Contact_book_array output = null;

        if (!sql_main.IsConnected) {
            sql_main.connect();
        }
        String where = "AccoutId=" + String.valueOf(AccoutId);
        String[] attrs = { "AccoutId", "ContactId" };
        String[][] data = sql_main.getMany("Accouts_to_Contact", attrs, where);
        if (data == null) {
            return null;
        }

        output = new Contact_book_array();
        for (int i = 0; i != data.length; i++) {

            Contact co = sql_get_contect.getData(Integer.parseInt(data[i][1]));
            output.append(co);
            co.a();
        }

        return output;
    }
}
