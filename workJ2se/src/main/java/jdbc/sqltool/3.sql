delete from  Suppliers WHERE SupplierID =123
delete from  Suppliers WHERE SupplierID =456
delete from  Suppliers WHERE SupplierID =31
insert  INTO Suppliers (CompanyName) values( 'testName-' )
update Suppliers set CompanyName = 'testUpdate' where  CompanyName = 'testName-'