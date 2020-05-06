package com.example.projectakhir.Adapter;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.text.format.DateFormat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.projectakhir.Activity.Home;
import com.example.projectakhir.Fragment.FavoriteFragment;
import com.example.projectakhir.Fragment.HolidaysFragment;
import com.example.projectakhir.HolidaysModel.HolidaysItem;
import com.example.projectakhir.R;

import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class HolidaysAdapter extends RecyclerView.Adapter<HolidaysAdapter.ViewHolder> {

    private ArrayList<HolidaysItem> holidaysItems = new ArrayList<>();
    private Context context;
    private LinearLayout tbFavorite;

    public HolidaysAdapter(Context context) {
        this.context = context;
    }

    public void setData(ArrayList<HolidaysItem> items){
        holidaysItems.clear();
        holidaysItems.addAll(items);
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public HolidaysAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final HolidaysAdapter.ViewHolder holder, int position) {
//        Format formatter = new SimpleDateFormat(holidaysItems.get(position).getDate());
//        String date = formatter.format(new Date());
//        holder.tvHoliday.setText(date);
        holder.tvType.setText(holidaysItems.get(position).getName());
        holder.tvMonth.setText(holidaysItems.get(position).getDate());
        tbFavorite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }

    @Override
    public int getItemCount() {
        return holidaysItems.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvHoliday, tvMonth, tvType;
        CardView cvItem;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            cvItem = itemView.findViewById(R.id.itemlist_cv);
//            tvHoliday = itemView.findViewById(R.id.date_holiday);
            tvMonth = itemView.findViewById(R.id.month_holiday);
            tvType = itemView.findViewById(R.id.type_holiday);
            tbFavorite = itemView.findViewById(R.id.FavClick);
        }
    }
}
