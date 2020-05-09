package com.example.projectakhir.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.projectakhir.Favorite.AppDatabase;
import com.example.projectakhir.Favorite.Favorite;
import com.example.projectakhir.HolidaysModel.HolidaysItem;
import com.example.projectakhir.R;

import java.util.ArrayList;

public class HolidaysAdapter extends RecyclerView.Adapter<HolidaysAdapter.ViewHolder> {

    private ArrayList<HolidaysItem> holidaysItems = new ArrayList<>();
    private Context context;
    private LinearLayout tbFavorite;
    private AppDatabase appDatabase;

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
        final String Holidays = holidaysItems.get(position).getName();
        final String Date = holidaysItems.get(position).getDate();
        holder.tvType.setText(Holidays);
        holder.tvMonth.setText(Date);
        tbFavorite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String holidays = Holidays;
                String date = Date;

                Favorite item = new Favorite();
                item.setDate(holidays);
                item.setHolidays(date);

                appDatabase.dao().insertData(item);
                
            }
        });
    }


    @Override
    public int getItemCount() {
        return holidaysItems.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvMonth, tvType;
        TextView tvDate, tvHolidays;
        CardView cvItem;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            cvItem = itemView.findViewById(R.id.itemlist_cv);
//            tvHoliday = itemView.findViewById(R.id.date_holiday);
            tvMonth = itemView.findViewById(R.id.month_holiday);
            tvType = itemView.findViewById(R.id.type_holiday);
            tbFavorite = itemView.findViewById(R.id.FavClick);

            appDatabase = AppDatabase.iniDb(context);

            tvDate = itemView.findViewById(R.id.month_holiday_fav);
            tvHolidays = itemView.findViewById(R.id.type_holiday_fav);
        }
    }
}
