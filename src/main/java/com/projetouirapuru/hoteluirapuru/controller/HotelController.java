package com.projetouirapuru.hoteluirapuru.controller;

import com.projetouirapuru.hoteluirapuru.model.pessoa.clientes.Hospede;
import com.projetouirapuru.hoteluirapuru.model.reserva.Acomodacao;
import com.projetouirapuru.hoteluirapuru.model.reserva.TipoQuarto;
import com.projetouirapuru.hoteluirapuru.service.HotelService;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/hotel")
public class HotelController {

    HotelService hotelService = new HotelService();

    @GetMapping("/acomodacoes")
    public ArrayList<Acomodacao> getAcomodacoes() {
        return hotelService.getAcomodacoes();
    }
    @GetMapping("/acomodacoes/{codigo}")
    public Acomodacao getAcomodacao(@PathVariable String codigo) {
        return hotelService.getAcomodacao(codigo);
    }
    @GetMapping("/acomodacoestipo/{tipo}")
    public ArrayList<Acomodacao> getAcomodacoesTipo(@PathVariable String tipo){
        return hotelService.getAcomodacoesPorTipo(TipoQuarto.valueOf(tipo));
    }
    @PostMapping("/acomodacoes")
    public Acomodacao newAcomodacoes(@RequestBody Acomodacao acomodacao){

        if (hotelService.addAcomodacao(acomodacao)){
           return acomodacao;
        }
        return new Acomodacao();
    }
    @PutMapping("/acomodacoes/{codigo}")
    public Acomodacao EditaAcomodacoes(@RequestBody Acomodacao novo, @PathVariable String codigo){
        return hotelService.editarAcomodacao(novo,codigo);
    }
    @DeleteMapping("/acomodacoes/{codigo}")
    public boolean DelAcomodacoes(@PathVariable String codigo){
        return hotelService.removerAcomodacao(codigo);
    }




}
