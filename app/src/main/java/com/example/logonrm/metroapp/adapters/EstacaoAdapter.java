package com.example.logonrm.metroapp.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.example.logonrm.metroapp.models.Estacao;

import java.util.List;

/**
 * Created by logonrm on 26/06/2017.
 */

public class EstacaoAdapter {

    public List<Estacao> estacoes;
    public EstacaoAdapter(List<Estacao> estacoes) { this.estacoes = estacoes; };

    public class EstacaoViewHolder extends RecyclerView.ViewHolder {

        public EstacaoViewHolder(View itemView) {
            super(itemView);
        }
    }

}
