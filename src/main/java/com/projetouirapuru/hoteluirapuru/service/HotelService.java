package com.projetouirapuru.hoteluirapuru.service;

import com.projetouirapuru.hoteluirapuru.model.pessoa.clientes.Acompanhante;
import com.projetouirapuru.hoteluirapuru.model.pessoa.clientes.Cliente;
import com.projetouirapuru.hoteluirapuru.model.pessoa.clientes.Hospede;
import com.projetouirapuru.hoteluirapuru.model.pessoa.documento.Documento;
import com.projetouirapuru.hoteluirapuru.model.pessoa.documento.InfosBasicas;
import com.projetouirapuru.hoteluirapuru.model.pessoa.documento.TipoDocumento;
import com.projetouirapuru.hoteluirapuru.model.pessoa.endereco.Endereco;
import com.projetouirapuru.hoteluirapuru.model.pessoa.funcionario.Funcionario;
import com.projetouirapuru.hoteluirapuru.model.pessoa.login.InfoLogin;
import com.projetouirapuru.hoteluirapuru.model.pessoa.login.TipoLogin;
import com.projetouirapuru.hoteluirapuru.model.reserva.Acomodacao;
import com.projetouirapuru.hoteluirapuru.model.reserva.Reserva;
import com.projetouirapuru.hoteluirapuru.model.reserva.ReservaCheckIn;
import com.projetouirapuru.hoteluirapuru.model.reserva.TipoQuarto;
import com.projetouirapuru.hoteluirapuru.model.reserva.pagamento.TipoPagamento;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
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

        Endereco endereco = new Endereco("CE","Fortaleza","123123","Rua das avenidas","123");

        InfosBasicas infos = new InfosBasicas(TipoDocumento.RG, "45678");
        Documento doc = new Documento(infos,"Eduardo", "Jucá", LocalDate.of(1999, Month.JANUARY, 1), "br");

        InfoLogin tes = new InfoLogin("@teste","123", TipoLogin.ADMINISTRADOR);
        InfoLogin tes2 = new InfoLogin("@lusca","123", TipoLogin.CLIENTE);


        Cliente ed = new Cliente("Ed",infos,tes);
        Cliente lusca = new Cliente("Lusca",infos,tes2);

        Reserva reserva = criarReserva("4321",ed, 1, TipoQuarto.LUXO,LocalDate.of(2011, Month.OCTOBER,20), LocalDate.of(2011,Month.OCTOBER,30));
        Reserva reserva2 = criarReserva("433331", lusca, 0, TipoQuarto.LUXO,LocalDate.of(2012, Month.OCTOBER,20), LocalDate.of(2012,Month.OCTOBER,30));
        efetuarReserva(reserva);
        efetuarReserva(reserva2);

        ReservaCheckIn reservaCheckIn = new ReservaCheckIn(reserva, endereco, "123123", LocalDateTime.of(LocalDate.of(2011,Month.OCTOBER,23),LocalTime.of(14,0,0)), doc);
        ReservaCheckIn reservaCheckIn2 = new ReservaCheckIn(reserva2, endereco, "123123", LocalDateTime.of(LocalDate.of(2012,Month.OCTOBER,23),LocalTime.of(14,0,0)), doc);

        efetuarCheckIn(reservaCheckIn);
        efetuarCheckIn(reservaCheckIn2);
    }
    public boolean removerAcomodacao(String codigo){
        return this.acomodacoes.removeIf(i -> i.getCodigo().equals(codigo));
    }
    public Acomodacao getAcomodacaoPorTipo(TipoQuarto tipoQuarto){
        for (Acomodacao acomodacao: acomodacoes) {
            if(acomodacao.getTipoQuarto() == tipoQuarto){
                return acomodacao;
            }
        }
        return null;
    }
    public Acomodacao getAcomodacao(String codigo){
        for (Acomodacao ac : acomodacoes){
            if (ac.getCodigo().equals(codigo)){
                return ac;
            }
        }
        return new Acomodacao();
    }
    public boolean addAcomodacao(Acomodacao quarto){
        return this.acomodacoes.add(quarto);
    }

    public ArrayList<Acomodacao> getAcomodacoesPorTipo(TipoQuarto tipo) {
        ArrayList<Acomodacao> acomodacoesPorTipo = new ArrayList<Acomodacao>();
        for (Acomodacao acomodacao : acomodacoes) {
            if (acomodacao.getTipoQuarto().equals(TipoQuarto.valueOf(String.valueOf(tipo)))) {
                acomodacoesPorTipo.add(acomodacao);
            }
        }
        return acomodacoesPorTipo;
    }
    public ArrayList<Acomodacao> getAcomodacoes(){
        return this.acomodacoes;
    }

    public Acomodacao editarAcomodacao(Acomodacao nova, String codigo){
        return acomodacoes.set(acomodacoes.indexOf(getAcomodacao(codigo)),nova);
    }

    //----------------------------------------------------------------------------------------

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

    //RESERVA

    public Reserva criarReserva(String codigo,Cliente hospedePrincipal, int qtdAcompanhantes, TipoQuarto tipoQuarto, LocalDate checkIn, LocalDate checkOut){
        return new Reserva(codigo,hospedePrincipal, qtdAcompanhantes, tipoQuarto, checkIn, checkOut);
    }

    public Reserva criarReserva(Reserva reservaNova) {
        	return new Reserva(reservaNova.getCodigo(), reservaNova.getHospedePrincipal(),
                    reservaNova.getQtdAcompanhantes(), reservaNova.getTipoQuarto(),
                    LocalDate.of(reservaNova.getCheckIn().getYear(), reservaNova.getCheckIn().getMonth(),
                            reservaNova.getCheckIn().getDayOfMonth()),
                    LocalDate.of(reservaNova.getCheckOut().getYear(), reservaNova.getCheckOut().getMonth(),
                            reservaNova.getCheckOut().getDayOfMonth()));
    }

    public boolean excluirReserva(String codigo){
        return removeReserva(getReserva(codigo));
    }

    private boolean removeReserva(Reserva excluir){
        return this.reversasAtivas.remove(excluir);
    }

    public ArrayList<Reserva> getReservas(String email){
        ArrayList<Reserva> reservasUsuario = new ArrayList<>();
        for (Reserva r : getReservas()){
            if (r.getHospedePrincipal().getInfoLogin().getEmail().equals(email)){
                reservasUsuario.add(r);
            }
        }
        return reservasUsuario;
    }
    public Reserva getReserva(String codigo){
        for (Reserva r : getReservas()){
            if (r.getAcompanhantes().equals(codigo)){
                return r;
            }
        }
        return new Reserva();
    }
    public ArrayList<Reserva> getReservasQuarto(String codigo){
        for (Acomodacao ac : getAcomodacoes()){
            if (ac.getCodigo().equals(codigo)){
                return ac.getReservas();
            }
        }
        return new ArrayList<Reserva>();
    }
    public ArrayList<Reserva> getReservas(){
        ArrayList<Reserva> reservasRetorno = new ArrayList<>();

        for (Acomodacao rs : acomodacoes){
            reservasRetorno.addAll(rs.getReservas());
        }

        return reservasRetorno;
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


    public Hospede criarHospedes(Cliente cliente,Endereco endereco, String telefone){
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

    private Boolean adicionarDocumento(Reserva reserva, Documento documento){
        Documento doc = new Documento(reserva.getHospedePrincipal().getInfosBasicas(), documento.getNomePai(), documento.getNomeMae(), documento.getDataNascimento(), documento.getNacionalidade());
        reserva.getHospedePrincipal().setInfosBasicas(doc);
        if(reserva.getHospedePrincipal().hasDocumento(reserva.getHospedePrincipal().getInfosBasicas())){
            return true;
        }
        return false;
    }


    public boolean efetuarCheckIn(ReservaCheckIn reserva){
        if(reserva.getReserva().getHospedePrincipal() instanceof Hospede == false){
            if(reserva.getChegada().isAfter(reserva.getReserva().getCheckIn()) && reserva.getChegada().isBefore(reserva.getReserva().getCheckOut())){
                reserva.getReserva().setHorarioChegada(reserva.getChegada());
                adicionarDocumento(reserva.getReserva(), reserva.getDocumento());
                Hospede hospede = new Hospede(reserva.getReserva().getHospedePrincipal(), reserva.getEndereco(), reserva.getTelefone());
                reserva.getReserva().setHospedePrincipal(hospede);
                return true;
            }
        }
        return false;
    }

    private Acompanhante criarAcompanhante(String nome, InfosBasicas infos){
        return new Acompanhante(nome, infos);
    }

    public void cadastrarAcompanhante(Reserva reserva, String nome, InfosBasicas infos){
        reserva.addAcompanhantes(criarAcompanhante(nome, infos));
    }

    public boolean efetuarCheckOut(Reserva reserva, TipoPagamento tipoPagamento, LocalDateTime saida){
        if(reserva.getReservaAtiva()){
            Cliente cliente = new Cliente(reserva.getHospedePrincipal().getNome(),reserva.getHospedePrincipal().getInfosBasicas(), reserva.getHospedePrincipal().getInfoLogin());
            reserva.setTipoPagamento(tipoPagamento);
            reserva.setHospedePrincipal(cliente);
            reserva.setHorarioSaida(saida);
            return true;
        }
        return false;
    }

    public void efetuarPagamento(Reserva reserva, String nome, String numero, int cvv, int mesValidade, int anoValidade){
        reserva.setPagamentoCartao(nome, numero, cvv, mesValidade, anoValidade);
    }

    public void efetuarPagamento(Reserva reserva, double valor){
        LocalDate dataValidade =  reserva.getCheckOut().toLocalDate();
        dataValidade.plusDays(30);
        reserva.setPagamentoBoleto(dataValidade, valor);
    }

    public void efetuarPagamento(Reserva reserva, String nomeBeneficiario){
        reserva.setPagamentoCheque(nomeBeneficiario);
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
