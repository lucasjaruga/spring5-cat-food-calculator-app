package pl.jarugalucas.spring5catfoodcalculatorapp.controlers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MixController {

    @RequestMapping({"/mix"})
    public String mix(){


        return "/html/mix";
    }

    @PostMapping("/returnToIndexFromMix")
    public String getIndex2() {
        return "redirect:/";
    }
}