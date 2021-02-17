package pl.jarugalucas.spring5catfoodcalculatorapp.controlers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.jarugalucas.spring5catfoodcalculatorapp.services.AlgorithmService;
import pl.jarugalucas.spring5catfoodcalculatorapp.model.Cat;

@Controller
@RequestMapping("/1")
public class DryWetController {

    AlgorithmService algorithmService;

    public DryWetController(AlgorithmService algorithmService) {
        this.algorithmService = algorithmService;
    }

    @RequestMapping({"/drywet"})
    public String getDryWet(Model model){

        model.addAttribute("cat", new Cat());
        return "/html/dryWet";
    }

    @RequestMapping({"/mix"})
    public String getMix(Model model){

        model.addAttribute("cat", new Cat());
        return "/html/mix";
    }

    @PostMapping("/postCatData")
    public String postCatData(@ModelAttribute("cat") Cat cat){

        cat.setResult(algorithmService.getDryWetResult(cat));

        return "html/result";
    }

    @RequestMapping("index.html/getIndex")
    public String getIndex() {
        return "redirect:/";
    }
}