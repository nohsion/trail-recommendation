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
--     (@var1, @var2, @var3, @var4, @var5, @var6, @var7, @var8, @var9, @var10, @var11, @var12, @var13, @var14, @var15, @var16, @var17, @var18, @var19, @var20, @var21)
--     SET id = @var1, road_name = @var2, road_desc = @var3, distance = @var4, time = @var5, start_name = @var6, start_road_addr = @var7, start_lot_addr = @var8, start_point = POINT(@var9, @var10),
--     end_name = @var11,  end_road_addr = @var12, end_lot_addr = @var13, end_point = POINT(@var14, @var15), road_path = @var16, agency_tel = @var17, agency_name = @var18, base_date = @var19, provider_code = @var20, provider_name = @var21;
