package com.projetouirapuru.hoteluirapuru.controller;

import com.projetouirapuru.hoteluirapuru.model.pessoa.clientes.Hospede;
import com.projetouirapuru.hoteluirapuru.model.pessoa.login.TipoLogin;
import com.projetouirapuru.hoteluirapuru.model.reserva.Acomodacao;
import com.projetouirapuru.hoteluirapuru.model.reserva.Reserva;
import com.projetouirapuru.hoteluirapuru.model.reserva.TipoQuarto;
import com.projetouirapuru.hoteluirapuru.service.HotelService;
import org.springframework.web.bind.annotation.*;


import java.util.ArrayList;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/hotel")
public class HotelController {

    HotelService hotelService = new HotelService();

    /*
        Rotas destinadas para CRUD de acomodacoes
     */

    /*


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

    /*


    @GetMapping("/reservas")
    public ArrayList<Reserva> getReservas(){
        return hotelService.getReservasAtivas();
    }
    @GetMapping("/reservas/{email}")
    public ArrayList<Reserva> getReservasPessoa(@PathVariable String email){
        return hotelService.getReservas(email);
    }

    @PostMapping("/reservas")
    public Reserva criarReserva(@RequestBody Reserva nova){
       return hotelService.criarReserva(nova);
    }

    @PostMapping("/reservas/checkin")
    public Reserva fazerCheckIn(@RequestBody ReservaCheckIn reserva) {
        if(hotelService.efetuarCheckIn(reserva)) {
            return reserva.getReserva();
        }
        return new Reserva();
    }

     */
    /*
        Rotas destinadas para o CRUD de tipos de quarto

    @GetMapping("/tiposquartos")
    public ArrayList<Acomodacao> getTiposQuartosDisponiveis(){
        return hotelService.getTipoQuartosDisponiveis();
    }

     */


    /*
        ROTAS HOSPEDES
    */
    @PostMapping("/hospedes")
    public boolean criaHospede(@RequestBody Hospede novo){
        return hotelService.criaHospede(novo);
    }
    @GetMapping("/hospedes")
    public ArrayList<Hospede> getHospedes(){
        return hotelService.getHospedes();
    }
    @GetMapping("/hospedes/{documento}")
    public Hospede getHospede(@PathVariable String documento){
        return hotelService.getHospedePorDocumento(documento);
    }
    @PutMapping("/hospedes/{documento}")
    public Hospede editaHospede(@PathVariable String documento,@RequestBody Hospede novo){
        return hotelService.editaHospede(documento,novo);
    }
    @DeleteMapping("/hospedes/{codigo}")
    public Hospede deletaHospede(@PathVariable String codigo){
        return hotelService.excluiHospede(codigo);
    }

    /*
        ROTAS ACOMODACOES
    */

    @PostMapping("/acomodacoes")
    public Boolean criaAcomodacao(@RequestBody Acomodacao novo){
        return hotelService.criaAcomodacao(novo);
    }
    @GetMapping("/acomodacoes")
    public ArrayList<Acomodacao> getAcomodacoes(){
        return hotelService.getAcomodacoes();
    }

    @GetMapping("/acomodacoes/{codigo}")
    public Acomodacao getAcomodacao(@PathVariable String codigo){
        return hotelService.getAcomodacao(codigo);
    }
    @PutMapping("/acomodacoes/{codigo}")
    public Acomodacao EditaAcomodacao(@PathVariable String codigo,@RequestBody Acomodacao novo){
        return hotelService.editaAcomodacao(codigo,novo);
    }

    @DeleteMapping("/acomodacoes/{codigo}")
    public Acomodacao excluiAcomodacao(@PathVariable String codigo){
        return hotelService.excluiAcomodacao(codigo);
    }

    /*
        ROTAS RESERVAS
    */

    @PostMapping("/reservas")
    public boolean criarReserva(@RequestBody Reserva nova){
        return  hotelService.criarReserva(nova);
    }
    @GetMapping("/reservas")
    public ArrayList<Reserva> getReservas(){
        return hotelService.getReservas();
    }
    @GetMapping("/reservas/ativas")
    public ArrayList<Reserva> getReservasAtivas(){
        return hotelService.getReservasAtivas();
    }

    @GetMapping("/reservas/{codigo}")
    public Reserva getReservaCodigo(@PathVariable String codigo){
        return  hotelService.getReserva(codigo);
    }
    @PutMapping("/reservas/{codigo}")
    public Reserva editaReserva(@PathVariable String codigo, @RequestBody Reserva nova){
        return hotelService.editaReserva(codigo,nova);
    }
    @DeleteMapping("/reservas/{codigo}")
    public Reserva excluiReserva(@PathVariable String codigo){
        return hotelService.excluiReserva(codigo);
    }

    /*
        PRINCIPAIS METEDOS
    */

    @GetMapping("/login/{email}/{senha}")
    public TipoLogin verficaLogin(@PathVariable String email, @PathVariable String senha){
        return hotelService.verificaLogin(email,senha);
    }











}
