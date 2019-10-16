package com.example.entregavel2.views;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.entregavel2.R;
import com.example.entregavel2.adapter.PratoAdapter;
import com.example.entregavel2.adapter.RestauranteAdapter;
import com.example.entregavel2.interfaces.RecyclerViewOnClickPrato;
import com.example.entregavel2.model.PratoModel;
import com.example.entregavel2.model.RestauranteModel;

import java.util.ArrayList;
import java.util.IllegalFormatCodePointException;
import java.util.List;

import static com.example.entregavel2.views.PrincipalActivity.RESTAURANTE_KEY;

public class TelaRestauranteActivity extends AppCompatActivity implements RecyclerViewOnClickPrato {
    private ImageView imgRestaurante;
    private TextView txtNome;
    private RecyclerView recyclerViewPrato;
    private PratoAdapter adapterPrato;
    private List<PratoModel> aoyamaList = new ArrayList<>();
    private List<PratoModel> outbackList = new ArrayList<>();
    private List<PratoModel> siSenorList = new ArrayList<>();
    private List<PratoModel> pratosList = new ArrayList<>();
    public static final String PRATO_KEY = "prato";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_restaurante);
        initViews();

        if (getIntent() != null && getIntent().getExtras() != null) {

            RestauranteModel restaurante = getIntent().getExtras().getParcelable(RESTAURANTE_KEY);

            Drawable drawable = getResources().getDrawable(restaurante.getFoto());
            imgRestaurante.setImageDrawable(drawable);
            txtNome.setText(restaurante.getTxtNome());
        }


        recyclerViewPrato = findViewById(R.id.listaPratosRecyclerView);
        adapterPrato = new PratoAdapter(getPratos(), this);
        recyclerViewPrato.setAdapter(adapterPrato);
        recyclerViewPrato.setLayoutManager(new GridLayoutManager(this,2));

    }


    private List<PratoModel> getPratos() {

        if (txtNome.getText().toString().equals("Aoyama - Moema")) {
            pratosList.add(new PratoModel(R.drawable.yakissoba, "Yakissoba", "Nosso Yakissoba é a escolha perfeita para quem não abre mão de um prato tradicional da culinária japonesa, com toque especial Aoyama."));
            pratosList.add(new PratoModel(R.drawable.hotholl, "Hotroll", "Hot Roll Aoyama, a junção dos seus ingredientes favoritos: Salmão, Atum, Kani e Cream Cheese. Que formam uma bomba atômica de explosão de sabores!"));
            pratosList.add(new PratoModel(R.drawable.guioza, "Guioza", "Se existe um prato da culinária oriental que é facilmente aceito entre os brasileiros, ele é o Guioza. Este prato típico da culinária chinesa, e que depois se difundiu por toda a Ásia, é basicamente um pastel de carne moída com legumes, que pode ser frito ou cozido no vapor."));
        } else if (txtNome.getText().toString().equals("Outback - Moema")) {
            pratosList.add(new PratoModel(R.drawable.costela, "Ribs On The Barbie", "Preparada em chama aberta como manda a tradição australiana, nossa rib é um grande diferencial da nossa cozinha. Além do ponto perfeito e uma textura muito suculenta, a carne tem um indescritível tempero resultado de um mix secreto e exclusivo de ervas e especiarias. É servida com cinnamon apples, as nossas maçãs cozidas com canela (contém açúcar, glúten e lactose). Para acompanhar, sugerimos batatas fritas."));
            pratosList.add(new PratoModel(R.drawable.costela_empanada, "Royal Cheese Ribs", "A Royal Cheese Ribs vai te deixar derretido!Ela é recheadíssima e vai além, é empanada e coberta com MAIS queijo. IRRESISTÍVEL!!!"));
            pratosList.add(new PratoModel(R.drawable.batata, "Aussie Cheese Fries", "Nossas batatas fritas crocantes cobertas com um irresistível mix de queijos e bacon! O molho Ranch dá o toque final!"));
        } else if (txtNome.getText().toString().equals("Sí Señor - Moema")) {
            pratosList.add(new PratoModel(R.drawable.burrito, "Burrito Tex", "Nosso famoso Chili, coberto por queijo cremoso, alface, cebolas caramelizadas ao molho barbecue e acompanhado de guacamole. Adicione Frango Honey Glazed ou Alcatra Balck."));
            pratosList.add(new PratoModel(R.drawable.churros, "Churros", " Deliciosa porção de mini churros, crocantes por fora e macios por dentro. Acompanha doce de leite argentino ou calda de chocolate."));
            pratosList.add(new PratoModel(R.drawable.combo_especial, "La Frontera", "O melhor dos dois lados da fronteira em um delicioso combo. LADO TEX 4 bacon burgers, batatas chips, onion crispy e molho barbecue. LADO MEX 4 Chili tacos, nachos, jalapeño e guacamole."));
        }


        return pratosList;
    }


    private void initViews() {
        imgRestaurante = findViewById(R.id.img_telaRestaurante);
        txtNome = findViewById(R.id.txt_telaRestaurante_nome);
    }


    @Override
    public void onClick(PratoModel prato) {
        //Envio do objeto para a tela de detalhe
        Intent intent = new Intent(TelaRestauranteActivity.this, TelaPratoActivity.class);
        Bundle bundle = new Bundle();
        bundle.putParcelable(PRATO_KEY, prato);
        intent.putExtras(bundle);
        startActivity(intent);
    }


}







