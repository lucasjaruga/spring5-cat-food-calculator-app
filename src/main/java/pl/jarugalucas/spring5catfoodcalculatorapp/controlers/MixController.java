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
import pl.jarugalucas.spring5catfoodcalculatorapp.model.MixCat;
import pl.jarugalucas.spring5catfoodcalculatorapp.services.CatFoodAlgorithmService;

import javax.validation.Valid;

@Controller
@RequestMapping("/2")
public class MixController {

    CatFoodAlgorithmService catFoodAlgorithmService;

    public MixController(CatFoodAlgorithmService algorithmService) {
        this.catFoodAlgorithmService = algorithmService;
    }

    @RequestMapping({"/mix"})
    public String getMix(Model model){

        model.addAttribute("mixCat", new MixCat());
        return "/html/mix";
    }

    @InitBinder
    public void initBinder(WebDataBinder dataBinder) {

        StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
        dataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
    }

    @PostMapping("/postCatData")
    public String postCatData(@Valid @ModelAttribute("mixCat") MixCat cat, BindingResult bindingResult){

        if(bindingResult.hasErrors() || catFoodAlgorithmService.checkIfNotTooMuchWet(cat)){
            return "/html/mix";
        } else {
            cat.setResult(catFoodAlgorithmService.getMixResult(cat));
            return "html/result";
        }
    }

    @RequestMapping("index.html/getIndex")
    public String getIndex() {
        return "redirect:/";
    }
}