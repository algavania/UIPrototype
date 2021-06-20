package com.uitest.uiprototype.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.recyclerview.widget.RecyclerView;

import com.uitest.uiprototype.R;
import com.uitest.uiprototype.model.SliderModel;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SliderAdapter extends RecyclerView.Adapter<SliderAdapter.UserViewHolder> {

    private ArrayList<SliderModel> dataList;

    public SliderAdapter(ArrayList<SliderModel> dataList) {
        this.dataList = dataList;
    }

    @Override
    public SliderAdapter.UserViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.image_slider, parent, false);
        return new SliderAdapter.UserViewHolder(view);
    }

    @Override
    public void onBindViewHolder(SliderAdapter.UserViewHolder holder, int position) {
        holder.img_car.setImageResource(dataList.get(position).getImage());
    }

    @Override
    public int getItemCount() {
        return (dataList != null) ? dataList.size() : 0;
    }

    public class UserViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.img_car_slider)
        ImageView img_car;

        public UserViewHolder(View itemView) {
            super(itemView);

            ButterKnife.bind(this, itemView);
        }
    }
}