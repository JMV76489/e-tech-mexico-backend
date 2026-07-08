package org.generation.e_tech_mexico;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "hola")
public class HolaMundoController {
    @GetMapping
    public String holaMundo(){
        return "Hola Mundo Desde E-TECH Mexico";
    }
}
