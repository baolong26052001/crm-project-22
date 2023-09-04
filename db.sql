-- CRM PROJECT

create database crm;
use crm;

create table LoaiThanhVien(
	id int auto_increment,
	ten varchar(255),
	mota varchar(255),
	
	primary key(id)
);


create table NguoiDung(
	id int auto_increment,
	email varchar(255),
	matkhau varchar(255),
	fullname varchar(255),
	diachi varchar(255),
	soDienThoai varchar(11),
	id_loaithanhvien int,
	
	
	primary key(id)
);

create table DuAn(
	id int auto_increment,
	ten varchar(255),
	mota varchar(255),
	ngaybatdau timestamp,
	ngayketthuc timestamp,
	
	primary key(id)
);

create table CongViec(
	id int auto_increment,
	ten varchar(255),
	id_duan int,
	id_nguoidung int,
	ngaybatdau timestamp,
	ngayketthuc timestamp,
	id_trangthai int,
	
	primary key(id)
);

create table TrangThai(
	id int auto_increment,
	ten varchar(255),
	mota varchar(255),
	
	primary key(id)
);


alter table NguoiDung add constraint FK_id_loaithanhvien_NguoiDung 
foreign key(id_loaithanhvien) references LoaiThanhVien(id);

alter table CongViec add constraint FK_id_nguoidung_CongViec
foreign key(id_nguoidung) references NguoiDung(id);



alter table CongViec add constraint FK_id_trangthai_CongViec
foreign key(id_trangthai) references TrangThai(id);

alter table CongViec add constraint FK_id_duan_CongViec
foreign key(id_duan) references DuAn(id);



