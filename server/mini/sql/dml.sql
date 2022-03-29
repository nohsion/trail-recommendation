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


-- 스포츠(sports) 관련 조회
select * from park_info where facility_sport LIKE "%축구%"
                           or facility_sport LIKE "%궁터%"
                           or facility_sport LIKE "%농구%"
                           or facility_sport like "%풋살%"
                           or facility_sport like "%바이크%"
                           or facility_sport like "%배드민턴%"
                           or facility_sport like "%론볼%"
                           or facility_sport like "%테니스%"
                           or facility_sport like "%족구%"
                           or facility_sport like "%인라인%"
                           or facility_sport like "%배구%"
                           or facility_sport like "%야구%"
                           or facility_sport like "%씨름%"
                           or facility_sport like "%골프%"
                           or facility_sport like "%수영%"
                           or facility_sport like "%게이트볼%"
                           or facility_sport like "%궁도%"
                           or facility_sport like "%국궁%"
                           or facility_sport like "%배드민턴%"
                           or facility_sport like "%game%"
                           or facility_sport like "%게임%"
                           or facility_sport like "%사이클%";

-- 운동기구(exercise) 관련 조회
select * from park_info where facility_sport LIKE "%운동%"
                           or facility_sport like "%허리%"
                           or facility_sport like "%걷기%"
                           or facility_sport like "%체육%"
                           or facility_sport like "%운동%"
                           or facility_sport like "%봉%"
                           or facility_sport like "%웨이트%"
                           or facility_sport like "%체력%"
                           or facility_sport like "%헬스%"
                           or facility_sport like "%체조%"
                           or facility_sport like "%윗몸%"
                           or facility_sport like "%온몸%"
                           or facility_sport like "%워킹%";

-- 편의시설(conv) 관련 조회
select * from park_info where facility_conv LIKE "%파고라%"
                           or facility_sport LIKE "%팔각정%"
                           or facility_sport like "%쉼터%"
                           or facility_sport like "%휴게소%"
                           or facility_sport like "%피크닉장%"
                           or facility_sport like "%평상%"
                           or facility_sport like "%퍼걸러%"
                           or facility_sport like "%팔각정자%"
                           or facility_sport like "%평의자%"
                           or facility_sport like "%정자%"
                           or facility_sport like "%분수%"
                           or facility_etc like "%파고라%"
                           or facility_etc like "%정자%"
                           or facility_etc like "%자전거보관%"
                           or facility_etc like "%분수%";

-- 주차장(parking lot) 관련 조회
select * from park_info where facility_conv LIKE "%주차%"
                           or facility_etc LIKE "%주차%";

-- 놀이기구(amuse) 관련 조회
select * from park_info where facility_amuse is not null;