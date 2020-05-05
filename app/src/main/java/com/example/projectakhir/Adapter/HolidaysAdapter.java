package com.example.projectakhir.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.projectakhir.HolidaysModel.Holidays;
import com.example.projectakhir.HolidaysModel.HolidaysItem;
import com.example.projectakhir.R;

import java.util.ArrayList;
import java.util.List;

public class HolidaysAdapter extends RecyclerView.Adapter<HolidaysAdapter.ViewHolder> {

    private ArrayList<HolidaysItem> holidaysItems = new ArrayList<>();
    private Context context;

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
    public void onBindViewHolder(@NonNull HolidaysAdapter.ViewHolder holder, int position) {
        holder.tvType.setText(holidaysItems.get(position).getType());
        holder.tvMonth.setText(holidaysItems.get(position).getStart());
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
            tvHoliday = itemView.findViewById(R.id.date_holiday);
            tvMonth = itemView.findViewById(R.id.month_holiday);
            tvType = itemView.findViewById(R.id.type_holiday);
        }
    }
}
