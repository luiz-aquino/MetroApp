package com.example.logonrm.metroapp.models;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by logonrm on 26/06/2017.
 */

public class Linha implements Parcelable {
    private String cor;
    private int numero;
    private String urlImagem;

    protected Linha(Parcel in) {
        cor = in.readString();
        numero = in.readInt();
        urlImagem = in.readString();
    }

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

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(cor);
        dest.writeInt(numero);
        dest.writeString(urlImagem);
    }

    public static final Creator<Linha> CREATOR = new Creator<Linha>() {
        @Override
        public Linha createFromParcel(Parcel in) {
            return new Linha(in);
        }

        @Override
        public Linha[] newArray(int size) {
            return new Linha[size];
        }
    };
}
