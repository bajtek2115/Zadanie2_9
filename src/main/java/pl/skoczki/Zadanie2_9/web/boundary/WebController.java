package pl.skoczki.Zadanie2_9.web.boundary;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.skoczki.Zadanie2_9.service.boundary.SkiJumperService;

@Controller
public class WebController {

    @Autowired
    private SkiJumperService service;

    @RequestMapping(value = "/")
    public String index(Model model) {
        model.addAttribute("skiJumpers", service.getAll());
        return "index";
    }

}