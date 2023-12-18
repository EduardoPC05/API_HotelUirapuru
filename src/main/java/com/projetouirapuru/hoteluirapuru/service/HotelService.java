package com.projetouirapuru.hoteluirapuru.service;

import com.projetouirapuru.hoteluirapuru.model.pessoa.clientes.Acompanhante;
import com.projetouirapuru.hoteluirapuru.model.pessoa.clientes.Cliente;
import com.projetouirapuru.hoteluirapuru.model.pessoa.clientes.Hospede;
import com.projetouirapuru.hoteluirapuru.model.pessoa.endereco.Endereco;
import com.projetouirapuru.hoteluirapuru.model.pessoa.funcionario.Funcionario;
import com.projetouirapuru.hoteluirapuru.model.pessoa.login.TipoLogin;
import com.projetouirapuru.hoteluirapuru.model.reserva.Acomodacao;
import com.projetouirapuru.hoteluirapuru.model.reserva.Reserva;
import com.projetouirapuru.hoteluirapuru.model.reserva.TipoQuarto;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class HotelService {
    private ArrayList<Reserva> reversasAtivas;

    private ArrayList<Funcionario> funcionarios;

    private ArrayList<Acomodacao> acomodacoes;


    public HotelService() {
        // DADOS MOCKADOS

        Acomodacao teste = new Acomodacao("12","12","ELE È BOM DMS", TipoQuarto.LUXO);
        Acomodacao teste1 = new Acomodacao("12","33","ELE È BOM DMS", TipoQuarto.LUXO);
        Acomodacao teste2 = new Acomodacao("12","44","ELE È BOM DMS", TipoQuarto.NORMAL);
        Acomodacao teste3 = new Acomodacao("12","44","ELE È BOM DMS", TipoQuarto.SUITE);

        this.acomodacoes = new ArrayList<Acomodacao>();
        acomodacoes.add(teste);
        acomodacoes.add(teste1);
        acomodacoes.add(teste2);
        acomodacoes.add(teste3);

    }

    public ArrayList<Reserva> getReversasAtivas() {
        return reversasAtivas;
    }

    public ArrayList<Funcionario> getFuncionarios() {
        return funcionarios;
    }


    public boolean removerAcomodacao(Acomodacao quarto){
        //TODO
        //Fazer verificações referentes a debitos;
        return removeAcomodacao(quarto);
    }
    public boolean removerAcomodacao(String codigo){
        return this.acomodacoes.removeIf(i -> i.getCodigo().equals(codigo));
    }

    public ArrayList<Acomodacao> getAcomodacoes(){
        return this.acomodacoes;
    }
    public Acomodacao getAcomodacao(String codigo){
        for (Acomodacao i : getAcomodacoes()){
            if (i.getCodigo().equals(codigo)){
                return i;
            }
        }
        return new Acomodacao();
    }
    public Acomodacao getAcomodacaoPorTipo(TipoQuarto tipoQuarto){
        for (Acomodacao acomodacao: acomodacoes) {
            if(acomodacao.getTipoQuarto() == tipoQuarto){
                return acomodacao;
            }
        }
        return null;
    }
    public boolean addAcomodacao(Acomodacao quarto){
        return this.acomodacoes.add(quarto);
    }
    private boolean removeAcomodacao(Acomodacao quarto){
        return this.acomodacoes.remove(quarto);
    }

    private Acomodacao editaAcomodacao(Acomodacao novo, int index){
        return this.acomodacoes.set(index,novo);
    }
    public Acomodacao editarAcomodacao(Acomodacao novo,String codigo){
        return editaAcomodacao(novo, this.acomodacoes.indexOf(getAcomodacao(codigo)));
    }
    public ArrayList<Acomodacao> getAcomodacoesPorTipo(TipoQuarto tipo) {
        ArrayList<Acomodacao> acomodacoesPorTipo = new ArrayList<Acomodacao>();
        for (Acomodacao acomodacao : acomodacoes) {
            if (acomodacao.getTipoQuarto() == tipo) {
                acomodacoesPorTipo.add(acomodacao);
            }
        }
        return acomodacoesPorTipo;
    }

    public Reserva criarReserva(Cliente hospedePrincipal, ArrayList<Acompanhante> acompanhantes, TipoQuarto tipoQuarto, LocalDate checkIn, LocalDate checkOut){
        return new Reserva(hospedePrincipal, acompanhantes, tipoQuarto, checkIn, checkOut);
    }

    public boolean efetuarReserva(Reserva nova){
        ArrayList<Acomodacao> acomodacoes = getAcomodacoesPorTipo(nova.getTipoQuarto());

        for(Acomodacao acomodacao: acomodacoes) {
            if(acomodacao.verificaReserva(nova)){
                acomodacao.addReserva(nova);
                return true;
            }
        }

        return false;
    }

    public boolean excluirReserva(String email){
        return removeReserva(getReservas(email).getLast());
    }

    private boolean removeReserva(Reserva excluir){
        return this.reversasAtivas.remove(excluir);
    }

    public ArrayList<Reserva> getReservas(String email){
        ArrayList<Reserva> reservasUsuario = new ArrayList<>();
        for (Acomodacao rs: acomodacoes){
            for (Reserva r: rs.getReservas()){
                if (r.getHospedePrincipal().getInfoLogin().getEmail().equals(email)){
                    reservasUsuario.add(r);
                }
            }
        }
        return reservasUsuario;
    }
    public Hospede criarHospedes(Cliente cliente, Endereco endereco, String telefone){
        return new Hospede(cliente,endereco,telefone);
    }

    public Endereco criarEndereco( String estado,String cidade,String rua,String numero,String bairro){
        return new Endereco(estado,cidade,rua,numero,bairro);
    };

    public ArrayList<Acomodacao> getTipoQuartosDisponiveis(){
        ArrayList<Acomodacao> retorno = new ArrayList<>();

        for (TipoQuarto c: TipoQuarto.values()){
            if (getAcomodacaoPorTipo(c) != null){
                retorno.add(getAcomodacaoPorTipo(c));
            }
        }

        return  retorno;
    }

    public boolean efetuarCheckIn(Reserva reserva, Endereco endereco, String telefone, LocalDateTime chegada){
        if(reserva.getHospedePrincipal() instanceof Hospede == false){
            if(chegada.isAfter(reserva.getCheckIn()) && chegada.isBefore(reserva.getCheckOut())){
                Hospede hospede = new Hospede(reserva.getHospedePrincipal(), endereco, telefone);
                reserva.setHospedePrincipal(hospede);
                return true;
            }
        }
        return false;
    }

    public boolean efetuarCheckOut(Reserva reserva){
        if(reserva.getReservaAtiva()){
            Cliente cliente = new Cliente(reserva.getHospedePrincipal().getNome(),reserva.getHospedePrincipal().getDocumento(), reserva.getHospedePrincipal().getInfoLogin());
            reserva.setHospedePrincipal(cliente);
            return true;
        }
        return false;
    }

    public ArrayList<Reserva> getReservasAtivas(){
        ArrayList<Reserva> retorno = new ArrayList<>();
        for(Acomodacao a : acomodacoes){
            for(Reserva r : a.getReservas()){
                if(r.getReservaAtiva()){
                    retorno.add(r);
                }
            }
        }
        return retorno;
    }

    public TipoLogin verificaLogin(String email, String senha){
        for(Acomodacao a : acomodacoes){
            for(Reserva r : a.getReservas()){
                if(r.getHospedePrincipal().getInfoLogin().getEmail().equals(email)){
                    if(r.getHospedePrincipal().getInfoLogin().getSenha().equals(senha)){
                        return r.getHospedePrincipal().getInfoLogin().getTipoLogin();
                    }
                }
            }
        }
        for(Funcionario f : funcionarios){
            if(f.getInfoLogin().getEmail().equals(email)){
                if(f.getInfoLogin().getSenha().equals(senha)){
                    return f.getInfoLogin().getTipoLogin();
                }
            }
        }
        return null;
    }

}
