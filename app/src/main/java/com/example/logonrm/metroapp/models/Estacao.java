package com.example.logonrm.metroapp.models;

import com.google.gson.annotations.SerializedName;

import java.util.Date;

/**
 * Created by logonrm on 26/06/2017.
 */

public class Estacao {
    private String nome;
    private String endereco;
    private double latitude;
    private double longitude;
    @SerializedName("capacidade_passageiro_hora_pico")
    private int capacidadePassageiroHoraPico;
    @SerializedName("area_construida_m_2")
    private int areaConstruidaM2;
    private String inauguracao;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public int getCapacidadePassageiroHoraPico() {
        return capacidadePassageiroHoraPico;
    }

    public void setCapacidadePassageiroHoraPico(int capacidadePassageiroHoraPico) {
        this.capacidadePassageiroHoraPico = capacidadePassageiroHoraPico;
    }

    public int getAreaConstruidaM2() {
        return areaConstruidaM2;
    }

    public void setAreaConstruidaM2(int areaConstruidaM2) {
        this.areaConstruidaM2 = areaConstruidaM2;
    }

    public String getInauguracao() {
        return inauguracao;
    }

    public void setInauguracao(String inauguracao) {
        this.inauguracao = inauguracao;
    }
}
