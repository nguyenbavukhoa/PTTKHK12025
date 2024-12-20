/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.finaltermproject;

import com.formdev.flatlaf.extras.FlatSVGIcon;
import com.mycompany.createGUI.productGUI.AddProduct;
import com.mycompany.createGUI.productGUI.EditProduct;
import com.mycompany.createGUI.EditQuantity;
import com.mycompany.createGUI.importGUI.AddImportNote;
import com.mycompany.setUpJTable.CheckQuantityCellRenderer;
import com.mycompany.HandlerClass.Function;
import com.sqlConnection.JDBCUtil;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author letri
 */
public class storageUI extends javax.swing.JFrame {

    String productQueryString = null;
    DefaultTableModel productTableModel;

    /**
     * Creates new form storageUI
     */
    public storageUI() {
        initComponents();
        productTableModel = this.productTableModel = (DefaultTableModel) productTable.getModel();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        Logo = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jComboBox2 = new javax.swing.JComboBox<>();
        BackButton1 = new javax.swing.JButton();
        RefreshButton = new javax.swing.JButton();
        SearchTextField = new javax.swing.JTextField();
        SearchButton = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        productTable = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Grocery Store");
        setBackground(new java.awt.Color(204, 255, 255));
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
        });
        getContentPane().setLayout(new javax.swing.BoxLayout(getContentPane(), javax.swing.BoxLayout.Y_AXIS));

        jPanel2.setBackground(new java.awt.Color(204, 255, 255));

        Logo.setBackground(new java.awt.Color(204, 255, 255));

        jLabel2.setIcon(new FlatSVGIcon("./icon/product.svg"));

        jLabel3.setBackground(new java.awt.Color(255, 255, 255));
        jLabel3.setFont(new java.awt.Font("Sitka Text", 1, 48)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(51, 51, 51));
        jLabel3.setText("Quản lý sản phẩm");
        jLabel3.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout LogoLayout = new javax.swing.GroupLayout(Logo);
        Logo.setLayout(LogoLayout);
        LogoLayout.setHorizontalGroup(
            LogoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(LogoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addContainerGap())
        );
        LogoLayout.setVerticalGroup(
            LogoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(LogoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(11, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, LogoLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jButton2.setText("Suppliers");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("Edit quantity");
        jButton3.setEnabled(false);
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton1.setText("Add Products");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addProduct(evt);
            }
        });

        jButton5.setText("Edit Products");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editProduct(evt);
            }
        });

        jButton6.setText("delete Products");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteProduct(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Logo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(49, 49, 49)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(10, 10, 10)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton5)
                            .addComponent(jButton6))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton2)
                            .addComponent(jButton1)
                            .addComponent(jButton3))
                        .addContainerGap())
                    .addComponent(Logo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        getContentPane().add(jPanel2);

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Sort by", "Name: A to Z", "Name: Z to A", "Low to High Price", "High to Low Price" }));
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });

        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Filter by type", "Đồ uống", "Bánh ngọt", "Đồ ăn nhẹ", "Gia vị", "Hóa mỹ phẩm" }));
        jComboBox2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox2ActionPerformed(evt);
            }
        });

        BackButton1.setText("Back");
        BackButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BackButton1ActionPerformed(evt);
            }
        });

        RefreshButton.setText("Refresh");
        RefreshButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RefreshButtonActionPerformed(evt);
            }
        });

        SearchTextField.setColumns(15);
        SearchTextField.setFont(new java.awt.Font("Segoe UI", 2, 12)); // NOI18N
        SearchTextField.setText("Enter product's name");
        SearchTextField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                SearchTextFieldFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                SearchTextFieldFocusLost(evt);
            }
        });
        SearchTextField.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                SearchTextFieldMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                SearchTextFieldMouseExited(evt);
            }
        });
        SearchTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SearchTextFieldActionPerformed(evt);
            }
        });

        SearchButton.setText("Search");
        SearchButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SearchButtonActionPerformed(evt);
            }
        });

        jButton4.setText("Import report");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(BackButton1)
                .addGap(18, 18, 18)
                .addComponent(RefreshButton, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 104, Short.MAX_VALUE)
                .addComponent(jButton4)
                .addGap(54, 54, 54)
                .addComponent(SearchButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(SearchTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BackButton1)
                    .addComponent(RefreshButton)
                    .addComponent(SearchTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(SearchButton)
                    .addComponent(jButton4))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel5);

        jScrollPane1.setBackground(new java.awt.Color(255, 255, 255));

        productTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "ID", "Tên sản phẩm", "Giá nhập TB", "Giá Bán", "Xuất xứ", "Nhà cung cấp", "Phân loại", "Số lượng"
            }
        ));
        productTable.setGridColor(new java.awt.Color(204, 255, 255));
        productTable.setSelectionBackground(new java.awt.Color(0, 153, 204));
        productTable.setSelectionForeground(new java.awt.Color(255, 255, 255));
        jScrollPane1.setViewportView(productTable);

        getContentPane().add(jScrollPane1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BackButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BackButton1ActionPerformed
        mainUI main = new mainUI();
        main.setLocation(this.getX(), this.getY());
        main.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_BackButton1ActionPerformed

    private void RefreshButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RefreshButtonActionPerformed
        try {
            //Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = JDBCUtil.getConnection();

            ResultSet resultSet = JDBCUtil.getResultSet(con, productQueryString);

            ResultSetMetaData resultSetMetaData = JDBCUtil.getMetaData(resultSet);

            productTableModel.setRowCount(0);

            String id, name, import_avg_price, sell_price, quantity, product_type, origin, supplier;
            while (resultSet.next()) {
                id = resultSet.getString(1);
                name = resultSet.getString(2);
                import_avg_price = Function.dinhDangTien(Long.parseLong(resultSet.getString(3).split("\\.")[0]));
                sell_price = resultSet.getString(4);
                origin = resultSet.getString(5);
                supplier = resultSet.getString(6);
                product_type = resultSet.getString(7);
                quantity = resultSet.getString(8);
                String[] row = {id, name, import_avg_price, sell_price, origin, supplier, product_type, quantity};
                productTableModel.addRow(row);
            }
            productTable.setDefaultRenderer(Object.class, new CheckQuantityCellRenderer(7, 20));
            JDBCUtil.closeConnection(con);
            //jButton1.setEnabled(false);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_RefreshButtonActionPerformed

    private void SearchButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SearchButtonActionPerformed
        if (SearchTextField.getText().equals("Enter product's name") || SearchTextField.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Please enter product's name!");
        }
        try {
            Connection con = JDBCUtil.getConnection();
            StringBuilder query = new StringBuilder(productQueryString);
            query.append("HAVING pr.product_name LIKE ?");

            ResultSet resultSet = JDBCUtil.getResultSet(con, query.toString(), 1, "%" + SearchTextField.getText() + "%");

            ResultSetMetaData resultSetMetaData = JDBCUtil.getMetaData(resultSet);

            productTableModel.setRowCount(0);

            String id, name, import_avg_price, sell_price, quantity, product_type, origin, supplier;
            while (resultSet.next()) {
                id = resultSet.getString(1);
                name = resultSet.getString(2);
                import_avg_price = Function.dinhDangTien(Long.parseLong(resultSet.getString(3).split("\\.")[0]));
                sell_price = resultSet.getString(4);
                origin = resultSet.getString(5);
                supplier = resultSet.getString(6);
                product_type = resultSet.getString(7);
                quantity = resultSet.getString(8);
                String[] row = {id, name, import_avg_price, sell_price, origin, supplier, product_type, quantity};
                productTableModel.addRow(row);
            }
            productTable.setDefaultRenderer(Object.class, new CheckQuantityCellRenderer(7, 20));
            JDBCUtil.closeConnection(con);

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }//GEN-LAST:event_SearchButtonActionPerformed

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        updateTableData();
    }//GEN-LAST:event_jComboBox1ActionPerformed

    private void jComboBox2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox2ActionPerformed
        updateTableData();
    }//GEN-LAST:event_jComboBox2ActionPerformed

    private void SearchTextFieldMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SearchTextFieldMouseClicked

    }//GEN-LAST:event_SearchTextFieldMouseClicked

    private void SearchTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SearchTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_SearchTextFieldActionPerformed

    private void SearchTextFieldFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_SearchTextFieldFocusLost
        if (SearchTextField.getText().equals(""))
            SearchTextField.setText("Enter product's name");
    }//GEN-LAST:event_SearchTextFieldFocusLost

    private void SearchTextFieldMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SearchTextFieldMouseExited

    }//GEN-LAST:event_SearchTextFieldMouseExited

    private void SearchTextFieldFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_SearchTextFieldFocusGained
        SearchTextField.setText("");
    }//GEN-LAST:event_SearchTextFieldFocusGained

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated

        productQueryString = "SELECT"
                + "    pr.id AS ma_san_pham,"
                + "    pr.product_name,"
                + "    AVG(CAST(ct.don_gia AS INT)) AS gia_nhap_trung_binh,"
                + "    pr.sell_price,"
                + "    pr.origin,"
                + "    pr.supplier,"
                + "    pr.product_type,"
                + "    pr.quantity "
                + "FROM "
                + "    products pr "
                + "LEFT JOIN ctphieunhap ct ON"
                + "    pr.id = ct.ma_san_pham "
                + "GROUP BY "
                + "    pr.id,"
                + "    pr.product_name,"
                + "    pr.sell_price,"
                + "    pr.origin,"
                + "    pr.supplier,"
                + "    pr.product_type,"
                + "    pr.quantity ";
        try (Connection con = JDBCUtil.getConnection()) {
            ResultSet resultSet = JDBCUtil.getResultSet(con, productQueryString);

            ResultSetMetaData resultSetMetaData = JDBCUtil.getMetaData(resultSet);

            productTableModel.setRowCount(0);

            String id, name, import_avg_price, sell_price, quantity, product_type, origin, supplier;
            while (resultSet.next()) {
                id = resultSet.getString(1);
                name = resultSet.getString(2);
                import_avg_price = Function.dinhDangTien(Long.parseLong(resultSet.getString(3).split("\\.")[0]));
                sell_price = resultSet.getString(4);
                origin = resultSet.getString(5);
                supplier = resultSet.getString(6);
                product_type = resultSet.getString(7);
                quantity = resultSet.getString(8);
                String[] row = {id, name, import_avg_price, sell_price, origin, supplier, product_type, quantity};
                productTableModel.addRow(row);
            }
            productTable.setDefaultRenderer(Object.class, new CheckQuantityCellRenderer(7, 20));
        } catch (SQLException ex) {
            Logger.getLogger(storageUI.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_formWindowActivated

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        int selectedRow = productTable.getSelectedRow();
        if (selectedRow != -1) {
            AddImportNote addImportNote = new AddImportNote((String) productTable.getValueAt(selectedRow, 0));
            addImportNote.setLocation(this.getX()+20, this.getY()+20);
            addImportNote.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            addImportNote.setVisible(true);

        } else {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn một dòng!");
        }
        
    }//GEN-LAST:event_jButton4ActionPerformed

    private void deleteProduct(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteProduct
        // Hiển thị thông báo xác nhận xóa
        int confirm = JOptionPane.showConfirmDialog(null,
                "Bạn có chắc chắn muốn xóa sản phẩm này?",
                "Xác nhận xóa",
                JOptionPane.YES_NO_OPTION);

        // Nếu người dùng chọn "Có"
        if (confirm == JOptionPane.YES_OPTION) {
            String productId = null;
            int selectedRow = productTable.getSelectedRow();
            if (selectedRow != -1) {
                productId = (String) productTable.getValueAt(selectedRow, 0);
                try {
                    Connection con = JDBCUtil.getConnection();

                    // 2. Tạo câu lệnh SQL DELETE
                    String sql = "DELETE FROM products WHERE id = ?";

                    // 3. Thực thi câu lệnh DELETE
                    int rowsDeleted = JDBCUtil.getPreparedStatement(con, sql, 1, productId).executeUpdate();

                    if (rowsDeleted > 0) {
                        productTableModel.removeRow(selectedRow);
                        JOptionPane.showMessageDialog(null, "Đã xóa sản phẩm thành công!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);

                    } else {
                        JOptionPane.showMessageDialog(null, "Không tìm thấy sản phẩm để xóa.", "Lỗi", JOptionPane.ERROR_MESSAGE);
                    }

                } catch (SQLException e) {
                    if (e.getSQLState().equals("23503")) {
                        JOptionPane.showMessageDialog(null, "Không thể xóa sản phẩm này vì nó đang được sử dụng trong đơn hàng.", "Lỗi", JOptionPane.ERROR_MESSAGE);
                    } else {
                        JOptionPane.showMessageDialog(null, "Lỗi khi xóa sản phẩm!", "Lỗi", JOptionPane.ERROR_MESSAGE);
                    }
                }
            } else {
                JOptionPane.showMessageDialog(this, "Vui lòng chọn một dòng!");
            }
        }
    }//GEN-LAST:event_deleteProduct

    private void editProduct(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editProduct
        int selectedRow = productTable.getSelectedRow();
        if (selectedRow != -1) {
            try {
                EditProduct editProduct = new EditProduct((String) productTable.getValueAt(selectedRow, 0));
                editProduct.setLocation(this.getX() + 20, this.getY() + 20);
                editProduct.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                editProduct.setVisible(true);
            } catch (SQLException ex) {
                Logger.getLogger(storageUI.class.getName()).log(Level.SEVERE, null, ex);
            }

        } else {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn một dòng!");
        }
    }//GEN-LAST:event_editProduct

    private void addProduct(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addProduct
        AddProduct addProduct = new AddProduct();
        addProduct.setLocation(this.getX() + 20, this.getY() + 20);
        addProduct.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        addProduct.setVisible(true);
    }//GEN-LAST:event_addProduct

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        EditQuantity editQuantity = new EditQuantity();
        editQuantity.setLocation(this.getX() + 20, this.getY() + 20);
        editQuantity.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        editQuantity.setVisible(true);
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        SupplierGUI supplierGUI = new SupplierGUI();
        supplierGUI.setLocation(this.getX()+20, this.getY()+20);
        supplierGUI.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        supplierGUI.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

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
            java.util.logging.Logger.getLogger(storageUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(storageUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(storageUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(storageUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new storageUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BackButton1;
    private javax.swing.JPanel Logo;
    private javax.swing.JButton RefreshButton;
    private javax.swing.JButton SearchButton;
    private javax.swing.JTextField SearchTextField;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable productTable;
    // End of variables declaration//GEN-END:variables

    private void updateTableData() {
        String sortOption = (String) jComboBox1.getSelectedItem();
        String filterOption = (String) jComboBox2.getSelectedItem();
        //filterOption = filterOption.toLowerCase();

        StringBuilder query = new StringBuilder(productQueryString);

        boolean hasFilter = !filterOption.equals("Filter by type");
        if (hasFilter) {
            query.append("HAVING pr.product_type = ?");
        }

        switch (sortOption) {
            case "Name: A to Z":
                query.append(" ORDER BY pr.product_name ASC");
                break;
            case "Name: Z to A":
                query.append(" ORDER BY pr.product_name DESC");
                break;
            case "Low to High Price":
                query.append(" ORDER BY pr.sell_price ASC");
                break;
            case "High to Low Price":
                query.append(" ORDER BY pr.sell_price DESC");
                break;
            default:
                // No sorting
                break;
        }

        try {
            Connection con = JDBCUtil.getConnection();
            PreparedStatement pr = con.prepareStatement(query.toString());

            if (hasFilter) {
                pr.setString(1, filterOption);
            }

            ResultSet resultSet = pr.executeQuery();

            // Clear the current data in the table
            productTableModel.setRowCount(0);

            // Add rows to the table model
            while (resultSet.next()) {
                String[] row = new String[8];
                for (int i = 0; i < 8; i++) {
                    row[i] = resultSet.getString(i + 1);
                }
                productTableModel.addRow(row);
            }

            JDBCUtil.closeConnection(con);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
