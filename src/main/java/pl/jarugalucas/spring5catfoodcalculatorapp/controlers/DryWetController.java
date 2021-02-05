package pl.jarugalucas.spring5catfoodcalculatorapp.controlers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class DryWetController {

    @RequestMapping({"/drywet"})
    public String dryWet(){
        return "/html/dryWet";
    }

    @PostMapping("/returnToIndexFromDryWet")
    public String getIndex2() {
        return "redirect:/";
    }
}