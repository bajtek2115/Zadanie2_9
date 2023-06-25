package pl.skoczki.Zadanie2_9.service.control;

import org.springframework.stereotype.Component;
import pl.skoczki.Zadanie2_9.service.entity.SkiJumper;
import pl.skoczki.Zadanie2_9.service.entity.SkiJumperDTO;

import java.util.ArrayList;
import java.util.List;

@Component
public class SkiJumperMapper {

    public List<SkiJumperDTO> map(Iterable<SkiJumper> skiJumpers) {
        List<SkiJumperDTO> dtos = new ArrayList<>();
        skiJumpers.forEach(skiJumper -> dtos.add(map(skiJumper)));
        return dtos;
    }

    private SkiJumperDTO map(SkiJumper skiJumper) {
        return new SkiJumperDTO(skiJumper.getName(), skiJumper.getSurname(), skiJumper.getCountry(), skiJumper.getAge(), skiJumper.getJumpRecord());
    }
}