package ru.regulartech.SQL;


import com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException;
import org.apache.log4j.Logger;
import ru.regulartech.officeObjects.OfficeObject;

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
    private static final Logger logger = Logger.getLogger(ReportDAO.class);
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
            if (con == null){
                return null;
            }
            String sql = "SELECT * FROM finantial_report";
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next())
                result.add(new Object[]{rs.getString(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getDate(5)});

            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
            logger.error("SQL query execution errors. Error: " + e.getSQLState() + " | " + e.getErrorCode());
        } finally {
            try {
                if (ps != null)
                    ps.close();
                if (rs != null)
                    rs.close();
            } catch (Exception e){
                logger.warn("Connection was closed with errors.");
            }
        }
        return result;
    }
    public static List<OfficeObject> listAll(){
        List<OfficeObject> result = new LinkedList<OfficeObject>();
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            con = ConnectionManager.getConnection();
            if (con == null){
                return null;
            }
            String sql = "SELECT id, name, office_object_type_id FROM office_object";
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()){
                result.add(OfficeObject.loadOfficeObject(rs.getInt(1), rs.getString(2), rs.getInt(3)));
            }
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
            logger.error("SQL query execution errors. Error: " + e.getSQLState() + " | " + e.getErrorCode());
        } finally {
            try {
                if (ps != null)
                    ps.close();
                if (rs != null)
                    rs.close();
            } catch (Exception e){
                logger.warn("Connection was closed with errors.");
            }
        }
        return result;
    }

    public static OfficeObject getOfficeObject(Integer objectId) {
        OfficeObject result = null;
        ResultSet rs = null;
        PreparedStatement ps = null;

        try {
            con = ConnectionManager.getConnection();
            if (con == null){
                return null;
            }
            String sql = "SELECT id, name, office_object_type_id FROM office_object WHERE id = ".concat(objectId.toString());
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            if (rs.next()){
                result = OfficeObject.loadOfficeObject(rs.getInt(1), rs.getString(2), rs.getInt(3));
            }
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
            logger.error("SQL query execution errors. Error: " + e.getSQLState() + " | " + e.getErrorCode());
        } finally {
            try {
                if (ps != null)
                    ps.close();
                if (rs != null)
                    rs.close();
            } catch (Exception e){
                logger.warn("Connection was closed with errors.");
            }
        }
        return result;
    }

    public static void createNewReport(OfficeObject object, int operationType, Integer costs) {
        PreparedStatement ps = null;

        try {
            con = ConnectionManager.getConnection();
            if (con == null){
                return ;
            }
             //TODO: add time to data format
            String insertTableSQL = "INSERT INTO office_object_finantial(office_object_id,  finantial_types_id, cost, action_date)  VALUES (?,?,?,?)";

            ps = con.prepareStatement(insertTableSQL);
            ps.setInt(1, object.getId());
            ps.setInt(2, operationType + 1);
            ps.setInt(3, costs);
            ps.setDate(4, new Date((new java.util.Date()).getTime()));
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            logger.error("SQL query execution errors. Error: " + e.getSQLState() + " | " + e.getErrorCode());
        } finally {
            try {
                if (ps != null)
                    ps.close();
            } catch (Exception e){
                logger.warn("Connection was closed with errors.");
            }
        }
    }

    public static void setStatus(OfficeObject officeObject, Integer status) {
        PreparedStatement ps = null;

        try {
            con = ConnectionManager.getConnection();
            if (con == null){
                return ;
            }
            //TODO: add time to data format
            String insertTableSQL = "UPDATE OFFICE_OBJECT SET OFFICE_OBJECT_STATUS_ID = (?) WHERE ID = (?)";

            ps = con.prepareStatement(insertTableSQL);
            ps.setInt(1, status);
            ps.setInt(2, officeObject.getId());

            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            logger.error("SQL query execution errors. Error: " + e.getSQLState() + " | " + e.getErrorCode());
        } finally {
            try {
                if (ps != null)
                    ps.close();
            } catch (Exception e){
                logger.warn("Connection was closed with errors.");
            }
        }
    }

    public static Integer getUniqueId() {
        Integer result = null;
        ResultSet rs = null;
        PreparedStatement ps = null;

        try {
            con = ConnectionManager.getConnection();
            if (con == null){
                return null;
            }
            String sql = "SELECT max(id) + 1 FROM office_object";
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            if (rs.next()){
                result = rs.getInt(1);
            }
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
            logger.error("SQL query execution errors. Error: " + e.getSQLState() + " | " + e.getErrorCode());
        } finally {
            try {
                if (ps != null)
                    ps.close();
                if (rs != null)
                    rs.close();
            } catch (Exception e){
                logger.warn("Connection was closed with errors.");
            }
        }
        return result;
    }
    public static Integer createOfficeObject(Integer OFFICE_OBJECT_TYPE_ID){
        Integer id = getUniqueId();
        PreparedStatement ps = null;

        try {
            con = ConnectionManager.getConnection();
            if (con == null){
                return null;
            }
            //TODO: add time to data format
            String insertTableSQL = "INSERT INTO office_object(id, name, office_object_type_id, office_object_status_id)" +
                    " VALUES (?,?,?,?)";

            ps = con.prepareStatement(insertTableSQL);
            ps.setInt(1, id);
            ps.setString(2, "");
            ps.setInt(3, OFFICE_OBJECT_TYPE_ID);
            ps.setInt(4, OfficeObject.ALL_IS_OK);

            ps.executeUpdate();
        } catch (MySQLIntegrityConstraintViolationException e){
            e.printStackTrace();
        }
        catch (SQLException e) {
            e.printStackTrace();
            logger.error("SQL query execution errors. Error: " + e.getSQLState() + " | " + e.getErrorCode());
        } finally {
            try {
                if (ps != null)
                    ps.close();
            } catch (Exception e){
                logger.warn("Connection was closed with errors.");
            }
        }
        return id;
    }

    public static void createOfficeObject(Integer OFFICE_OBJECT_TYPE_ID, Integer id, String name) {
        PreparedStatement ps = null;

        try {
            con = ConnectionManager.getConnection();
            if (con == null){
                return;
            }
            //TODO: add time to data format
            String insertTableSQL = "INSERT INTO office_object(id, name, office_object_type_id, office_object_status_id)" +
                    " VALUES (?,?,?,?)";

            ps = con.prepareStatement(insertTableSQL);
            ps.setInt(1, id);
            ps.setString(2, "");
            ps.setInt(3, OFFICE_OBJECT_TYPE_ID);
            ps.setInt(4, OfficeObject.ALL_IS_OK);

            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            logger.error("SQL query execution errors. Error: " + e.getSQLState() + " | " + e.getErrorCode());
        } finally {
            try {
                if (ps != null)
                    ps.close();
            } catch (Exception e){
                logger.warn("Connection was closed with errors.");
            }
        }
    }

    public static void createOfficeObject(OfficeObject officeObject) {
        PreparedStatement ps = null;

        try {
            con = ConnectionManager.getConnection();
            if (con == null){
                return;
            }
            //TODO: add time to data format
            String insertTableSQL = "INSERT INTO office_object(id, name, office_object_type_id, office_object_status_id)" +
                    " VALUES (?,?,?,?)";

            ps = con.prepareStatement(insertTableSQL);
            ps.setInt(1, officeObject.getId());
            ps.setString(2, officeObject.getName());
            ps.setInt(3, officeObject.getType());
            ps.setInt(4, officeObject.getOfficeObjectStatusId());

            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            logger.error("SQL query execution errors. Error: " + e.getSQLState() + " | " + e.getErrorCode());
        } finally {
            try {
                if (ps != null)
                    ps.close();
            } catch (Exception e){
                logger.warn("Connection was closed with errors.");
            }
        }
    }
}
