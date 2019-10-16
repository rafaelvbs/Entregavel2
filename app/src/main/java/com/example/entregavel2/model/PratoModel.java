package com.example.entregavel2.model;

import android.os.Parcel;
import android.os.Parcelable;

public class PratoModel implements Parcelable {
    private int imgPrato;
    private String txtInfoPrato;
    private String txtNomePrato;


    public PratoModel(int imgPrato, String txtNomePrato, String txtInfoPrato) {
        this.imgPrato = imgPrato;
        this.txtNomePrato = txtNomePrato;
        this.txtInfoPrato = txtInfoPrato;
    }


    protected PratoModel(Parcel in) {
        imgPrato = in.readInt();
        txtInfoPrato = in.readString();
        txtNomePrato = in.readString();
    }

    public static final Parcelable.Creator<PratoModel> CREATOR = new Parcelable.Creator<PratoModel>() {
        @Override
        public PratoModel createFromParcel(Parcel in) {
            return new PratoModel(in);
        }

        @Override
        public PratoModel[] newArray(int size) {
            return new PratoModel[size];
        }
    };
    

    public String getTxtNomePrato() {
        return txtNomePrato;
    }

    public void setTxtNomePrato(String txtNomePrato) {
        this.txtNomePrato = txtNomePrato;
    }


    public int getimgPrato() {
        return imgPrato;
    }

    public void setimgPrato(int imgPrato) {
        this.imgPrato = imgPrato;
    }

    public String gettxtInfoPrato() {
        return txtInfoPrato;
    }

    public void settxtInfoPrato(String txtInfoPrato) {
        this.txtInfoPrato = txtInfoPrato;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(imgPrato);
        dest.writeString(txtInfoPrato);
        dest.writeString(txtNomePrato);
    }
}

