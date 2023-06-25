package pl.skoczki.Zadanie2_9.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;
import pl.skoczki.Zadanie2_9.service.boundary.SkiJumperRepository;
import pl.skoczki.Zadanie2_9.service.boundary.SkiJumperService;
import pl.skoczki.Zadanie2_9.service.entity.SkiJumper;
import pl.skoczki.Zadanie2_9.web.SkiJumperCreateRequest;

import java.util.Optional;

@Controller
public class WebController {

    @Autowired
    private SkiJumperService service;

    @Autowired
    private SkiJumperRepository repository;

    @RequestMapping(value = "/")
    public String index(Model model) {
        model.addAttribute("skiJumpers", service.getAll());
        return "index";
    }

    @RequestMapping(value = "/add-ski-jumper", method = RequestMethod.GET)
    public String addSkiJumper(Model model) {
        model.addAttribute("skiJumper", new SkiJumperCreateRequest());
        return "add-ski-jumper";
    }
    
    @RequestMapping(value = "/add-ski-jumper", method = RequestMethod.POST)
    public RedirectView createSkiJumperSubmit(@ModelAttribute(value = "skiJumper") SkiJumperCreateRequest createRequest) {
        SkiJumper skiJumper = new SkiJumper();
        skiJumper.setName(createRequest.getName());
        skiJumper.setSurname(createRequest.getSurname());
        skiJumper.setCountry(createRequest.getCountry());
        skiJumper.setAge(createRequest.getAge());
        skiJumper.setJumpRecord(createRequest.getJumpRecord());
        repository.save(skiJumper);
        return new RedirectView("/");
    }
}