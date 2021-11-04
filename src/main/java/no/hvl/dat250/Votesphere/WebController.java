package no.hvl.dat250.Votesphere;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class WebController {

    @RequestMapping("/")
    public String getPage() {
        return "/index.html";
    }
}