package com.example.projectakhir.ViewModel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.projectakhir.HolidaysModel.HolidaysItem;
import com.example.projectakhir.HolidaysModel.HolidaysResponse;
import com.example.projectakhir.Service.ApiMain;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HolidayViewModel extends ViewModel {

    private ApiMain apiMain;
    private MutableLiveData<ArrayList<HolidaysItem>> listHolidays = new MutableLiveData<>();

    public void setListHolidays() {
        if(this.apiMain == null){
            apiMain = new ApiMain();
        }

        apiMain.getApiHolidays().getHoliday().enqueue(new Callback<HolidaysResponse>() {
            @Override
            public void onResponse(Call<HolidaysResponse> call, Response<HolidaysResponse> response) {
                HolidaysResponse responseHolidays = response.body();
                if (responseHolidays != null && responseHolidays.getHolidays() != null){
                    ArrayList<HolidaysItem> holidaysItems = responseHolidays.getHolidays().getHolidays();
                    listHolidays.postValue(holidaysItems);
                }
            }

            @Override
            public void onFailure(Call<HolidaysResponse> call, Throwable t) {

            }
        });
    }

    public LiveData<ArrayList<HolidaysItem>> getHoliday(){
        return listHolidays;
    }
}
