USE sql_invoicing;
CREATE TABLE payment_methods(
payment_method_id tinyint NOT NULL IDENTITY(1,1),
name varchar(50) NOT NULL,
primary key(payment_method_id)
);