-- Department Data
INSERT INTO Department (name, creation_date, department_head_id) VALUES
('HR', '2020-01-01', NULL),
('Finance', '2020-01-01', NULL),
('IT', '2020-01-01', NULL);

--Reporting head employee Data
INSERT INTO Employee (name, date_of_birth, salary, address, role, joining_date, yearly_bonus_percentage, department_id, reporting_manager_id) VALUES
('John Doe', '1990-01-01', 50000, '123 Main St', 'Developer', '2020-01-01', 5, 1, 1),
('Alice Johnson', '1985-03-03', 70000, '789 Pine St', 'Manager', '2019-03-01', 7, 3, 2);

-- Other Employee Data
INSERT INTO Employee (name, date_of_birth, salary, address, role, joining_date, yearly_bonus_percentage, department_id, reporting_manager_id) VALUES
('Jane Smith', '1992-02-02', 60000, '456 Oak St', 'Analyst', '2021-02-01', 6, 2, 2);

