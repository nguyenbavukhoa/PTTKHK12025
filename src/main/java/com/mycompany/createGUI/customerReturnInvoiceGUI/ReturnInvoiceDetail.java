/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.createGUI.customerReturnInvoiceGUI;

import com.mycompany.HandlerClass.Function;
import com.mycompany.finaltermproject.CustomerReturnInvoiceGUI;
import com.sqlConnection.JDBCUtil;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.*;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author trieu
 */
public class ReturnInvoiceDetail extends javax.swing.JFrame {

    DefaultTableModel choiseProductTableModel;
    String idPhieuTra = null;

    /**
     * Creates new form AddProduct
     */
    public ReturnInvoiceDetail() {
        initComponents();
        this.choiseProductTableModel = (DefaultTableModel) choiseProductTable.getModel();
        choiseProductTableModel.setRowCount(0);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public ReturnInvoiceDetail(String id, String trangThai) {
        initComponents();
        this.choiseProductTableModel = (DefaultTableModel) choiseProductTable.getModel();
        idPhieuTra = id;

// Kiểm tra giá trị `id`
        if (id == null || id.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Mã phiếu trả không hợp lệ!");
            return;
        }

        String query = "SELECT pt.ma_phieu_tra, pt.ma_phieu_ban, pt.thoi_gian, pt.account_id, "
                + "pt.trang_thai, kh.ten_khach_hang, "
                + "ctb.ma_san_pham, pr.product_name, ctb.quantity, ctb.quantity_returned, ctb.don_gia "
                + "FROM phieu_tra pt "
                + "JOIN phieuban pb ON pt.ma_phieu_ban = pb.ma_phieu_ban "
                + "JOIN ctphieuban ctb ON pb.ma_phieu_ban = ctb.ma_phieu_ban "
                + "JOIN products pr ON ctb.ma_san_pham = pr.id "
                + "JOIN khach_hang kh ON pb.khach_hang = kh.ma_khach_hang "
                + "WHERE pt.ma_phieu_tra = ?";

        try (Connection con = JDBCUtil.getConnection(); PreparedStatement pstmt = con.prepareStatement(query)) {
            if (con == null) {
                throw new SQLException("Kết nối cơ sở dữ liệu không thành công!");
            }

            pstmt.setString(1, id);
            try (ResultSet resultSet = pstmt.executeQuery()) {
                if (resultSet == null) {
                    throw new SQLException("ResultSet là null.");
                }

                if (resultSet.next()) {
                    // Gán dữ liệu vào các trường giao diện
                    idPhieuTraTF.setText(resultSet.getString("pt.ma_phieu_tra"));
                    idPhieuTraTF.setEnabled(false);

                    idPhieuBanTF.setText(resultSet.getString("pt.ma_phieu_ban"));
                    idPhieuBanTF.setEnabled(false);

                    accountNameTF.setText(resultSet.getString("pt.account_id"));
                    accountNameTF.setEnabled(false);

                    customerNameTF.setText(resultSet.getString("kh.ten_khach_hang"));
                    customerNameTF.setEnabled(false);

                    dateTF.setText(resultSet.getDate("pt.thoi_gian").toString());
                    dateTF.setEnabled(false);

                    choiseProductTableModel.setRowCount(0);

                    // Tính tổng số lượng trả và tổng tiền trả
                    int totalReturnQuantity = 0;
                    int totalReturnMoney = 0;

                    do {
                        int nextSTT = choiseProductTableModel.getRowCount() + 1; // STT
                        String productId = resultSet.getString("ctb.ma_san_pham");
                        String name = resultSet.getString("pr.product_name");
                        int soldQuantity = resultSet.getInt("ctb.quantity");
                        int returnQuantity = resultSet.getInt("ctb.quantity_returned");
                        int unitPrice = resultSet.getInt("ctb.don_gia");
                        int returnAmount = returnQuantity * unitPrice; // Thành tiền trả

                        // Tính tổng
                        totalReturnQuantity += returnQuantity;
                        totalReturnMoney += returnAmount;

                        // Định dạng số tiền
                        String formattedUnitPrice = Function.dinhDangTien(unitPrice);
                        String formattedReturnAmount = Function.dinhDangTien(returnAmount);

                        // Thêm dữ liệu vào bảng
                        Object[] row = {nextSTT, productId, name, soldQuantity, returnQuantity, formattedUnitPrice, formattedReturnAmount};
                        choiseProductTableModel.addRow(row);
                    } while (resultSet.next());

                    // Hiển thị tổng số lượng trả và tổng tiền trả
                    returnCount.setText(String.valueOf(totalReturnQuantity));
                    returnMoney.setText(Function.dinhDangTien(totalReturnMoney));
                } else {
                    JOptionPane.showMessageDialog(null, "Không tìm thấy phiếu trả với mã: " + id);
                }
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Lỗi cơ sở dữ liệu: " + ex.getMessage());
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

        jPanel4 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        idPhieuTraTF = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        accountNameTF = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        customerNameTF = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        dateTF = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        idPhieuBanTF = new javax.swing.JTextField();
        jPanel9 = new javax.swing.JPanel();
        choisePane = new javax.swing.JScrollPane();
        choiseProductTable = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        returnCount = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        returnMoney = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        killNoteBtn = new javax.swing.JButton();
        confirmBtn = new javax.swing.JButton();
        backBtn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Grocery Store");
        setBackground(new java.awt.Color(204, 255, 255));
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
            public void windowClosed(java.awt.event.WindowEvent evt) {
                backToImportUI(evt);
            }
        });
        getContentPane().setLayout(new javax.swing.BoxLayout(getContentPane(), javax.swing.BoxLayout.Y_AXIS));

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jPanel4.setLayout(new java.awt.GridBagLayout());

        jLabel1.setFont(new java.awt.Font("Sitka Text", 1, 18)); // NOI18N
        jLabel1.setText("Mã phiếu trả:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(15, 20, 10, 20);
        jPanel4.add(jLabel1, gridBagConstraints);

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
        gridBagConstraints.ipadx = 100;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(10, 20, 30, 20);
        jPanel4.add(idPhieuTraTF, gridBagConstraints);

        jLabel2.setFont(new java.awt.Font("Sitka Text", 1, 18)); // NOI18N
        jLabel2.setText("Nhân viên bán:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(15, 20, 10, 20);
        jPanel4.add(jLabel2, gridBagConstraints);

        accountNameTF.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        accountNameTF.setText("Vũ Khoa");
        accountNameTF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                accountNameTFActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.ipadx = 100;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(10, 20, 30, 20);
        jPanel4.add(accountNameTF, gridBagConstraints);

        jLabel4.setFont(new java.awt.Font("Sitka Text", 1, 18)); // NOI18N
        jLabel4.setText("Khách hàng:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(15, 20, 10, 20);
        jPanel4.add(jLabel4, gridBagConstraints);

        customerNameTF.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        customerNameTF.setText("Công ty TNHH Trung Kiên");
        customerNameTF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                customerNameTFActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.ipadx = 100;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(10, 20, 30, 20);
        jPanel4.add(customerNameTF, gridBagConstraints);

        jLabel6.setFont(new java.awt.Font("Sitka Text", 1, 18)); // NOI18N
        jLabel6.setText("Thời gian tạo:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(15, 20, 10, 20);
        jPanel4.add(jLabel6, gridBagConstraints);

        dateTF.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        dateTF.setText("Công ty TNHH Trung Kiên");
        dateTF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dateTFActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.ipadx = 100;
        gridBagConstraints.insets = new java.awt.Insets(10, 20, 30, 20);
        jPanel4.add(dateTF, gridBagConstraints);

        jLabel5.setFont(new java.awt.Font("Sitka Text", 1, 18)); // NOI18N
        jLabel5.setText("Mã phiếu bán:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(15, 20, 10, 20);
        jPanel4.add(jLabel5, gridBagConstraints);

        idPhieuBanTF.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        idPhieuBanTF.setText("1234");
        idPhieuBanTF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                idPhieuBanTFActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.ipadx = 100;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(10, 20, 30, 20);
        jPanel4.add(idPhieuBanTF, gridBagConstraints);

        getContentPane().add(jPanel4);

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

        getContentPane().add(jPanel9);

        jPanel2.setBackground(new java.awt.Color(204, 255, 255));
        jPanel2.setLayout(new java.awt.GridBagLayout());

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel3.setText("Tổng SL trả: ");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(10, 0, 10, 10);
        jPanel2.add(jLabel3, gridBagConstraints);

        returnCount.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        returnCount.setText("jLabel5");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(10, 0, 10, 50);
        jPanel2.add(returnCount, gridBagConstraints);

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel7.setText("Tổng tiền trả:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(10, 0, 10, 10);
        jPanel2.add(jLabel7, gridBagConstraints);

        returnMoney.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        returnMoney.setText("jLabel8");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(10, 0, 10, 0);
        jPanel2.add(returnMoney, gridBagConstraints);

        getContentPane().add(jPanel2);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new java.awt.GridBagLayout());

        jButton1.setBackground(new java.awt.Color(51, 204, 255));
        jButton1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Xuất PDF");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.ipadx = 20;
        gridBagConstraints.ipady = 10;
        gridBagConstraints.insets = new java.awt.Insets(20, 10, 20, 10);
        jPanel1.add(jButton1, gridBagConstraints);

        killNoteBtn.setBackground(new java.awt.Color(255, 102, 102));
        killNoteBtn.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        killNoteBtn.setForeground(new java.awt.Color(255, 255, 255));
        killNoteBtn.setText("Hủy phiếu");
        killNoteBtn.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        killNoteBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                killNoteBtnActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.ipadx = 30;
        gridBagConstraints.ipady = 10;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(20, 10, 20, 10);
        jPanel1.add(killNoteBtn, gridBagConstraints);

        confirmBtn.setBackground(new java.awt.Color(102, 204, 0));
        confirmBtn.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        confirmBtn.setForeground(new java.awt.Color(255, 255, 255));
        confirmBtn.setText("Xác nhận");
        confirmBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                confirmBtnActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.ipadx = 20;
        gridBagConstraints.ipady = 10;
        gridBagConstraints.insets = new java.awt.Insets(20, 10, 20, 10);
        jPanel1.add(confirmBtn, gridBagConstraints);

        backBtn.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        backBtn.setText("Back");
        backBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backBtnActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.ipadx = 20;
        gridBagConstraints.ipady = 10;
        gridBagConstraints.insets = new java.awt.Insets(20, 10, 20, 10);
        jPanel1.add(backBtn, gridBagConstraints);

        getContentPane().add(jPanel1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void idPhieuTraTFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_idPhieuTraTFActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_idPhieuTraTFActionPerformed

    private void accountNameTFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_accountNameTFActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_accountNameTFActionPerformed

    private void customerNameTFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_customerNameTFActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_customerNameTFActionPerformed

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated

    }//GEN-LAST:event_formWindowActivated

    private void choiseProductTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_choiseProductTableMouseClicked

    }//GEN-LAST:event_choiseProductTableMouseClicked

    private void dateTFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dateTFActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_dateTFActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void killNoteBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_killNoteBtnActionPerformed
        killNoteBtn.addActionListener(e -> {
            if (idPhieuTra == null || idPhieuTra.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Mã phiếu trả không hợp lệ!");
                return;
            }

            // Câu lệnh SQL
            String updatePhieuTraQuery = "UPDATE phieu_tra SET trang_thai = 2 WHERE ma_phieu_tra = ?";
            String resetQuantityReturnedQuery = "UPDATE ctphieuban SET quantity_returned = 0 "
                    + "WHERE ma_phieu_ban = (SELECT ma_phieu_ban FROM phieu_tra WHERE ma_phieu_tra = ?)";

            try (Connection con = JDBCUtil.getConnection(); PreparedStatement updatePhieuTraStmt = con.prepareStatement(updatePhieuTraQuery); PreparedStatement resetQuantityReturnedStmt = con.prepareStatement(resetQuantityReturnedQuery)) {

                // Gán tham số cho câu lệnh SQL
                updatePhieuTraStmt.setString(1, idPhieuTra);
                resetQuantityReturnedStmt.setString(1, idPhieuTra);

                // Đặt lại số lượng trả về 0 trong ctphieuban
                int quantityResetRows = resetQuantityReturnedStmt.executeUpdate();
                if (quantityResetRows > 0) {
                    System.out.println("Đặt lại số lượng trả trong ctphieuban thành công!");
                } else {
                    System.out.println("Không có dữ liệu nào trong ctphieuban cần đặt lại.");
                }

                // Cập nhật trạng thái phiếu trả
                int phieuTraRowsUpdated = updatePhieuTraStmt.executeUpdate();
                if (phieuTraRowsUpdated > 0) {
                    JOptionPane.showMessageDialog(this, "Hủy phiếu trả thành công!");
                } else {
                    JOptionPane.showMessageDialog(this, "Không tìm thấy phiếu trả để hủy!");
                }
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(this, "Lỗi khi hủy phiếu trả: " + ex.getMessage());
            }
        });

    }//GEN-LAST:event_killNoteBtnActionPerformed

    private void backToImportUI(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_backToImportUI
        CustomerReturnInvoiceGUI customerReturnInvoiceGUI = new CustomerReturnInvoiceGUI();
        customerReturnInvoiceGUI.setLocation(this.getX(), this.getY());
        customerReturnInvoiceGUI.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_backToImportUI

    private void backBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backBtnActionPerformed
        this.dispose();
    }//GEN-LAST:event_backBtnActionPerformed

    private void confirmBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_confirmBtnActionPerformed
        confirmBtn.addActionListener(e -> {
            if (idPhieuTra == null || idPhieuTra.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Mã phiếu trả không hợp lệ!");
                return;
            }

            // Câu lệnh SQL
            String updatePhieuTraQuery = "UPDATE phieu_tra SET trang_thai = 1 WHERE ma_phieu_tra = ?";
            String updateProductsQuery = "UPDATE products p "
                    + "SET p.quantity = p.quantity + ("
                    + "    SELECT SUM(ct.quantity_returned) "
                    + "    FROM ctphieuban ct "
                    + "    JOIN phieuban pb ON ct.ma_phieu_ban = pb.ma_phieu_ban "
                    + "    WHERE pb.ma_phieu_ban = (SELECT ma_phieu_ban FROM phieu_tra WHERE ma_phieu_tra = ?) "
                    + "    AND ct.ma_san_pham = p.id"
                    + ") "
                    + "WHERE EXISTS ("
                    + "    SELECT 1 "
                    + "    FROM ctphieuban ct "
                    + "    JOIN phieuban pb ON ct.ma_phieu_ban = pb.ma_phieu_ban "
                    + "    WHERE pb.ma_phieu_ban = (SELECT ma_phieu_ban FROM phieu_tra WHERE ma_phieu_tra = ?) "
                    + "    AND ct.ma_san_pham = p.id"
                    + ")";

            try (Connection con = JDBCUtil.getConnection(); PreparedStatement updatePhieuTraStmt = con.prepareStatement(updatePhieuTraQuery); PreparedStatement updateProductsStmt = con.prepareStatement(updateProductsQuery)) {

                // Gán tham số cho câu lệnh SQL
                updatePhieuTraStmt.setString(1, idPhieuTra);
                updateProductsStmt.setString(1, idPhieuTra);
                updateProductsStmt.setString(2, idPhieuTra);

                // Cập nhật bảng products trước
                int productRowsUpdated = updateProductsStmt.executeUpdate();
                if (productRowsUpdated > 0) {
                    System.out.println("Cập nhật số lượng sản phẩm thành công!");
                } else {
                    System.out.println("Không có sản phẩm nào được cập nhật.");
                }

                // Cập nhật trạng thái phiếu trả
                int phieuTraRowsUpdated = updatePhieuTraStmt.executeUpdate();
                if (phieuTraRowsUpdated > 0) {
                    JOptionPane.showMessageDialog(this, "Xác nhận phiếu trả thành công!");
                } else {
                    JOptionPane.showMessageDialog(this, "Không tìm thấy phiếu trả để xác nhận!");
                }
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(this, "Lỗi khi xác nhận phiếu trả: " + ex.getMessage());
            }
        });

    }//GEN-LAST:event_confirmBtnActionPerformed

    private void idPhieuBanTFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_idPhieuBanTFActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_idPhieuBanTFActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new ReturnInvoiceDetail().setVisible(true);
            }
        });
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField accountNameTF;
    private javax.swing.JButton backBtn;
    private javax.swing.JScrollPane choisePane;
    private javax.swing.JTable choiseProductTable;
    private javax.swing.JButton confirmBtn;
    private javax.swing.JTextField customerNameTF;
    private javax.swing.JTextField dateTF;
    private javax.swing.JTextField idPhieuBanTF;
    private javax.swing.JTextField idPhieuTraTF;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JButton killNoteBtn;
    private javax.swing.JLabel returnCount;
    private javax.swing.JLabel returnMoney;
    // End of variables declaration//GEN-END:variables
}
