package com.example.projectakhir.Fragment;


import android.os.Bundle;

import androidx.annotation.ContentView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.projectakhir.Adapter.FavoriteAdapter;
import com.example.projectakhir.Favorite.AppDatabase;
import com.example.projectakhir.Favorite.Favorite;
import com.example.projectakhir.R;

import java.util.ArrayList;
import java.util.List;

import static com.example.projectakhir.R.layout.*;


/**
 * A simple {@link Fragment} subclass.
 */
public class FavoriteFragment extends Fragment {

    private FavoriteAdapter favoriteAdapter;
    private AppDatabase appDatabase;
    private RecyclerView rvFavorite;
    private List<Favorite> list = new ArrayList<>();

    public FavoriteFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(fragment_favorite, container, false);

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        appDatabase = AppDatabase.iniDb(getActivity().getApplicationContext());

        rvFavorite = view.findViewById(R.id.favorite_cv);
        rvFavorite.setHasFixedSize(true);
        read();
    }

    private void read() {
        list.addAll(appDatabase.dao().getData());

        rvFavorite.setLayoutManager(new GridLayoutManager(getContext(),1));

        favoriteAdapter = new FavoriteAdapter(getContext());
        favoriteAdapter.notifyDataSetChanged();

        favoriteAdapter.setFavoriteList(list);
        rvFavorite.setAdapter(favoriteAdapter);
    }
}
