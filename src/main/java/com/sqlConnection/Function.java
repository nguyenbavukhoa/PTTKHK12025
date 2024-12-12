/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sqlConnection;

import java.awt.Color;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
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
            textField.setBackground(new Color(254,128,127));
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
    
    
    public static String generateUniqueRandomString(Connection connection,String tableName,String columnName, int length) throws SQLException {
        String randomString;
        boolean isDuplicate;

        do {
            isDuplicate = false;
            randomString = generateRandomString(length);

            // 3. Kiểm tra xem chuỗi đã tồn tại trong cơ sở dữ liệu chưa
            String sql = "SELECT COUNT(*) FROM "+ tableName + " WHERE "+ columnName + " = ?"; 
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
}
