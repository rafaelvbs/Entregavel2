package com.example.entregavel2.views;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import com.example.entregavel2.R;
import com.example.entregavel2.adapter.RestauranteAdapter;
import com.example.entregavel2.interfaces.RecyclerViewOnClickRestaurante;
import com.example.entregavel2.model.RestauranteModel;

import java.util.ArrayList;
import java.util.List;

public class PrincipalActivity extends AppCompatActivity implements RecyclerViewOnClickRestaurante {
    private RecyclerView recyclerView;
    private RestauranteAdapter adapter;
    private List<RestauranteModel> restauranteList = new ArrayList<>();
    public static final String RESTAURANTE_KEY = "restaurante";



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);


        recyclerView = findViewById(R.id.listaRestaurantesRecyclerView);
        adapter = new RestauranteAdapter(getrestaurante(),this);
        recyclerView.setAdapter(adapter);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }



    private List<RestauranteModel> getrestaurante() {

        restauranteList.add(new RestauranteModel(R.drawable.aoyama,"Aoyama - Moema","Av. Lavandisca, 717 - Indianópolis, São Paulo","Fecha às 22:00" ));
        restauranteList.add(new RestauranteModel(R.drawable.outback,"Outback - Moema","Av. Moaci, 187 - Indianópolis, São Paulo","Fecha às 23:00"));
        restauranteList.add(new RestauranteModel(R.drawable.si_senor, "Sí Señor - Moema","Alameda Jauaperi, 626 - Moema, São Paulo", "Fecha às 23:00"));

        return restauranteList;

    }
  @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater= getMenuInflater();
        inflater.inflate(R.menu.menu_profile,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {


        int id = item.getItemId();
        if (id == R.id.item_profile) {
            startActivity(new Intent(PrincipalActivity.this, profileActivity.class));
            return true;
        }


        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(RestauranteModel restaurante) {
        Intent intent = new Intent(PrincipalActivity.this, TelaRestauranteActivity.class);
        Bundle bundle = new Bundle();
        bundle.putParcelable(RESTAURANTE_KEY, restaurante);
        intent.putExtras(bundle);
        startActivity(intent);
    }
}


