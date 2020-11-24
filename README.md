# sharesheet

โปรเจค ShareSheet ใช้สำหรับก็บรวบรวมURLของ ไฟล์,สไลด์,การบ้าน,สรุปวิชา เพื่อแบ่งปันหรือเป็นตัวกลางในการกระจายข้อมูลสู่หลากหลายผู้ใช้ได้ง่ายขึ้น

รายชื่อสมาชิก
- นายกิตติภณ			 หุตะวาณิชย์กุล	6010450055
- นางสาวชนฑกานต์	นันตมาศ		  6010450161
- นายปาริญ			  ฮอปเปอร์		6010450420
- นายปิยวัฒน์ 		  ภิรมย์พิน		  6010450438
- นายกฤตกร			 ผลศิริ			  6010450969

คำแนะนำก่อน รันโปรเจค
1.สร้างฐานข้อมูลบน mysql ด้วย

Create Database sharesheet;
USE sharesheet;

CREATE TABLE user (
   id INT NOT NULL,
   name VARCHAR(45) NOT NULL,
   pin TEXT NOT NULL,
   PRIMARY KEY (id)
);
------------------------------------------

Create Database sharesheetaccount;
USE sharesheetaccount;

CREATE table post_account(
    id int NOT NULL AUTO_INCREMENT,
	  namepost varchar(50) NOT NULL,
    description varchar(50) NOT NULL,
    file text NOT NULL,
    PRIMARY KEY (id)
    );
    
2.clone โปรเจค sharesheetAPI ที่ https://github.com/wakizashixd/sharesheetAPI

3.serve โปรเจคทั้งสองก่อนใช้งาน
    
