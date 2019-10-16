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
import com.example.entregavel2.interfaces.RecyclerViewOnClickRestaurante;
import com.example.entregavel2.model.RestauranteModel;

import java.util.List;

public class RestauranteAdapter extends RecyclerView.Adapter<RestauranteAdapter.ViewHolder> {

    private List<RestauranteModel> restauranteList;

    private RecyclerViewOnClickRestaurante listener;

    public RestauranteAdapter(List<RestauranteModel> restauranteList, RecyclerViewOnClickRestaurante listener) {
        this.restauranteList = restauranteList;
        this.listener = listener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view= LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_recycler_restaurante, viewGroup, false);
        return new ViewHolder(view);


    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int posicao) {
        final RestauranteModel restaurante = restauranteList.get(posicao);
        viewHolder.onBind(restaurante);


        //Seta a função de click no itemView(que é um parametro passado no construtor da classe
        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //chamada do método da interface através do atributo
                listener.onClick(restaurante);
            }
        });



    }




        @Override
    public int getItemCount() {
        return restauranteList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView txtInforRestaurante;
        private TextView txtNomeRestaurante;
        private TextView txtHorarioRestaurante;
        private ImageView imgRestaurante;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            txtInforRestaurante = itemView.findViewById(R.id.txt_recyclerRestaurant_informacoes);
            txtNomeRestaurante = itemView.findViewById(R.id.txt_recyclerRestaurant_nome);
            txtHorarioRestaurante = itemView.findViewById(R.id.txt_recyclerRestaurant_horario);
            imgRestaurante = itemView.findViewById(R.id.img_recyclerRestaurant_aoyama);
        }

        public void onBind(RestauranteModel restaurante) {

            Drawable drawable = itemView.getResources().getDrawable(restaurante.getFoto());
            imgRestaurante.setImageDrawable(drawable);
            txtInforRestaurante.setText(restaurante.getTxtInformacoes());
            txtNomeRestaurante.setText(restaurante.getTxtNome());
            txtHorarioRestaurante.setText(restaurante.getTxtHorario());

        }

    }
}
