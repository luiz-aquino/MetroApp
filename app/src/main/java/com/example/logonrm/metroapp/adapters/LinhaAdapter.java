package com.example.logonrm.metroapp.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.logonrm.metroapp.R;
import com.example.logonrm.metroapp.api.APIUtils;
import com.example.logonrm.metroapp.models.Linha;
import com.example.logonrm.metroapp.models.OnItemClickListener;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by logonrm on 26/06/2017.
 */

public class LinhaAdapter extends RecyclerView.Adapter<LinhaAdapter.LinhaViewHolder> {

    private List<Linha> linhas;
    private OnItemClickListener listener;
    public LinhaAdapter(List<Linha> linhas, OnItemClickListener listener){
        this.linhas = linhas;
        this.listener = listener;
    }

    public class LinhaViewHolder extends  RecyclerView.ViewHolder {
        public ImageView ivLinha;
        public TextView tvNumero;
        public TextView tvCor;

        public LinhaViewHolder(View itemView){
            super(itemView);
            ivLinha = (ImageView) itemView.findViewById(R.id.iv_linha);
            tvNumero = (TextView) itemView.findViewById(R.id.tv_numero_linha);
            tvCor = (TextView) itemView.findViewById(R.id.tv_cor_linha);
        }
    }

    @Override
    public LinhaViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());

        View myLayout = inflater.inflate(R.layout.linha_metro, parent, false);

        return new LinhaViewHolder(myLayout);
    }

    @Override
    public void onBindViewHolder(LinhaViewHolder holder, final int position) {
        Linha linha = linhas.get(position);
        holder.tvNumero.setText( String.valueOf(linha.getNumero()));
        holder.tvCor.setText(linha.getCor());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onItemClick(linhas.get(position));
            }
        });

        Picasso.with(holder.itemView.getContext())
                .load(APIUtils.getResourceFullUrl(linha.getUrlImagem()))
                .placeholder(R.mipmap.ic_launcher)
                .error(R.mipmap.ic_launcher)
                .into(holder.ivLinha);
    }

    @Override
    public int getItemCount() {
        return linhas.size();
    }

    public void update(List<Linha> linhas){
        this.linhas = linhas;
        notifyDataSetChanged();
    }
}
