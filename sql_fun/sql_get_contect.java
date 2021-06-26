package sql_fun;

import Schema.Address;
import Schema.Contact;
import Schema.User;

public class sql_get_contect {
    static public Contact getData(int ContactId) {

        if (!sql_main.IsConnected) {
            sql_main.connect();
        }
        String where = "ContactId='" + ContactId + "'";
        String[] attrs = { "First_name", "last_name", "telephone_number", "email", "region", "city", "sub_city",
                "werda", "houseNo" };
        String[] data = sql_main.getOne("Contact", attrs, where);
        if (data == null) {
            return null;
        }

        Address ad = new Address(data[4], data[5], data[6], data[7], data[8]);
        User us = new User(data[0], data[1], data[2], data[3], ad);
        Contact output = new Contact(us, ad, ContactId);

        return output;
    }
}
