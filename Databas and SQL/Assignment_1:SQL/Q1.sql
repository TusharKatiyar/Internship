CREATE TABLE Project (
Pid VARCHAR(54) NOT NULL,
Pname VARCHAR(50) NOT NULL,
PRIMARY KEY (Pid)
);
    
CREATE TABLE Employee (
Eid INT NOT NULL,
Ename VARCHAR(50) NOT NULL,
Pid VARCHAR(4),
PRIMARY KEY (Eid),
FOREIGN KEY (Pid) REFERENCES Project(Pid)
);

INSERT INTO Project (Pid, Pname)
VALUES ('P189', 'Rest'),
('P546', 'Spring'),
('P547', 'Maven'),
('P567', 'Swift'),
('P789', 'Angular'),
('P799', 'Script'),
('P805', 'Mssql'),
('P855', 'Perl'),
('P895', 'Pthon'),
('P902', 'Ruby'),
('P928', 'R');

INSERT INTO Employee (Eid, Ename, Pid)
VALUES (100, 'ABC', 'P189'),
(101, 'MNP', 'P789'),
(102, 'DEF', 'P567'),
(103, 'JKL', NULL),
(104, 'GHJ', 'P567'),
(105, 'UJM', 'P189'),
(106, 'UJM', NULL),
(107, 'RGJ', 'P567'),
(108, 'IJH', NULL),
(109, 'NMH', 'P547'),
(110, 'SDF', 'P189'),
(111, 'TGB', 'P546'),
(112, 'HUF', NULL),
(113, 'SDF', 'P789'),
(114, 'RGJ', 'P567'),
(115, 'JKG', 'P189');



-- 1. Find all the projects which are not currently taken up by any employee
SELECT Pname
FROM Project
WHERE Pid NOT IN (SELECT Pid 
                  FROM Employee 
                  WHERE Pid IS NOT NULL);


-- 2. Find all the other employees who are working in the same project with  ‘ABC’
SELECT Ename
FROM Employee
WHERE Pid IN (SELECT Pid 
              FROM Employee 
              WHERE Ename='ABC');


-- 3. Find all the project names and No of employees working on each project
SELECT Pname, COUNT(Employee.Pid)
FROM Project
LEFT JOIN Employee
ON Employee.Pid=Project.Pid
GROUP BY Project.Pid;


-- 4. Find all the projects which have 2 or more employees with same name
SELECT Pname
FROM Project
JOIN Employee
ON Project.Pid = Employee.Pid
GROUP BY Employee.Ename,Project.Pid
HAVING COUNT(Employee.Ename AND Employee.Pid)>1;




-- 5. List out the names of both employees and projects in alphabetical order into the single result.
SELECT Pname, Ename
FROM Project
JOIN Employee
ON Project.Pid=Employee.Pid
ORDER BY Pname, Ename;
