# DOCUMENTS
- [doctument](https://drive.google.com/drive/u/0/folders/12KTQyu9NfOW5YnRo4qgC-4i08HdTtEDU)

# CHUẨN BỊ

### CÀI ĐẶT JDK
Step 1: Truy cập trang chủ oracle
[tại đây](https://www.oracle.com/java/technologies/downloads/#jdk17-windows)

    https://www.oracle.com/java/technologies/downloads/#jdk17-windows

Step 2: Chọn hệ điều hành phù hợp. 

    trong ví dụ là window và chọn x64 installer

step 3: run file và tiến hành cài đặt

step 4: kiểm tra version. run lệnh sau ở command line để kiểm tra version 

    java -version

[Video hướng dẫn cài đặt JDK 17](https://www.youtube.com/watch?v=fFbdHAD4ekg)

### CÀI ĐẶT APACHE TOMCAT

step 1: tài file cài đặt tomcat 9 [tại đây](https://tomcat.apache.org/download-90.cgi). chọn mục sau đây.

    32-bit/64-bit Windows Service Installer (pgp, sha512)

step 2: run file cài đặt

    - nhấn next ở trang đầu tiên
    - chọn i agree
    - chọn components cần cài đặt (giữ nguyên)
    - cấu hình ban đầu

        Server Shutdow Port, HTTP/1.1 Connector Port, AJP/1.3 Connector Port để mặc định.

        Windows Service Name: nhập tên tùy ý

        Tomcat Administrator Login: Roles(admin-gui,manager-gui)



 step 3: Cấu hình Java Virtual Machine:

    Tại giao diện Java Virtual Machine, nếu bạn đã cài đặt JDK (ở bước 1) thì hệ thống sẽ tự động nhận diện đường dẫn, nhấn Next để tiếp tục quá trình cài đặt.

step 4: Cấu hình đường dẫn cài đặt Tomcat

    Với giao diện Choose Install Location, bạn tìm và chọn đường dẫn lưu thư mục Tomcat hoặc để mặc định

step 5: hoàn thành và kiểm tra

truy cập [http://localhost:8080](http://localhost:8080) để kiểm tra server tomcat đã hoạt động chưa


 > có thể xem hướng dẫn tại [bài viết](https://hiepsharing.com/>cai-dat-tomcat-9-tren-windows/)

[video hướng dẫn](https://www.youtube.com/watch?v=hz-Pb1MgRBU)


# cài đặt database

run lần lượt các file.sql sau

1. Create_Database.sql
2. RBTV.sql
3. Procedure.sql
4. Insert.sql

Điều chỉnh các thông số phù hợp trong file
**application.properties** ở đường dẫn:

    \QuanLyCanTeen\src\main\resources\application.properties

```
server.port=8080

spring.datasource.url = jdbc:sqlserver://localhost:1433;databaseName=QLCANTIN;encrypt=true;trustServerCertificate=true;

spring.datasource.username={username}
spring.datasource.password={password}
spring.datasource.driverClassName = com.microsoft.sqlserver.jdbc.SQLServerDriver
spring.jpa.show-sql = true
spring.jpa.properties.hibernate.dialect = org.hibernate.dialect.SQLServer2012Dialect

#spring.jpa.hibernate.ddl-auto = update
#spring.mvc.pathmatch.matching-strategy = ANT_PATH_MATCHER
```

    dùng tài khoản có quyền cao như sa 
    {username} : tên login để đăng nhập vào database
    {password} : pasword đăng nhập database

    server.port điều chỉnh khi có điều chỉnh thì phải đổi port ở file function.js trong repo frontend(nmcnpm)
 
# cài đặt chương trình

> clone repo frontend [tại đây](https://github.com/Tthanhwork94/nmcnpm)
>
> clone repo backend [tại đây](https://github.com/Tthanhwork94/quanlyCanTeen)
>

truy cập vào đường dẫn trong folder QuanLyCanTeen\target

> mở cmd và run lệnh

    java -jar QuanLyCanTeen-0.0.1-SNAPSHOT.jar

tomcat sẽ run trên port:8080

nếu port 8080 đã dùng ở ứng dụng khác thì ta có thể đổi port trong file **application.properties** và điều chỉnh port của biến localhost lại trong repo frontend trong file **function.js**


## mở chrome để chạy chương trình không bị lỗi chặn cors

mở cmd và run lần lượt các lệnh sau:

    cd "c:\Program Files\Google\Chrome\Application"

    chrome.exe --disable-web-security --user-data-dir="c:/ChromeDevSession"

sau đó truy cập [http://127.0.0.1:5501/](http://127.0.0.1:5501/) ở cửa sổ chrome mới vừa được mở lên