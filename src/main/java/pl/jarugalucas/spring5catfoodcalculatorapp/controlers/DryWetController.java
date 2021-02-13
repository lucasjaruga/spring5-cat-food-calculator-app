package pl.jarugalucas.spring5catfoodcalculatorapp.controlers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import pl.jarugalucas.spring5catfoodcalculatorapp.model.Cat;
import pl.jarugalucas.spring5catfoodcalculatorapp.services.CatService;

import javax.validation.Valid;

@Controller
public class DryWetController implements WebMvcConfigurer {

    private final CatService catService;

    public DryWetController(CatService catServiceImpl) {
        this.catService = catServiceImpl;
    }

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/results").setViewName("results");
    }

    @RequestMapping({"/drywet"})
    public String dryWet(Model model){

        model.addAttribute("cat", new Cat());
        return "/html/dryWet";
    }

    @PostMapping("/returnToIndexFromDryWet")
    public String getIndexFromDryWet() {
        return "redirect:/";
    }

    @PostMapping("/postCatData")
    public Cat postCatData(@Valid Cat cat, BindingResult errors){



        return cat;
    }
}