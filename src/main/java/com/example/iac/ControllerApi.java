package com.example.iac;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.text.SimpleDateFormat;
import java.util.Date;

@RequestMapping("iac/spring/boot")
@RestController
public class ControllerApi {

    @GetMapping(path = "welcome/{name}")
    public String getName(@Valid @NotNull @PathVariable("name") String nameInput){
        return "Welkom " + nameInput;
    }

    @GetMapping(path = "current-date")
    public String getDateTime() {
        SimpleDateFormat dateFormatter= new SimpleDateFormat("yyyy-MM-dd 'at' HH:mm:ss z");
        Date date = new Date(System.currentTimeMillis());
        String dateFormatted = dateFormatter.format(date);
        System.out.println("datum format: "+ dateFormatted);
        return dateFormatted;
    }
}