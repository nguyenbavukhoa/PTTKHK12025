CREATE DATABASE GROCERYSTORE;
USE GROCERYSTORE;

-- Create the PRODUCT_TYPE table
CREATE TABLE PRODUCT_TYPE (
    id VARCHAR(10) PRIMARY KEY,
    type_name VARCHAR(50)
);  

CREATE TABLE SUPPLIER (
    id VARCHAR(10) PRIMARY KEY,
    supplier_name VARCHAR(50),
    address VARCHAR(100),
    phone VARCHAR(15)
);

-- Create the PRODUCT table
CREATE TABLE PRODUCT(
    id VARCHAR(10) PRIMARY KEY,
    product_name VARCHAR(50),
    expiry DATE,
    import_price INT,
    sell_price INT GENERATED ALWAYS AS (import_price * 1.2) STORED,
    origin NVARCHAR(50),
    quantity INT,
    product_type VARCHAR(10),
    supplier_id VARCHAR(10),
    CONSTRAINT fk_product_type FOREIGN KEY (product_type) REFERENCES PRODUCT_TYPE(id),
    CONSTRAINT fk_supplier FOREIGN KEY (supplier_id) REFERENCES SUPPLIER(id)
);

-- Create the INCOME_DETAILS table


-- Create the STAFF table
CREATE TABLE STAFF(
    id VARCHAR(10) PRIMARY KEY,
    name VARCHAR(50),
    sex ENUM('male', 'female'),
    dob DATE,
    address VARCHAR(50),
    salary INT,
    start_date DATE,
    end_date DATE
);

-- Create the IMPORT_STATISTIC_SHEET table
CREATE TABLE IMPORT_STATISTIC_SHEET (
    id VARCHAR(10) PRIMARY KEY,
    product_id VARCHAR(10),
    price INT,
    statistical_day DATE
    -- statistician VARCHAR(10),
    -- CONSTRAINT fk_product_id_1 FOREIGN KEY (product_id) REFERENCES PRODUCT(id)
    -- CONSTRAINT fk_statistician_1 FOREIGN KEY (statistician) REFERENCES STAFF(id)
);

-- Create the ACCOUNT table
CREATE TABLE ACCOUNT (
    username VARCHAR(10) PRIMARY KEY,
    password VARCHAR(50),
    CONSTRAINT fk_username FOREIGN KEY (username) REFERENCES STAFF(id)
);

-- Insert data into PRODUCT_TYPE table
INSERT INTO PRODUCT_TYPE (id, type_name) VALUES
('Fo', 'foods'),
('Dr', 'drinks'),
('Sp', 'spices'),
('HPI', 'personal hygiene items'),
('HA', 'household appliances');

INSERT INTO SUPPLIER (id, supplier_name, address, phone) VALUES
('SUP001', 'Supplier One', '123 Supplier St', '123-456-7890'),
('SUP002', 'Supplier Two', '456 Supplier Ave', '098-765-4321'),
('SUP003', 'Supplier Three', '789 Supplier Blvd', '234-567-8901'),
('SUP004', 'Supplier Four', '101 Supplier Rd', '345-678-9012'),
('SUP005', 'Supplier Five', '202 Supplier Ln', '456-789-0123'),
('SUP006', 'Supplier Six', '303 Supplier Dr', '567-890-1234'),
('SUP007', 'Supplier Seven', '404 Supplier Ct', '678-901-2345'),
('SUP008', 'Supplier Eight', '505 Supplier Pl', '789-012-3456'),
('SUP009', 'Supplier Nine', '606 Supplier Way', '890-123-4567'),
('SUP010', 'Supplier Ten', '707 Supplier Pkwy', '901-234-5678');

CREATE TABLE INCOME_DETAILS(
    product_id VARCHAR(10),
    sold_quantity INT,
    report_month INT,
    PRIMARY KEY (product_id, report_month),
    CONSTRAINT fk_product_id FOREIGN KEY (product_id) REFERENCES PRODUCT(id)
);

-- Create the INCOME_REPORT table with computed income and profit
CREATE TABLE INCOME_REPORT(
    report_month INT PRIMARY KEY,
    income INT
);



-- Insert data into STAFF table
INSERT INTO STAFF (id, name, sex, dob, address, salary, start_date, end_date)
VALUES
('S001', 'John Doe', 'male', '1990-05-15', '123 Main St, New York', NULL, '2021-01-01', NULL),
('S002', 'Jane Smith', 'female', '1992-08-20', '456 Oak Ave, Los Angeles', NULL, '2021-02-01', NULL),
('S003', 'Michael Johnson', 'male', '1985-03-10', '789 Elm Rd, Chicago', NULL, '2021-03-01', NULL),
('S004', 'Emily Brown', 'female', '1991-11-25', '567 Pine Blvd, Houston', NULL, '2021-04-01', '2022-04-01'),
('S005', 'David Wilson', 'male', '1988-07-05', '890 Cedar Dr, San Francisco', NULL, '2021-05-01', '2022-05-01'),
('S006', 'Jessica Martinez', 'female', '1993-02-18', '234 Maple Ln, Miami', NULL, '2021-06-01', '2022-06-01'),
('S007', 'Christopher Garcia', 'male', '1987-09-30', '678 Birch Ave, Boston', NULL, '2021-07-01', NULL),
('S008', 'Sarah Lopez', 'female', '1990-04-12', '345 Oakwood St, Seattle', NULL, '2021-08-01', NULL),
('S009', 'Daniel Miller', 'male', '1986-01-08', '456 Pinecrest Rd, Denver', NULL, '2021-09-01', NULL),
('S010', 'Melissa Thompson', 'female', '1994-06-22', '789 Elmwood Dr, Atlanta', NULL, '2021-10-01', '2022-10-01'),
('S011', 'Robert White', 'male', '1989-12-17', '567 Maplewood Ave, Dallas', NULL, '2021-11-01', '2022-11-01'),
('S012', 'Amanda Scott', 'female', '1992-03-28', '123 Cedar Ln, Philadelphia', NULL, '2021-12-01', NULL),
('S013', 'William Lee', 'male', '1984-08-14', '890 Pine Rd, Phoenix', NULL, '2022-01-01', NULL),
('S014', 'Laura King', 'female', '1991-05-03', '234 Birch Ave, Detroit', NULL, '2022-02-01', NULL),
('S015', 'Richard Perez', 'male', '1987-10-19', '456 Elm St, Minneapolis', NULL, '2022-03-01', NULL),
('S016', 'Jennifer Harris', 'female', '1993-07-08', '678 Oak Ave, Baltimore', NULL, '2022-04-01', '2023-04-01'),
('S017', 'Matthew Clark', 'male', '1985-02-11', '789 Maple Rd, Portland', NULL, '2022-05-01', NULL),
('S018', 'Michelle Lewis', 'female', '1990-09-26', '345 Pine Blvd, Las Vegas', NULL, '2022-06-01', NULL),
('S019', 'Joshua Robinson', 'male', '1986-04-30', '456 Cedar Dr, San Diego', NULL, '2022-07-01', NULL),
('S020', 'Kimberly Walker', 'female', '1994-01-15', '567 Oakwood Ln, Charlotte', NULL, '2022-08-01', '2023-08-01'),
('S021', 'Jason Hall', 'male', '1989-06-18', '678 Maple Ave, Washington', NULL, '2022-09-01', '2023-09-01'),
('S022', 'Stephanie Young', 'female', '1992-11-23', '123 Birch Rd, San Antonio', NULL, '2022-10-01', NULL),
('S023', 'Joseph Allen', 'male', '1984-07-04', '890 Elmwood St, Tampa', NULL, '2022-11-01', NULL),
('S024', 'Christina Green', 'female', '1991-04-09', '234 Pinecrest Rd, Nashville', NULL, '2022-12-01', NULL),
('S025', 'Daniel Baker', 'male', '1987-09-12', '456 Maplewood Ave, Honolulu', NULL, '2023-01-01', NULL),
('S026', 'Emily Hill', 'female', '1993-05-27', '789 Cedar Ln, Austin', NULL, '2023-02-01', NULL),
('S027', 'Kevin Adams', 'male', '1985-12-03', '890 Birch Ave, Orlando', NULL, '2023-03-01', NULL),
('S028', 'Rachel Ross', 'female', '1990-03-16', '345 Oak Rd, Denver', NULL, '2023-04-01', '2024-04-01'),
('S029', 'Brandon Campbell', 'male', '1986-08-28', '456 Pine Ave, Chicago', NULL, '2023-05-01', NULL),
('admin', 'Alexis Price', 'female', '1994-02-01', '567 Elm Blvd, Miami', NULL, '2023-06-01', NULL);

-- Insert data into ACCOUNT table
INSERT INTO ACCOUNT (username, password)
VALUES
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
('S029', 'password029'),
('admin', 'admin');

-- Insert data into PRODUCT table
INSERT INTO PRODUCT (id, product_name, expiry, import_price, origin, quantity, product_type,supplier_id)
VALUES
('P001', 'Rice', '2024-12-31', 5000, 'Vietnam', 100, 'Fo','SUP001'),
('P002', 'Milk', '2023-06-30', 20000, 'USA', 200, 'Dr','SUP002'),
('P003', 'Salt', '2025-01-15', 1000,'India', 150, 'Sp','SUP003'),
('P004', 'Shampoo', '2024-11-20', 30000, 'Japan', 80, 'HPI','SUP004'),
('P005', 'Dish Soap', '2024-10-10', 25000, 'Germany', 60, 'HA','SUP005'),
('P006', 'Chicken', '2024-06-30', 20000,  'Brazil', 150, 'Fo','SUP006'),
('P007', 'Orange Juice', '2024-09-30', 10000,  'Spain', 100, 'Dr','SUP007'),
('P008', 'Cinnamon', '2023-12-31', 12000,  'Sri Lanka', 40, 'Sp','SUP008'),
('P009', 'Tooth Brush', '2024-04-30', 9000, 'France', 70, 'HPI','SUP009'),
('P010', 'Refrigerator', NULL, 5000000,  'South Korea', 20, 'HA','SUP010'),
('P011', 'Beef', '2024-05-31', 25000,  'Australia', 120, 'Fo','SUP001'),
('P012', 'Apple Juice', '2024-08-31', 12000,  'Italy', 80, 'Dr','SUP002'),
('P013', 'Turmeric', '2023-11-30', 18000, 'India', 60, 'Sp','SUP003'),
('P014', 'Soap', '2024-03-31', 7000, 'Germany', 0, 'HPI','SUP004'),
('P015', 'Microwave', NULL, 2000000,'Japan', 25, 'HA','SUP005'),
('P016', 'Pork', '2024-07-31', 22000,  'Vietnam', 110, 'Fo','SUP006'),
('P017', 'Grape Juice', '2024-10-31', 11000,  'USA', 0, 'Dr','SUP008'),
('P018', 'Garlic', '2023-10-31', 10000, 'China', 45, 'Sp','SUP009'),
('P019', 'Deodorant', '2024-06-30', 8500, 'France', 60, 'HPI','SUP010'),
('P020', 'Dishwasher', NULL, 4000000,  'Germany', 15, 'HA','SUP007'),
('P021', 'Lamb', '2024-04-30', 28000,  'New Zealand', 80, 'Fo','SUP001'),
('P022', 'Lemonade', '2024-09-30', 9000, 'Brazil', 85, 'Dr','SUP002'),
('P023', 'Coriander', '2023-12-31', 13000,  'India', 0, 'Sp','SUP003'),
('P024', 'Conditioner', '2024-03-31', 9500,  'Italy', 75, 'HPI','SUP004'),
('P025', 'Oven', NULL, 3000000,  'South Korea', 20, 'HA','SUP005'),
('P026', 'Fish', '2024-08-31', 18000, 'Norway', 95, 'Fo','SUP006'),
('P027', 'Mango Juice', '2024-11-30', 13000, 'India', 65, 'Dr','SUP008'),
('P028', 'Cardamom', '2023-09-30', 16000, 'Guatemala', 50, 'Sp','SUP009'),
('P029', 'Toilet Paper', '2024-05-31', 6000, 'Canada', 0, 'HPI','SUP010'),
('P030', 'TV', NULL, 6000000, 'USA', 10, 'HA','SUP007');

-- Insert data into INCOME_DETAILS table
INSERT INTO INCOME_DETAILS (product_id, sold_quantity, report_month)
VALUES
('P001', 10, 202301),
('P002', 15, 202301),
('P003', 8, 202301),
('P004', 20, 202302),
('P005', 5, 202302),
('P006', 12, 202302),
('P007', 30, 202303),
('P008', 18, 202303),
('P009', 25, 202303),
('P010', 3, 202304),
('P011', 14, 202304),
('P012', 22, 202304),
('P013', 19, 202305),
('P014', 27, 202305),
('P015', 6, 202305),
('P016', 21, 202306),
('P017', 17, 202306),
('P018', 26, 202306),
('P019', 9, 202307),
('P020', 16, 202307),
('P021', 23, 202307),
('P022', 13, 202308),
('P023', 20, 202308),
('P024', 11, 202308),
('P025', 8, 202309),
('P026', 18, 202309),
('P027', 24, 202309),
('P028', 7, 202310),
('P029', 15, 202310),
('P030', 12, 202310),
('P001', 14, 202311),
('P002', 22, 202311),
('P003', 19, 202311),
('P004', 27, 202312),
('P005', 6, 202312),
('P006', 21, 202312),
('P007', 25, 202312);

-- Insert data into IMPORT_STATISTIC_SHEET table
/*INSERT INTO IMPORT_STATISTIC_SHEET (id, product_id, price, statistical_day, statistician)
VALUES
('ISS001', 'P001', 200000, '2024-06-01', 'S001'),
('ISS002', 'P002', 150000, '2024-06-02', 'S002'),
('ISS003', 'P003', 300000, '2024-06-03', 'S003'),
('ISS004', 'P004', 120000, '2024-06-04', 'S004'),
('ISS005', 'P005', 5000000, '2024-06-05', 'S005'),
('ISS006', 'P006', 250000, '2024-06-06', 'S006'),
('ISS007', 'P007', 100000, '2024-06-07', 'S007'),
('ISS008', 'P008', 80000, '2024-06-08', 'S008'),
('ISS009', 'P009', 150000, '2024-06-09', 'S009'),
('ISS010', 'P010', 7000000, '2024-06-10', 'S010'),
('ISS011', 'P011', 280000, '2024-06-11', 'S011'),
('ISS012', 'P012', 110000, '2024-06-12', 'S012'),
('ISS013', 'P013', 180000, '2024-06-13', 'S013'),
('ISS014', 'P014', 75000, '2024-06-14', 'S014'),
('ISS015', 'P015', 3500000, '2024-06-15', 'S015'),
('ISS016', 'P016', 230000, '2024-06-16', 'S016'),
('ISS017', 'P017', 90000, '2024-06-17', 'S017'),
('ISS018', 'P018', 120000, '2024-06-18', 'S018'),
('ISS019', 'P019', 100000, '2024-06-19', 'S019'),
('ISS020', 'P020', 4800000, '2024-06-20', 'S020'),
('ISS021', 'P021', 300000, '2024-06-21', 'S021'),
('ISS022', 'P022', 140000, '2024-06-22', 'S022'),
('ISS023', 'P023', 95000, '2024-06-23', 'S023'),
('ISS024', 'P024', 110000, '2024-06-24', 'S024'),
('ISS025', 'P025', 3800000, '2024-06-25', 'S025'),
('ISS026', 'P026', 200000, '2024-06-26', 'S026'),
('ISS027', 'P027', 120000, '2024-06-27', 'S027'),
('ISS028', 'P028', 160000, '2024-06-28', 'S028'),
('ISS029', 'P029', 90000, '2024-06-29', 'S029'),
('ISS030', 'P030', 7000000, '2024-06-30', 'admin');*/

-- Create stored procedure to update salary based on start date
/*DELIMITER $$
CREATE PROCEDURE UpdateSalary()
BEGIN
    UPDATE STAFF
    SET salary = 5000 + (YEAR(CURDATE()) - YEAR(start_date)) * 500
    WHERE end_date IS NULL OR end_date >= CURDATE();
END$$
DELIMITER ;

-- Create trigger to update salary before inserting or updating a record in STAFF
DELIMITER $$
CREATE TRIGGER BeforeInsertOrUpdateStaff
BEFORE INSERT ON STAFF
FOR EACH ROW
BEGIN
    SET NEW.salary = 5000 + (YEAR(CURDATE()) - YEAR(NEW.start_date)) * 500;
END$$
DELIMITER ;*/
DELIMITER $$
CREATE PROCEDURE UpdateSalary()
BEGIN
    UPDATE STAFF
    SET salary = 5000 * POWER(1.05, DATEDIFF(CURDATE(), start_date) / 60)
    WHERE end_date IS NULL OR end_date >= CURDATE();
END$$
DELIMITER ;

-- Create trigger to update salary before inserting or updating a record in STAFF
DELIMITER $$
CREATE TRIGGER BeforeInsertOrUpdateStaff
BEFORE INSERT ON STAFF
FOR EACH ROW
BEGIN
    SET NEW.salary = 5000 * POWER(1.05, DATEDIFF(CURDATE(), NEW.start_date) / 60);
END$$
DELIMITER ;

-- Call the stored procedure to update salary for existing records
CALL UpdateSalary();

INSERT INTO INCOME_REPORT (report_month, income)
SELECT
    id.report_month,
    SUM(id.sold_quantity * p.sell_price) AS income
FROM
    INCOME_DETAILS id
JOIN
    PRODUCT p ON id.product_id = p.id
GROUP BY
    id.report_month;
    
-- Create a VIEW to calculate profit
CREATE VIEW INCOME_REPORT_VIEW AS
SELECT
    ir.report_month,
    ir.income,
    (ir.income - IFNULL(SUM(id.sold_quantity * p.import_price), 0)) AS profit
FROM
    INCOME_REPORT ir
    LEFT JOIN INCOME_DETAILS id ON ir.report_month = id.report_month
    LEFT JOIN PRODUCT p ON id.product_id = p.id
GROUP BY
    ir.report_month, ir.income;

-- Create the STORE table
CREATE TABLE STORE (
    product_id VARCHAR(10),
    quantity INT,
    PRIMARY KEY (product_id),
    CONSTRAINT fk_product FOREIGN KEY (product_id) REFERENCES PRODUCT(id)
);

-- Create a trigger to check the quantity constraint before insert or update
DELIMITER $$
CREATE TRIGGER BeforeInsertOrUpdateStore
BEFORE INSERT ON STORE
FOR EACH ROW
BEGIN
    DECLARE product_quantity INT;
    SELECT quantity INTO product_quantity FROM PRODUCT WHERE id = NEW.product_id;
    IF NEW.quantity > product_quantity THEN
        SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = 'Quantity exceeds available stock in PRODUCT table';
    END IF;
END$$
DELIMITER ;

DELIMITER $$
CREATE TRIGGER BeforeUpdateStore
BEFORE UPDATE ON STORE
FOR EACH ROW
BEGIN
    DECLARE product_quantity INT;
    SELECT quantity INTO product_quantity FROM PRODUCT WHERE id = NEW.product_id;
    IF NEW.quantity > product_quantity THEN
        SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = 'Quantity exceeds available stock in PRODUCT table';
    END IF;
END$$
DELIMITER ;

INSERT INTO STORE (product_id, quantity) VALUES
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
('P016', 10),
('P015', 15);


    




