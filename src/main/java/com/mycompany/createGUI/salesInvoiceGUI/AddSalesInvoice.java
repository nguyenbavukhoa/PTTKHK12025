/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.createGUI.salesInvoiceGUI;

import com.mycompany.createGUI.productGUI.*;
import com.mycompany.finaltermproject.ImportUI;
import com.mycompany.setUpJTable.CheckQuantityCellRenderer;
import com.mycompany.HandlerClass.Function;
import com.mycompany.finaltermproject.SalesInvoiceGUI;
import com.sqlConnection.JDBCUtil;
import java.awt.Color;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.NumberFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author trieu
 */
public class AddSalesInvoice extends javax.swing.JFrame {

    DefaultTableModel productTableModel;
    DefaultTableModel choiseProductTableModel;

    /**
     * Creates new form AddProduct
     */
    public AddSalesInvoice() {
        initComponents();
        this.productTableModel = (DefaultTableModel) productTable.getModel();
        this.choiseProductTableModel = (DefaultTableModel) choiseProductTable.getModel();
        choiseProductTableModel.setRowCount(0);

        this.productTableModel = (DefaultTableModel) productTable.getModel();
        this.choiseProductTableModel = (DefaultTableModel) choiseProductTable.getModel();
        choiseProductTableModel.setRowCount(0);

        addProduct.setEnabled(false);
        deleteProduct.setEnabled(false);
        editProduct.setEnabled(false);

        Connection con = JDBCUtil.getConnection();
        String randomId = null;
        try {
            randomId = "PB" + Function.generateUniqueRandomString(con, "PHIEUBAN", "ma_phieu_ban", 8);
        } catch (SQLException ex) {
            Logger.getLogger(AddProduct.class.getName()).log(Level.SEVERE, null, ex);
        }

        idPhieuBanTF.setText(randomId);
        idPhieuBanTF.setEnabled(false);
        idPhieuBanTF.setBackground(new Color(228, 226, 226));

        String query = "SELECT id, product_name, sell_price, quantity FROM products";

        ResultSet resultSet = JDBCUtil.getResultSet(con, query);

        productTableModel.setRowCount(0);

        try {
            while (resultSet.next()) {
                String id = resultSet.getString("id");
                String name = resultSet.getString("product_name");
                int sellPrice = resultSet.getInt("sell_price");
                int quantity = resultSet.getInt("quantity");

                productTableModel.addRow(new Object[]{id, name, sellPrice, quantity});
            }
            productTable.setDefaultRenderer(Object.class, new CheckQuantityCellRenderer(3, 20));
        } catch (SQLException ex) {
            Logger.getLogger(AddSalesInvoice.class.getName()).log(Level.SEVERE, null, ex);
        }

        JDBCUtil.closeConnection(con);

    }

    public AddSalesInvoice(String productId) {
        initComponents();
        this.productTableModel = (DefaultTableModel) productTable.getModel();
        this.choiseProductTableModel = (DefaultTableModel) choiseProductTable.getModel();
        choiseProductTableModel.setRowCount(0);

        addProduct.setEnabled(true);
        deleteProduct.setEnabled(false);
        editProduct.setEnabled(false);

        Connection con = JDBCUtil.getConnection();
        String randomId = null;
        try {
            randomId = "PB" + Function.generateUniqueRandomString(con, "PHIEUBAN", "ma_phieu_ban", 8);
        } catch (SQLException ex) {
            Logger.getLogger(AddProduct.class.getName()).log(Level.SEVERE, null, ex);
        }

        idPhieuBanTF.setText(randomId);
        idPhieuBanTF.setEnabled(false);
        idPhieuBanTF.setBackground(new Color(228, 226, 226));

        String query = "SELECT id, product_name, sell_price, quantity FROM products";

        ResultSet resultSet = JDBCUtil.getResultSet(con, query);

        productTableModel.setRowCount(0);

        try {
            while (resultSet.next()) {
                String id = resultSet.getString("id");
                String name = resultSet.getString("product_name");
                int sellPrice = resultSet.getInt("sell_price");
                int quantity = resultSet.getInt("quantity");

                productTableModel.addRow(new Object[]{id, name, sellPrice, quantity});
                if (productId.equals(id)) {
                    int i = productTable.getRowCount() - 1;
                    // Display the selected row information
                    productIdTF.setText(id);
                    productIdTF.setEditable(false);
                    productIdTF.setBackground(new Color(228, 226, 226));

                    productNameTF.setText(name);
                    productNameTF.setEditable(false);
                    productNameTF.setBackground(new Color(228, 226, 226));
                    productTable.setRowSelectionInterval(i, i);
                }
            }
            productTable.setDefaultRenderer(Object.class, new CheckQuantityCellRenderer(3, 20));
        } catch (SQLException ex) {
            Logger.getLogger(AddSalesInvoice.class.getName()).log(Level.SEVERE, null, ex);
        }

        JDBCUtil.closeConnection(con);

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        jPanel3 = new javax.swing.JPanel();
        jPanel9 = new javax.swing.JPanel();
        searchPanel = new javax.swing.JPanel();
        searchField = new javax.swing.JTextField();
        productPane = new javax.swing.JScrollPane();
        productTable = new javax.swing.JTable();
        jPanel7 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        productIdTF = new javax.swing.JTextField();
        productNameTF = new javax.swing.JTextField();
        quantityTF = new javax.swing.JTextField();
        choisePane = new javax.swing.JScrollPane();
        choiseProductTable = new javax.swing.JTable();
        functionPanel = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        addNewProduct = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        deleteProduct = new javax.swing.JButton();
        editProduct = new javax.swing.JButton();
        addProduct = new javax.swing.JButton();
        jPanel6 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        idPhieuBanTF = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        accountNameTF = new javax.swing.JTextField();
        customerNameTF = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        totalMoneyL = new javax.swing.JLabel();
        confirmBtn = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        tempBtn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Grocery Store");
        setBackground(new java.awt.Color(204, 255, 255));
        setResizable(false);

        jPanel3.setBackground(new java.awt.Color(204, 255, 255));

        jPanel9.setBackground(new java.awt.Color(255, 255, 255));
        jPanel9.setLayout(new java.awt.GridBagLayout());

        searchPanel.setBackground(new java.awt.Color(255, 255, 255));
        searchPanel.setLayout(new javax.swing.BoxLayout(searchPanel, javax.swing.BoxLayout.X_AXIS));

        searchField.setText("Tên sản phẩm ......");
        searchField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                searchProduct(evt);
            }
        });
        searchPanel.add(searchField);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.ipady = 10;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        jPanel9.add(searchPanel, gridBagConstraints);

        productPane.setBackground(new java.awt.Color(255, 255, 255));

        productTable.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        productTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Mã SP", "Tên SP", "Giá bán", "Số lượng"
            }
        ));
        productTable.setGridColor(new java.awt.Color(255, 255, 255));
        productTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                showProductInfo(evt);
            }
        });
        productPane.setViewportView(productTable);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTH;
        gridBagConstraints.weightx = 0.01;
        gridBagConstraints.weighty = 0.5;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 0, 5);
        jPanel9.add(productPane, gridBagConstraints);

        jPanel7.setBackground(new java.awt.Color(255, 255, 255));
        jPanel7.setLayout(new java.awt.GridBagLayout());

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel7.setText("Mã sản phẩm:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        jPanel7.add(jLabel7, gridBagConstraints);

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel8.setText("Tên sản phẩm:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        jPanel7.add(jLabel8, gridBagConstraints);

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel10.setText("Số lượng:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        jPanel7.add(jLabel10, gridBagConstraints);

        productIdTF.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        productIdTF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                productIdTFActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.ipadx = 150;
        gridBagConstraints.insets = new java.awt.Insets(10, 5, 10, 10);
        jPanel7.add(productIdTF, gridBagConstraints);

        productNameTF.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        productNameTF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                productNameTFActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.ipadx = 150;
        gridBagConstraints.insets = new java.awt.Insets(10, 5, 10, 10);
        jPanel7.add(productNameTF, gridBagConstraints);

        quantityTF.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.ipadx = 150;
        gridBagConstraints.insets = new java.awt.Insets(10, 5, 10, 10);
        jPanel7.add(quantityTF, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.ipadx = 20;
        gridBagConstraints.ipady = 10;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTH;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 0, 5);
        jPanel9.add(jPanel7, gridBagConstraints);

        choisePane.setBackground(new java.awt.Color(255, 255, 255));

        choiseProductTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "STT", "Mã SP", "Tên sản phẩm", "Đơn giá", "Số lượng"
            }
        ));
        choiseProductTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                choiseProductTableMouseClicked(evt);
            }
        });
        choisePane.setViewportView(choiseProductTable);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 0.5;
        gridBagConstraints.weighty = 0.5;
        jPanel9.add(choisePane, gridBagConstraints);

        functionPanel.setBackground(new java.awt.Color(247, 246, 246));
        functionPanel.setLayout(new javax.swing.BoxLayout(functionPanel, javax.swing.BoxLayout.LINE_AXIS));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new javax.swing.BoxLayout(jPanel1, javax.swing.BoxLayout.X_AXIS));

        addNewProduct.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        addNewProduct.setText("Thêm sản phẩm mới");
        addNewProduct.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addNewProductActionPerformed(evt);
            }
        });
        jPanel1.add(addNewProduct);

        functionPanel.add(jPanel1);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setLayout(new java.awt.GridBagLayout());

        deleteProduct.setBackground(new java.awt.Color(255, 102, 102));
        deleteProduct.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        deleteProduct.setForeground(new java.awt.Color(255, 255, 255));
        deleteProduct.setText("Xóa sản phẩm");
        deleteProduct.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteProductActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 14, 0, 0);
        jPanel2.add(deleteProduct, gridBagConstraints);

        editProduct.setBackground(new java.awt.Color(102, 204, 0));
        editProduct.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        editProduct.setForeground(new java.awt.Color(255, 255, 255));
        editProduct.setText("Sửa thông tin");
        editProduct.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editProductActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 20, 0, 20);
        jPanel2.add(editProduct, gridBagConstraints);

        addProduct.setBackground(new java.awt.Color(102, 204, 255));
        addProduct.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        addProduct.setForeground(new java.awt.Color(255, 255, 255));
        addProduct.setText("Thêm ");
        addProduct.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addProductToNote(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(0, 20, 0, 20);
        jPanel2.add(addProduct, gridBagConstraints);

        functionPanel.add(jPanel2);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.ipady = 10;
        gridBagConstraints.insets = new java.awt.Insets(1, 0, 1, 0);
        jPanel9.add(functionPanel, gridBagConstraints);

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));
        jPanel6.setLayout(new java.awt.BorderLayout());

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jPanel4.setLayout(new java.awt.GridBagLayout());

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setText("Mã phiếu bán:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(15, 20, 10, 20);
        jPanel4.add(jLabel1, gridBagConstraints);

        idPhieuBanTF.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        idPhieuBanTF.setText("1234");
        idPhieuBanTF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                idPhieuBanTFActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.ipadx = 214;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(10, 20, 10, 20);
        jPanel4.add(idPhieuBanTF, gridBagConstraints);

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setText("Nhân viên bán:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(10, 20, 10, 20);
        jPanel4.add(jLabel2, gridBagConstraints);

        accountNameTF.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        accountNameTF.setText("Vũ Khoa");
        accountNameTF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                accountNameTFActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.ipadx = 214;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(10, 20, 10, 20);
        jPanel4.add(accountNameTF, gridBagConstraints);

        customerNameTF.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        customerNameTF.setText("Công ty TNHH Trung Kiên");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.ipadx = 214;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(10, 20, 10, 20);
        jPanel4.add(customerNameTF, gridBagConstraints);

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel4.setText("Khách hàng:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(10, 20, 10, 20);
        jPanel4.add(jLabel4, gridBagConstraints);

        jPanel6.add(jPanel4, java.awt.BorderLayout.NORTH);

        jPanel8.setBackground(new java.awt.Color(255, 255, 255));
        jPanel8.setLayout(new java.awt.GridBagLayout());

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 51, 51));
        jLabel5.setText("Tổng tiền:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(20, 40, 20, 20);
        jPanel8.add(jLabel5, gridBagConstraints);

        totalMoneyL.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        totalMoneyL.setText("0");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(20, 20, 20, 20);
        jPanel8.add(totalMoneyL, gridBagConstraints);

        confirmBtn.setBackground(new java.awt.Color(204, 204, 204));
        confirmBtn.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        confirmBtn.setText("Luu Tạm");
        confirmBtn.setToolTipText("");
        confirmBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                temporarySalesInvoice(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.ipadx = 250;
        gridBagConstraints.ipady = 10;
        gridBagConstraints.insets = new java.awt.Insets(20, 0, 40, 0);
        jPanel8.add(confirmBtn, gridBagConstraints);

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel3.setText("đ");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.insets = new java.awt.Insets(20, 5, 20, 20);
        jPanel8.add(jLabel3, gridBagConstraints);

        tempBtn.setBackground(new java.awt.Color(102, 204, 0));
        tempBtn.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        tempBtn.setForeground(new java.awt.Color(255, 255, 255));
        tempBtn.setText("Thanh toán");
        tempBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                confirmSalesInvoice(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.ipadx = 280;
        gridBagConstraints.ipady = 10;
        gridBagConstraints.insets = new java.awt.Insets(20, 0, 20, 0);
        jPanel8.add(tempBtn, gridBagConstraints);

        jPanel6.add(jPanel8, java.awt.BorderLayout.SOUTH);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, 673, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, 409, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, 802, Short.MAX_VALUE)
                    .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void idPhieuBanTFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_idPhieuBanTFActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_idPhieuBanTFActionPerformed

    private void accountNameTFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_accountNameTFActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_accountNameTFActionPerformed

    private void addProductToNote(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addProductToNote
        if (quantityTF.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Chưa điền số lượng nhập !");
            Function.checkTextField(quantityTF);
        } else {
            int selectedRow = productTable.getSelectedRow();

            // Check if a row is selected
            if (selectedRow != -1) {
                // Get values from the selected row
                int nextSTT = choiseProductTableModel.getRowCount() + 1; // STT tiếp theo
                String id = productTable.getValueAt(selectedRow, 0).toString();
                String name = productTable.getValueAt(selectedRow, 1).toString();
                String sellPrice = productTable.getValueAt(selectedRow, 2).toString();
                String quantity = quantityTF.getText();

                Object[] row = {nextSTT, id, name, sellPrice, quantity};
                choiseProductTableModel.addRow(row);
                updateSTT();
            } else {
                JOptionPane.showMessageDialog(this, "Vui lòng chọn sản phẩm !");
            }

        }


    }//GEN-LAST:event_addProductToNote

    private void deleteProductActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteProductActionPerformed
        int selectedRow = choiseProductTable.getSelectedRow();
        if (selectedRow >= 0) {
            choiseProductTableModel.removeRow(selectedRow);
            updateSTT();
        } else {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn một dòng để xóa.", "Thông báo", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_deleteProductActionPerformed

    private void searchProduct(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_searchProduct
        String keyword = searchField.getText();
        try {
            searchProduct(keyword);
        } catch (SQLException ex) {
            Logger.getLogger(AddSalesInvoice.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_searchProduct

    private void productIdTFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_productIdTFActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_productIdTFActionPerformed

    private void productNameTFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_productNameTFActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_productNameTFActionPerformed

    private void showProductInfo(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_showProductInfo
        choiseProductTable.clearSelection();

        int selectedRow = productTable.getSelectedRow();
        boolean isRowSelected = selectedRow >= 0;

        addProduct.setEnabled(isRowSelected);
        deleteProduct.setEnabled(!isRowSelected);
        editProduct.setEnabled(!isRowSelected);

        // Check if a row is selected
        if (selectedRow != -1) {
            // Get values from the selected row
            String id = productTable.getValueAt(selectedRow, 0).toString();
            String name = productTable.getValueAt(selectedRow, 1).toString();

            // Display the selected row information
            productIdTF.setText(id);
            productIdTF.setEditable(false);
            productIdTF.setBackground(new Color(228, 226, 226));

            productNameTF.setText(name);
            productNameTF.setEditable(false);
            productNameTF.setBackground(new Color(228, 226, 226));

            quantityTF.setText(null);

        } else {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn sản phẩm !");
        }
    }//GEN-LAST:event_showProductInfo

    private void editProductActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editProductActionPerformed
        int selectedRow = choiseProductTable.getSelectedRow();
        if (selectedRow >= 0) {
            choiseProductTableModel.setValueAt(productIdTF.getText(), selectedRow, 1);
            choiseProductTableModel.setValueAt(productNameTF.getText(), selectedRow, 2);
            choiseProductTableModel.setValueAt(quantityTF.getText(), selectedRow, 4);
            updateSTT(); // Cập nhật lại STT nếu cần
        } else {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn một dòng để cập nhật.", "Thông báo", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_editProductActionPerformed

    private void choiseProductTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_choiseProductTableMouseClicked
        productTable.clearSelection();

        int selectedRow = choiseProductTable.getSelectedRow();
        boolean isRowSelected = selectedRow >= 0;

        addProduct.setEnabled(!isRowSelected);
        deleteProduct.setEnabled(isRowSelected);
        editProduct.setEnabled(isRowSelected);

        // Check if a row is selected
        if (selectedRow != -1) {
            // Get values from the selected row
            String id = choiseProductTable.getValueAt(selectedRow, 1).toString();
            String name = choiseProductTable.getValueAt(selectedRow, 2).toString();
            String importPrice = choiseProductTable.getValueAt(selectedRow, 3).toString();
            String quantity = choiseProductTable.getValueAt(selectedRow, 4).toString();

            // Display the selected row information
            productIdTF.setText(id);
            productIdTF.setEditable(false);
            productIdTF.setBackground(new Color(228, 226, 226));

            productNameTF.setText(name);
            productNameTF.setEditable(false);
            productNameTF.setBackground(new Color(228, 226, 226));

            quantityTF.setText(quantity);

        } else {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn sản phẩm !");
        }
    }//GEN-LAST:event_choiseProductTableMouseClicked

    private void temporarySalesInvoice(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_temporarySalesInvoice
        try (Connection con = JDBCUtil.getConnection(); PreparedStatement insertPhieuBan = con.prepareStatement("INSERT INTO phieuban (ma_phieu_ban, thoi_gian, trang_thai, khach_hang, account_id) VALUES (?, ?, ?, ?, ?)"); PreparedStatement insertCTPhieuBan = con.prepareStatement("INSERT INTO ctphieuban (ma_phieu_ban, ma_san_pham, quantity, don_gia) VALUES (?, ?, ?, ?)"); PreparedStatement psCheckCustomer = con.prepareStatement("SELECT ma_khach_hang FROM khach_hang WHERE ten_khach_hang = ?")) {

            // Kiểm tra thông tin hóa đơn
            if (accountNameTF.getText().isEmpty()) {
                JOptionPane.showMessageDialog(this, "Chưa điền Tên người làm phiếu !");
                Function.checkTextField(accountNameTF);
                return;
            }

            if (customerNameTF.getText().isEmpty()) {
                JOptionPane.showMessageDialog(this, "Chưa điền Tên khách hàng !");
                Function.checkTextField(customerNameTF);
                return;
            }

            if (choiseProductTable.getRowCount() == 0) {
                JOptionPane.showMessageDialog(this, "Chưa có sản phẩm trong hóa đơn !");
                return;
            }

            // Kiểm tra khách hàng
            psCheckCustomer.setString(1, customerNameTF.getText());
            ResultSet rs = psCheckCustomer.executeQuery();

            String maKhachHang;
            if (rs.next()) {
                // Khách hàng đã tồn tại
                maKhachHang = rs.getString("ma_khach_hang");
            } else {
                // Thêm khách hàng mới
                String sqlInsertCustomer = "INSERT INTO khach_hang (ma_khach_hang, ten_khach_hang) VALUES (?, ?)";
                maKhachHang = "KH" + Function.generateUniqueRandomString(con, "khach_hang", "ma_khach_hang", 7);
                try (PreparedStatement psInsertCustomer = con.prepareStatement(sqlInsertCustomer)) {
                    psInsertCustomer.setString(1, maKhachHang);
                    psInsertCustomer.setString(2, customerNameTF.getText());
                    psInsertCustomer.executeUpdate();
                }
            }

            // Thêm hóa đơn vào bảng phieuban
            String maPhieuBan = idPhieuBanTF.getText();
            java.util.Date utilDate = new java.util.Date(); // Lấy ngày hiện tại
            java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime()); // Chuyển đổi sang java.sql.Date
            insertPhieuBan.setString(1, maPhieuBan);
            insertPhieuBan.setDate(2, sqlDate);
            insertPhieuBan.setInt(3, 0); // Trạng thái hóa đơn (0: Chưa thanh toán)
            insertPhieuBan.setString(4, maKhachHang);
            insertPhieuBan.setString(5, accountNameTF.getText());
            insertPhieuBan.executeUpdate();

            // Thêm chi tiết sản phẩm vào bảng ctphieuban
            for (int i = 0; i < choiseProductTable.getRowCount(); i++) {
                String maSanPham = choiseProductTable.getValueAt(i, 1).toString();
                int quantity = Integer.parseInt(choiseProductTable.getValueAt(i, 4).toString());
                String donGia = choiseProductTable.getValueAt(i, 3).toString();

                // Gán dữ liệu vào PreparedStatement
                insertCTPhieuBan.setString(1, maPhieuBan);
                insertCTPhieuBan.setString(2, maSanPham);
                insertCTPhieuBan.setInt(3, quantity);
                insertCTPhieuBan.setString(4, donGia);

                // Thực thi lệnh INSERT
                insertCTPhieuBan.executeUpdate();
            }

            // Hiển thị thông báo thành công
            JOptionPane.showMessageDialog(null, "Tạo hóa đơn thành công!");
            SalesInvoiceGUI salesInvoiceGUI = new SalesInvoiceGUI();
            salesInvoiceGUI.setLocation(this.getX(), this.getY());
            salesInvoiceGUI.setVisible(true);
            this.dispose();

        } catch (SQLException ex) {
            Logger.getLogger(AddSalesInvoice.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(this, "Lỗi khi xử lý hóa đơn: " + ex.getMessage());
        }


    }//GEN-LAST:event_temporarySalesInvoice

    private void addNewProductActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addNewProductActionPerformed
        AddProduct addProduct = new AddProduct();
        addProduct.setLocation(this.getX() + 20, this.getY() + 20);
        addProduct.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        addProduct.setVisible(true);        // TODO add your handling code here:
    }//GEN-LAST:event_addNewProductActionPerformed

    private void confirmSalesInvoice(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_confirmSalesInvoice
        String updateProductQuantityQuery = "UPDATE products p "
                + "SET p.quantity = p.quantity - ("
                + "    SELECT SUM(ct.quantity) "
                + "    FROM ctphieuban ct "
                + "    WHERE ct.ma_phieu_ban = ? "
                + "    AND ct.ma_san_pham = p.id"
                + ") "
                + "WHERE EXISTS ("
                + "    SELECT 1 "
                + "    FROM ctphieuban ct "
                + "    WHERE ct.ma_phieu_ban = ? "
                + "    AND ct.ma_san_pham = p.id"
                + ")";
        
        try (Connection con = JDBCUtil.getConnection(); PreparedStatement insertPhieuBan = con.prepareStatement("INSERT INTO phieuban (ma_phieu_ban, thoi_gian, trang_thai, khach_hang, account_id) VALUES (?, ?, ?, ?, ?)"); PreparedStatement insertCTPhieuBan = con.prepareStatement("INSERT INTO ctphieuban (ma_phieu_ban, ma_san_pham, quantity, don_gia) VALUES (?, ?, ?, ?)"); PreparedStatement psCheckCustomer = con.prepareStatement("SELECT ma_khach_hang FROM khach_hang WHERE ten_khach_hang = ?");PreparedStatement updateProductQuantity = con.prepareStatement(updateProductQuantityQuery)) {

            // Kiểm tra thông tin hóa đơn
            if (accountNameTF.getText().isEmpty()) {
                JOptionPane.showMessageDialog(this, "Chưa điền Tên người làm phiếu !");
                Function.checkTextField(accountNameTF);
                return;
            }

            if (customerNameTF.getText().isEmpty()) {
                JOptionPane.showMessageDialog(this, "Chưa điền Tên khách hàng !");
                Function.checkTextField(customerNameTF);
                return;
            }

            if (choiseProductTable.getRowCount() == 0) {
                JOptionPane.showMessageDialog(this, "Chưa có sản phẩm trong hóa đơn !");
                return;
            }

            // Kiểm tra khách hàng
            psCheckCustomer.setString(1, customerNameTF.getText());
            ResultSet rs = psCheckCustomer.executeQuery();

            String maKhachHang;
            if (rs.next()) {
                // Khách hàng đã tồn tại
                maKhachHang = rs.getString("ma_khach_hang");
            } else {
                // Thêm khách hàng mới
                String sqlInsertCustomer = "INSERT INTO khach_hang (ma_khach_hang, ten_khach_hang) VALUES (?, ?)";
                maKhachHang = "KH" + Function.generateUniqueRandomString(con, "khach_hang", "ma_khach_hang", 7);
                try (PreparedStatement psInsertCustomer = con.prepareStatement(sqlInsertCustomer)) {
                    psInsertCustomer.setString(1, maKhachHang);
                    psInsertCustomer.setString(2, customerNameTF.getText());
                    psInsertCustomer.executeUpdate();
                }
            }

            // Thêm hóa đơn vào bảng phieuban
            String maPhieuBan = idPhieuBanTF.getText();
            java.util.Date utilDate = new java.util.Date(); // Lấy ngày hiện tại
            java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime()); // Chuyển đổi sang java.sql.Date
            insertPhieuBan.setString(1, maPhieuBan);
            insertPhieuBan.setDate(2, sqlDate);
            insertPhieuBan.setInt(3, 1); // Trạng thái hóa đơn (1: đã thanh toán)
            insertPhieuBan.setString(4, maKhachHang);
            insertPhieuBan.setString(5, accountNameTF.getText());
            insertPhieuBan.executeUpdate();

            // Thêm chi tiết sản phẩm vào bảng ctphieuban
            for (int i = 0; i < choiseProductTable.getRowCount(); i++) {
                String maSanPham = choiseProductTable.getValueAt(i, 1).toString();
                int quantity = Integer.parseInt(choiseProductTable.getValueAt(i, 4).toString());
                String donGia = choiseProductTable.getValueAt(i, 3).toString();

                // Gán dữ liệu vào PreparedStatement
                insertCTPhieuBan.setString(1, maPhieuBan);
                insertCTPhieuBan.setString(2, maSanPham);
                insertCTPhieuBan.setInt(3, quantity);
                insertCTPhieuBan.setString(4, donGia);

                // Thực thi lệnh INSERT
                insertCTPhieuBan.executeUpdate();
            }
            
            // Cập nhật số lượng trong bảng products
            updateProductQuantity.setString(1, maPhieuBan); // Tham số đầu tiên cho `ma_phieu_ban`
            updateProductQuantity.setString(2, maPhieuBan); // Tham số thứ hai cho `ma_phieu_ban`
            int rowsAffected = updateProductQuantity.executeUpdate();

            // Hiển thị thông báo thành công
            JOptionPane.showMessageDialog(null, "Tạo hóa đơn thành công!");
            SalesInvoiceGUI salesInvoiceGUI = new SalesInvoiceGUI();
            salesInvoiceGUI.setLocation(this.getX(), this.getY());
            salesInvoiceGUI.setVisible(true);
            this.dispose();

        } catch (SQLException ex) {
            Logger.getLogger(AddSalesInvoice.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(this, "Lỗi khi xử lý hóa đơn: " + ex.getMessage());
        }
    }//GEN-LAST:event_confirmSalesInvoice

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(AddSalesInvoice.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AddSalesInvoice.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AddSalesInvoice.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AddSalesInvoice.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new AddSalesInvoice().setVisible(true);
            }
        });
    }

    // The searchProduct function:
    private void searchProduct(String keyword) throws SQLException {
        Connection con = JDBCUtil.getConnection();
        String query = "SELECT id, product_name, sell_price, quantity FROM products WHERE product_name LIKE ?";
        String value = "%" + keyword + "%";

        ResultSet resultSet = JDBCUtil.getResultSet(con, query, 1, value);

        productTableModel.setRowCount(0);

        while (resultSet.next()) {
            String id = resultSet.getString("id");
            String name = resultSet.getString("product_name");
            int sellPrice = resultSet.getInt("sell_price");
            int quantity = resultSet.getInt("quantity");

            productTableModel.addRow(new Object[]{id, name, sellPrice, quantity});
        }

        JDBCUtil.closeConnection(con);
    }

    // Hàm cập nhật lại STT
    @SuppressWarnings("empty-statement")
    private void updateSTT() {
        long totalPrice = 0;

        for (int i = 0; i < choiseProductTableModel.getRowCount(); i++) {
            choiseProductTableModel.setValueAt(i + 1, i, 0);// Cập nhật cột STT
            int quantity = Integer.parseInt((String) choiseProductTableModel.getValueAt(i, 4));  // Lấy giá trị ở cột "Số lượng"
            long price = Long.parseLong((String) choiseProductTableModel.getValueAt(i, 3));  // Lấy giá trị ở cột "Giá"
            totalPrice += quantity * price; // Cộng tổng tiền
        }

        // Định dạng tiền tệ
        NumberFormat currencyFormat = NumberFormat.getInstance();
        String formattedTotalPrice = currencyFormat.format(totalPrice);

        // Cập nhật lại label với tổng tiền được định dạng
        totalMoneyL.setText(formattedTotalPrice);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField accountNameTF;
    private javax.swing.JButton addNewProduct;
    private javax.swing.JButton addProduct;
    private javax.swing.JScrollPane choisePane;
    private javax.swing.JTable choiseProductTable;
    private javax.swing.JButton confirmBtn;
    private javax.swing.JTextField customerNameTF;
    private javax.swing.JButton deleteProduct;
    private javax.swing.JButton editProduct;
    private javax.swing.JPanel functionPanel;
    private javax.swing.JTextField idPhieuBanTF;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JTextField productIdTF;
    private javax.swing.JTextField productNameTF;
    private javax.swing.JScrollPane productPane;
    private javax.swing.JTable productTable;
    private javax.swing.JTextField quantityTF;
    private javax.swing.JTextField searchField;
    private javax.swing.JPanel searchPanel;
    private javax.swing.JButton tempBtn;
    private javax.swing.JLabel totalMoneyL;
    // End of variables declaration//GEN-END:variables
}
