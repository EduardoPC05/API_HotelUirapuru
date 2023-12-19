package com.projetouirapuru.hoteluirapuru.model.reserva;

import java.time.LocalDateTime;

public class ReservaCheckInCheckOut {
    private Reserva reserva;
    private LocalDateTime data;

    public Reserva getReserva() {
        return reserva;
    }

    public LocalDateTime getData() {
        return data;
    }
}
