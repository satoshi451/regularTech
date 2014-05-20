package regularTech.SQL;

import regularTech.Main;

import java.io.*;
import java.sql.*;
import java.util.Properties;

/**
 * Create by Votrin Andrey (votrin.andrey@caesber.ru).
 * DATE: 05.04.2014
 * TIME: 22:00
 */
public class ConnectionManager {
    // TODO: create user in database kile this: 'create user application identified by password'
    private static String driverName;
    private static String serverName;
    private static String mydatabase;
    private static String DBPassword;
    private static String DBUser;
    private static Properties properties;
    private static String port;

    private final static String propertiesFileName = "config.properties";
    static{
        driverName = "com.mysql.jdbc.Driver";
        mydatabase = "regularTech";
        DBPassword = "Ns5(!11PLus";
        DBUser = "root";
        try {
            loadConfig();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    // TODO: May be needs to make metho private?...
    public static void loadConfig() throws IOException {
        properties = new Properties();
        InputStream input = null; //Main.class.getClassLoader().getResourceAsStream(propertiesFileName);
        String path = Main.class.getProtectionDomain().getCodeSource().getLocation().getPath();
        path += propertiesFileName;
        System.out.println(path);

        input = new FileInputStream(path);

        if(input == null){
            // TODO: add logger warning
            return;
        }
        properties.load(input);

        driverName = properties.getProperty("driver");
        mydatabase = properties.getProperty("database");
        DBPassword = properties.getProperty("password");
        port = properties.getProperty("port");
        DBUser = properties.getProperty("username");

        if(port != null)
            if(Integer.parseInt(port) != 0)
                serverName += port;

        try {
            input.close();
        } catch (IOException e) {
            // TODO: add logger
            e.printStackTrace();
        }

    }
    public static Connection getConnection(){
        Connection connection = null;
        try {
            Class.forName(driverName);

            String url = "jdbc:mysql://" + serverName + "/" + mydatabase;

            System.out.println(url);

            connection = DriverManager.getConnection(url, DBUser, DBPassword);
            } catch (SQLException e) {
                // TODO: change to logger
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        return connection;
    }
    public static Boolean getConnection(String ServerName, String Login, String Password) throws SQLException{
        Connection connection = null;
        Statement stmt = null;
        ResultSet rs = null;
        boolean isAdmin = false;
        Boolean isConnected = false;
        try {
            Class.forName(driverName);
            serverName = ServerName;

            String url = "jdbc:mysql://" + serverName + "/" + mydatabase;

            System.out.println(url);

            connection = DriverManager.getConnection(url, DBUser, DBPassword);
            System.out.println("is connect to DB" + connection);

            String query = "Select isAdmin FROM appUsers where login = '".concat(Login).concat("' and password = '").concat(Password).concat("';");
            System.out.println(query);

            stmt = connection.createStatement();
            rs = stmt.executeQuery(query);
            String dbtime = null;

            if(rs.next()) {
                dbtime = rs.getString(1);
                System.out.println(dbtime);
                isConnected = true;
            }
            if(dbtime != null) {
                if (dbtime.equals("1"))
                    isAdmin = true;
                else
                    isAdmin = false;
            }
            connection.close();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            // Could not find the database driver
        } finally {
            try {
                if (stmt != null)
                    stmt.close();
                if (rs != null)
                    rs.close();
            } catch (Exception e){
                // TODO: Add logger message
            }
        }

        if (!isConnected)
            return null;
        else
            return isAdmin;
    }
}
