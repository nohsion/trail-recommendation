package capstone_design.mini.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class RoadUpdateRequestDto {

    private String road_name;
    private String road_desc;
    private double distance;
    private String time;
    private String start_name;
    private String start_road_addr;
    private String start_lot_addr;
    private double start_lat;
    private double start_lng;
    private String end_name;
    private String end_road_addr;
    private String end_lot_addr;
    private double end_lat;
    private double end_lng;
    private String road_path;
    private String agency_tel;
    private String agency_name;
    private String base_date;
    private String provider_code;
    private String provider_name;

    @Builder
    public RoadUpdateRequestDto(String road_name, String road_desc, double distance, String time, String start_name, String start_road_addr, String start_lot_addr, double start_lat, double start_lng, String end_name, String end_road_addr, String end_lot_addr, double end_lat, double end_lng, String road_path, String agency_tel, String agency_name, String base_date, String provider_code, String provider_name) {
        this.road_name = road_name;
        this.road_desc = road_desc;
        this.distance = distance;
        this.time = time;
        this.start_name = start_name;
        this.start_road_addr = start_road_addr;
        this.start_lot_addr = start_lot_addr;
        this.start_lat = start_lat;
        this.start_lng = start_lng;
        this.end_name = end_name;
        this.end_road_addr = end_road_addr;
        this.end_lot_addr = end_lot_addr;
        this.end_lat = end_lat;
        this.end_lng = end_lng;
        this.road_path = road_path;
        this.agency_tel = agency_tel;
        this.agency_name = agency_name;
        this.base_date = base_date;
        this.provider_code = provider_code;
        this.provider_name = provider_name;
    }
}
