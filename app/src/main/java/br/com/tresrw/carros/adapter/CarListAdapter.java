package br.com.tresrw.carros.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import br.com.tresrw.carros.R;
import br.com.tresrw.carros.entities.Car;
import br.com.tresrw.carros.listener.OnListClickInteractionListener;
import br.com.tresrw.carros.viewholder.CarViewHolder;

/**
 * Created by Roni on 26/02/2018.
 */

public class CarListAdapter extends RecyclerView.Adapter<CarViewHolder>{

    private List<Car> mListCars;
    private OnListClickInteractionListener mOnListClickInteractionListener;  // Declara a interface

    /*
    private int mCountOnCreate = 0;
    private int mCountOnBind = 0;
    */

    public CarListAdapter(List<Car> cars, OnListClickInteractionListener listener){     //
        this.mListCars = cars;
        this.mOnListClickInteractionListener = listener;    // Passa a interface por parâmetro
    }



    // Mesmo que o OnCreate das activitys
    // É chamado a cada linha que é criada
    @Override
    public CarViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // this.mCountOnCreate++;
        Context context = parent.getContext();      // Obtendo o contexto para instânciar a row_car_list nesse contexto (view lista de carros)
        LayoutInflater inflater = LayoutInflater.from(context); // Inflar/criar o layout e obter os elementos

        View carView = inflater.inflate(R.layout.row_car_list, parent, false);  //3 parâmetros - 1 - Resourse que é a linha (R.layout.row_car_list) | 2 -  ViewGroup = parent acima | 3 -  adicionar nosso layout a um elemento pai, como já temos a row_car_list o Linear Layout, por esse motivo informa false
        return new CarViewHolder(carView); // istanciou a row_car_list acima, para que a CarViewHolder gerenciar, obter os elementos emanipula-los
    }

    // A cada vez que uma linha fica visivel na interface, através do position obtemos o item da lista que estamos exibindo
    // CarViewHolder foi criado para gerenciar os elementos da interface
    // É chamada toda vez que a linha é preenchida com valores
    @Override
    public void onBindViewHolder(CarViewHolder holder, int position) {
        // this.mCountOnBind++;
        Car car = this.mListCars.get(position);
        holder.bindData(car, this.mOnListClickInteractionListener); // passa a interface para a ViewHolder

    }

    // Retorna quantos iten a ViewHolder está trabalhando
    @Override
    public int getItemCount() {
        return this.mListCars.size();
    }
}
