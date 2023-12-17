package com.projetouirapuru.hoteluirapuru.controller;

import com.projetouirapuru.hoteluirapuru.model.pessoa.clientes.Hospede;
import com.projetouirapuru.hoteluirapuru.model.reserva.Acomodacao;
import com.projetouirapuru.hoteluirapuru.service.HotelService;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/hotel")
public class HotelController {

    HotelService hotelService = new HotelService();

    @GetMapping(path = "/acomodacoes")
    public ArrayList<Acomodacao> getAcomodacoes() {
        return hotelService.getAcomodacoes();
    }

//    @GetMapping(path = "/acomodacoes")
//    public String getAcomodacoes() {
//        return "Hospedes, vários hospedes, muitos hospedes";
//    }

}
