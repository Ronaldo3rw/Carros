package br.com.tresrw.carros.views;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import br.com.tresrw.carros.R;
import br.com.tresrw.carros.constants.CarrosConstants;
import br.com.tresrw.carros.data.CarMock;
import br.com.tresrw.carros.entities.Car;

public class DetailsActivity extends AppCompatActivity {


    private ViewHolder mViewHolder = new ViewHolder();  // instância a ViewHolder
    private CarMock mCarMock; // instância a CarMock
    private Car mCar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        // Mostrar icone na barra superior
        getSupportActionBar().setDisplayShowTitleEnabled(true);    // informa que o título da aplicação não será exibido - false
        getSupportActionBar().setDisplayShowHomeEnabled(true);      // informa que vou exibir uma imagem
        getSupportActionBar().setIcon(R.mipmap.ic_launcher_carros);        // Configura o icone a ser exibido

        // Instância variáveis
        this.mCarMock = new CarMock(this); // instância no onCreate

        // Instância elementos da interace
        this.mViewHolder.imgCarPicture = findViewById(R.id.img_car_pic);
        this.mViewHolder.textModel = findViewById(R.id.text_car_model);
        this.mViewHolder.textManufacturer = findViewById(R.id.text_manufacturer);
        this.mViewHolder.textHorsePower = findViewById(R.id.text_horse_power);
        this.mViewHolder.textPrice = findViewById(R.id.text_price);

        // Obtém o valor passado por parâmetro
        this.getDataFromActivity(); // cria método para pegar o id do carro

        // Atribui pos valores aos elementos da interface
        this.setData(); // Pega os valores mockados e imprime na view


    }

    // todos os dados do carro
    private void setData() {

        this.mViewHolder.imgCarPicture.setImageDrawable(this.mCar.picture);
        this.mViewHolder.textModel.setText(this.mCar.model);
        this.mViewHolder.textManufacturer.setText(this.mCar.manufacturer);
        this.mViewHolder.textHorsePower.setText(String.valueOf(this.mCar.horsePower));  // setText espera uma string e a variável é um int String.valueOf()
        this.mViewHolder.textPrice.setText("R$ " + String.valueOf(this.mCar.price)); // setText espera uma string e a variável é Double, conversão com String.valueOf()

    }

    private void getDataFromActivity() {
        Bundle extras = getIntent().getExtras();    // pega os dados passados por Bundle
        if (extras != null) {    // Verifica se vem algun valor
            // recupera o objeto carro mas não vou manupular a interface por ele e sim pelo método setData (acima) -> this.mCar carrega a entidade
            this.mCar = this.mCarMock.get(extras.getInt(CarrosConstants.CARRO_ID));
        }
    }

    private static class ViewHolder {
        ImageView imgCarPicture;
        TextView textModel;
        TextView textManufacturer;
        TextView textHorsePower;
        TextView textPrice;
    }
}
