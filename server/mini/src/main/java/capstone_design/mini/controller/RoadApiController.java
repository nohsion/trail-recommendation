package capstone_design.mini.controller;

import capstone_design.mini.domain.Road;
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
    public List<RoadResponseDto> getRoads(Road entity) {
        List<Road> roads = roadService.getRoads();
        return roads.stream().map(RoadResponseDto::new).collect(Collectors.toList());
    }

    @GetMapping("/road/id/{id}")
    public RoadResponseDto findById(@PathVariable Long id) {
        return roadService.findById(id);
    }

    @PutMapping("/road/post/{id}")
    public Long update(@PathVariable Long id, @RequestBody RoadUpdateRequestDto requestDto) {
        return roadService.update(id, requestDto);
    }
}
