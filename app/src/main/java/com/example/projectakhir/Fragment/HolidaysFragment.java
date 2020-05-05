package com.example.projectakhir.Fragment;


import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.projectakhir.Adapter.HolidaysAdapter;
import com.example.projectakhir.HolidaysModel.HolidaysItem;
import com.example.projectakhir.R;
import com.example.projectakhir.ViewModel.HolidayViewModel;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class HolidaysFragment extends Fragment {

    private HolidaysAdapter holidaysAdapter;
    private RecyclerView rvHolidays;
    private HolidayViewModel holidayViewModel;

    public HolidaysFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_holidays, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        holidaysAdapter = new HolidaysAdapter(getContext());
        holidaysAdapter.notifyDataSetChanged();

        rvHolidays = view.findViewById(R.id.fragment_rv);
        rvHolidays.setLayoutManager(new GridLayoutManager(getContext(), 0));

        holidayViewModel = new ViewModelProvider(this).get(HolidayViewModel.class);
        holidayViewModel.setListHolidays();
        holidayViewModel.getHoliday().observe(this, getHoliday);

        rvHolidays.setAdapter(holidaysAdapter);
    }

    private Observer<ArrayList<HolidaysItem>> getHoliday = new Observer<ArrayList<HolidaysItem>>() {
        @Override
        public void onChanged(ArrayList<HolidaysItem> holidaysItems) {
            if (holidaysItems != null) {
                holidaysAdapter.setData(holidaysItems);
            }
        }
    };
}
