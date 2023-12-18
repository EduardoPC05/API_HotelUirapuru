package com.projetouirapuru.hoteluirapuru.model.pessoa.documento;

public class InfosBasicas {
    private TipoDocumento tipoDocumento;
    private String numeroDocumento;

    public InfosBasicas(TipoDocumento tipoDocumento, String numeroDocumento) {
        this.tipoDocumento = tipoDocumento;
        this.numeroDocumento = numeroDocumento;
    }

    public TipoDocumento getTipoDocumento() {
        return tipoDocumento;
    }

    public String getNumeroDocumento() {
        return numeroDocumento;
    }
}
