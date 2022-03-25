package capstone_design.mini.service;

import capstone_design.mini.domain.Road;
import capstone_design.mini.domain.RoadRepository;
import capstone_design.mini.dto.RoadResponseDto;
import capstone_design.mini.dto.RoadSaveRequestDto;
import capstone_design.mini.dto.RoadUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
@Service
public class RoadService {

    private final RoadRepository roadRepository;

    @Transactional
    public Long save(RoadSaveRequestDto requestDto) {
        return roadRepository.save(requestDto.toEntity()).getId();
    }

    @Transactional
    public Long update(Long id, RoadUpdateRequestDto requestDto) {
        Road road = roadRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 산책길이 없습니다. id=" + id));
        road.update(requestDto.getRoad_name(), requestDto.getRoad_desc(),
                requestDto.getDistance(), requestDto.getTime(),
                requestDto.getStart_name(), requestDto.getStart_road_addr(),
                requestDto.getStart_lot_addr(), requestDto.getEnd_name(),
                requestDto.getEnd_road_addr(), requestDto.getEnd_lot_addr(),
                requestDto.getRoad_path(), requestDto.getAgency_tel(),
                requestDto.getAgency_name(), requestDto.getBase_date(),
                requestDto.getX(), requestDto.getY(),
                requestDto.getProvider_code(), requestDto.getProvider_name());
        return id;
    }

    public RoadResponseDto findById(Long id) {
        Road entity = roadRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 산책길이 없습니다. id=" + id));
        return new RoadResponseDto(entity);
    }


    public List<Road> getRoads() {
        return roadRepository.findAll();
    }
}
