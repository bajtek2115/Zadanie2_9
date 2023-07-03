package pl.skoczki.Zadanie2_9.service.boundary;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.skoczki.Zadanie2_9.service.entity.Country;
import pl.skoczki.Zadanie2_9.service.entity.SkiJumper;

import java.util.List;

@Repository
public interface SkiJumperRepository extends CrudRepository<SkiJumper, Long> {

    List<SkiJumper> findByCountry(Country country);
}