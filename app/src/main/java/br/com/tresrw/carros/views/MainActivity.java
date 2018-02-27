package br.com.tresrw.carros.views;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import br.com.tresrw.carros.R;
import br.com.tresrw.carros.adapter.CarListAdapter;
import br.com.tresrw.carros.constants.CarrosConstants;
import br.com.tresrw.carros.data.CarMock;
import br.com.tresrw.carros.entities.Car;
import br.com.tresrw.carros.listener.OnListClickInteractionListener;

public class MainActivity extends AppCompatActivity {

    ViewHolder mViewHolder = new ViewHolder();
    private Context mContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.mContext = this;

        CarMock carMock = new CarMock();        // Instância a classe carMok para gerar massa de dados
        List<Car> carList = new ArrayList<>();  // Instância uma lista de carros vazia que será preenchida com o Array
        carList.addAll(carMock.getList());     // adiciona uma colection (carMock) na carList com o Array


        // 1 - Obter a recyclerview
        this.mViewHolder.recyclerCars = (RecyclerView) this.findViewById(R.id.recycler_cars);

        OnListClickInteractionListener listener = new OnListClickInteractionListener() {
            @Override
            public void onClick(int id) {
                Bundle bundle = new Bundle();
                bundle.putInt(CarrosConstants.CARRO_ID, id);

                Intent intent = new Intent(mContext, DetailsActivity.class);
                intent.putExtras(bundle);

                startActivity(intent);


            }
        };

        // 2 -  Definir adapter
        CarListAdapter carListAdapter = new CarListAdapter(carList, listener); // Instância de CarListAdapter
        this.mViewHolder.recyclerCars.setAdapter(carListAdapter); // ver depois???

        // 3 - Definir um layout
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        this.mViewHolder.recyclerCars.setLayoutManager(linearLayoutManager);

    }

    // ViewHolder
    private static class ViewHolder {
        RecyclerView recyclerCars;

    }


}
