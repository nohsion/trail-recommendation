package capstone_design.mini.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Getter
@NoArgsConstructor
@Entity
public class Park {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String park_id;

    private String name;

    private String type;

    private String addr_new;

    private String addr;

    private Double lat;

    private Double lng;

    private int area;

    private String facility_sport;

    private String facility_amuse;

    private String facility_conv;

    private String facility_cul;

    private String facility_etc;

    private String updated;

    private String manage_agency;

    private String dataBaseDate;

    private String provider_code;

    private String provider_name;



}
