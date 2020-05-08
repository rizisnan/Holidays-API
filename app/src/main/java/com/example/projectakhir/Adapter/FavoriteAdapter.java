package com.example.projectakhir.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.projectakhir.Favorite.Favotite;
import com.example.projectakhir.Fragment.FavoriteFragment;
import com.example.projectakhir.R;

import java.util.ArrayList;
import java.util.List;

public class FavoriteAdapter extends RecyclerView.Adapter<FavoriteAdapter.ViewHolder> {

    private FavoriteListener favoriteListener;
    private ArrayList<Favotite> favotiteList;

    public Context context;

    public FavoriteAdapter(Context context) {
        this.favoriteListener = favoriteListener;
        this.favotiteList = favotiteList;
        this.context = context;
    }

    public FavoriteAdapter(FavoriteFragment favoriteFragment, FavoriteListener favoriteListener) {
    }

    public ArrayList<Favotite> getFavorite(){
        return favotiteList;
    }

    public void setFavorite(ArrayList<Favotite> favorite){
        this.favotiteList = favotiteList;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemRow = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_favorite, parent, false);
        return new ViewHolder(itemRow);
    }

    @Override
    public void onBindViewHolder(@NonNull FavoriteAdapter.ViewHolder holder, int position) {
        holder.tvDate.setText(getFavorite().get(position).getDate());
        holder.tvHolidays.setText(getFavorite().get(position).getHolidays());
    }

    @Override
    public int getItemCount() {
        return getFavorite().size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private TextView tvDate, tvHolidays;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            tvDate = itemView.findViewById(R.id.month_holiday_fav);
            tvHolidays = itemView.findViewById(R.id.type_holiday_fav);
        }
    }
}
