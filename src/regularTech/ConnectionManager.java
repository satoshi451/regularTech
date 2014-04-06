package regularTech;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Create by Votrin Andrey (votrin.andrey@caesber.ru).
 * DATE: 05.04.2014
 * TIME: 22:00
 */
public class ConnectionManager {


    public static boolean getConnection(String ServerName, String Login, String Password) throws SQLException{
        Connection connection;
        boolean isAdmin = false;
        try {
            // Название драйвера
            String driverName = "com.mysql.jdbc.Driver";

            Class.forName(driverName);

            // Create a connection to the database
            String serverName = ServerName;
            String mydatabase = "regularTech";
            String url = "jdbc:mysql://" + serverName + "/" + mydatabase;
            String username = Login;
            String password = Password;

            connection = DriverManager.getConnection(url, username, password);
            System.out.println("is connect to DB" + connection);

            String query = new String("Select isAdmin FROM appUsers where login = '").concat(username).concat("' and password = '").concat(password).concat("';");
            System.out.println(query);


            Statement stmt = connection.createStatement();

            ResultSet rs = stmt.executeQuery(query);
            String dbtime = null;
            //System.out.println(rs.first());

            if(rs.next()) {
                dbtime = rs.getString(1);
                System.out.println(dbtime);
            }
            if(dbtime.equals("1"))
                isAdmin = true;
            else
                isAdmin = false;
            connection.close();
        } // end try
        catch (ClassNotFoundException e) {
            e.printStackTrace();
            // Could not find the database driver
        }

        return isAdmin;
    }
}
