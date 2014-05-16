package regularTech.SQL;

import regularTech.Pair;

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
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            con = DriverManager.getConnection(url, accessLogin, accessPassword);
            String sql = "SELECT * FROM finantial_report";
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next())
                result.add(new Object[]{rs.getString(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getDate(5)});\

            con.close();
        }catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (ps != null)
                    ps.close();
                if (rs != null)
                    rs.close();
            } catch (Exception e){
                // TODO: Add logger message
            }
        }
        return result;
    }
    public static List<Pair<Integer, String>> listAll(){
        List<Pair<Integer, String>> result = new LinkedList<Pair<Integer, String>>();
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            con = DriverManager.getConnection(url, accessLogin, accessPassword);
            String sql = "SELECT id, name FROM office_oject";
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()){
                result.add(new Pair(rs.getInt(1),rs.getString(2)));
            }
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (ps != null)
                    ps.close();
                if (rs != null)
                    rs.close();
            } catch (Exception e){
                // TODO: Add logger message
            }
        }
        return result;
    }

    public static OfficeObjectModel getOfficeObject(Integer objectId) {
        OfficeObjectModel result = null;
        ResultSet rs = null;
        PreparedStatement ps = null;

        try {
            con = DriverManager.getConnection(url, accessLogin, accessPassword);
            String sql = "SELECT id, name, office_oject_type_id FROM office_oject WHERE id = ".concat(objectId.toString());
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            if (rs.next()){
                result = new OfficeObjectModel(rs.getInt(1), rs.getString(2), rs.getInt(3));
            }
            con.close();
        }catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            try {
                if (ps != null)
                    ps.close();
                if (rs != null)
                    rs.close();
            } catch (Exception e){
                // TODO: Add logger message
            }
        }
        return result;
    }

    public static void createNewReport(Object curentObject, int selectedIndex, Integer finalCosts) {

    }
}
