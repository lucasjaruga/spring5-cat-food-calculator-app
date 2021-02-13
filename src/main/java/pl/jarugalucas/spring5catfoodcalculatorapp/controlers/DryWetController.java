package pl.jarugalucas.spring5catfoodcalculatorapp.controlers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.jarugalucas.spring5catfoodcalculatorapp.model.Cat;

@Controller
public class DryWetController {

    @RequestMapping({"/drywet"})
    public String dryWet(Model model){

        model.addAttribute("cat", new Cat());
        return "/html/dryWet";
    }

    @RequestMapping("/returnToIndexFromDryWet")
    public String getIndexFromDryWet() {
        return "redirect:/";
    }

    @PostMapping("/postCatData")
    public void postCatData(@ModelAttribute("cat") Cat cat){
        System.out.println(cat.toString());
    }
}