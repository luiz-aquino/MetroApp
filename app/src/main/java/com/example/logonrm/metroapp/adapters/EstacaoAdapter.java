package com.example.logonrm.metroapp.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import com.example.logonrm.metroapp.models.Estacao;
import com.example.logonrm.metroapp.models.OnItemClickListener;

import java.util.List;

/**
 * Created by logonrm on 26/06/2017.
 */

public class EstacaoAdapter extends RecyclerView.Adapter<EstacaoAdapter.EstacaoViewHolder> {

    public List<Estacao> estacoes;
    private OnItemClickListener listener;

    public EstacaoAdapter(List<Estacao> estacoes, OnItemClickListener listener) {
        this.estacoes = estacoes;
        this.listener = listener;
    }

    @Override
    public EstacaoViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(EstacaoViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class EstacaoViewHolder extends RecyclerView.ViewHolder {

        public EstacaoViewHolder(View itemView) {


            super(itemView);
        }
    }

}
