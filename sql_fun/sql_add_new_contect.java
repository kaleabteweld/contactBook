package sql_fun;

import Schema.Contact;

public class sql_add_new_contect {

    static public Contact addData(Contact contact, int AccoutId) {

        Contact output = null;

        if (!sql_main.IsConnected) {
            sql_main.connect();
        }

        String[] VALUES = new String[contact.getAll(2).length - 1];
        System.arraycopy(contact.getAll(2), 1, VALUES, 0, contact.getAll(2).length - 1);
        sql_main.putOne("Contact", VALUES);

        String where = "First_name='" + VALUES[0] + "' and last_name='" + VALUES[1] + "' and telephone_number='"
                + VALUES[2] + "' and email='" + VALUES[3] + "'";
        String[] attrs = { "ContactId" };
        String[] data = sql_main.getOne("Contact", attrs, where);

        output = sql_fun.sql_get_contect.getData(Integer.parseInt(data[0]));

        String a[] = { String.valueOf(AccoutId), String.valueOf(output.getContactId()) };
        sql_main.putOne("Accouts_to_Contact", a);

        // String where = "AccoutId=" + String.valueOf(AccoutId);
        // String[] attrs = { "AccoutId", "ContactId" };
        // String[][] data = sql_main.getMany("Accouts_to_Contact", attrs, where);
        // if (data == null) {
        // return null;
        // }

        // output = new Contact_book_array();
        // for (int i = 0; i != data.length; i++) {

        // Contact co = sql_get_contect.getData(Integer.parseInt(data[i][0]));
        // output.append(co);
        // co.a();
        // }

        return output;
    }

}
