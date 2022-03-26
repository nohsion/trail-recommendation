package capstone_design.mini.controller;

import capstone_design.mini.domain.Road;
import capstone_design.mini.dto.RoadNearInterface;
import capstone_design.mini.dto.RoadResponseDto;
import capstone_design.mini.dto.RoadSaveRequestDto;
import capstone_design.mini.dto.RoadUpdateRequestDto;
import capstone_design.mini.service.RoadService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@RestController
public class RoadApiController {

    private final RoadService roadService;

    @GetMapping("/road/all")
    public List<RoadResponseDto> getRoads() {
        List<Road> roads = roadService.getRoads();
        return roads.stream().map(RoadResponseDto::new).collect(Collectors.toList());
    }

    @GetMapping("/road/id/{id}")
    public RoadResponseDto findById(@PathVariable Long id) {
        return roadService.findById(id);
    }

    @PostMapping("/road/post")
    public Long save(@RequestBody RoadSaveRequestDto requestDto) {
        return roadService.save(requestDto);
    }

    @PutMapping("/road/post/{id}")
    public Long update(@PathVariable Long id, @RequestBody RoadUpdateRequestDto requestDto) {
        return roadService.update(id, requestDto);
    }

    // TODO: 안드로이드에서 현위치(lat,lng) 받아서 반경 2km에 존재하는 DB 찾아서 보내주기
    @GetMapping("/road/nearRoads")
    public List<RoadNearInterface> getNearRoads(@RequestParam double lat, @RequestParam double lng) {
        List<RoadNearInterface> nearRoads = roadService.getNearRoads(lat, lng);
        return nearRoads;
    }
}
