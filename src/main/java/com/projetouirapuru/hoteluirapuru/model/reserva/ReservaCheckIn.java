package com.projetouirapuru.hoteluirapuru.model.reserva;

import com.projetouirapuru.hoteluirapuru.model.pessoa.documento.Documento;
import com.projetouirapuru.hoteluirapuru.model.pessoa.endereco.Endereco;

import java.time.LocalDateTime;

public class ReservaCheckIn {
    private Reserva reserva;
    private Endereco endereco;
    private String telefone;
    private LocalDateTime chegada;
    private Documento documento;

    public ReservaCheckIn(Reserva reserva, Endereco endereco, String telefone, LocalDateTime chegada, Documento documento) {
        this.reserva = reserva;
        this.endereco = endereco;
        this.telefone = telefone;
        this.chegada = chegada;
        this.documento = documento;
    }
    public Reserva getReserva() {
        return reserva;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public String getTelefone() {
        return telefone;
    }

    public LocalDateTime getChegada() {
        return chegada;
    }

    public Documento getDocumento() {
        return documento;
    }
}
