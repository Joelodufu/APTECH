USE LaptopShop;
INSERT INTO ProductSales(
ProductID,
ProductDescription,
CostPrice,
SalePrice
)VALUES
(1, 'HP Core i9', 2000.00, 2300.00),
(2, 'Lenovo vpro core i9', 2000.00, 4332.00),
(3, 'DELL vpro core i9', 2000.00, 3234.00),
(4, 'MacOS vpro core i9', 2000.00, 2300.00),
(5, 'Toshiba vpro core i9', 2000.00, 3000.00),
(6, 'Acer vpro core i9', 2000.00, 3400.00),
(7, 'Lenovo vpro core i9', 2000.00, 3244.00);

SELECT ProductId,
ProductDescription, 
CostPrice, 
SalePrice, 
(SalePrice-CostPrice) AS Profit 
FROM ProductSales;