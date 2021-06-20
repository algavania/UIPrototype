package com.uitest.uiprototype.adapter;

import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.card.MaterialCardView;
import com.uitest.uiprototype.R;
import com.uitest.uiprototype.model.SliderModel;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class HorizontalAdapter extends RecyclerView.Adapter<HorizontalAdapter.UserViewHolder> {

    private ArrayList<SliderModel> dataList;

    public HorizontalAdapter(ArrayList<SliderModel> dataList) {
        this.dataList = dataList;
    }

    @Override
    public HorizontalAdapter.UserViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.horizontal_rv_view, parent, false);
        return new HorizontalAdapter.UserViewHolder(view);
    }

    @Override
    public void onBindViewHolder(HorizontalAdapter.UserViewHolder holder, int position) {
        holder.img_car.setBackgroundResource(dataList.get(position).getImage());
    }

    @Override
    public int getItemCount() {
        return (dataList != null) ? dataList.size() : 0;
    }

    public class UserViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.layout_horizontal_rv)
        CardView img_car;

        public UserViewHolder(View itemView) {
            super(itemView);

            ButterKnife.bind(this, itemView);
        }
    }
}