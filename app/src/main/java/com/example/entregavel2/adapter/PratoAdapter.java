package com.example.entregavel2.adapter;

import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.entregavel2.R;
import com.example.entregavel2.interfaces.RecyclerViewOnClickPrato;
import com.example.entregavel2.model.PratoModel;

import java.util.List;

public class PratoAdapter extends RecyclerView.Adapter<PratoAdapter.ViewHolder>{

    private List<PratoModel> pratoList;

    private RecyclerViewOnClickPrato listener;

    public PratoAdapter(List<PratoModel> pratoList, RecyclerViewOnClickPrato listener) {
        this.pratoList = pratoList;
        this.listener = listener;
    }

    @NonNull
    @Override
    public PratoAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view= LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_recycler_prato, viewGroup, false);
        return new PratoAdapter.ViewHolder(view);


    }

    @Override
    public void onBindViewHolder(@NonNull PratoAdapter.ViewHolder viewHolder, int posicao) {
        final PratoModel prato = pratoList.get(posicao);
        viewHolder.onBind(prato);


        //Seta a função de click no itemView(que é um parametro passado no construtor da classe
        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //chamada do método da interface através do atributo
                listener.onClick(prato);
            }
        });



    }




    @Override
    public int getItemCount() {
        return pratoList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView txtNomePrato;
        private ImageView imgPrato;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            txtNomePrato = itemView.findViewById(R.id.txt_recyclerPrato_nome);
            imgPrato = itemView.findViewById(R.id.img_recyclerPrato);
        }

        public void onBind(PratoModel Prato) {

            Drawable drawable = itemView.getResources().getDrawable(Prato.getimgPrato());
            imgPrato.setImageDrawable(drawable);
            txtNomePrato.setText(Prato.getTxtNomePrato());


        }

    }
}

