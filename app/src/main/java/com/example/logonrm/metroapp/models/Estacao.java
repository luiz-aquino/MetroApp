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
    private Date inauguracao;
}
