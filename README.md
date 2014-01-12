JavaPhanTan
===========

Đồ án cuối kì môn Lập trình java phân tán

##Yêu cầu hệ thống
 - Maven
 - Java jdk 7
 - Mongodb

##Hướng dẫn chạy project
 - Mở server Mongo sau đó làm 1 trong các cách sau
	 - Cách 1: 
	 	+ Import vào eclipse
	 	+ Run as -> Web aplication

	 - Cách 2: Chạy bằng commandline
	 	+ cd vào SOURCE/shopcamera và gõ mvn install tomcat7:run
	 	+ truy cập http://localhost:8080/index.html
	 - Cách 3: Hoặc chạy file setup.bat trong thư mục SOURCE/shopcamera	

##Hướng dẫn import/export database:
####Export database từ MongoDB (dump)
Mở cmd:
C:\\>mongodump --db shop
=> Tự động tạo một thư mục 'dump\shop' chứa các file dump.

####Import database từ dump file
Mở cmd, cd đến thư mục chứa thư mục 'dump'
C:\\>mongorestore dump/shop
=> CSDL được import vào MongoDB
