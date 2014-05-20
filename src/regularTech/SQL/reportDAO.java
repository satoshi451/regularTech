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
public class ReportDAO {

    private static Connection con;

    /**
     *
     * @return
     */
    public static List<Object[]> listReportObject() {
        List<Object[]> result = new LinkedList<Object[]>();
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            con = ConnectionManager.getConnection();
            String sql = "SELECT * FROM finantial_report";
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next())
                result.add(new Object[]{rs.getString(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getDate(5)});

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
    public static List<Pair<Integer, String>> listAll(){
        List<Pair<Integer, String>> result = new LinkedList<Pair<Integer, String>>();
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            con = ConnectionManager.getConnection();
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
            con = ConnectionManager.getConnection();
            String sql = "SELECT id, name, office_oject_type_id FROM office_oject WHERE id = ".concat(objectId.toString());
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            if (rs.next()){
                result = new OfficeObjectModel(rs.getInt(1), rs.getString(2), rs.getInt(3));
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

    public static void createNewReport(OfficeObjectModel object, int operationType, Integer costs) {
        PreparedStatement ps = null;

        try {
            con = ConnectionManager.getConnection();
            String insertTableSQL = "INSERT INTO office_oject_financial(office_oject_id,  financial_types_id, cost, action_date)" +
                    " VALUES (?,?,?,?)";

            ps = con.prepareStatement(insertTableSQL);
            ps.setInt(1, object.getId());
            ps.setInt(2, operationType + 1);
            ps.setInt(3, costs);
            ps.setDate(4, new Date((new java.util.Date()).getTime()));
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (ps != null)
                    ps.close();
            } catch (Exception e){
                // TODO: Add logger message
            }
        }
    }
}
