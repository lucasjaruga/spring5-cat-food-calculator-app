package pl.jarugalucas.spring5catfoodcalculatorapp.controlers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.jarugalucas.spring5catfoodcalculatorapp.model.Cat;

@Controller
public class MixController {

    @RequestMapping({"/mix"})
    public String mix(Model model){

        model.addAttribute("cat", new Cat());
        return "/html/mix";
    }

    @RequestMapping("/returnToIndexFromMix")
    public String getIndexFromMix() {
        return "redirect:/";
    }
}