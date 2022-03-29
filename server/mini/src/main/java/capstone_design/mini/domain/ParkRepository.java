package capstone_design.mini.domain;

import capstone_design.mini.dto.ParkRecommendInterface;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ParkRepository extends JpaRepository<Park, Long> {

    // 반경 5km 이내 시작 주소가 있는 road 반환 (d, id, road_name)
    @Query(value = "SELECT ( 6371 * acos ( cos ( radians(lat) ) * cos( radians(:latitude) ) * cos( radians(lng) - radians(:longitude) ) + sin ( radians(lat) ) * sin( radians(:latitude) ) )\n" +
            "        ) AS d, id, name, addr, lat, lng, area\n" +
            "FROM park_info\n" +
            "HAVING d < 5\n" +
            "ORDER BY d\n" +
            "LIMIT 0 , 10;", nativeQuery = true)
    List<ParkRecommendInterface> findNearRoads(@Param("latitude") double latitude, @Param("longitude") double longitude);

    // 스포츠(sports) 관련 조회
    @Query(value = "select * from park_info where facility_sport LIKE \"%축구%\"\n" +
            "    or facility_sport LIKE \"%궁터%\"\n" +
            "    or facility_sport LIKE \"%농구%\"\n" +
            "    or facility_sport like \"%풋살%\"\n" +
            "    or facility_sport like \"%바이크%\"\n" +
            "    or facility_sport like \"%배드민턴%\"\n" +
            "    or facility_sport like \"%론볼%\"\n" +
            "    or facility_sport like \"%테니스%\"\n" +
            "    or facility_sport like \"%족구%\"\n" +
            "    or facility_sport like \"%인라인%\"\n" +
            "    or facility_sport like \"%배구%\"\n" +
            "    or facility_sport like \"%야구%\"\n" +
            "    or facility_sport like \"%씨름%\"\n" +
            "    or facility_sport like \"%골프%\"\n" +
            "    or facility_sport like \"%수영%\"\n" +
            "    or facility_sport like \"%게이트볼%\"\n" +
            "    or facility_sport like \"%궁도%\"\n" +
            "    or facility_sport like \"%국궁%\"\n" +
            "    or facility_sport like \"%배드민턴%\"\n" +
            "    or facility_sport like \"%game%\"\n" +
            "    or facility_sport like \"%게임%\"\n" +
            "    or facility_sport like \"%사이클%\";", nativeQuery = true)
    List<Park> findSports();

    // 운동기구(exercise) 관련 조회
    @Query(value = "select * from park_info where facility_sport LIKE \"%운동%\"\n" +
            "                           or facility_sport like \"%허리%\"\n" +
            "                           or facility_sport like \"%걷기%\"\n" +
            "                           or facility_sport like \"%체육%\"\n" +
            "                           or facility_sport like \"%운동%\"\n" +
            "                           or facility_sport like \"%봉%\"\n" +
            "                           or facility_sport like \"%웨이트%\"\n" +
            "                           or facility_sport like \"%체력%\"\n" +
            "                           or facility_sport like \"%헬스%\"\n" +
            "                           or facility_sport like \"%체조%\"\n" +
            "                           or facility_sport like \"%윗몸%\"\n" +
            "                           or facility_sport like \"%온몸%\"\n" +
            "                           or facility_sport like \"%워킹%\";", nativeQuery = true)
    List<Park> findExercise();

    // 편의시설(conv) 관련 조회
    @Query(value = "select * from park_info where facility_conv LIKE \"%파고라%\"\n" +
            "                           or facility_sport LIKE \"%팔각정%\"\n" +
            "                           or facility_sport like \"%쉼터%\"\n" +
            "                           or facility_sport like \"%휴게소%\"\n" +
            "                           or facility_sport like \"%피크닉장%\"\n" +
            "                           or facility_sport like \"%평상%\"\n" +
            "                           or facility_sport like \"%퍼걸러%\"\n" +
            "                           or facility_sport like \"%팔각정자%\"\n" +
            "                           or facility_sport like \"%평의자%\"\n" +
            "                           or facility_sport like \"%정자%\"\n" +
            "                           or facility_sport like \"%분수%\"\n" +
            "                           or facility_etc like \"%파고라%\"\n" +
            "                           or facility_etc like \"%정자%\"\n" +
            "                           or facility_etc like \"%자전거보관%\"\n" +
            "                           or facility_etc like \"%분수%\";", nativeQuery = true)
    List<Park> findConv();

    // 주차장(parking lot) 관련 조회
    @Query(value = "select * from park_info where facility_conv LIKE \"%주차%\"\n" +
            "                           or facility_etc LIKE \"%주차%\";", nativeQuery = true)
    List<Park> findParkingLot();

    // 놀이기구(amuse) 관련 조회
    @Query(value = "select * from park_info where facility_amuse is not null;", nativeQuery = true)
    List<Park> findAmuse();
}
