package com.example.logonrm.metroapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.example.logonrm.metroapp.adapters.EstacaoAdapter;
import com.example.logonrm.metroapp.api.APIUtils;
import com.example.logonrm.metroapp.api.IMetroAPI;
import com.example.logonrm.metroapp.models.Estacao;
import com.example.logonrm.metroapp.models.Linha;
import com.example.logonrm.metroapp.models.OnItemClickListener;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class EstacoesActivity extends AppCompatActivity {

    private Linha linha;
    private IMetroAPI metroApi;
    private RecyclerView rvEstacoes;
    private EstacaoAdapter estacaoAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_estacoes);

        if(getIntent() != null){
            linha = getIntent().getParcelableExtra("LINHA");
            this.loadData();
        }

        rvEstacoes = (RecyclerView) findViewById(R.id.rvEstacoes);
        estacaoAdapter = new EstacaoAdapter(new ArrayList<Estacao>(), new OnItemClickListener() {
            @Override
            public void onItemClick(Linha item) {

            }
        });

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        rvEstacoes.setLayoutManager(layoutManager);
        rvEstacoes.setAdapter(estacaoAdapter);
    }

    private void loadData(){
        metroApi = APIUtils.getMetroAPI();

        List<Estacao> estacoes;

        metroApi.GetEstacoes(linha.getCor()).enqueue(new Callback<List<Estacao>>() {
            @Override
            public void onResponse(Call<List<Estacao>> call, Response<List<Estacao>> response) {
                if(response.isSuccessful()){

                }
            }

            @Override
            public void onFailure(Call<List<Estacao>> call, Throwable throwable) {
                Log.e("Deu ruim", "Não foi possivel listar as estacoes");
            }
        });
    }
}
