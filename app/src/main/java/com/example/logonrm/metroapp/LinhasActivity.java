package com.example.logonrm.metroapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;

import com.example.logonrm.metroapp.adapters.LinhaAdapter;
import com.example.logonrm.metroapp.api.APIUtils;
import com.example.logonrm.metroapp.api.IMetroAPI;
import com.example.logonrm.metroapp.models.Linha;
import com.example.logonrm.metroapp.models.OnItemClickListener;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LinhasActivity extends AppCompatActivity {

    private RecyclerView rvLinhas;
    private LinhaAdapter linhaAdapter;
    private IMetroAPI metroAPI;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_linhas);

        rvLinhas = (RecyclerView) findViewById(R.id.rvLinhas);

        linhaAdapter = new LinhaAdapter(new ArrayList<Linha>(), new OnItemClickListener() {
            @Override
            public void onItemClick(Linha linha) {
                Intent telaMapa = new Intent(LinhasActivity.this, MapsActivity.class);
                telaMapa.putExtra("LINHA", linha);
                startActivity(telaMapa);
            }
        });

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        rvLinhas.setLayoutManager(layoutManager);
        rvLinhas.setAdapter(linhaAdapter);
        rvLinhas.setHasFixedSize(true);

        RecyclerView.ItemDecoration itemDecoration = new DividerItemDecoration(this, DividerItemDecoration.VERTICAL);
        rvLinhas.addItemDecoration(itemDecoration);

        loadData();
    }

    private void loadData(){
        metroAPI = APIUtils.getMetroAPI();

        List<Linha> linhas = null;

        metroAPI.GetLinhas().enqueue(new Callback<List<Linha>>() {
            @Override
            public void onResponse(Call<List<Linha>> call, Response<List<Linha>> response) {
                if(response.isSuccessful()){
                    linhaAdapter.update(response.body());
                }
            }

            @Override
            public void onFailure(Call<List<Linha>> call, Throwable t) {
                Log.i("Metro lines", "Deu ruim ao listar linhas");
            }
        });
    }

}
