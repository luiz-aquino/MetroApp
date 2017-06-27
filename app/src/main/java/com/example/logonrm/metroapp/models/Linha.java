package com.example.logonrm.metroapp.models;

/**
 * Created by logonrm on 26/06/2017.
 */

public class Linha {
    private String cor;
    private int numero;
    private String urlImagem;

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getUrlImagem() {
        return urlImagem;
    }

    public void setUrlImagem(String urlImagem) {
        this.urlImagem = urlImagem;
    }
}
