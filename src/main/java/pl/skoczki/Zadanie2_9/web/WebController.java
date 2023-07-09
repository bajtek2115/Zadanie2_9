package pl.skoczki.Zadanie2_9.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;
import pl.skoczki.Zadanie2_9.service.boundary.SkiJumperRepository;
import pl.skoczki.Zadanie2_9.service.boundary.SkiJumperService;
import pl.skoczki.Zadanie2_9.service.entity.Country;
import pl.skoczki.Zadanie2_9.service.entity.SkiJumper;
import pl.skoczki.Zadanie2_9.service.entity.SkiJumperDTO;
import pl.skoczki.Zadanie2_9.web.SkiJumperCreateRequest;

import java.util.List;
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

    @RequestMapping(value = "/edit-ski-jumper/{id}", method = RequestMethod.GET)
    public String editSkiJumper(Model model, @PathVariable Long id) {
        SkiJumper skiJumper = repository.findById(id).orElseThrow();
        SkiJumperEditRequest editRequest = new SkiJumperEditRequest(skiJumper.getId(), skiJumper.getName(), skiJumper.getSurname(), skiJumper.getCountry(), skiJumper.getAge(), skiJumper.getJumpRecord());
        model.addAttribute("skiJumper", editRequest);
        return "edit-ski-jumper";
    }

    @RequestMapping(value = "/edit-ski-jumper", method = RequestMethod.PUT)
    public RedirectView editSkiJumperSubmit(@ModelAttribute(value = "skiJumper") SkiJumperEditRequest editRequest) {
        SkiJumper skiJumper = repository.findById(editRequest.getId()).orElseThrow();
        skiJumper.setName(editRequest.getName());
        skiJumper.setSurname(editRequest.getSurname());
        skiJumper.setCountry(editRequest.getCountry());
        skiJumper.setAge(editRequest.getAge());
        skiJumper.setJumpRecord(editRequest.getJumpRecord());
        repository.save(skiJumper);
        return new RedirectView("/");
    }

    @RequestMapping(value = "/delete-ski-jumper/{id}", method = RequestMethod.GET)
    public RedirectView deleteSkiJumper(Model model, @PathVariable Long id) {
        repository.deleteById(id);
        return new RedirectView("/");
    }

    @RequestMapping(value = "/search-by-country", method = RequestMethod.GET)
    public String searchByCountry(Model model, @RequestParam(name = "country", required = false) Country country) {
        List<SkiJumperDTO> skiJumperDTOS = service.searchByCountry(country);
        model.addAttribute("skiJumpers", skiJumperDTOS);
        return "index";
    }
}