package fr.iutparis8.CSID.backSIVoc.Controleur;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class HomeControlleur {
	
	@GetMapping
    public String getHome() {
        return "Welcome";
    }

}
