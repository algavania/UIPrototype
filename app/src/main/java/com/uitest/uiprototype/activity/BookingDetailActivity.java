package com.uitest.uiprototype.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.PagerSnapHelper;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.SnapHelper;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.widget.ImageView;

import com.uitest.uiprototype.R;
import com.uitest.uiprototype.adapter.HorizontalAdapter;
import com.uitest.uiprototype.adapter.ItemAdapter;
import com.uitest.uiprototype.adapter.SliderAdapter;
import com.uitest.uiprototype.model.ItemModel;
import com.uitest.uiprototype.model.SliderModel;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import ru.tinkoff.scrollingpagerindicator.ScrollingPagerIndicator;

public class BookingDetailActivity extends AppCompatActivity {

    @BindView(R.id.rv_imageSlider_detail)
    RecyclerView recyclerView;

    @BindView(R.id.horizontal_recyclerView_detail)
    RecyclerView horizontalRv;

    @BindView(R.id.back_detail)
    ImageView btn_back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_booking_detail);

        ButterKnife.bind(this);

        addData();
        addHorizontalData();
    }

    @OnClick(R.id.back_detail) void backDetail() {
        onBackPressed();
    }

    private void addData() {
        ArrayList<SliderModel> arrayList = new ArrayList<>();
        arrayList.add(new SliderModel(R.drawable.mazda));
        arrayList.add(new SliderModel(R.drawable.hondahybrid));
        arrayList.add(new SliderModel(R.drawable.ssangyong));
        arrayList.add(new SliderModel(R.drawable.toyotasienta));

        SliderAdapter adapter = new SliderAdapter(arrayList);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        recyclerView.setItemViewCacheSize(20);
        recyclerView.setDrawingCacheEnabled(true);
        recyclerView.setDrawingCacheQuality(View.DRAWING_CACHE_QUALITY_HIGH);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);

        SnapHelper snapHelper = new PagerSnapHelper();
        snapHelper.attachToRecyclerView(recyclerView);

        ScrollingPagerIndicator recyclerIndicator = findViewById(R.id.indicator_slider_detail);
        recyclerIndicator.attachToRecyclerView(recyclerView);
    }

    private void addHorizontalData() {
        ArrayList<SliderModel> arrayList = new ArrayList<>();
        arrayList.add(new SliderModel(R.drawable.pickupcar));
        arrayList.add(new SliderModel(R.drawable.pickupcar));
        arrayList.add(new SliderModel(R.drawable.pickupcar));
        arrayList.add(new SliderModel(R.drawable.pickupcar));

        HorizontalAdapter adapter = new HorizontalAdapter(arrayList);
        horizontalRv.setHasFixedSize(true);
        horizontalRv.setItemViewCacheSize(20);
        horizontalRv.setDrawingCacheEnabled(true);
        horizontalRv.setDrawingCacheQuality(View.DRAWING_CACHE_QUALITY_HIGH);
        horizontalRv.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false){
            @Override
            public boolean checkLayoutParams(RecyclerView.LayoutParams lp) {
                lp.width = getWidth() / 3;
                return true;
            }
        });

        horizontalRv.setAdapter(adapter);
    }
}