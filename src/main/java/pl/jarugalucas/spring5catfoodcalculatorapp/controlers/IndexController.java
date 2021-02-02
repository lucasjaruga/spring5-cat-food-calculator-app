package pl.jarugalucas.spring5catfoodcalculatorapp.controlers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {

    @RequestMapping({"", "/", "index", "index.html"})
    public String index(){
        return "/html/index";
    }

    @PostMapping("/drywet")
    public String getDryWetFood() {
        return "redirect:/drywet";
    }

    @PostMapping("/mix")
    public String getMixFood() {
        return "redirect:/mix";
    }
}