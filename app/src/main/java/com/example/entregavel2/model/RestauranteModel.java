package com.example.entregavel2.model;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Parcel;
import android.os.Parcelable;

public class RestauranteModel extends AppCompatActivity implements Parcelable {
    private int foto;
    private String txtInformacoes;
    private String txtNome;
    private String txtHorario;


    public RestauranteModel(int foto, String txtNome, String txtInformacoes, String txtHorario) {
        this.foto = foto;
        this.txtNome = txtNome;
        this.txtInformacoes = txtInformacoes;
        this.txtHorario = txtHorario;
    }


    protected RestauranteModel(Parcel in) {
        foto = in.readInt();
        txtInformacoes = in.readString();
        txtNome = in.readString();
        txtHorario = in.readString();
    }

    public static final Creator<RestauranteModel> CREATOR = new Creator<RestauranteModel>() {
        @Override
        public RestauranteModel createFromParcel(Parcel in) {
            return new RestauranteModel(in);
        }

        @Override
        public RestauranteModel[] newArray(int size) {
            return new RestauranteModel[size];
        }
    };

    public String getTxtHorario() {
        return txtHorario;
    }

    public void setTxtHorario(String txtHorario) {
        this.txtHorario = txtHorario;
    }


    public String getTxtNome() {
        return txtNome;
    }

    public void setTxtNome(String txtNome) {
        this.txtNome = txtNome;
    }


    public int getFoto() {
        return foto;
    }

    public void setFoto(int foto) {
        this.foto = foto;
    }

    public String getTxtInformacoes() {
        return txtInformacoes;
    }

    public void setTxtInformacoes(String txtInformacoes) {
        this.txtInformacoes = txtInformacoes;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(foto);
        dest.writeString(txtInformacoes);
        dest.writeString(txtNome);
        dest.writeString(txtHorario);
    }
}
