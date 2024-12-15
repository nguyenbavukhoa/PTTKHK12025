-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Máy chủ: 127.0.0.1
-- Thời gian đã tạo: Th12 15, 2024 lúc 11:04 AM
-- Phiên bản máy phục vụ: 10.4.32-MariaDB
-- Phiên bản PHP: 8.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Cơ sở dữ liệu: `grocerystore`
--

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `account`
--

CREATE TABLE `account` (
  `username` varchar(10) NOT NULL,
  `password` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Đang đổ dữ liệu cho bảng `account`
--

INSERT INTO `account` (`username`, `password`) VALUES
('admin', 'admin'),
('S001', 'password001'),
('S002', 'password002'),
('S003', 'password003'),
('S004', 'password004'),
('S005', 'password005'),
('S006', 'password006'),
('S007', 'password007'),
('S008', 'password008'),
('S009', 'password009'),
('S010', 'password010'),
('S011', 'password011'),
('S012', 'password012'),
('S013', 'password013'),
('S014', 'password014'),
('S015', 'password015'),
('S016', 'password016'),
('S017', 'password017'),
('S018', 'password018'),
('S019', 'password019'),
('S020', 'password020'),
('S021', 'password021'),
('S022', 'password022'),
('S023', 'password023'),
('S024', 'password024'),
('S025', 'password025'),
('S026', 'password026'),
('S027', 'password027'),
('S028', 'password028'),
('S029', 'password029');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `ctphieuban`
--

CREATE TABLE `ctphieuban` (
  `ma_phieu_ban` varchar(10) NOT NULL,
  `ma_san_pham` varchar(10) NOT NULL,
  `quantity` int(11) NOT NULL,
  `don_gia` int(11) NOT NULL,
  `quantity_returned` int(11) DEFAULT 0
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Đang đổ dữ liệu cho bảng `ctphieuban`
--

INSERT INTO `ctphieuban` (`ma_phieu_ban`, `ma_san_pham`, `quantity`, `don_gia`, `quantity_returned`) VALUES
('PB001', '1', 5, 27000, 0),
('PB001', '10', 4, 25000, 0),
('PB0011', 'SP001', 5, 50000, 2),
('PB0011', 'SP002', 3, 45000, 1),
('PB002', '11', 6, 45000, 0),
('PB002', '12', 8, 14000, 0),
('PB003', '13', 10, 18000, 0),
('PB003', '14', 7, 10000, 0),
('PB004', '15', 6, 13000, 0),
('PB004', '16', 8, 27000, 0),
('PB005', '17', 4, 90000, 0),
('PB005', '18', 10, 23000, 0),
('PB006', '19', 5, 18000, 0),
('PB006', '20', 3, 40000, 0),
('PB007', '2', 8, 22000, 0),
('PB007', '3', 12, 9000, 0),
('PB008', '4', 7, 15000, 0),
('PB008', '5', 10, 10000, 0),
('PB009', '6', 9, 20000, 0),
('PB009', '7', 11, 19000, 0),
('PB010', '8', 15, 4000, 0),
('PB010', '9', 10, 35000, 0),
('PBhMOPu39W', '14', 20, 12000, 0),
('PBhMOPu39W', '17', 10, 100000, 0),
('PBni8E0nxa', '12', 20, 15000, 0),
('PBp9knp49N', '16', 50, 30000, 0),
('PBukg14MSs', '11', 20, 50000, 0),
('PBuuQTFj35', '18', 100, 25000, 0);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `ctphieunhap`
--

CREATE TABLE `ctphieunhap` (
  `ma_phieu_nhap` varchar(10) NOT NULL,
  `ma_san_pham` varchar(10) NOT NULL,
  `quantity` int(11) NOT NULL,
  `don_gia` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Đang đổ dữ liệu cho bảng `ctphieunhap`
--

INSERT INTO `ctphieunhap` (`ma_phieu_nhap`, `ma_san_pham`, `quantity`, `don_gia`) VALUES
('PN001', '4', 10, '12000'),
('PN001', '14', 15, '8000'),
('PN001', '3', 20, '5000'),
('PN002', '7', 25, '12000'),
('PN002', '6', 30, '15000'),
('PN003', '20', 10, '30000'),
('PN003', '8', 15, '4000'),
('PN003', '9', 12, '25000'),
('PN004', '18', 18, '15000'),
('PN004', '11', 14, '30000'),
('PN004', '13', 16, '15000'),
('PN005', '12', 20, '12000'),
('PN005', '15', 22, '10000'),
('PN006', '1', 30, '12000'),
('PN006', '19', 18, '10000'),
('PN006', '17', 25, '70000'),
('PN007', '10', 12, '20000'),
('PN007', '5', 14, '7000'),
('PN007', '2', 10, '20000'),
('PN008', '16', 28, '25000'),
('PN001', 'SP001', 10, '50000'),
('PN001', 'SP002', 20, '30000'),
('PNlQsXFcnf', 'D7xT89eXTh', 10, '80000');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `khach_hang`
--

CREATE TABLE `khach_hang` (
  `ma_khach_hang` varchar(10) NOT NULL,
  `ten_khach_hang` varchar(255) NOT NULL,
  `dia_chi` varchar(255) DEFAULT NULL,
  `so_dien_thoai` varchar(15) DEFAULT NULL,
  `email` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Đang đổ dữ liệu cho bảng `khach_hang`
--

INSERT INTO `khach_hang` (`ma_khach_hang`, `ten_khach_hang`, `dia_chi`, `so_dien_thoai`, `email`) VALUES
('KH001', 'Huynh Trong Phuc', 'Hà Nội', '0123456789', 'a@example.com'),
('KH002', 'Tran Thi B', 'Hồ Chí Minh', '0123456790', 'b@example.com'),
('KH003', 'Le Van C', 'Đà Nẵng', '0123456791', 'c@example.com'),
('KH004', 'Pham Thi D', 'Hải Phòng', '0123456792', 'd@example.com'),
('KH005', 'Hoang Van E', 'Cần Thơ', '0123456793', 'e@example.com'),
('KH006', 'Nguyen Thi F', 'Vũng Tàu', '0123456794', 'f@example.com'),
('KH007', 'Tran Van G', 'Nha Trang', '0123456795', 'g@example.com'),
('KH008', 'Le Thi H', 'Huế', '0123456796', 'h@example.com'),
('KH009', 'Pham Van I', 'Quảng Nam', '0123456797', 'i@example.com'),
('KH010', 'Hoang Thi J', 'Thanh Hóa', '0123456798', 'j@example.com'),
('KHgwptKCO', 'Phúc', 'Vĩnh Long', '12873891245', '4@gmail.com'),
('KHWwtI7OS', 'Công ty TNHH Trung Kiên', NULL, NULL, NULL);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `nha_cung_cap`
--

CREATE TABLE `nha_cung_cap` (
  `ma_nha_cung_cap` varchar(10) NOT NULL,
  `ten_nha_cung_cap` varchar(255) NOT NULL,
  `dia_chi` varchar(255) DEFAULT NULL,
  `so_dien_thoai` varchar(20) DEFAULT NULL,
  `email` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Đang đổ dữ liệu cho bảng `nha_cung_cap`
--

INSERT INTO `nha_cung_cap` (`ma_nha_cung_cap`, `ten_nha_cung_cap`, `dia_chi`, `so_dien_thoai`, `email`) VALUES
('NCC001', 'Công ty A', 'Hà Nội', '0123456789', 'a@example.com'),
('NCC002', 'Công ty B', 'Hồ Chí Minh', '0123456790', 'b@example.com'),
('NCC003', 'Công ty C', 'Đà Nẵng', '0123456791', 'c@example.com'),
('NCC004', 'Công ty D', 'Hải Phòng', '0123456792', 'd@example.com'),
('NCC005', 'Công ty E', 'Cần Thơ', '0123456793', 'e@example.com'),
('NCC006', 'Công ty F', 'Vũng Tàu', '0123456794', 'f@example.com'),
('NCC007', 'Công ty G', 'Nha Trang', '0123456795', 'g@example.com'),
('NCC008', 'Công ty H', 'Huế', '0123456796', 'h@example.com'),
('NCCjKah3H', 'Kingston', NULL, NULL, NULL);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `phieuban`
--

CREATE TABLE `phieuban` (
  `ma_phieu_ban` varchar(10) NOT NULL,
  `thoi_gian` date NOT NULL,
  `trang_thai` int(11) NOT NULL,
  `khach_hang` varchar(10) NOT NULL,
  `account_id` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Đang đổ dữ liệu cho bảng `phieuban`
--

INSERT INTO `phieuban` (`ma_phieu_ban`, `thoi_gian`, `trang_thai`, `khach_hang`, `account_id`) VALUES
('PB001', '2024-12-01', 1, 'KH001', 'TK001'),
('PB0011', '2024-12-15', 1, 'KH001', 'NV001'),
('PB002', '2024-12-02', 1, 'KH002', 'TK002'),
('PB003', '2024-12-03', 1, 'KH003', 'TK003'),
('PB004', '2024-12-04', 1, 'KH004', 'TK004'),
('PB005', '2024-12-05', 1, 'KH005', 'TK005'),
('PB006', '2024-12-06', 1, 'KH006', 'TK006'),
('PB007', '2024-12-07', 1, 'KH007', 'TK007'),
('PB008', '2024-12-08', 1, 'KH008', 'TK008'),
('PB009', '2024-12-09', 1, 'KH009', 'TK009'),
('PB010', '2024-12-10', 1, 'KH010', 'TK010'),
('PBhMOPu39W', '2024-12-15', 1, 'KHgwptKCO', 'Vũ Khoa'),
('PBni8E0nxa', '2024-12-14', 1, 'KHgwptKCO', 'Vũ Khoa'),
('PBp9knp49N', '2024-12-15', 2, 'KHWwtI7OS', 'Vũ Khoa'),
('PBukg14MSs', '2024-12-15', 2, 'KHgwptKCO', 'Vũ Khoa'),
('PBuuQTFj35', '2024-12-14', 1, 'KHWwtI7OS', 'Vũ Khoa');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `phieunhap`
--

CREATE TABLE `phieunhap` (
  `ma_phieu_nhap` varchar(10) NOT NULL,
  `thoi_gian` date NOT NULL,
  `trang_thai` int(11) NOT NULL,
  `ma_nha_cung_cap` varchar(10) NOT NULL,
  `account_id` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Đang đổ dữ liệu cho bảng `phieunhap`
--

INSERT INTO `phieunhap` (`ma_phieu_nhap`, `thoi_gian`, `trang_thai`, `ma_nha_cung_cap`, `account_id`) VALUES
('PN001', '2024-12-01', 1, 'NCC001', 'TK001'),
('PN0012', '2024-12-14', 1, 'NCC001', 'admin'),
('PN002', '2024-12-02', 1, 'NCC002', 'TK002'),
('PN003', '2024-12-03', 1, 'NCC003', 'TK003'),
('PN004', '2024-12-04', 1, 'NCC004', 'TK004'),
('PN005', '2024-12-05', 1, 'NCC005', 'TK005'),
('PN006', '2024-12-06', 1, 'NCC006', 'TK006'),
('PN007', '2024-12-07', 1, 'NCC007', 'TK007'),
('PN008', '2024-12-08', 1, 'NCC008', 'TK008'),
('PNlQsXFcnf', '2024-12-15', 1, 'NCCjKah3H', 'admin');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `phieu_tra`
--

CREATE TABLE `phieu_tra` (
  `ma_phieu_tra` varchar(10) NOT NULL,
  `thoi_gian` date NOT NULL,
  `ma_phieu_ban` varchar(10) NOT NULL,
  `tong_tien` bigint(20) NOT NULL,
  `account_id` varchar(10) NOT NULL,
  `trang_thai` int(11) DEFAULT 1
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Đang đổ dữ liệu cho bảng `phieu_tra`
--

INSERT INTO `phieu_tra` (`ma_phieu_tra`, `thoi_gian`, `ma_phieu_ban`, `tong_tien`, `account_id`, `trang_thai`) VALUES
('PT001', '2024-12-16', 'PB0011', 0, 'NV001', 0);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `products`
--

CREATE TABLE `products` (
  `id` varchar(10) NOT NULL,
  `product_name` varchar(255) DEFAULT NULL,
  `sell_price` int(11) DEFAULT NULL,
  `origin` varchar(255) DEFAULT NULL,
  `supplier` varchar(255) DEFAULT NULL,
  `product_type` varchar(50) DEFAULT NULL,
  `quantity` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Đang đổ dữ liệu cho bảng `products`
--

INSERT INTO `products` (`id`, `product_name`, `sell_price`, `origin`, `supplier`, `product_type`, `quantity`) VALUES
('1', 'Cà Phê ', 30000, 'Việt Nam', 'Trung Nguyên', 'Đồ uống', 100),
('10', 'Nước Tương', 30000, 'Việt Nam', 'Chinsu', 'Gia vị', 100),
('11', 'Nước Mắm', 50000, 'Việt Nam', 'Nam Ngư', 'Gia vị', 120),
('12', 'Sữa Đậu Nà', 15000, 'Việt Nam', 'Fami', 'Đồ uống', 80),
('13', 'Sữa Tươi có đường', 20000, 'Việt Nam', 'Vinamilk', 'Đồ uống', 90),
('14', 'Bánh Gạo', 12000, 'Việt Nam', 'OneOne', 'Bánh kẹo', 50),
('15', 'Sữa Chua', 15000, 'Việt Nam', 'Vinamilk', 'Đồ uống', 100),
('16', 'Rau Củ', 30000, 'Việt Nam', 'Co.op Mart', 'Thực phẩm', 150),
('17', 'Thịt Heo', 100000, 'Việt Nam', 'Vissan', 'Thực phẩm', 50),
('18', 'Khẩu Trang', 25000, 'Việt Nam', 'May Nhà Bè', 'Y tế', 200),
('19', 'Xà Phòng', 20000, 'Việt Nam', 'Lifebuoy', 'Hóa mỹ phẩm', 90),
('2', 'Trà Sữa', 25000, 'Việt Nam', 'Vinamilk', 'Đồ uống', 120),
('20', 'Bột Giặt', 50000, 'Việt Nam', 'Omo', 'Hóa mỹ phẩm', 80),
('3', 'Bánh Mì', 10000, 'Việt Nam', 'ABC Bakery', 'Bánh ngọt', 80),
('4', 'Bánh Choco', 18000, 'Hàn Quốc', 'Orion', 'Bánh kẹo', 60),
('5', 'Snack Khoa', 12000, 'Việt Nam', 'Oishi', 'Đồ ăn nhẹ', 100),
('6', 'Bia Sài Gò', 25000, 'Việt Nam', 'Sabeco', 'Đồ uống', 200),
('7', 'Bia Hà Nội', 22000, 'Việt Nam', 'Habeco', 'Đồ uống', 180),
('8', 'Mì Tôm', 5000, 'Việt Nam', 'Acecook', 'Thực phẩm', 510),
('9', 'Dầu Ăn', 40000, 'Việt Nam', 'Tường An', 'Gia vị', 90),
('D7xT89eXTh', 'USB', 100000, 'Việt Nam', 'NCCjKah3H', 'Đồ uống', 10),
('SP001', 'Cà phê Trung Nguyên', 55000, 'Việt Nam', 'Trung Nguyên', 'Đồ uống', 100),
('SP002', 'Nước cam Ép', 45000, 'Việt Nam', 'Tropicana', 'Nước uống', 200);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `staff`
--

CREATE TABLE `staff` (
  `id` varchar(10) NOT NULL,
  `name` varchar(50) DEFAULT NULL,
  `sex` enum('male','female') DEFAULT NULL,
  `dob` date DEFAULT NULL,
  `address` varchar(50) DEFAULT NULL,
  `salary` int(11) DEFAULT NULL,
  `start_date` date DEFAULT NULL,
  `end_date` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Đang đổ dữ liệu cho bảng `staff`
--

INSERT INTO `staff` (`id`, `name`, `sex`, `dob`, `address`, `salary`, `start_date`, `end_date`) VALUES
('admin', 'Alexis Price', 'female', '1994-02-01', '567 Elm Blvd, Miami', 7865, '2023-06-01', NULL),
('S001', 'John Doe', 'male', '1990-05-15', '123 Main St, New York', 16099, '2021-01-01', NULL),
('S002', 'Jane Smith', 'female', '1992-08-20', '456 Oak Ave, Los Angeles', 15699, '2021-02-01', NULL),
('S003', 'Michael Johnson', 'male', '1985-03-10', '789 Elm Rd, Chicago', 15345, '2021-03-01', NULL),
('S004', 'Emily Brown', 'female', '1991-11-25', '567 Pine Blvd, Houston', NULL, '2021-04-01', '2022-04-01'),
('S005', 'David Wilson', 'male', '1988-07-05', '890 Cedar Dr, San Francisco', NULL, '2021-05-01', '2022-05-01'),
('S006', 'Jessica Martinez', 'female', '1993-02-18', '234 Maple Ln, Miami', NULL, '2021-06-01', '2022-06-01'),
('S007', 'Christopher Garcia', 'male', '1987-09-30', '678 Birch Ave, Boston', 13896, '2021-07-01', NULL),
('S008', 'Sarah Lopez', 'female', '1990-04-12', '345 Oakwood St, Seattle', 13550, '2021-08-01', NULL),
('S009', 'Daniel Miller', 'male', '1986-01-08', '456 Pinecrest Rd, Denver', 13213, '2021-09-01', NULL),
('S010', 'Melissa Thompson', 'female', '1994-06-22', '789 Elmwood Dr, Atlanta', NULL, '2021-10-01', '2022-10-01'),
('S011', 'Robert White', 'male', '1989-12-17', '567 Maplewood Ave, Dallas', NULL, '2021-11-01', '2022-11-01'),
('S012', 'Amanda Scott', 'female', '1992-03-28', '123 Cedar Ln, Philadelphia', 12270, '2021-12-01', NULL),
('S013', 'William Lee', 'male', '1984-08-14', '890 Pine Rd, Phoenix', 11965, '2022-01-01', NULL),
('S014', 'Laura King', 'female', '1991-05-03', '234 Birch Ave, Detroit', 11667, '2022-02-01', NULL),
('S015', 'Richard Perez', 'male', '1987-10-19', '456 Elm St, Minneapolis', 11404, '2022-03-01', NULL),
('S016', 'Jennifer Harris', 'female', '1993-07-08', '678 Oak Ave, Baltimore', NULL, '2022-04-01', '2023-04-01'),
('S017', 'Matthew Clark', 'male', '1985-02-11', '789 Maple Rd, Portland', 10852, '2022-05-01', NULL),
('S018', 'Michelle Lewis', 'female', '1990-09-26', '345 Pine Blvd, Las Vegas', 10582, '2022-06-01', NULL),
('S019', 'Joshua Robinson', 'male', '1986-04-30', '456 Cedar Dr, San Diego', 10327, '2022-07-01', NULL),
('S020', 'Kimberly Walker', 'female', '1994-01-15', '567 Oakwood Ln, Charlotte', NULL, '2022-08-01', '2023-08-01'),
('S021', 'Jason Hall', 'male', '1989-06-18', '678 Maple Ave, Washington', NULL, '2022-09-01', '2023-09-01'),
('S022', 'Stephanie Young', 'female', '1992-11-23', '123 Birch Rd, San Antonio', 9583, '2022-10-01', NULL),
('S023', 'Joseph Allen', 'male', '1984-07-04', '890 Elmwood St, Tampa', 9344, '2022-11-01', NULL),
('S024', 'Christina Green', 'female', '1991-04-09', '234 Pinecrest Rd, Nashville', 9119, '2022-12-01', NULL),
('S025', 'Daniel Baker', 'male', '1987-09-12', '456 Maplewood Ave, Honolulu', 8892, '2023-01-01', NULL),
('S026', 'Emily Hill', 'female', '1993-05-27', '789 Cedar Ln, Austin', 8671, '2023-02-01', NULL),
('S027', 'Kevin Adams', 'male', '1985-12-03', '890 Birch Ave, Orlando', 8476, '2023-03-01', NULL),
('S028', 'Rachel Ross', 'female', '1990-03-16', '345 Oak Rd, Denver', NULL, '2023-04-01', '2024-04-01'),
('S029', 'Brandon Campbell', 'male', '1986-08-28', '456 Pine Ave, Chicago', 8065, '2023-05-01', NULL);

--
-- Bẫy `staff`
--
DELIMITER $$
CREATE TRIGGER `BeforeInsertOrUpdateStaff` BEFORE INSERT ON `staff` FOR EACH ROW BEGIN
    SET NEW.salary = 5000 * POWER(1.05, DATEDIFF(CURDATE(), NEW.start_date) / 60);
END
$$
DELIMITER ;

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `store`
--

CREATE TABLE `store` (
  `product_id` varchar(10) NOT NULL,
  `quantity` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Đang đổ dữ liệu cho bảng `store`
--

INSERT INTO `store` (`product_id`, `quantity`) VALUES
('P001', 50),
('P002', 150),
('P003', 100),
('P004', 50),
('P005', 40),
('P006', 100),
('P007', 80),
('P008', 30),
('P009', 60),
('P010', 10),
('P011', 80),
('P012', 60),
('P013', 30),
('P015', 15),
('P016', 10);

--
-- Bẫy `store`
--
DELIMITER $$
CREATE TRIGGER `BeforeInsertOrUpdateStore` BEFORE INSERT ON `store` FOR EACH ROW BEGIN
    DECLARE product_quantity INT;
    SELECT quantity INTO product_quantity FROM PRODUCT WHERE id = NEW.product_id;
    IF NEW.quantity > product_quantity THEN
        SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = 'Quantity exceeds available stock in PRODUCT table';
    END IF;
END
$$
DELIMITER ;
DELIMITER $$
CREATE TRIGGER `BeforeUpdateStore` BEFORE UPDATE ON `store` FOR EACH ROW BEGIN
    DECLARE product_quantity INT;
    SELECT quantity INTO product_quantity FROM PRODUCT WHERE id = NEW.product_id;
    IF NEW.quantity > product_quantity THEN
        SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = 'Quantity exceeds available stock in PRODUCT table';
    END IF;
END
$$
DELIMITER ;

--
-- Chỉ mục cho các bảng đã đổ
--

--
-- Chỉ mục cho bảng `account`
--
ALTER TABLE `account`
  ADD PRIMARY KEY (`username`);

--
-- Chỉ mục cho bảng `ctphieuban`
--
ALTER TABLE `ctphieuban`
  ADD PRIMARY KEY (`ma_phieu_ban`,`ma_san_pham`),
  ADD KEY `ma_san_pham` (`ma_san_pham`);

--
-- Chỉ mục cho bảng `ctphieunhap`
--
ALTER TABLE `ctphieunhap`
  ADD KEY `ma_phieu_nhap` (`ma_phieu_nhap`),
  ADD KEY `ma_san_pham` (`ma_san_pham`);

--
-- Chỉ mục cho bảng `khach_hang`
--
ALTER TABLE `khach_hang`
  ADD PRIMARY KEY (`ma_khach_hang`);

--
-- Chỉ mục cho bảng `nha_cung_cap`
--
ALTER TABLE `nha_cung_cap`
  ADD PRIMARY KEY (`ma_nha_cung_cap`);

--
-- Chỉ mục cho bảng `phieuban`
--
ALTER TABLE `phieuban`
  ADD PRIMARY KEY (`ma_phieu_ban`);

--
-- Chỉ mục cho bảng `phieunhap`
--
ALTER TABLE `phieunhap`
  ADD PRIMARY KEY (`ma_phieu_nhap`),
  ADD KEY `fk_phieunhap_nhacungcap` (`ma_nha_cung_cap`);

--
-- Chỉ mục cho bảng `phieu_tra`
--
ALTER TABLE `phieu_tra`
  ADD PRIMARY KEY (`ma_phieu_tra`),
  ADD KEY `ma_phieu_ban` (`ma_phieu_ban`);

--
-- Chỉ mục cho bảng `products`
--
ALTER TABLE `products`
  ADD PRIMARY KEY (`id`);

--
-- Chỉ mục cho bảng `staff`
--
ALTER TABLE `staff`
  ADD PRIMARY KEY (`id`);

--
-- Chỉ mục cho bảng `store`
--
ALTER TABLE `store`
  ADD PRIMARY KEY (`product_id`);

--
-- Các ràng buộc cho các bảng đã đổ
--

--
-- Các ràng buộc cho bảng `account`
--
ALTER TABLE `account`
  ADD CONSTRAINT `fk_username` FOREIGN KEY (`username`) REFERENCES `staff` (`id`);

--
-- Các ràng buộc cho bảng `ctphieuban`
--
ALTER TABLE `ctphieuban`
  ADD CONSTRAINT `ctphieuban_ibfk_1` FOREIGN KEY (`ma_phieu_ban`) REFERENCES `phieuban` (`ma_phieu_ban`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `ctphieuban_ibfk_2` FOREIGN KEY (`ma_san_pham`) REFERENCES `products` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Các ràng buộc cho bảng `ctphieunhap`
--
ALTER TABLE `ctphieunhap`
  ADD CONSTRAINT `ctphieunhap_ibfk_1` FOREIGN KEY (`ma_phieu_nhap`) REFERENCES `phieunhap` (`ma_phieu_nhap`),
  ADD CONSTRAINT `ctphieunhap_ibfk_2` FOREIGN KEY (`ma_san_pham`) REFERENCES `products` (`id`);

--
-- Các ràng buộc cho bảng `phieunhap`
--
ALTER TABLE `phieunhap`
  ADD CONSTRAINT `fk_phieunhap_nhacungcap` FOREIGN KEY (`ma_nha_cung_cap`) REFERENCES `nha_cung_cap` (`ma_nha_cung_cap`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Các ràng buộc cho bảng `phieu_tra`
--
ALTER TABLE `phieu_tra`
  ADD CONSTRAINT `phieu_tra_ibfk_1` FOREIGN KEY (`ma_phieu_ban`) REFERENCES `phieuban` (`ma_phieu_ban`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Các ràng buộc cho bảng `store`
--
ALTER TABLE `store`
  ADD CONSTRAINT `fk_product` FOREIGN KEY (`product_id`) REFERENCES `product` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
