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
        accessLogin = "root";
        accessPassword = "Ns5(!11PLus";
        url = "jdbc:mysql://localhost/regulartech";
    }

    public static List<Object[]> listObjects() {
        List<Object[]> result = new LinkedList<Object[]>();

        try {
            Connection con = DriverManager.getConnection(url, accessLogin, accessPassword);
            String sql = "SELECT * FROM finantial_report";
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                System.out.println(rs.getString(1) + " " + rs.getString(2) + " " + rs.getString(3) + " " + rs.getInt(4) + rs.getDate(5));
                result.add(new Object[]{rs.getString(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getDate(5)});
            }
        }catch (SQLException e) {
            e.printStackTrace();
        }
        finally {

        };
        return result;
    }
}
