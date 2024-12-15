/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.setUpJTable;

import java.awt.*;
import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;

/**
 *
 * @author Vu Khoa
 */
public class CheckQuantityCellRenderer extends DefaultTableCellRenderer {

    private final int columnIndex;      // Vị trí cột
    private final int comparisonValue; // Giá trị để so sánh

    // Constructor
    public CheckQuantityCellRenderer(int columnIndex, int comparisonValue) {
        this.columnIndex = columnIndex;
        this.comparisonValue = comparisonValue;
    }

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        // Gọi phương thức mặc định
        Component cell = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);

        try {
            // Lấy giá trị của cột và kiểm tra
            int cellValue = Integer.parseInt(table.getValueAt(row, columnIndex).toString());
            boolean shouldHighlight = false;

            // Thực hiện so sánh dựa trên comparisonType
            if (cellValue == comparisonValue) {
                cell.setBackground(new Color(255,255,204));
            } else if (cellValue < comparisonValue) {
                cell.setBackground(new Color(255,189,189));
            } else {
                cell.setBackground(Color.WHITE);
            }

        } catch (NumberFormatException e) {
            cell.setBackground(Color.WHITE); // Màu nền mặc định nếu lỗi
        }

        // Đổi màu nền khi được chọn
        if (isSelected) {
            cell.setBackground(new Color(184, 207, 229)); // Màu nền khi được chọn
        }

        return cell;
    }
}
