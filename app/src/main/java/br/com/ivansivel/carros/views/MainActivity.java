package br.com.ivansivel.carros.views;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import br.com.ivansivel.carros.R;
import br.com.ivansivel.carros.adapter.CarListAdapter;
import br.com.ivansivel.carros.constants.CarrosConstants;
import br.com.ivansivel.carros.data.CarMock;
import br.com.ivansivel.carros.entities.Car;
import br.com.ivansivel.carros.listener.OnListClickInteractionListener;

public class MainActivity extends AppCompatActivity {

    private final ViewHolder mViewHolder = new ViewHolder();
    private Context mContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportActionBar().setDisplayShowTitleEnabled(false);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setIcon(R.mipmap.ic_launcher);

        this.mContext = this;

        CarMock carMock = new CarMock();
        List<Car> carList = new ArrayList<>();
        carList.addAll(carMock.getList());

        //1 - Obter a RecyclerView
        this.mViewHolder.recyclerCars = findViewById(R.id.recycler_cars);

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

        //Definir adapter
        CarListAdapter carListAdapter = new CarListAdapter(carList, listener);
        this.mViewHolder.recyclerCars.setAdapter(carListAdapter);

        //Definir layout
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        this.mViewHolder.recyclerCars.setLayoutManager(linearLayoutManager);
    }

    private static class ViewHolder {
        RecyclerView recyclerCars;
    }
}
