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
    }//Lista todas as acomodacoes
    @GetMapping("/acomodacoes/{codigo}")
    public Acomodacao getAcomodacao(@PathVariable String codigo) {
        return hotelService.getAcomodacao(codigo);
    }//Faz uma busca em acomodacoes baseado no codigo
    @GetMapping("/acomodacoes/tipo/{tipo}")
    public ArrayList<Acomodacao> getAcomodacoesTipo(@PathVariable String tipo){
        return hotelService.getAcomodacoesPorTipo(TipoQuarto.valueOf(tipo));
    }//Retorna uma lista de acomodacoes somente do tipo selecionado
    @PostMapping("/acomodacoes")
    public Acomodacao newAcomodacoes(@RequestBody Acomodacao acomodacao){
        if (hotelService.addAcomodacao(acomodacao)){
           return acomodacao;
        }
        return new Acomodacao();
    }//Cria uma nova acomodacao
    @PutMapping("/acomodacoes/{codigo}")
    public Acomodacao EditaAcomodacoes(@RequestBody Acomodacao novo, @PathVariable String codigo){
        return hotelService.editarAcomodacao(novo,codigo);
    }//Edita uma acomodacao selecionada pelo codigo
    @DeleteMapping("/acomodacoes/{codigo}")
    public boolean DelAcomodacoes(@PathVariable String codigo){
        return hotelService.removerAcomodacao(codigo);
    }//Deleta uma acomodacao pelo codigo selecionado

    /*
       Rotas destinadas para CRUD de reservas
    */
    @GetMapping("/reservas")
    public ArrayList<Reserva> getReservas(){
        return hotelService.getReservasAtivas();
    }
    @GetMapping("/reservas/{email}")
    public ArrayList<Reserva> getReservasPessoa(@PathVariable String email){
        return hotelService.getReservas(email);
    }

    @PostMapping("/reservas/nova")
    public Reserva criarReserva(@RequestBody Reserva nova){
       return criarReserva(nova);
    }


    /*
        Rotas destinadas para o CRUD de tipos de quarto
     */
    @GetMapping("/tiposquartos")
    public ArrayList<Acomodacao> getTiposQuartosDisponiveis(){
        return hotelService.getTipoQuartosDisponiveis();
    }


}
