package pl.skoczki.Zadanie2_9;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import pl.skoczki.Zadanie2_9.service.boundary.SkiJumperRepository;
import pl.skoczki.Zadanie2_9.service.entity.SkiJumper;

@Component
public class Start {

    private SkiJumperRepository skiJumperRepository;

    @Autowired
    public Start(SkiJumperRepository skiJumperRepository) {
        this.skiJumperRepository = skiJumperRepository;
    }

//    @EventListener(ApplicationReadyEvent.class)
    public void run() {
        SkiJumper skiJumper = new SkiJumper("Kamil", "Stoch", "Polska", 36, 251.5);
        skiJumperRepository.save(skiJumper);
        Iterable<SkiJumper> all = skiJumperRepository.findAll();
        all.forEach(System.out::println);
    }
}