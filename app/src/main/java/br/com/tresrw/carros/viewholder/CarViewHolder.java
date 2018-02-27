package br.com.tresrw.carros.viewholder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import br.com.tresrw.carros.R;
import br.com.tresrw.carros.entities.Car;
import br.com.tresrw.carros.listener.OnListClickInteractionListener;

/**
 * Created by Roni on 26/02/2018.
 */

public class CarViewHolder extends RecyclerView.ViewHolder {

    private TextView mTextModel;

    public CarViewHolder(View itemView) {
        super(itemView);
        this.mTextModel = itemView.findViewById(R.id.text_model);


    }

    public void bindData(final Car car, final OnListClickInteractionListener listener){
        this.mTextModel.setText(car.model);
        this.mTextModel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onClick(car.id);
            }
        });


    }
}
