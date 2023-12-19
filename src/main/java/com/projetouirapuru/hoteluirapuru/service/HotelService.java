package com.projetouirapuru.hoteluirapuru.service;

import com.projetouirapuru.hoteluirapuru.model.pessoa.Pessoa;
import com.projetouirapuru.hoteluirapuru.model.pessoa.clientes.Acompanhante;
import com.projetouirapuru.hoteluirapuru.model.pessoa.clientes.Hospede;
import com.projetouirapuru.hoteluirapuru.model.pessoa.documento.Documento;
import com.projetouirapuru.hoteluirapuru.model.pessoa.documento.TipoDocumento;
import com.projetouirapuru.hoteluirapuru.model.pessoa.endereco.Endereco;
import com.projetouirapuru.hoteluirapuru.model.pessoa.funcionario.Funcionario;
import com.projetouirapuru.hoteluirapuru.model.pessoa.login.InfoLogin;
import com.projetouirapuru.hoteluirapuru.model.pessoa.login.TipoLogin;
import com.projetouirapuru.hoteluirapuru.model.reserva.Acomodacao;
import com.projetouirapuru.hoteluirapuru.model.reserva.Reserva;
import com.projetouirapuru.hoteluirapuru.model.reserva.TipoQuarto;
import org.slf4j.helpers.FormattingTuple;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.util.ArrayList;

public class HotelService {
    private ArrayList<Reserva> reservas;

    private ArrayList<Funcionario> funcionarios;

    private ArrayList<Acomodacao> acomodacoes;

    private ArrayList<Hospede> hospedes;


    public HotelService() {


        this.funcionarios = new ArrayList<>();
        this.acomodacoes = new ArrayList<>();
        this.hospedes = new ArrayList<>();
        this.reservas = new ArrayList<>();

        // DADOS MOCKADOS

        Acomodacao quarto1 = new Acomodacao("12","12","PURO LUXO", TipoQuarto.LUXO);
        Acomodacao quarto2 = new Acomodacao("11","11","PURO LUXO", TipoQuarto.LUXO);
        Acomodacao quarto3 = new Acomodacao("10","10","NORMAL E BOM DMS", TipoQuarto.NORMAL);
        Acomodacao quarto4 = new Acomodacao("9","9","SUITE BOM DMS", TipoQuarto.SUITE);

        acomodacoes.add(quarto1);
        acomodacoes.add(quarto2);
        acomodacoes.add(quarto3);
        acomodacoes.add(quarto4);


            /*
                    {
                "nome": "TESTE S",
                "documento": {
                    "nomePai": "TESTE",
                    "nomeMae": "TESTE",
                    "dataNascimento": "2005-10-23",
                    "nacionalidade": "Brasiliero",
                    "tipoDocumento": "RG",
                    "numeroDocumento": "DOCTESTE"
                },
                "endereco": {
                    "estado": "SP",
                    "cidade": "TESTE",
                    "rua": "TESTE",
                    "numero": "666",
                    "bairro": "JDROSEIRA"
                },
                "telefone": "9999999",
                "infoLogin": {
                    "email": "teste@TESTE",
                    "senha": "SENHA1234",
                    "tipoLogin": "HOSPEDE"
                }
            }
         */


        //LocalDate.of(2021,Month.OCTOBER,23), LocalDate.of(2021, Month.OCTOBER, 30)

        Documento docEduardo = new Documento("PAIEDUARDO","MAEEDUARDO",LocalDate.of(2005,Month.OCTOBER,23),"Brasiliero",TipoDocumento.RG,"RGEDUARDO");
        Endereco endEduardo = new Endereco("SP","IBITINGA","RIZZI","90","JDROSEIRA");
        InfoLogin infEduardo = new InfoLogin("eduardo@TESTE","SENHA1234",TipoLogin.HOSPEDE);
        Hospede eduardo = new Hospede("EDUARDO S",docEduardo,endEduardo,"9999999",infEduardo);
        criaHospede(eduardo);

        Documento docCaio = new Documento("PAICAIO","MAECAIO",LocalDate.of(2005,Month.MARCH,23),"Brasiliero",TipoDocumento.PASSAPORTE,"PASSAPORTECAIO");
        Endereco endCaio = new Endereco("SP","IBITINGA","ROSEIRA","900","JDROSEIRA");
        InfoLogin infCaio = new InfoLogin("caio@TESTE","SENHA1234",TipoLogin.HOSPEDE);
        Hospede caio = new Hospede("CAIO L",docCaio,endCaio,"9989999",infCaio);
        criaHospede(caio);

        Reserva rEduardo = new Reserva("1212",eduardo,new ArrayList<Acompanhante>(),TipoQuarto.LUXO,LocalDate.of(2023,Month.OCTOBER,24),LocalDate.of(2023,Month.OCTOBER,30));
        Reserva rCaio = new Reserva("1111",caio,new ArrayList<>(),TipoQuarto.LUXO,LocalDate.of(2023,Month.OCTOBER,24),LocalDate.of(2023,Month.OCTOBER,30));


        criarReserva(rEduardo);
        criarReserva(rCaio);





    }

    /*
        HOSPEDES
     */

        /*
            CRIAÇÃO DE NOVO HOSPEDE
        */

        public boolean criaHospede(Hospede novo){
            return this.hospedes.add(novo);
        }

        /*
            LEITURA DE HOSPEDES
        */

        public ArrayList<Hospede> getHospedes(){
            return hospedes;
        }

        public Hospede getHospedePorDocumento(String nDocumento){
            for (Hospede h : getHospedes()){
                if (h.getDocumento().getNumeroDocumento().equals(nDocumento)){
                    return h;
                }
            }
            return new Hospede();
        }

        /*
            EDIÇÃO DE HOSPEDES
        */

        public Hospede editaHospede(String nDocumento,Hospede novo){
            getHospedePorDocumento(nDocumento).setNome(novo.getNome());
            getHospedePorDocumento(nDocumento).setDocumento(novo.getDocumento());
            getHospedePorDocumento(nDocumento).setEndereco(novo.getEndereco());
            getHospedePorDocumento(nDocumento).setTelefone(novo.getTelefone());
            getHospedePorDocumento(nDocumento).setInfoLogin(novo.getInfoLogin());
            return  getHospedePorDocumento(nDocumento);
        }

        /*
            EXCLUSÃO DO HOSPEDE
        */

        public Hospede excluiHospede(String nDocumento){
            return getHospedes().remove(getHospedes().indexOf(getHospedePorDocumento(nDocumento)));
        }

    /*
        ACOMODAÇÕES
    */

        /*
            CRIAÇÃO DE NOVA ACOMODACOES
        */

        public boolean criaAcomodacao(Acomodacao novo){
            return this.acomodacoes.add(novo);
        }

        /*
            LEITURA DE ACOMODACOES
        */

        public ArrayList<Acomodacao> getAcomodacoes(){
            return this.acomodacoes;
        }

        public Acomodacao getAcomodacao(String codigo){
            for (Acomodacao ac : getAcomodacoes()){
                if (ac.getCodigo().equals(codigo)){
                    return ac;
                }
            }
            return new Acomodacao();
        }

         /*
            BUSCA POR TIPO DE QUARTO
        */

        public ArrayList<Acomodacao> getAcomodacoesTipo(TipoQuarto tipoQuarto){
            ArrayList<Acomodacao> retorno = new ArrayList<>();
            for (Acomodacao ac : getAcomodacoes()){
                if(ac.getTipoQuarto().equals(tipoQuarto)){
                    retorno.add(ac);
                }
            }
            return retorno;
        }

        /*
            EDIÇÃO DE ACOMODACAO
        */

        public Acomodacao editaAcomodacao(String codigo, Acomodacao nova){
            getAcomodacao(codigo).setAndar(nova.getAndar());
            getAcomodacao(codigo).setNumero(nova.getNumero());
            getAcomodacao(codigo).setDescricao(nova.getDescricao());
            getAcomodacao(codigo).setLimiteAdultos(nova.getLimiteAdultos());
            getAcomodacao(codigo).setLimiteCriancas(nova.getLimiteCriancas());
            getAcomodacao(codigo).setReservas(nova.getReservas());
            getAcomodacao(codigo).setPrecoDiaria(nova.getPrecoDiaria());
            getAcomodacao(codigo).setCodigo(nova.getCodigo());

            return getAcomodacao(nova.getCodigo());
        }

        /*
            EXCLUSÃO DO ACOMODACAO
        */

        public Acomodacao excluiAcomodacao(String codigo){
           return getAcomodacoes().remove(getAcomodacoes().indexOf(getAcomodacao(codigo)));
        }
         /*
        RESERVAS
     */
        /*
            CRIAÇÃO DE NOVA RESERVA
        */
            public boolean criarReserva(Reserva nova){
            if (verficaReservaH(nova)){
               nova.setPrecoDiaria(getAcomodacao(nova.getCodigoAcomodacao()).getPrecoDiaria());
               return this.reservas.add(nova);
            }
            return false;
        }

        /*
            LEITURA DE RESERVAS
        */

        public ArrayList<Reserva> getReservas(){
            return this.reservas;
        }
        public ArrayList<Reserva> getReservasAtivas(){
            ArrayList<Reserva> retorno  = new ArrayList<>();
            for (Reserva r : getReservas()){
                if (r.isAtiva()){
                    retorno.add(r);
                }
            }
            return retorno;
        }
        public ArrayList<Reserva> getReservas(String email){
            ArrayList<Reserva> retorno = new ArrayList<>();
            for (Reserva r : getReservas()){
                if (r.getHospedePrincipal().getInfoLogin().getEmail().equals(email)){
                    retorno.add(r);
                }
            }
            return retorno;
        }
        public Reserva getReserva(String email){
            for (Reserva r : getReservas()){
                if (r.getHospedePrincipal().getInfoLogin().getEmail().equals(email)){
                    return r;
                }
            }
            return new Reserva();
        }

        /*
            EDITA RESERVA
        */

        public Reserva editaReserva(String email,Reserva nova){
           getReserva(email).setAcompanhantes(nova.getAcompanhantes());
           getReserva(email).setCheckIn(nova.getCheckIn());
           getReserva(email).setCheckOut(nova.getCheckOut());
           getReserva(email).setTipoQuarto(nova.getTipoQuarto());
           getReserva(email).setAcompanhantes(nova.getAcompanhantes());
           getReserva(email).setHospedePrincipal(nova.getHospedePrincipal());
           getReserva(email).setDataChegada(nova.getDataChegada());
           getReserva(email).setDataSaida(nova.getDataSaida());
           getReserva(email).setCodigoAcomodacao(nova.getCodigoAcomodacao());
           return getReserva(email);
        }

        /*
           DELETA RESERVA
        */

        public Reserva excluiReserva(String email){
            return getReservas().remove(getReservas().indexOf(getReserva(email)));
        }

        /*
            VALIDACAO DA RESERVA
        */
        private Boolean verficaReservaH(Reserva nova){
            for (Acomodacao ac : getAcomodacoesTipo(nova.getTipoQuarto())){
                if (ac.verificaReserva(nova)){
                    return true;
                }
            }
            return false;
        }

    /*
       FUNCIONARIOS
    */

        /*
           CRIA FUNCIONARIO
        */

        public Boolean criaFuncionario(Funcionario novo){
           return this.funcionarios.add(novo);
        }

        /*
            LEITURA DE RESERVAS
        */

        public ArrayList<Funcionario> getFuncionarios(){
            return this.funcionarios;
        }
        public Funcionario getFuncionario(String nDocumento){
            for (Funcionario f: getFuncionarios()){
                if (f.getDocumento().getNumeroDocumento().equals(nDocumento)){
                    return f;
                }
            }
            return new Funcionario();
        }

        /*
           EDITA FUNCIONARIO
        */

        public Funcionario editaFuncionario(String nDocumento,Funcionario f){
            getFuncionario(nDocumento).setReservaResponsavel(f.getReservaResponsavel());
            getFuncionario(nDocumento).setNome(f.getNome());
            getFuncionario(nDocumento).setInfoLogin(f.getInfoLogin());
            getFuncionario(nDocumento).setDocumento(f.getDocumento());
            return getFuncionario(f.getDocumento().getNumeroDocumento());
        }

        /*
            DELETA FUNCIONARIO
        */
        public boolean excluiFuncionario(String nDocumento){
            return getFuncionarios().remove(getFuncionario(nDocumento));
        }
    /*
        PRINCIPAIS METODOS
    */
        public ArrayList<Acomodacao> getAcomodacoesPorTipo(TipoQuarto tipo) {
            ArrayList<Acomodacao> acomodacoesPorTipo = new ArrayList<Acomodacao>();
            for (Acomodacao acomodacao : acomodacoes) {
                if (acomodacao.getTipoQuarto() == tipo) {
                    acomodacoesPorTipo.add(acomodacao);
                }
            }
            return acomodacoesPorTipo;
        }
        public Acomodacao getAcomodacaoPorTipo(TipoQuarto tipoQuarto){
            for (Acomodacao acomodacao: acomodacoes) {
                if(acomodacao.getTipoQuarto() == tipoQuarto){
                    return acomodacao;
                }
            }
            return null;
        }

        /*
            VALIDAÇÃO DE LOGIN
        */

        public Pessoa verificaLogin(String email, String senha){
            Hospede h = new Hospede();
            for(Reserva r : getReservas()){
                if(r.getHospedePrincipal().getInfoLogin().getEmail().equals(email)){
                    if(r.getHospedePrincipal().getInfoLogin().getSenha().equals(senha)){
                        return r.getHospedePrincipal();
                    }
                }
            }
            for (Funcionario f : getFuncionarios()){
                if(f.getInfoLogin().getEmail().equals(email)){
                    if(f.getInfoLogin().getSenha().equals(senha)){
                        return f;
                    }
                }
            }

            return new Pessoa() {};
        }

        public boolean checkIn(Reserva reserva,LocalDateTime chegada){
            reserva.setDataChegada(chegada);
            return true;
        }

        public double checkOut(Reserva reserva, LocalDateTime saida){
            reserva.setDataSaida(saida);
            return reserva.getPrecoEstadia();
        }


}
