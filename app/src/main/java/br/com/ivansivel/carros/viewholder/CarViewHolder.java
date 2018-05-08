package br.com.ivansivel.carros.viewholder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import br.com.ivansivel.carros.R;
import br.com.ivansivel.carros.entities.Car;
import br.com.ivansivel.carros.listener.OnListClickInteractionListener;

public class CarViewHolder extends RecyclerView.ViewHolder {

    private TextView mTextModel;

    public CarViewHolder(View itemView) {
        super(itemView);
        this.mTextModel = itemView.findViewById(R.id.text_model);
    }

    public void bindData(final Car car, final OnListClickInteractionListener listener) {
        this.mTextModel.setText(car.model);
        this.mTextModel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listener.onClick(car.id);
            }
        });
    }
}
