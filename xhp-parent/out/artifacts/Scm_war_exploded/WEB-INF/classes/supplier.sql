create table supplier
(
   sup_id               int not null,
   sup_name             varchar(20),
   sup_linkman          varchar(20),
   sup_phone            varchar(11),
   sup_address          varchar(100),
   sup_remark           varchar(100),
   sup_pay              decimal(12,2),
   sup_type             varchar(10),
   primary key (sup_id)
);
/* 添加帐户数据, */
insert into account (acc_login,acc_pass) values ('admin','admin');
insert into account (acc_login,acc_pass) values ('admin2','admin2');
/* 添加供应商数据, */
insert into supplier (sup_id,sup_name,sup_linkman,sup_phone,sup_address,sup_remark,sup_pay,sup_type) values (1,'苹果供应商','小张','12388888887','广州花都','普通供应商',0,1);
insert into supplier (sup_id,sup_name,sup_linkman,sup_phone,sup_address,sup_remark,sup_pay,sup_type) values (2,'三星供应商','小王','12388888888','广州增城','普通供应商',0,1);
insert into supplier (sup_id,sup_name,sup_linkman,sup_phone,sup_address,sup_remark,sup_pay,sup_type) values (3,'华为供应商','小王','12388888889','广东深圳','一级供应商',0,2);
insert into supplier (sup_id,sup_name,sup_linkman,sup_phone,sup_address,sup_remark,sup_pay,sup_type) values (4,'TCL供应商','小王','12388888666','广州增城','普通供应商',0,1);
insert into supplier (sup_id,sup_name,sup_linkman,sup_phone,sup_address,sup_remark,sup_pay,sup_type) values (5,'Nokia供应商','小王','12388888777','广东深圳','一级供应商',0,2);
/*添加商品信息*/
insert into goods (goods_Id,goods_name,goods_unit,goods_color,goods_remark,goods_sel_price,goods_buy_price)
values('1','note4','部','1','red note4',2500.00,2000.00);
insert into goods (goods_Id,goods_name,goods_unit,goods_color,goods_remark,goods_sel_price,goods_buy_price)
values('2','note5','部','5','red note5',3500.00,3000.00);
insert into goods (goods_Id,goods_name,goods_unit,goods_color,goods_remark,goods_sel_price,goods_buy_price)
values('3','note6','部','6','blue note5',4500.00,4000.00);
/*添加仓库信息*/
insert into store_house(sh_id,sh_name,sh_address) values('1','主仓库','广东省广州市');
insert into store_house(sh_id,sh_name,sh_address) values('2','深圳分仓库','广东省深圳市');

select * from account;
select * from supplier;
select * from goods;
select * from store_house;
