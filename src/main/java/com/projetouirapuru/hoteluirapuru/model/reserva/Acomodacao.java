package com.projetouirapuru.hoteluirapuru.model.reserva;


import java.util.ArrayList;

public class Acomodacao {

    private String codigo;
    private String andar;
    private String numero;
    private String descricao;
    private TipoQuarto tipoQuarto;
    private ArrayList<Reserva> reservas;
    private int limiteAdultos;

    private int limiteCriancas;


    public Acomodacao(String andar, String numero, String descricao, TipoQuarto tipoQuarto) {
        this.andar = andar;
        this.numero = numero;
        this.descricao = descricao;
        this.tipoQuarto = tipoQuarto;
        this.reservas = new ArrayList<Reserva>();
        setCodigo(andar, numero);
        setQtdpessoas(tipoQuarto);
    }
    public Acomodacao(){};



    private void setQtdpessoas(TipoQuarto tipoQuarto){
        switch (tipoQuarto){
            case NORMAL:
                limiteAdultos = 2;
                limiteCriancas = 1;
                break;
            case SUITE:
                limiteAdultos = 3;
                limiteCriancas = 2;
                break;
            case LUXO:
                limiteAdultos = 3;
                limiteCriancas = 2;
                break;
        }
    }

    private void setCodigo(String andar, String numero){
        codigo = andar + numero;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getAndar() {
        return andar;
    }

    public String getNumero() {
        return numero;
    }

    public String getDescricao() {
        return descricao;
    }

    public ArrayList<Reserva> getReservas() {
        return reservas;
    }

    public TipoQuarto getTipoQuarto() {
        return tipoQuarto;
    }

    public int getLimiteAdultos() {
        return limiteAdultos;
    }

    public int getLimiteCriancas() {
        return limiteCriancas;
    }

    public void addReserva(Reserva novo){
        this.reservas.add(novo);
    }

    public void removeReserva(Reserva excluir){
        this.reservas.remove(excluir);
    }
    public boolean verificaReserva(Reserva nova){
        if(!reservas.isEmpty()) {
            for (Reserva r : this.reservas){
                if (r.getTipoQuarto() == nova.getTipoQuarto()){
                    return !r.getCheckIn().isBefore(nova.getCheckOut()) && !r.getCheckOut().isAfter(nova.getCheckIn());
                }
            }
        }
        return true;
    }


}
