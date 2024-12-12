/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.createGUI;

import java.awt.*;
import javax.swing.*;
/**
 *
 * @author Vu Khoa
 */
public class ProductDetailsForm extends JFrame {

    private JLabel idLabel, nameLabel, expiryLabel, priceLabel, originLabel, quantityLabel, typeLabel;

    public ProductDetailsForm(String id, String name, String expiry, String sellPrice, String origin, String quantity, String productType) {
        // Khởi tạo các JLabel
        idLabel = new JLabel();
        nameLabel = new JLabel();
        expiryLabel = new JLabel();
        priceLabel = new JLabel();
        originLabel = new JLabel();
        quantityLabel = new JLabel();
        typeLabel = new JLabel();

        // Thiết lập text cho các JLabel
        idLabel.setText("ID: " + id);
        nameLabel.setText("Name: " + name);
        expiryLabel.setText("Expiry: " + expiry);
        priceLabel.setText("Sell Price: " + sellPrice);
        originLabel.setText("Origin: " + origin);
        quantityLabel.setText("Quantity: " + quantity);
        typeLabel.setText("Product Type: " + productType);

        // Thêm các JLabel vào form
        setLayout(new GridLayout(7, 1)); // Sử dụng GridLayout để sắp xếp các JLabel theo chiều dọc
        add(idLabel);
        add(nameLabel);
        add(expiryLabel);
        add(priceLabel);
        add(originLabel);
        add(quantityLabel);
        add(typeLabel);

        // Thiết lập các thuộc tính cho form
        setTitle("Product Details"); // Đặt tiêu đề cho form
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // Đóng form chi tiết mà không đóng form chính
        pack(); // Tự động điều chỉnh kích thước form cho vừa với nội dung
        setLocationRelativeTo(null); // Hiển thị form ở giữa màn hình
    }
}
