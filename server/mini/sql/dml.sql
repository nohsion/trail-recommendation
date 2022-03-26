-- 출발주소 관련 10km 반경 이내 데이터 조사
SELECT
    (
            6371 * acos (
                        cos ( radians(start_lat) )
                        * cos( radians(37.56726109866003) )
                        * cos( radians(start_lng) - radians(127.1903672271528) )
                    + sin ( radians(start_lat) )
                            * sin( radians(37.56726109866003) )
            )
        ) AS d, id, road_name, road_desc, distance, time, start_name, start_road_addr, start_lot_addr, start_lat, start_lng, end_name, end_road_addr, end_lot_addr, end_lat, end_lng, road_path
FROM road
HAVING d < 10
ORDER BY d
    LIMIT 0 , 10;

-- 출발주소 관련 10km 반경 이내 데이터 조사
SELECT
    (
            6371 * acos (
                        cos ( radians(end_lat) )
                        * cos( radians(37.56726109866003) )
                        * cos( radians(end_lng) - radians(127.1903672271528) )
                    + sin ( radians(end_lat) )
                            * sin( radians(37.56726109866003) )
            )
        ) AS d, id, road_name, road_desc, distance, time, start_name, start_road_addr, start_lot_addr, start_lat, start_lng, end_name, end_road_addr, end_lot_addr, end_lat, end_lng, road_path
FROM road
HAVING d < 10
ORDER BY d
    LIMIT 0 , 10;
