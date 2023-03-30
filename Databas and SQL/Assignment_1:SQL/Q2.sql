CREATE TABLE Categories (
CategoryID INT,
CategoryName VARCHAR(15),
Description VARCHAR(70),
PRIMARY KEY (CategoryID)
);
    
CREATE TABLE Products (
ProductID INT,
ProductName VARCHAR(40),
SupplierID INT,
CategoryID INT,
Unit INT,
Price INT,
PRIMARY KEY (ProductID),
FOREIGN KEY (CategoryID) REFERENCES Categories(CategoryID)
);

INSERT INTO Categories (CategoryID, CategoryName, Description)
VALUES (1, 'Beverages', 'Soft drinks, coffees, teas, beers, and ales'),
(2, 'Condiments', 'Sweet and savory sauces, relishes, spreads, and seasonings'),
(3, 'Confections', 'Desserts, candies, and sweet breads'),
(4, 'Dairy Products', 'Cheeses'),
(5, 'Grains/Cereals', 'Breads, crackers, pasta, and cereal');

INSERT INTO Products (ProductID, ProductName, SupplierID, CategoryID, Unit, Price)
VALUES (1, 'Chais', 1, 1, 200, 18),
(2, 'Chang', 1, 1, 120, 19),
(3, 'Aniseed Syrup', 1, 2, 50, 10),
(4, 'Chef Anton''s Cajun Seasoning', 2, 2, 45, 22),
(5, 'Chef Anton''s Gumbo Mix ', 2, 4, 65, 25),
(6, 'Grandma''s Boysenberry Spread', 3, 2, 78, 25),
(7, 'Uncle Bob''s Organic Dried Pears', 3, 3, 98, 30),
(8, 'Northwoods Cranberry Sauce', 3, 2, 150, 40),
(9, 'Mishi Kobe Niku', 4, 4, 230, 97),
(10, 'Ikura', 4, 5, 45, 31);



--1. Find all records where product name contains ‘ch’

SELECT *
FROM Products
WHERE ProductName LIKE '%ch%'

--2. Find all records where price is greater than the average price of all products

SELECT *
FROM Products
WHERE Price>(SELECT AVG(Price) FROM Products);

--3. Find all products whose category name is ‘Condiments’

SELECT *
FROM Products
WHERE CategoryID = (SELECT CategoryID 
                    FROM Categories 
                    WHERE CategoryName='Condiments');

--4. Find No of products of each category

SELECT CategoryName, COUNT(ProductID)
FROM Products
JOIN Categories
ON Products.CategoryID=Categories.CategoryID
GROUP BY CategoryName;

                                    OR

SELECT CategoryID, COUNT(ProductID) 
FROM Products 
GROUP BY CategoryID;

-- 5. The following query is too slow on the products table containing more than 10 lacs records 
-- Select * from products where Unit > 500;
-- Write a query that decreases the retrieval time from now
-- Hint: Create INDEX unit_index on Products (Unit)

CREATE INDEX unit_index 
ON Products (Unit);

SELECT *
FROM Products
WHERE Unit > 500;