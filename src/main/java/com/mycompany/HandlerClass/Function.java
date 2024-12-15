/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.HandlerClass;

import static com.sqlConnection.JDBCUtil.getConnection;
import java.awt.Color;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import javax.swing.*;

/**
 *
 * @author Vu Khoa
 */
public class Function {

    public static String[] getColumnName(ResultSetMetaData rd) throws SQLException {
        int columnCount = rd.getColumnCount();

        String[] columnName = new String[columnCount];
        for (int i = 0; i < columnCount; i++) {
            columnName[i] = rd.getColumnName(i + 1);
        }

        return columnName;
    }

    // Lệnh kiểm tra TF có trống không nếu trống thì hiện màu đỏ
    public static boolean checkTextField(JTextField textField) {
        if (textField.getText().isEmpty()) {
            textField.setBackground(new Color(254, 128, 127));
            return false;
        } else {
            textField.setBackground(Color.WHITE);
            return true;
        }
    }

    //Lệnh random chuỗi 10 ký tự
    public static String generateRandomString(int length) {
        // Danh sách các ký tự có thể có trong chuỗi
        String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";

        Random random = new Random();
        StringBuilder sb = new StringBuilder(length);

        for (int i = 0; i < length; i++) {
            int randomIndex = random.nextInt(characters.length());
            char randomChar = characters.charAt(randomIndex);
            sb.append(randomChar);
        }

        return sb.toString();
    }

    public static String generateUniqueRandomString(Connection connection, String tableName, String columnName, int length) throws SQLException {
        String randomString;
        boolean isDuplicate;

        do {
            isDuplicate = false;
            randomString = generateRandomString(length);

            // 3. Kiểm tra xem chuỗi đã tồn tại trong cơ sở dữ liệu chưa
            String sql = "SELECT COUNT(*) FROM " + tableName + " WHERE " + columnName + " = ?";
            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                statement.setString(1, randomString);
                ResultSet resultSet = statement.executeQuery();
                resultSet.next();
                int count = resultSet.getInt(1);

                if (count > 0) {
                    isDuplicate = true;
                }

                resultSet.close();
            }

        } while (isDuplicate);

        return randomString;
    }

    // Hàm tính tổng tiền và cập nhật lại label
    @SuppressWarnings("empty-statement")
    public static void updateTotalPrice(JTable table, int columnNumber, JLabel totalLabel) {
        long totalPrice = 0;

        // Duyệt qua tất cả các dòng và tính tổng tiền (Số lượng * Giá)
        for (int i = 0; i < table.getRowCount(); i++) {
            totalPrice += (long) table.getValueAt(i, columnNumber);;  // Cộng tổng tiền
        }

        // Định dạng tiền tệ
        NumberFormat currencyFormat = NumberFormat.getInstance();
        String formattedTotalPrice = currencyFormat.format(totalPrice);

        // Cập nhật lại label với tổng tiền được định dạng
        totalLabel.setText(formattedTotalPrice);
    }

    public static String dinhDangTien(long totalPrice) {
        NumberFormat currencyFormat = NumberFormat.getInstance();
        String formattedTotalPrice = currencyFormat.format(totalPrice);
        return formattedTotalPrice;
    }

    public static List<String> timKiemTenNCC(String tuKhoa) {
        List<String> ketQua = new ArrayList<>();
        Connection conn = getConnection();
        if (conn != null) {
            try {
                String sql = "SELECT ten_nha_cung_cap FROM nha_cung_cap WHERE LOWER(ten_nha_cung_cap) LIKE ?";
                PreparedStatement ps = conn.prepareStatement(sql);
                ps.setString(1, "%" + tuKhoa.toLowerCase() + "%");
                ResultSet rs = ps.executeQuery();

                while (rs.next()) {
                    ketQua.add(rs.getString("ten_nha_cung_cap"));
                }
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return ketQua;
    }
}
