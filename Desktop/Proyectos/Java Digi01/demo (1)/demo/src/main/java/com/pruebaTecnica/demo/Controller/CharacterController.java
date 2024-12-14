/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pruebaTecnica.demo.Controller;


import com.pruebaTecnica.demo.ML.Personaje;
import java.util.List;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

/**
 *
 * @author andre_ydlyfc2
 */
@Controller
@RequestMapping("/HarryApi")
public class CharacterController {
    
    @GetMapping("/Index")
    public String GetAll(Model model){
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<List<Personaje>> response = restTemplate.exchange("https://hp-api.onrender.com/api/characters",
                HttpMethod.GET,
                null, 
                new ParameterizedTypeReference<List<Personaje>>() {
                });
        List<Personaje> personajes = response.getBody();
        model.addAttribute("personajes", personajes);
        return "Personajes";
    }
}
