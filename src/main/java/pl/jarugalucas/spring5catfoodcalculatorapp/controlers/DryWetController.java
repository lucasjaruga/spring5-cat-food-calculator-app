package pl.jarugalucas.spring5catfoodcalculatorapp.controlers;

import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.jarugalucas.spring5catfoodcalculatorapp.model.DryWetCat;
import pl.jarugalucas.spring5catfoodcalculatorapp.services.CatFoodAlgorithmService;

import javax.validation.Valid;

@Controller
@RequestMapping("/1")
public class DryWetController {

    CatFoodAlgorithmService catFoodAlgorithmService;

    public DryWetController(CatFoodAlgorithmService catFoodAlgorithmService) {
        this.catFoodAlgorithmService = catFoodAlgorithmService;
    }

    @RequestMapping({"/drywet"})
    public String getDryWet(Model model){

        model.addAttribute("dryWetCat", new DryWetCat());
        return "/html/dryWet";
    }

    @InitBinder
    public void initBinder(WebDataBinder dataBinder) {

        StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
        dataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
    }

    @PostMapping("/postCatData")
    public String postCatData(@Valid @ModelAttribute("dryWetCat") DryWetCat cat, BindingResult bindingResult){

        if(bindingResult.hasErrors()){
            return "/html/dryWet";
        } else {
            cat.setResult(catFoodAlgorithmService.getDryWetResult(cat));
            return "html/result";
        }
    }

    @RequestMapping("index.html/getIndex")
    public String getIndex() {
        return "redirect:/";
    }
}