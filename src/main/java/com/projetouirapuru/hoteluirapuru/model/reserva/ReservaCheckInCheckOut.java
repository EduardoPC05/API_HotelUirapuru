package com.projetouirapuru.hoteluirapuru.model.reserva;

import java.time.LocalDateTime;

public class ReservaCheckInCheckOut {


    private Reserva reserva;
    private LocalDateTime data;

    public ReservaCheckInCheckOut(Reserva reserva, LocalDateTime data) {
        this.reserva = reserva;
        this.data = data;
    }
    public ReservaCheckInCheckOut getReservaChecK(){
      return  new ReservaCheckInCheckOut(getReserva(),getData());
    }

    public Reserva getReserva() {
        return reserva;
    }

    public LocalDateTime getData() {
        return data;
    }


}
