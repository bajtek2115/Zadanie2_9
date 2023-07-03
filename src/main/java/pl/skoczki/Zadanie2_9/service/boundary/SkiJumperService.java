package pl.skoczki.Zadanie2_9.service.boundary;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.skoczki.Zadanie2_9.service.control.SkiJumperMapper;
import pl.skoczki.Zadanie2_9.service.entity.Country;
import pl.skoczki.Zadanie2_9.service.entity.SkiJumper;
import pl.skoczki.Zadanie2_9.service.entity.SkiJumperDTO;

import java.util.List;

@Service
public class SkiJumperService {

    @Autowired
    private SkiJumperRepository repository;

    @Autowired
    private SkiJumperMapper mapper;

    public List<SkiJumperDTO> getAll() {
        Iterable<SkiJumper> skiJumpers = repository.findAll();
        return mapper.map(skiJumpers);
    }

    public void deleteSkiJumper(Long id) {
        repository.deleteById(id);
    }

    public List<SkiJumperDTO> searchByCountry(Country country) {
        List<SkiJumper> skiJumpers = repository.findByCountry(country);
        return mapper.map(skiJumpers);
    }
}