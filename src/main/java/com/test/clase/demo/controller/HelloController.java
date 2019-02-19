package com.test.clase.demo.controller;

import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;

/**
 * @RequestController  indica que esta clase sera un controlador de servicio Rest
 */

@RestController
public class HelloController {


    /**
     * Traza la ruta raiz "/" y envia saludo
     */
    @RequestMapping("/")
    public String index() {
        return "Saludos!!! desde Spring Boot!";
    }


    @RequestMapping(
            //Ruta
            value = "/alumnos",
            //Metodo de peticion
            method = RequestMethod.GET,
            //Que tipos de datos produce al responder
            produces = { "application/JSON"},
            //Que tipos de datos acepta(consume) en la peticion
            consumes = MediaType.ALL_VALUE)
    public String test(
            //Variable
            @RequestParam(value="name", defaultValue="Sin nombre") String name
    ) {
        return "{ \"saludo\": \"Saludos, "+name+" !!!\"}";
    }


    @RequestMapping(
            //Ruta
            value = "/alumnosA",
            //Metodo de peticion
            method = RequestMethod.POST,
            //Que tipos de datos produce al responder
            produces = { "image/png"},
            //Que tipos de datos acepta(consume) en la peticion
            consumes = MediaType.ALL_VALUE )
    public HttpEntity<byte[]> testA() {
        //Imagen PNG en base64
        String imagenBase64="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";
       //Conversion de Base64 a Bytes
        byte[] bytes = Base64.decodeBase64(imagenBase64);
        //Cabecera de HTTP para respuesta
        HttpHeaders headers = new HttpHeaders();
        //Tipo de contenido de respuesta
        headers.setContentType(MediaType.IMAGE_PNG);
        //Tamaño de respuesta
        headers.setContentLength(bytes.length);

        return new HttpEntity<byte[]>(bytes, headers);

    }


    /**
     *
     * @CommandLineRunner, sirve para crear una acción mientras al inicio de la aplicación
     *
     */

    @Bean
    public CommandLineRunner commandLineRunner(ApplicationContext ctx) {
        return args -> {

            System.out.println("Inspeccionar los beans que provee Spring Boot:");

            /**
             * Le pide al contexto (ctx) los bean definidos
             */
            String[] beanNames = ctx.getBeanDefinitionNames();
            Arrays.sort(beanNames);
            for (String beanName : beanNames) {
                System.err.println(beanName);
            }

        };
    }

}
