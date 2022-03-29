package capstone_design.mini.controller;

import capstone_design.mini.domain.Park;
import capstone_design.mini.dto.ParkRecommendInterface;
import capstone_design.mini.service.ParkService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;


@RequiredArgsConstructor
@RestController
public class ParkApiController {

    private final ParkService parkService;

    @PostMapping("/park/recommend")
    public List<Park> recommendParks(@RequestBody Map<String, Object> param) {
        System.out.println(param);

        Double lat = (Double) param.get("lat");
        Double lng = (Double) param.get("lng");

        Boolean isSports = (Boolean) param.get("sports");
        Boolean isExercise = (Boolean) param.get("exercise");
        Boolean isConv = (Boolean) param.get("conv");
        Boolean isParking = (Boolean) param.get("parkingLot");
        Boolean isAmuse = (Boolean) param.get("amuse");

        List<Double> point = new ArrayList<>(Arrays.asList(lat, lng));
        List<Boolean> booleanList = new ArrayList<>(Arrays.asList(isSports, isExercise, isConv, isParking, isAmuse));

        return parkService.getRecommendedParks(point, booleanList);
    }
}
