drop table if exists road cascade;
create table road (
    id bigint(20) not null auto_increment primary key,
    road_name varchar(50) not null,
    road_desc varchar(600) not null,
    distance double not null,
    time varchar(50) not null,
    start_name varchar(50) not null,
    start_road_addr varchar(150),
    start_lot_addr varchar(150),
    start_lat double not null,
    start_lng double not null,
    end_name varchar(50),
    end_road_addr varchar(80),
    end_lot_addr varchar(80),
    end_lat double not null,
    end_lng double not null,
    road_path varchar(80),
    agency_tel char(15),
    agency_name varchar(50),
    base_date char(10),
    provider_code varchar(50),
    provider_name varchar(50)

)

LOAD DATA LOCAL INFILE "C:\\Users\\SION_2\\Downloads\\road_data.csv"
INTO TABLE capstone_design.road
FIELDS TERMINATED BY "|"
LINES TERMINATED BY "\n"
IGNORE 1 ROWS;