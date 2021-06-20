package com.uitest.uiprototype.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.uitest.uiprototype.R;
import com.uitest.uiprototype.model.ItemModel;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ItemAdapter extends RecyclerView.Adapter<ItemAdapter.UserViewHolder> {

    private ArrayList<ItemModel> dataList;
    private OnItemClickListener mListener;

    public interface OnItemClickListener{
        void onItemClick(int position);
    }

    public void setOnItemClickListener(OnItemClickListener listener){
        mListener = listener;
    }

    public ItemAdapter(ArrayList<ItemModel> dataList) {
        this.dataList = dataList;
    }

    @Override
    public UserViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.item_list, parent, false);
        return new UserViewHolder(view, mListener);
    }

    @Override
    public void onBindViewHolder(UserViewHolder holder, int position) {
        holder.img_car.setImageResource(dataList.get(position).getImage());
        holder.tv_carName.setText(dataList.get(position).getName());
        holder.tv_carLicense.setText(dataList.get(position).getLicensePlate());
        holder.tv_carSeat.setText(dataList.get(position).getSeat() + " Seater");
        holder.tv_carDistance.setText(dataList.get(position).getDistance() + " KM Away");
        holder.tv_rentalFee.setText("Fr. $"+dataList.get(position).getRentalFee()+"/hr");
        holder.tv_mileageFee.setText("$"+dataList.get(position).getMileageFee()+"/km");
    }

    @Override
    public int getItemCount() {
        return (dataList != null) ? dataList.size() : 0;
    }

    public class UserViewHolder extends RecyclerView.ViewHolder{

        @BindView(R.id.img_car_list)
        ImageView img_car;
        @BindView(R.id.tv_carName_list)
        TextView tv_carName;
        @BindView(R.id.tv_carLicense_list)
        TextView tv_carLicense;
        @BindView(R.id.tv_carSeat_list)
        TextView tv_carSeat;
        @BindView(R.id.tv_carDistance_list)
        TextView tv_carDistance;
        @BindView(R.id.tv_rentalFee_list)
        TextView tv_rentalFee;
        @BindView(R.id.tv_mileageFee_list)
        TextView tv_mileageFee;

        public UserViewHolder(View itemView, final OnItemClickListener listener) {
            super(itemView);

            ButterKnife.bind(this, itemView);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (listener != null){
                        int position = getAdapterPosition();
                        if(position != RecyclerView.NO_POSITION){
                            listener.onItemClick(position);
                        }
                    }
                }
            });
        }
    }
}