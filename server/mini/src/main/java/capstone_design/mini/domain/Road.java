package capstone_design.mini.domain;

import com.sun.istack.NotNull;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
public class Road {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private String road_name;

    @NotNull
    @Column(length = 600)
    private String road_desc;

    @NotNull
    private double distance;

    @NotNull
    private String time;

    @NotNull
    private String start_name;

    private String start_road_addr;

    private String start_lot_addr;

    @NotNull
    private String end_name;

    private String end_road_addr;

    private String end_lot_addr;

    @NotNull
    @Column(length = 400)
    private String road_path;

    @NotNull
    private String agency_tel;

    @NotNull
    private String agency_name;

    @NotNull
    private String base_date;

    private String x;

    private String y;

    @NotNull
    private String provider_code;

    @NotNull
    private String provider_name;

    @Builder
    public Road(String road_name, String road_desc, double distance, String time, String start_name, String start_road_addr, String start_lot_addr, String end_name, String end_road_addr, String end_lot_addr, String road_path, String agency_tel, String agency_name, String base_date, String x, String y, String provider_code, String provider_name) {
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

    public void update(String road_name, String road_desc, double distance, String time, String start_name, String start_road_addr, String start_lot_addr, String end_name, String end_road_addr, String end_lot_addr, String road_path, String agency_tel, String agency_name, String base_date, String x, String y, String provider_code, String provider_name) {
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

}
