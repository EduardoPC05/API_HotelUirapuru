package com.projetouirapuru.hoteluirapuru.controller;

import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/hotel")
public class HotelController {


    @GetMapping(path = "/hospedes")
    public String getHospedes() {
        return "Hospedes, vários hospedes, muitos hospedes";
    }

    @GetMapping(path = "/acomodacoes")
    public String getAcomodacoes() {
        return "Acomodações, várias acomodações, muitas acomodações";
    }

    @GetMapping(value = "/{id}")
    public String getHospede(@PathVariable Long id) {
        return "Hospede" + id;
    }

}
