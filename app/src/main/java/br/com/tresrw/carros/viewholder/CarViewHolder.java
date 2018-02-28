package br.com.tresrw.carros.viewholder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import br.com.tresrw.carros.R;
import br.com.tresrw.carros.entities.Car;
import br.com.tresrw.carros.listener.OnListClickInteractionListener;

/**
 * Created by Roni on 26/02/2018.
 */

/**
 * Responsável por fazer as manipulações de elementos de interface
 **/
public class CarViewHolder extends RecyclerView.ViewHolder {

    // elemento de interface
    private ImageView mImgCarPicture;
    private TextView mTextCarModel;
    private TextView mTextViewDetails;


    /**
     * Construtor
     **/
    public CarViewHolder(View itemView) {
        super(itemView);
        this.mImgCarPicture = itemView.findViewById(R.id.img_car_pic);
        this.mTextCarModel = itemView.findViewById(R.id.text_car_model);
        this.mTextViewDetails = itemView.findViewById(R.id.text_view_details);

    }

    /**
     * Atribui valor aos elementos
     **/
    public void bindData(final Car car, final OnListClickInteractionListener listener) {

        //altera Valor
        this.mImgCarPicture.setImageDrawable(car.picture);
        this.mTextCarModel.setText(car.model);

        // Adiciona evento de click
        this.mTextViewDetails.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onClick(car.id);
            }
        });


    }
}
