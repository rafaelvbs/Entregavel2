package com.example.entregavel2.views;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.entregavel2.R;
import com.example.entregavel2.model.PratoModel;
import com.example.entregavel2.model.RestauranteModel;

import static com.example.entregavel2.views.PrincipalActivity.RESTAURANTE_KEY;
import static com.example.entregavel2.views.TelaRestauranteActivity.PRATO_KEY;

public class TelaPratoActivity extends AppCompatActivity {
    private ImageView imgPrato;
    private TextView txtNomePrato;
    private TextView txtInfoPrato;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_prato);
        initViews();

        if (getIntent() != null && getIntent().getExtras() != null){

            PratoModel prato = getIntent().getExtras().getParcelable(PRATO_KEY);

            Drawable drawable = getResources().getDrawable(prato.getimgPrato());
            imgPrato.setImageDrawable(drawable);
            txtNomePrato.setText(prato.getTxtNomePrato());
            txtInfoPrato.setText(prato.gettxtInfoPrato());

        }

    }


    private void initViews(){
        imgPrato = findViewById(R.id.img_telaPrato);
        txtNomePrato = findViewById(R.id.txt_telaPrato_nome);
        txtInfoPrato = findViewById(R.id.txt_telaPrato_informacoes);

    }



}
