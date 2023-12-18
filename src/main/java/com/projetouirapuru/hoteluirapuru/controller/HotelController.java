package com.projetouirapuru.hoteluirapuru.controller;

import com.projetouirapuru.hoteluirapuru.model.pessoa.clientes.Hospede;
import com.projetouirapuru.hoteluirapuru.model.reserva.Acomodacao;
import com.projetouirapuru.hoteluirapuru.model.reserva.Reserva;
import com.projetouirapuru.hoteluirapuru.model.reserva.TipoQuarto;
import com.projetouirapuru.hoteluirapuru.service.HotelService;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/hotel")
public class HotelController {

    HotelService hotelService = new HotelService();




    /*
        Rotas destinadas para CRUD de acomodacoes
     */
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

    /*
       Rotas destinadas para CRUD de reservas
    */
//    @GetMapping("/reservas")
//    public ArrayList<Reserva> getReservas(){
//        return hotelService.getReservas();
//    }

    @GetMapping("/reservas/{email}")
    public ArrayList<Reserva> getReservasPessoa(@PathVariable String email){
        return hotelService.getReservas(email);
    }

    @GetMapping("/tiposquartos")
    public ArrayList<Acomodacao> getTiposQuartosDisponiveis(){
        return hotelService.getTipoQuartosDisponiveis();
    }


}
