create database jdbcTest2;
use jdbcTest2;

create table product_info(
prodId int primary key,
prodName Varchar(20),
prodQty int check(prodQty>=0),
prodPrice double check(prodPrice>=0)
);

create table order_info(
ordId int primary key AUTO_INCREMENT,
customerName Varchar(20),
prodId int,
prodQty int check(prodQty>=0),
totalBill double check(totalBill>=0) ,
FOREIGN KEY (prodId) REFERENCES product_info(prodId)
)
;
select * from product_info;
select * from order_info;

insert into product_info 
values(101,'suger',90,42),
(102,'tea',100,360.0),
(103,'rice',120,60),
(104,'ghee',40,600);
insert into product_info values (104,'ghee',40,600);



-- place order Procedure-- 
DELIMITER //
create procedure placeOrder(CustName varchar(20),pId int,pQty int)
begin 
	declare pPrice double;
    select prodPrice into pPrice from product_info where prodId=pId;
	insert into order_info(customerName,prodId,prodQty) values(custName,pId,pQty);
    update product_info set prodQty=prodQty-pQty;
    update order_info set totalBill=(pPrice*pQty) where ordId=last_insert_id();
end //
DELIMITER ;
