package capstone_design.mini.domain;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class RoadRepositoryTest {

    @Autowired
    RoadRepository roadRepository;

    @AfterEach
    public void cleanup() {
        roadRepository.deleteAll();
    }

    @Test
    public void 산책로저장_불러오기() {
        //given
        String road_name = "테스트 산책로 이름";
        String road_desc = "테스트 산책로는 아름다워요!";
        double distance = 4.6;
        String time = "2시간30분";
        String start_name = "보라매공원";
        String end_name = "아주대학교";
        String road_path = "보공->광교역->아주대";
        String agency_tel = "031-155-4444";
        String agency_name = "아주대 산업전기";
        String base_date = "2019-04-11";
        String provider_code = "1231213";
        String provider_name = "아주대학교입니다";

        roadRepository.save(Road.builder()
                .road_name(road_name)
                .road_desc(road_desc)
                .distance(distance)
                .time(time)
                .start_name(start_name)
                .end_name(end_name)
                .road_path(road_path)
                .agency_tel(agency_tel)
                .agency_name(agency_name)
                .base_date(base_date)
                .provider_code(provider_code)
                .provider_name(provider_name)
                .build());

        //when
        List<Road> roadList = roadRepository.findAll();

        //then
        Road road = roadList.get(0);
        assertThat(road.getRoad_name()).isEqualTo(road_name);
        assertThat(road.getRoad_desc()).isEqualTo(road_desc);
        assertThat(road.getDistance()).isEqualTo(distance);
        assertThat(road.getTime()).isEqualTo(time);

    }

}
