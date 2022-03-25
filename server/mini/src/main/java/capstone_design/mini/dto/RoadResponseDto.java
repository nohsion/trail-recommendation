package capstone_design.mini.dto;

import capstone_design.mini.domain.Road;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
public class RoadResponseDto {

    private Long id;
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

    public RoadResponseDto(Road entity) {
        this.id = entity.getId();
        this.road_name = entity.getRoad_name();
        this.road_desc = entity.getRoad_desc();
        this.distance = entity.getDistance();
        this.time = entity.getTime();
        this.start_name = entity.getStart_name();
        this.start_road_addr = entity.getStart_road_addr();
        this.start_lot_addr = entity.getStart_lot_addr();
        this.start_lat = entity.getStart_lat();
        this.start_lng = entity.getStart_lng();
        this.end_name = entity.getEnd_name();
        this.end_road_addr = entity.getEnd_road_addr();
        this.end_lot_addr = entity.getEnd_lot_addr();
        this.end_lat = entity.getEnd_lat();
        this.end_lng = entity.getEnd_lng();
        this.road_path = entity.getRoad_path();
    }
}
