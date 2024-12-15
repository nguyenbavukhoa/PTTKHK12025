/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.HandlerClass;

import com.sqlConnection.JDBCUtil;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;

/**
 *
 * @author Vu Khoa
 */
public class ImportHandler {
    // Phương thức tạo phiếu nhập và chi tiết phiếu nhập
    public static void taoPhieuNhap(String productId, int quantity, String donGia) {
        try(Connection conn = JDBCUtil.getConnection()) {
            // Tạo mã phiếu nhập
            String maPhieuNhap = "PN" + Function.generateUniqueRandomString(conn, "phieunhap", "ma_phieu_nhap", 8);

            // Thêm vào bảng phieunhap
            String sqlInsertPhieuNhap = "INSERT INTO phieunhap (ma_phieu_nhap, thoi_gian, trang_thai, ma_nha_cung_cap, account_id) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement psPhieuNhap = conn.prepareStatement(sqlInsertPhieuNhap);
            psPhieuNhap.setString(1, maPhieuNhap);
            psPhieuNhap.setDate(2, Date.valueOf(LocalDate.now())); // Ngày hiện tại
            psPhieuNhap.setInt(3, 1); // Trạng thái = 1
            psPhieuNhap.setString(4, "NCC" + Function.generateUniqueRandomString(conn, "nha_cung_cap", "ma_nha_cung_cap", 7)); // Mã nhà cung cấp (có thể lấy từ Form)
            psPhieuNhap.setString(5, "ACC001"); // Mã tài khoản (có thể thay đổi)
            psPhieuNhap.executeUpdate();

            // Thêm vào bảng ctphieunhap
            String sqlInsertCTPhieuNhap = "INSERT INTO ctphieunhap (ma_phieu_nhap, ma_san_pham, quantity, don_gia) VALUES (?, ?, ?, ?)";
            PreparedStatement psCTPhieuNhap = conn.prepareStatement(sqlInsertCTPhieuNhap);
            psCTPhieuNhap.setString(1, maPhieuNhap);
            psCTPhieuNhap.setString(2, productId);
            psCTPhieuNhap.setInt(3, quantity);
            psCTPhieuNhap.setString(4, donGia); // Đơn giá = 0 (có thể thay đổi theo yêu cầu)
            psCTPhieuNhap.executeUpdate();

            System.out.println("Đã tạo phiếu nhập và chi tiết phiếu nhập cho sản phẩm: " + productId);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
