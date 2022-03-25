package capstone_design.mini.dto;

import capstone_design.mini.domain.Road;
import com.sun.istack.NotNull;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Getter
@NoArgsConstructor
public class RoadSaveRequestDto {

    private String road_name;
    private String road_desc;
    private double distance;
    private String time;
    private String start_name;
    private String start_road_addr;
    private String start_lot_addr;
    private String end_name;
    private String end_road_addr;
    private String end_lot_addr;
    private String road_path;
    private String agency_tel;
    private String agency_name;
    private String base_date;
    private String x;
    private String y;
    private String provider_code;
    private String provider_name;

    @Builder
    public RoadSaveRequestDto(String road_name, String road_desc, double distance, String time, String start_name, String start_road_addr, String start_lot_addr, String end_name, String end_road_addr, String end_lot_addr, String road_path, String agency_tel, String agency_name, String base_date, String x, String y, String provider_code, String provider_name) {
        this.road_name = road_name;
        this.road_desc = road_desc;
        this.distance = distance;
        this.time = time;
        this.start_name = start_name;
        this.start_road_addr = start_road_addr;
        this.start_lot_addr = start_lot_addr;
        this.end_name = end_name;
        this.end_road_addr = end_road_addr;
        this.end_lot_addr = end_lot_addr;
        this.road_path = road_path;
        this.agency_tel = agency_tel;
        this.agency_name = agency_name;
        this.base_date = base_date;
        this.x = x;
        this.y = y;
        this.provider_code = provider_code;
        this.provider_name = provider_name;
    }

    public Road toEntity() {
        return Road.builder()
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
    }
}
