package com.sptech.projeto2;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cidades")
public class CidadesController {

    @GetMapping
    public String lista(){
        return "As top 5 cidades são A, B e C";
    }

}
