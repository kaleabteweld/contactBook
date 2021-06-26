package sql_fun;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class sql_main {

    final static String databaseName = "ContactBook";
    final static String url = "jdbc:sqlserver://localhost;databaseName=" + databaseName + ";";
    final static String user = "pain";
    final static String password = "pain";

    // sql shi...
    static Connection dbConnection;
    static boolean IsConnected = false;

    public static boolean connect() {

        try {

            dbConnection = DriverManager.getConnection(url, user, password);

            if (dbConnection != null) {
                IsConnected = true;
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public static String[] getOne(String Table, String[] atts, String where) {

        if (!IsConnected) {
            connect();
        }

        String[] output = null;
        String query = "select ";

        for (int i = 0; i < atts.length; i++) {

            query += atts[i];
            if (i < atts.length - 1) {
                query += ",";
            }
        }

        query += " from " + Table + " where " + where;
        System.out.println("getOne query: " + query);
        try {

            Statement statement = dbConnection.createStatement();
            ResultSet res = statement.executeQuery(query);

            if (res.next()) {
                int i = 1;
                output = new String[atts.length];
                while (i != atts.length + 1) {
                    output[i - 1] = res.getString(i);
                    i++;
                }
            }

            return output;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }

    public static int getLen(String Table, String[] atts, String where) {
        if (!IsConnected) {
            connect();
        }
        int output = -1;
        String query = "select COUNT(" + atts[0] + ") as 'rowcount' from " + Table + " where " + where;
        System.out.println("getLen query: " + query);
        try {

            Statement statement = dbConnection.createStatement();
            ResultSet res = statement.executeQuery(query);

            if (res.next()) {
                output = res.getInt("rowcount");
            }

            return output;
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }

    }

    public static String[][] getMany(String Table, String[] atts, String where) {

        if (!IsConnected) {
            connect();
        }
        String[] output = null;
        String query = "select ";

        for (int i = 0; i < atts.length; i++) {

            query += atts[i];
            if (i < atts.length - 1) {
                query += ",";
            }
        }

        query += " from " + Table + " where " + where;
        System.out.println("getMany query: " + query);
        try {

            Statement statement = dbConnection.createStatement();
            ResultSet res = statement.executeQuery(query);

            int size = getLen(Table, atts, where);
            String[][] main_output = new String[size][atts.length];

            int j = 0;
            while (res.next()) {

                int i = 1;
                output = new String[atts.length];
                while (i != atts.length + 1) {
                    output[i - 1] = res.getString(i);
                    i++;
                }
                main_output[j] = output;
                j++;
            }

            return main_output;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }

    public static boolean putOne(String Table, String[] VALUES) {

        if (!IsConnected) {
            connect();
        }
        boolean output = false;
        String query = "INSERT INTO " + Table + " VALUES (";

        for (int i = 0; i < VALUES.length; i++) {

            query += "'" + VALUES[i] + "'";

            if (i < VALUES.length - 1) {
                query += ",";
            }
        }
        query += ");";
        System.out.println("putOne query: " + query);
        try {

            Statement statement = dbConnection.createStatement();
            statement.execute(query);
            return true;
            // while (res.next()) {
            // for (int i = 0; i != VALUES.length; i++) {
            // output = output + " " + res.getString(i);
            // }
            // break;
            // }
        } catch (Exception e) {
            e.printStackTrace();
            return output;
        }

    }

    public static boolean removeOne(String Table, String where) {

        if (!IsConnected) {
            connect();
        }
        boolean output = false;
        String query = "delete from " + Table + " WHERE " + where;
        System.out.println("removeOne query: " + query);
        try {

            Statement statement = dbConnection.createStatement();
            statement.execute(query);
            return true;
            // while (res.next()) {
            // for (int i = 0; i != VALUES.length; i++) {
            // output = output + " " + res.getString(i);
            // }
            // break;
            // }
        } catch (Exception e) {
            e.printStackTrace();
            return output;
        }

    }

    public static boolean UPDATEOne(String Table, String[] VALUES_attr, String[] VALUES, String where) {

        if (!IsConnected) {
            connect();
        }
        boolean output = false;

        String query = "UPDATE " + Table + " SET ";

        for (int i = 0; i < VALUES_attr.length; i++) {

            query += VALUES_attr[i] + " = '" + VALUES[i] + "'";

            if (i < VALUES_attr.length - 1) {
                query += ",";
            }
        }
        query += " WHERE " + where;
        System.out.println("UPDATEOne query: " + query);
        try {

            Statement statement = dbConnection.createStatement();
            statement.execute(query);
            return true;
            // while (res.next()) {
            // for (int i = 0; i != VALUES.length; i++) {
            // output = output + " " + res.getString(i);
            // }
            // break;
            // }
        } catch (Exception e) {
            e.printStackTrace();
            return output;
        }

    }

}