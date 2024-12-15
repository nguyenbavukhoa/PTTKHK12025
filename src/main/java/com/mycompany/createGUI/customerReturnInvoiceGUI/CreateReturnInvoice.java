/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.createGUI.customerReturnInvoiceGUI;

import com.mycompany.createGUI.productGUI.*;
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
public class CreateReturnInvoice extends javax.swing.JFrame {

    DefaultTableModel choiseProductTableModel;

    /**
     * Creates new form AddProduct
     */
    public CreateReturnInvoice() {
        initComponents();

    }

    public CreateReturnInvoice(String idPhieuBan) {
        initComponents();
        // Tạo DefaultTableModel tùy chỉnh
        this.choiseProductTableModel = new DefaultTableModel(new String[]{
            "STT", "Mã SP", "Tên sản phẩm", "Số lượng bán", "Số lượng trả", "Đơn giá", "Thành tiền"
        }, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                // Chỉ cho phép chỉnh sửa cột "Số lượng trả" (cột thứ 4)
                return column == 4;
            }
        };

        choiseProductTable.setModel(choiseProductTableModel);
        choiseProductTableModel.setRowCount(0);

        Connection con = JDBCUtil.getConnection();
        String randomId = null;

        try {
            // Sinh mã phiếu trả
            randomId = "PT" + Function.generateUniqueRandomString(con, "PHIEU_TRA", "ma_phieu_tra", 8);
            idPhieuTraTF.setText(randomId);
            idPhieuTraTF.setEnabled(false);
            idPhieuTraTF.setBackground(new Color(228, 226, 226));

            // Truy vấn thông tin phiếu bán và phiếu trả
            String query = "SELECT pb.ma_phieu_ban, kh.ten_khach_hang, pb.account_id, "
                    + "ctb.ma_san_pham, pr.product_name, ctb.quantity, ctb.don_gia, ctb.quantity_returned "
                    + "FROM phieuban pb "
                    + "JOIN ctphieuban ctb ON pb.ma_phieu_ban = ctb.ma_phieu_ban "
                    + "JOIN products pr ON ctb.ma_san_pham = pr.id "
                    + "JOIN khach_hang kh ON pb.khach_hang = kh.ma_khach_hang "
                    + "WHERE pb.ma_phieu_ban = ?";

            try (PreparedStatement pstmt = con.prepareStatement(query)) {
                pstmt.setString(1, idPhieuBan); // Sử dụng mã phiếu bán được chọn
                ResultSet rs = pstmt.executeQuery();

                // Hiển thị thông tin chung của phiếu bán
                if (rs.next()) {
                    idPhieuBanTF.setText(rs.getString("pb.ma_phieu_ban"));
                    idPhieuBanTF.setEnabled(false);

                    customerNameTF.setText(rs.getString("kh.ten_khach_hang"));
                    customerNameTF.setEnabled(false);

                    accountNameTF.setText(rs.getString("pb.account_id"));
                    accountNameTF.setEnabled(false);

                    do {
                        // Thêm dữ liệu sản phẩm vào bảng
                        Object[] row = {
                            choiseProductTableModel.getRowCount() + 1, // STT
                            rs.getString("ctb.ma_san_pham"), // Mã sản phẩm
                            rs.getString("pr.product_name"), // Tên sản phẩm
                            rs.getInt("ctb.quantity"), // Số lượng bán
                            rs.getInt("ctb.quantity_returned"), // Số lượng trả
                            rs.getInt("ctb.don_gia"), // Đơn giá
                            rs.getInt("ctb.quantity_returned")
                            * rs.getInt("ctb.don_gia") // Thành tiền trả
                        };
                        choiseProductTableModel.addRow(row);
                    } while (rs.next());
                } else {
                    JOptionPane.showMessageDialog(null, "Không tìm thấy phiếu bán!", "Thông báo", JOptionPane.WARNING_MESSAGE);
                }
            }

            // Thêm TableModelListener để theo dõi thay đổi trong bảng
            choiseProductTableModel.addTableModelListener(e -> {
                if (e.getColumn() == 4) { // Theo dõi cột "Số lượng trả"
                    updateRowAndTotals(e.getFirstRow());
                }
            });

            // Tính toán tổng số lượng trả và tổng tiền trả
            calculateReturnTotals();

        } catch (SQLException ex) {
            Logger.getLogger(ReturnInvoiceDetail.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Lỗi khi tải dữ liệu: " + ex.getMessage(), "Lỗi", JOptionPane.ERROR_MESSAGE);
        } finally {
            JDBCUtil.closeConnection(con);
        }

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
        choisePane = new javax.swing.JScrollPane();
        choiseProductTable = new javax.swing.JTable();
        jPanel6 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        idPhieuBanTF = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        accountNameTF = new javax.swing.JTextField();
        customerNameTF = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        idPhieuTraTF = new javax.swing.JTextField();
        jPanel8 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        moneyCount = new javax.swing.JLabel();
        confirmBtn = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        tempBtn = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        returnCount = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Grocery Store");
        setBackground(new java.awt.Color(204, 255, 255));
        setResizable(false);

        jPanel3.setBackground(new java.awt.Color(204, 255, 255));

        jPanel9.setBackground(new java.awt.Color(255, 255, 255));
        jPanel9.setLayout(new java.awt.GridBagLayout());

        choisePane.setBackground(new java.awt.Color(255, 255, 255));

        choiseProductTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "STT", "Mã SP", "Tên sản phẩm", "Số lượng bán", "Số lượng trả", "Đơn giá", "Thành tiền"
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

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));
        jPanel6.setLayout(new java.awt.BorderLayout());

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jPanel4.setLayout(new java.awt.GridBagLayout());

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setText("Mã phiếu bán:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
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
        gridBagConstraints.gridy = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.ipadx = 214;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(10, 20, 10, 20);
        jPanel4.add(idPhieuBanTF, gridBagConstraints);

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setText("Nhân viên trả:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
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
        gridBagConstraints.gridy = 5;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.ipadx = 214;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(10, 20, 10, 20);
        jPanel4.add(accountNameTF, gridBagConstraints);

        customerNameTF.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        customerNameTF.setText("Công ty TNHH Trung Kiên");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.ipadx = 214;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(10, 20, 10, 20);
        jPanel4.add(customerNameTF, gridBagConstraints);

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel4.setText("Khách hàng:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(10, 20, 10, 20);
        jPanel4.add(jLabel4, gridBagConstraints);

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel6.setText("Mã phiếu trả:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(15, 20, 10, 20);
        jPanel4.add(jLabel6, gridBagConstraints);

        idPhieuTraTF.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        idPhieuTraTF.setText("1234");
        idPhieuTraTF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                idPhieuTraTFActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.ipadx = 214;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(10, 20, 10, 20);
        jPanel4.add(idPhieuTraTF, gridBagConstraints);

        jPanel6.add(jPanel4, java.awt.BorderLayout.NORTH);

        jPanel8.setBackground(new java.awt.Color(255, 255, 255));
        jPanel8.setLayout(new java.awt.GridBagLayout());

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 51, 51));
        jLabel5.setText("Tổng tiền trả:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(20, 40, 20, 20);
        jPanel8.add(jLabel5, gridBagConstraints);

        moneyCount.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        moneyCount.setText("0");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(20, 20, 20, 20);
        jPanel8.add(moneyCount, gridBagConstraints);

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
        gridBagConstraints.gridy = 3;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.ipadx = 250;
        gridBagConstraints.ipady = 10;
        gridBagConstraints.insets = new java.awt.Insets(20, 0, 40, 0);
        jPanel8.add(confirmBtn, gridBagConstraints);

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel3.setText("đ");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.insets = new java.awt.Insets(20, 5, 20, 20);
        jPanel8.add(jLabel3, gridBagConstraints);

        tempBtn.setBackground(new java.awt.Color(102, 204, 0));
        tempBtn.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        tempBtn.setForeground(new java.awt.Color(255, 255, 255));
        tempBtn.setText("Xác nhận");
        tempBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                confirmSalesInvoice(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.ipadx = 280;
        gridBagConstraints.ipady = 10;
        gridBagConstraints.insets = new java.awt.Insets(20, 0, 20, 0);
        jPanel8.add(tempBtn, gridBagConstraints);

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel7.setText("Tổng SL trả:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(20, 40, 20, 20);
        jPanel8.add(jLabel7, gridBagConstraints);

        returnCount.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        returnCount.setText("jLabel8");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(20, 20, 20, 20);
        jPanel8.add(returnCount, gridBagConstraints);

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

    private void choiseProductTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_choiseProductTableMouseClicked

    }//GEN-LAST:event_choiseProductTableMouseClicked

    private void temporarySalesInvoice(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_temporarySalesInvoice
        try (Connection con = JDBCUtil.getConnection()) {
            con.setAutoCommit(false); // Bắt đầu transaction

            // 1. Cập nhật phiếu trả với trạng thái = 0
            String insertPhieuTraQuery = "INSERT INTO phieu_tra (ma_phieu_tra, ma_phieu_ban, thoi_gian, account_id, trang_thai) "
                    + "VALUES (?, ?, ?, ?, 0)";
            try (PreparedStatement psPhieuTra = con.prepareStatement(insertPhieuTraQuery)) {
                psPhieuTra.setString(1, idPhieuTraTF.getText());
                psPhieuTra.setString(2, idPhieuBanTF.getText());
                psPhieuTra.setDate(3, new java.sql.Date(System.currentTimeMillis())); // Ngày hiện tại
                psPhieuTra.setString(4, accountNameTF.getText());
                psPhieuTra.executeUpdate();
            }

            // 2. Cập nhật ctphieuban
            String updateCtPhieuBanQuery = "UPDATE ctphieuban SET quantity_returned = ? WHERE ma_phieu_ban = ? AND ma_san_pham = ?";
            try (PreparedStatement psCtPhieuBan = con.prepareStatement(updateCtPhieuBanQuery)) {
                for (int i = 0; i < choiseProductTableModel.getRowCount(); i++) {
                    String maSanPham = choiseProductTableModel.getValueAt(i, 1).toString();
                    int quantityReturned = Integer.parseInt(choiseProductTableModel.getValueAt(i, 4).toString());

                    // Cập nhật ctphieuban
                    psCtPhieuBan.setInt(1, quantityReturned);
                    psCtPhieuBan.setString(2, idPhieuBanTF.getText());
                    psCtPhieuBan.setString(3, maSanPham);
                    psCtPhieuBan.executeUpdate();
                }
            }

            con.commit(); // Xác nhận transaction
            JOptionPane.showMessageDialog(null, "Lưu tạm phiếu trả thành công!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException ex) {
            Logger.getLogger(ReturnInvoiceDetail.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Lỗi khi xử lý phiếu trả: " + ex.getMessage(), "Lỗi", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_temporarySalesInvoice

    private void confirmSalesInvoice(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_confirmSalesInvoice
        try (Connection con = JDBCUtil.getConnection()) {
            con.setAutoCommit(false); // Bắt đầu transaction

            // 1. Cập nhật phiếu trả
            String insertPhieuTraQuery = "INSERT INTO phieu_tra (ma_phieu_tra, ma_phieu_ban, thoi_gian, account_id, trang_thai) "
                    + "VALUES (?, ?, ?, ?, 1)";
            try (PreparedStatement psPhieuTra = con.prepareStatement(insertPhieuTraQuery)) {
                psPhieuTra.setString(1, idPhieuTraTF.getText());
                psPhieuTra.setString(2, idPhieuBanTF.getText());
                psPhieuTra.setDate(3, new java.sql.Date(System.currentTimeMillis())); // Ngày hiện tại
                psPhieuTra.setString(4, accountNameTF.getText());
                psPhieuTra.executeUpdate();
            }

            // 2. Cập nhật ctphieuban và quantity trong products
            String updateCtPhieuBanQuery = "UPDATE ctphieuban SET quantity_returned = ? WHERE ma_phieu_ban = ? AND ma_san_pham = ?";
            String updateProductsQuery = "UPDATE products SET quantity = quantity + ? WHERE id = ?";
            try (PreparedStatement psCtPhieuBan = con.prepareStatement(updateCtPhieuBanQuery); PreparedStatement psProducts = con.prepareStatement(updateProductsQuery)) {

                for (int i = 0; i < choiseProductTableModel.getRowCount(); i++) {
                    String maSanPham = choiseProductTableModel.getValueAt(i, 1).toString();
                    int quantityReturned = Integer.parseInt(choiseProductTableModel.getValueAt(i, 4).toString());

                    // Cập nhật ctphieuban
                    psCtPhieuBan.setInt(1, quantityReturned);
                    psCtPhieuBan.setString(2, idPhieuBanTF.getText());
                    psCtPhieuBan.setString(3, maSanPham);
                    psCtPhieuBan.executeUpdate();

                    // Cập nhật products
                    psProducts.setInt(1, quantityReturned);
                    psProducts.setString(2, maSanPham);
                    psProducts.executeUpdate();
                }
            }

            // 3. Cập nhật trạng thái phieuban
            String updatePhieuBanQuery = "UPDATE phieuban SET trang_thai = 3 WHERE ma_phieu_ban = ?";
            try (PreparedStatement psPhieuBan = con.prepareStatement(updatePhieuBanQuery)) {
                psPhieuBan.setString(1, idPhieuBanTF.getText());
                psPhieuBan.executeUpdate();
            }

            con.commit(); // Xác nhận transaction
            JOptionPane.showMessageDialog(null, "Xác nhận phiếu trả thành công!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
            this.dispose(); // Đóng giao diện sau khi hoàn thành
        } catch (SQLException ex) {
            Logger.getLogger(ReturnInvoiceDetail.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Lỗi khi xử lý phiếu trả: " + ex.getMessage(), "Lỗi", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_confirmSalesInvoice

    private void idPhieuTraTFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_idPhieuTraTFActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_idPhieuTraTFActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new CreateReturnInvoice().setVisible(true);
            }
        });
    }

    private void updateRowAndTotals(int row) {
        try {
            int soldQuantity = Integer.parseInt(choiseProductTableModel.getValueAt(row, 3).toString()); // Số lượng bán
            int returnQuantity = Integer.parseInt(choiseProductTableModel.getValueAt(row, 4).toString()); // Số lượng trả
            int unitPrice = Integer.parseInt(choiseProductTableModel.getValueAt(row, 5).toString()); // Đơn giá

            // Kiểm tra: Số lượng trả không được lớn hơn số lượng bán
            if (returnQuantity > soldQuantity) {
                JOptionPane.showMessageDialog(null, "Số lượng trả không được lớn hơn số lượng bán!", "Lỗi", JOptionPane.ERROR_MESSAGE);
                choiseProductTableModel.setValueAt(0, row, 4); // Đặt lại về 0 nếu nhập sai
                returnQuantity = 0;
            }

            // Tính lại thành tiền cho dòng hiện tại
            choiseProductTableModel.setValueAt(returnQuantity * unitPrice, row, 6);

            // Cập nhật tổng số lượng trả và tổng tiền trả
            calculateReturnTotals();

        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(null, "Vui lòng nhập số lượng hợp lệ!", "Lỗi", JOptionPane.ERROR_MESSAGE);
            choiseProductTableModel.setValueAt(0, row, 4); // Đặt lại về 0 nếu nhập sai
        }
    }

    private void calculateReturnTotals() {
        int totalQuantity = 0;
        int totalMoney = 0;

        for (int i = 0; i < choiseProductTableModel.getRowCount(); i++) {
            int returnQuantity = Integer.parseInt(choiseProductTableModel.getValueAt(i, 4).toString());
            int totalPrice = Integer.parseInt(choiseProductTableModel.getValueAt(i, 6).toString());

            totalQuantity += returnQuantity;
            totalMoney += totalPrice;
        }

        returnCount.setText(String.valueOf(totalQuantity));
        moneyCount.setText(String.format("%,d", totalMoney)); // Định dạng số tiền
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField accountNameTF;
    private javax.swing.JScrollPane choisePane;
    private javax.swing.JTable choiseProductTable;
    private javax.swing.JButton confirmBtn;
    private javax.swing.JTextField customerNameTF;
    private javax.swing.JTextField idPhieuBanTF;
    private javax.swing.JTextField idPhieuTraTF;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JLabel moneyCount;
    private javax.swing.JLabel returnCount;
    private javax.swing.JButton tempBtn;
    // End of variables declaration//GEN-END:variables
}
