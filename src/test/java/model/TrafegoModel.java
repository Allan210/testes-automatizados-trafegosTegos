package model;

import com.google.gson.annotations.Expose;
import lombok.Data;

@Data
public class TrafegoModel {
    @Expose(serialize = false)
    private int numeroTrafego;
    @Expose
    private String estado;
    @Expose
    private String cidade;
    @Expose
    private String cituacao;
    @Expose
    private String data_ocorrido;
}

