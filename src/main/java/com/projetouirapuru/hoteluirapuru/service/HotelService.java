package com.projetouirapuru.hoteluirapuru.service;

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
import com.projetouirapuru.hoteluirapuru.model.reserva.ReservaCheckIn;
import com.projetouirapuru.hoteluirapuru.model.reserva.TipoQuarto;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.util.ArrayList;

public class HotelService {
    private ArrayList<Reserva> reversasAtivas;

    private ArrayList<Funcionario> funcionarios;

    private ArrayList<Acomodacao> acomodacoes;

    private ArrayList<Hospede> hospedes;


    public HotelService() {


        this.funcionarios = new ArrayList<>();
        this.acomodacoes = new ArrayList<>();
        this.hospedes = new ArrayList<>();
        this.reversasAtivas = new ArrayList<>();

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
        InfoLogin infCaio = new InfoLogin("caio@TESTE","SENHA1234/",TipoLogin.HOSPEDE);
        Hospede caio = new Hospede("CAIO L",docCaio,endCaio,"9989999",infCaio);
        criaHospede(caio);

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
            CRIAÇÃO DE NOVO ACOMODACOES
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



}
