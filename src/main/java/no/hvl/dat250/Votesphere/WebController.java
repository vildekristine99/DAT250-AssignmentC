package no.hvl.dat250.Votesphere;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WebController {

    @GetMapping(value = "/frontend")
    public String home() {
        return "index";
    }
}
*/
