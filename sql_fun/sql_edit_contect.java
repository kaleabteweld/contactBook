package sql_fun;

import Schema.Contact;

public class sql_edit_contect {
    static public boolean editData(int ContactId, Contact newContact) {

        boolean output = true;

        if (!sql_main.IsConnected) {
            sql_main.connect();
        }

        String where = "ContactId = " + ContactId;
        sql_main.UPDATEOne("Contact", Contact.attr, newContact.getAll(0), where);
        return output;
    }
}
