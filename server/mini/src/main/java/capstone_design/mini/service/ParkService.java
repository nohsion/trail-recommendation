package capstone_design.mini.service;


import capstone_design.mini.domain.Park;
import capstone_design.mini.domain.ParkRepository;
import capstone_design.mini.dto.ParkRecommendInterface;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class ParkService {

    private final ParkRepository parkRepository;

    // 5km 이내에 있으면서 사용자 선호도에 맞는 공원 추천
    public List<Park> getRecommendedParks(List<Double> point, List<Boolean> booleanList) {
        List<Park> mergedList = new ArrayList<>();

        // 특정 위치 기준 5km 이내 데이터 조회
        Double lat = point.get(0);
        Double lng = point.get(1);
        List<ParkRecommendInterface> nearRoads = parkRepository.findNearRoads(lat, lng);
        List<Long> idList = nearRoads.stream().map(ParkRecommendInterface::getId).collect(Collectors.toList());

        if (booleanList.get(0)) {
            List<Park> sports = parkRepository.findSports();
            for (Park column : sports) {
                if (idList.contains(column.getId())) {
                    mergedList.add(column);
                }
            }
        }
        if (booleanList.get(1)) {
            List<Park> exercise = parkRepository.findExercise();
            for (Park column : exercise) {
                if (idList.contains(column.getId())) {
                    mergedList.add(column);
                }
            }
        }
        if (booleanList.get(2)) {
            List<Park> conv = parkRepository.findConv();
            for (Park column : conv) {
                if (idList.contains(column.getId())) {
                    mergedList.add(column);
                }
            }
        }
        if (booleanList.get(3)) {
            List<Park> parkingLot = parkRepository.findParkingLot();
            for (Park column : parkingLot) {
                if (idList.contains(column.getId())) {
                    mergedList.add(column);
                }
            }
        }
        if (booleanList.get(4)) {
            List<Park> amuse = parkRepository.findAmuse();
            for (Park column : amuse) {
                if (idList.contains(column.getId())) {
                    mergedList.add(column);
                }
            }
        }

        return mergedList;

    }
}
