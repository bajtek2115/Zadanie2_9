package pl.skoczki.Zadanie2_9.service.boundary;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.skoczki.Zadanie2_9.service.entity.SkiJumper;

@Repository
public interface SkiJumperRepository extends CrudRepository<SkiJumper, Long> {
}