package com.test.clase.demo.controller;


import com.test.clase.demo.model.CurriculumVitae;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/cv")
public class CVController {


 @GetMapping(value="/datos")
 public String obtenerDatos(Model model){

     //Objeto de curriculum
     CurriculumVitae vitae=new CurriculumVitae();
     vitae.setApellidoMaterno("Xacinto");
     vitae.setApellidoPaterno("Tlaloc");
     vitae.setNombre("Anunaki");
     vitae.setTitulo("Lic.");

     //Se agrega para enviar a la vista
     model.addAttribute("cv",vitae);

     return "cv";
 }


}
