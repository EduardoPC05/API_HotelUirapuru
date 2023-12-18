package com.projetouirapuru.hoteluirapuru.model.reserva.pagamento;

public class Cheque extends MetodoPagamento{
    private String nomeBeneficiário;

    public Cheque(String nomeBeneficiário) {
        this.nomeBeneficiário = nomeBeneficiário;
    }

    public String getNomeBeneficiário() {
        return nomeBeneficiário;
    }
}
