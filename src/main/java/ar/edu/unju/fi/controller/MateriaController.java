package ar.edu.unju.fi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unju.fi.collections.ListadoMaterias;
import ar.edu.unju.fi.model.Materia;

@Controller
public class MateriaController {
    
    @Autowired
    Materia nuevaMateria = new Materia();

    @GetMapping("/formularioMateria")
    public ModelAndView getFormMateria() {
        ModelAndView modelView = new ModelAndView("formMateria");
        modelView.addObject("nuevaMateria", nuevaMateria);  
        return modelView;
    }

    @PostMapping("/guardarMateria")
    public ModelAndView saveMateria(@ModelAttribute("nuevaMateria") Materia materiaParaGuardar) {
        ListadoMaterias.agregarMateria(materiaParaGuardar);

        ModelAndView modelView = new ModelAndView("listaDeMaterias");
        modelView.addObject("listadoMaterias", ListadoMaterias.listarMaterias());  
        return modelView;      
    }

    @GetMapping("/borrarMateria/{codigo}")
    public ModelAndView deleteMateriaDelListado(@PathVariable(name="codigo") String codigo) {
        ListadoMaterias.eliminarMateria(codigo);

        ModelAndView modelView = new ModelAndView("listaDeMaterias");
        modelView.addObject("listadoMaterias", ListadoMaterias.listarMaterias());  
        return modelView;      
    }
}
