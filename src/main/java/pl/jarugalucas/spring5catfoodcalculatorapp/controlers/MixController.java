package pl.jarugalucas.spring5catfoodcalculatorapp.controlers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.jarugalucas.spring5catfoodcalculatorapp.model.Cat;

@Controller
@RequestMapping("/2")
public class MixController {

    @RequestMapping({"/mix"})
    public String getMix(Model model){

        model.addAttribute("cat", new Cat());
        return "/html/mix";
    }

    @PostMapping("/postCatData")
    public void postCatData(@ModelAttribute("cat") Cat cat){

        // log purpose
        System.out.println(cat.toString());
    }

    @RequestMapping("index.html/getIndex")
    public String getIndex() {
        return "redirect:/";
    }
}