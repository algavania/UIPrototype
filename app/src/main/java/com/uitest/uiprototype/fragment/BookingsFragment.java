package com.uitest.uiprototype.fragment;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.uitest.uiprototype.R;
import com.uitest.uiprototype.activity.BookingDetailActivity;
import com.uitest.uiprototype.adapter.ItemAdapter;
import com.uitest.uiprototype.model.ItemModel;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link BookingsFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class BookingsFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    @BindView(R.id.booking_recycler)
    RecyclerView recyclerView;
    @BindView(R.id.tv_carFound_booking)
    TextView tv_carFound;

    public BookingsFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment BookingsFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static BookingsFragment newInstance(String param1, String param2) {
        BookingsFragment fragment = new BookingsFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_bookings, container, false);

        ButterKnife.bind(this, view);

        addData();
        return view;
    }

    private void addData() {
        ArrayList<ItemModel> arrayList = new ArrayList<>();
        arrayList.add(new ItemModel(R.drawable.mazda, "Mazda 3", "SMS1000Z", 5, 0.5, 3.00, 0.40));
        arrayList.add(new ItemModel(R.drawable.hondahybrid, "Honda Shuttle Hybrid", "SMN7000B", 7, 0.5, 3.00, 0.40));
        arrayList.add(new ItemModel(R.drawable.ssangyong, "Ssangyong Tivoli", "SMN1234Z", 5, 0.5, 3.00, 0.40));
        arrayList.add(new ItemModel(R.drawable.toyotasienta, "Toyota Sienta Hybrid", "SMN4412Z", 7, 0.5, 3.00, 0.40));

        ItemAdapter adapter = new ItemAdapter(arrayList);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);

        Spannable word = new SpannableString(arrayList.size()+"+ ");

        word.setSpan(new ForegroundColorSpan(getResources().getColor(R.color.pink)), 0, word.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);

        tv_carFound.setText(word);
        Spannable wordTwo = new SpannableString("cars found");

        wordTwo.setSpan(new ForegroundColorSpan(Color.WHITE), 0, wordTwo.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        tv_carFound.append(wordTwo);

        adapter.setOnItemClickListener(new ItemAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                Intent intent = new Intent(getActivity(), BookingDetailActivity.class);
                intent.putExtra("carName", arrayList.get(position).getName());
                intent.putExtra("licensePlate", arrayList.get(position).getLicensePlate());
                intent.putExtra("carImage", arrayList.get(position).getImage());
                startActivity(intent);
            }
        });
    }
}