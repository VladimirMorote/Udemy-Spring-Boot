package dev.com.vlady.web;


import dev.com.vlady.domain.Persona;
import dev.com.vlady.servicio.PersonaService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;


@Controller
@Slf4j
public class ControladorInicio {

    @Autowired
    private PersonaService personaService;
    
    @GetMapping("/")
    public String inicio(Model model){

        var personas = personaService.listarPersonas();
        model.addAttribute("personas",personas);
        return "index";
    }
    @GetMapping("/agregar")
    public String agregar(Persona persona){
        return "modificar";
    }

    @PostMapping("/guardar")
    public String guardar(@Valid Persona persona, Errors errores){
        if(errores.hasErrors()){
            return "modificar";
        }
        personaService.guardar(persona);
        return "redirect:/";
    }

    @GetMapping("/editar/{idPersona}")
    public String editar(Persona persona, Model model){
        persona = personaService.encontrarPersona(persona);
        model.addAttribute("persona", persona);
        return "modificar";
    }
    @GetMapping("/eliminar/{idPersona}")
    public String eliminar(Persona persona){
        personaService.eliminar(persona);
        return "redirect:/";
    }
}
