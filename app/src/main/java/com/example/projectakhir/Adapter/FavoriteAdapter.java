package com.example.projectakhir.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.projectakhir.Favorite.Favorite;
import com.example.projectakhir.Fragment.FavoriteFragment;
import com.example.projectakhir.R;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class FavoriteAdapter extends RecyclerView.Adapter<FavoriteAdapter.ViewHolder> {

    private FavoriteListener favoriteListener;
    private List<Favorite> favoriteList;
    private TextView btnReset;

    public Context context;

    public FavoriteAdapter(Context context) {
        this.favoriteListener = favoriteListener;
        this.favoriteList = favoriteList;
        this.context = context;
    }

    public FavoriteAdapter(List<Favorite> favoriteList) {
        this.favoriteList = favoriteList;
    }

    public FavoriteListener getFavoriteListener() {
        return favoriteListener;
    }

    public void setFavoriteListener(FavoriteListener favoriteListener) {
        this.favoriteListener = favoriteListener;
    }

    public List<Favorite> getFavoriteList() {
        return favoriteList;
    }

    public void setFavoriteList(List<Favorite> favoriteList) {
        this.favoriteList = favoriteList;
    }

    public Context getContext() {
        return context;
    }

    public void setContext(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemRow = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_favorite, parent, false);
        return new ViewHolder(itemRow);
    }

    @Override
    public void onBindViewHolder(@NonNull FavoriteAdapter.ViewHolder holder, int position) {
        holder.tvDate.setText(getFavoriteList().get(position).getHolidays());
        holder.tvHolidays.setText(getFavoriteList().get(position).getDate());

//        btnReset.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//            }
//        });
    }

    @Override
    public int getItemCount() {
        return favoriteList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private TextView tvDate, tvHolidays;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            btnReset = itemView.findViewById(R.id.btnReset);
            tvDate = itemView.findViewById(R.id.month_holiday_fav);
            tvHolidays = itemView.findViewById(R.id.type_holiday_fav);
        }
    }
}
