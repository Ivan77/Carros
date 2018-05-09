package br.com.ivansivel.carros.views;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;

import br.com.ivansivel.carros.R;
import br.com.ivansivel.carros.constants.CarrosConstants;
import br.com.ivansivel.carros.data.CarMock;
import br.com.ivansivel.carros.entities.Car;

public class DetailsActivity extends AppCompatActivity {

    private ViewHolder mViewHolder = new ViewHolder();
    private CarMock mCarMock;
    private Car mCar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        this.mCarMock = new CarMock();

        this.mViewHolder.textModel = findViewById(R.id.text_model);
        this.mViewHolder.textHorsePower = findViewById(R.id.text_horse_power);
        this.mViewHolder.textPrice = findViewById(R.id.text_price);


        this.getDataFromActivity();

        this.setData();
    }

    private void setData() {
        this.mViewHolder.textModel.setText(this.mCar.model);
        this.mViewHolder.textHorsePower.setText(String.valueOf(this.mCar.horsePower));
        this.mViewHolder.textPrice.setText(String.valueOf(this.mCar.price));
    }

    private void getDataFromActivity() {
        Bundle extras = getIntent().getExtras();
        if(extras != null) {
            this.mCar = this.mCarMock.get(extras.getInt(CarrosConstants.CARRO_ID));
        }
    }

    private static class ViewHolder {
        TextView textModel;
        TextView textHorsePower;
        TextView textPrice;
    }
}
