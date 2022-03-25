package capstone_design.mini.domain;

import capstone_design.mini.domain.Road;
import org.springframework.data.jpa.repository.JpaRepository;

// <Entity 클래스, PK 타입>
public interface RoadRepository extends JpaRepository<Road, Long> {

}
