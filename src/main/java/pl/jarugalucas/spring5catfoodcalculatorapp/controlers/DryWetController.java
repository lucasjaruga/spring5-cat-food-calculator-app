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

    @PostMapping("/postCatData")
    public String postCatData(@ModelAttribute("cat") Cat cat){

        // log purpose, will be remove later
        System.out.println(cat.toString());

        String result;
        if(cat.getTypeOfFood().equals("dry")){
            result = algorithmService.calculateDryFood(cat.getWeight()).toString();
        } else {
            result = algorithmService.calculateWetFood(cat.getWeight()).toString();
        }
        cat.setResult(result);

        return "html/result";
    }

    @RequestMapping("index.html/getIndex")
    public String getIndex() {
        return "redirect:/";
    }
}