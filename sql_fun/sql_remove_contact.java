package sql_fun;

public class sql_remove_contact {

    static public boolean RemoveData(int ContactId, int AccoutId) {

        // boolean output = false;

        if (!sql_main.IsConnected) {
            sql_main.connect();
        }

        String where = "ContactId=" + String.valueOf(ContactId);
        sql_main.removeOne("Contact", where);

        where = "ContactId=" + String.valueOf(ContactId) + " and AccoutId=" + String.valueOf(AccoutId);
        sql_main.removeOne("Accouts_to_Contact", where);

        return true;
    }

}