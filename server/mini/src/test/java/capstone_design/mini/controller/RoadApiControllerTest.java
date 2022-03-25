package capstone_design.mini.controller;

import capstone_design.mini.domain.Road;
import capstone_design.mini.domain.RoadRepository;
import capstone_design.mini.dto.RoadSaveRequestDto;
import capstone_design.mini.dto.RoadUpdateRequestDto;
import org.apache.tomcat.util.http.parser.HttpParser;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class RoadApiControllerTest {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate testRestTemplate;

    @Autowired
    private RoadRepository roadRepository;

    @AfterEach
    public void tearDown() throws Exception {
        roadRepository.deleteAll();
    }

    @Test
    public void Road_등록된다() throws Exception {
        //given
        String road_name = "테스트 산책로 이름";
        String road_desc = "테스트 산책로는 아름다워요!";
        double distance = 4.6;
        String time = "2시간30분";
        String start_name = "보라매공원";
        String start_road_addr = "1231";
        String start_lot_addr = "asdfas";
        String end_name = "아주대학교";
        String end_road_addr = "1231";
        String end_lot_addr = "adsf";
        String road_path = "보공->광교역->아주대";
        String agency_tel = "031-155-4444";
        String agency_name = "아주대 산업전기";
        String base_date = "2019-04-11";
        String x = "12";
        String y = "safsdafs";
        String provider_code = "1231213";
        String provider_name = "아주대학교입니다";
        RoadSaveRequestDto requestDto = RoadSaveRequestDto.builder()
                .road_name(road_name)
                .road_desc(road_desc)
                .distance(distance)
                .time(time)
                .start_name(start_name)
                .start_road_addr(start_road_addr)
                .start_lot_addr(start_lot_addr)
                .end_name(end_name)
                .end_road_addr(end_road_addr)
                .end_lot_addr(end_lot_addr)
                .road_path(road_path)
                .agency_tel(agency_tel)
                .agency_name(agency_name)
                .base_date(base_date)
                .x(x)
                .y(y)
                .provider_code(provider_code)
                .provider_name(provider_name)
                .build();
        String url = "http://localhost:" + port + "/road/post";

        //when
        ResponseEntity<Long> responseEntity = testRestTemplate.postForEntity(url, requestDto, Long.class);

        //then
        assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(responseEntity.getBody()).isGreaterThan(0L);
        List<Road> all = roadRepository.findAll();
        assertThat(all.get(0).getRoad_desc()).isEqualTo(road_desc);
    }

    @Test
    public void Road_수정된다() throws Exception {
        //given
        String road_name = "테스트 산책로 이름";
        String road_desc = "테스트 산책로는 아름다워요!";
        double distance = 4.6;
        String time = "2시간30분";
        String start_name = "보라매공원";
        String start_road_addr = "1231";
        String start_lot_addr = "asdfas";
        String end_name = "아주대학교";
        String end_road_addr = "1231";
        String end_lot_addr = "adsf";
        String road_path = "보공->광교역->아주대";
        String agency_tel = "031-155-4444";
        String agency_name = "아주대 산업전기";
        String base_date = "2019-04-11";
        String x = "12";
        String y = "safsdafs";
        String provider_code = "1231213";
        String provider_name = "아주대학교입니다";

        Road savedRoad = roadRepository.save(Road.builder()
                .road_name(road_name)
                .road_desc(road_desc)
                .distance(distance)
                .time(time)
                .start_name(start_name)
                .start_road_addr(start_road_addr)
                .start_lot_addr(start_lot_addr)
                .end_name(end_name)
                .end_road_addr(end_road_addr)
                .end_lot_addr(end_lot_addr)
                .road_path(road_path)
                .agency_tel(agency_tel)
                .agency_name(agency_name)
                .base_date(base_date)
                .x(x)
                .y(y)
                .provider_code(provider_code)
                .provider_name(provider_name)
                .build());
        Long updatedId = savedRoad.getId();
        String expectedRoadName = "수정수정수정";

        RoadUpdateRequestDto requestDto = RoadUpdateRequestDto.builder()
                .road_name(expectedRoadName)
                .road_desc("수정수정수정")
                .distance(1)
                .time("수정수정수정")
                .start_name("수정수정수정")
                .start_road_addr("수정수정수정")
                .start_lot_addr("수정수정수정")
                .end_name("수정수정수정")
                .end_road_addr("수정수정수정")
                .end_lot_addr("수정수정수정")
                .road_path("수정수정수정")
                .agency_tel("수정수정수정")
                .agency_name("수정수정수정")
                .base_date("수정수정수정")
                .provider_code("수정수정수정")
                .provider_name("수정수정수정")
                .build();

        String url = "http://localhost:" + port + "/road/post/" + updatedId;
        HttpEntity<RoadUpdateRequestDto> requestEntity = new HttpEntity<>(requestDto);

        //when
        ResponseEntity<Long> responseEntity = testRestTemplate.exchange(
                url, HttpMethod.PUT, requestEntity, Long.class);

        //then
        assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(responseEntity.getBody()).isGreaterThan(0L);
        List<Road> all = roadRepository.findAll();
        assertThat(all.get(0).getRoad_name()).isEqualTo(expectedRoadName);
    }

}
