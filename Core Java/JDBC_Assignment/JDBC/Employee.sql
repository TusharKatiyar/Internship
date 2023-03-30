USE sys;

CREATE TABLE Employee (
Eid INT NOT NULL,
Ename VARCHAR(3) NOT NULL,
Age INT NOT NULL,
PRIMARY KEY (Eid)
);

INSERT INTO Employee (Eid, Ename, Age)
VALUES (100, 'ABC', 21),
(101, 'MNP', 30),
(102, 'DEF', 23),
(103, 'JKL', 44),
(104, 'GHJ', 25),
(105, 'UJM', 32),
(106, 'UJM', 31),
(107, 'RGJ', 33),
(108, 'IJH', 35),
(109, 'NMH', 50),
(110, 'SDF', 49),
(111, 'TGB', 43),
(112, 'HUF', 24),
(113, 'SDF', 29),
(114, 'RGJ', 22),
(115, 'JKG', 21);