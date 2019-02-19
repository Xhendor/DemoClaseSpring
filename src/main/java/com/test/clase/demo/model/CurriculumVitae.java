package com.test.clase.demo.model;


import lombok.Data;

import java.util.ArrayList;

@Data
public class CurriculumVitae {

    private String titulo;
    private String nombre;
    private String apellidoMaterno;
    private String apellidoPaterno;

    private ArrayList<Estudios> estudios;

    private ArrayList<Experiencia> experiencia;



    ///private String otros datos....


}
