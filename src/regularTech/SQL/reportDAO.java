package regularTech.SQL;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;

/**
 * Create by Votrin Andrey (votrin.andrey@caesber.ru).
 * DATE: 05.05.2014
 * TIME: 10:12
 */
public class reportDAO {
    private static String driverName;
    private static String accessLogin;
    private static String accessPassword;
    private static String url;

    static{
        //TODO: create user in DB for access to data
        driverName = "com.mysql.jdbc.Driver";
        accessLogin = "root"; //"application";
        accessPassword = "Ns5(!11PLus"; //"586945782541336";
        url = "jdbc:mysql://localhost/regulartech";
    }

    private static Connection con;

    public static List<Object[]> listReportObject() {
        List<Object[]> result = new LinkedList<Object[]>();

        try {
            con = DriverManager.getConnection(url, accessLogin, accessPassword);
            String sql = "SELECT * FROM finantial_report";
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
               // System.out.println(rs.getString(1) + " " + rs.getString(2) + " " + rs.getString(3) + " " + rs.getInt(4) + " " +  rs.getDate(5));
                result.add(new Object[]{rs.getString(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getDate(5)});

            }
            con.close();
        }catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
        };
        return result;
    }
    public static List<String> listAll(){
        List<String> result = new LinkedList<String>();

        try {
            con = DriverManager.getConnection(url, accessLogin, accessPassword);
            String sql = "SELECT name FROM office_oject";
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                result.add(rs.getString(1));
            }
            con.close();
        }catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
        }
        return result;
    }
}
