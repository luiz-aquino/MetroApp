package com.example.logonrm.metroapp.api;

import com.example.logonrm.metroapp.models.Estacao;
import com.example.logonrm.metroapp.models.Linha;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by logonrm on 26/06/2017.
 */

public interface IMetroAPI {
    @GET("/linhas")
    Call<List<Linha>> GetLinhas();
    @GET("/linhas/{cor}/estacoes")
    Call<List<Estacao>> GetEstacoes(@Path("cor") String cor);
}
