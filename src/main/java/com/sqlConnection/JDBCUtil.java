package com.sqlConnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class JDBCUtil {

    public static Connection getConnection() {
        Connection result = null;
        try {
            //Cac thong so
            String url = "jdbc:mysql://localhost:3306/grocerystore?useSSL=false&serverTimezone=UTC&characterEncoding=UTF-8";
            String userName = "root";
            String password = "";
            //Tao ket noi 
            result = DriverManager.getConnection(url, userName, password);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Không thể kết nối đến cơ sở dữ liệu !", "Lỗi", JOptionPane.ERROR_MESSAGE);
        }
        return result;
    }

    public static void closeConnection(Connection c) {
        try {
            if (c != null) {
                c.close();
            }
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
    }

    // Phương thức lấy ResulSet
    public static ResultSet getResultSet(Connection conn, String query) {
        try {
            Statement stmt = conn.createStatement();
            return stmt.executeQuery(query);
        } catch (SQLException e) {
            System.err.println("Error while executing query: " + e.getMessage());
        }
        return null;
    }

    // Phương thức lấy ResultSet bằng PreparedStatement có parameter và value
    public static ResultSet getResultSet(Connection conn, String query, int parameterIndex, Object value) {

        try {
            // 1. Tạo PreparedStatement
            PreparedStatement statement = conn.prepareStatement(query);;

            // 2. Thiết lập tham số 
            statement.setObject(parameterIndex, value);

            // 3. Thực thi câu truy vấn và lấy ResultSet
            ResultSet resultSet = statement.executeQuery();

            // 4. Trả về ResultSet
            return resultSet;

        } catch (SQLException e) {
            System.err.println("Error while executing query: " + e.getMessage());
        }
        return null;
    }

    // Phương thức lấy table
    public static ResultSetMetaData getMetaData(ResultSet rs) {
        try {
            // Return metadata from ResultSet
            return rs.getMetaData();

        } catch (SQLException e) {
            System.err.println("Error while retrieving metadata: " + e.getMessage());
        }

        return null;
    }

    // Phương thức trả về PreparedStatement từ query, conn
    public static PreparedStatement getPreparedStatement(Connection conn, String query, int parameterIndex, Object value) {
        // 1. Tạo PreparedStatement
        PreparedStatement statement = null;
        try {
            statement = conn.prepareStatement(query);
            statement.setObject(parameterIndex, value);
            
            return statement;
        } catch (SQLException e) {
            System.err.println("Error while executing query: " + e.getMessage());
        }

        return null;
    }

}
