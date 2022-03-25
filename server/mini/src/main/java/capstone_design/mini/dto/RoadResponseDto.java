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
    private String start_road_addr;
    private String end_road_addr;
    private String road_path;
    private String agency_tel;
    private String agency_name;

    public RoadResponseDto(Road entity) {
        this.id = entity.getId();
        this.road_name = entity.getRoad_name();
        this.road_desc = entity.getRoad_desc();
        this.distance = entity.getDistance();
        this.time = entity.getTime();
        this.start_road_addr = entity.getStart_road_addr();
        this.end_road_addr = entity.getEnd_road_addr();
        this.road_path = entity.getRoad_path();
        this.agency_tel = entity.getAgency_tel();
        this.agency_name = entity.getAgency_name();
    }
}
